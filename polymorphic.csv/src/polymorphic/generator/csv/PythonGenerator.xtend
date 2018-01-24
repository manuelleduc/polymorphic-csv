package polymorphic.generator.csv

import java.util.Map
import org.eclipse.xtext.generator.IFileSystemAccess2
import polymorphic.csv.Language
import polymorphic.csv.Model
import polymorphic.csv.OpenCSV
import polymorphic.csv.PrintCSV
import polymorphic.csv.SaveCSV

import static extension org.eclipse.xtext.EcoreUtil2.*

class PythonGenerator implements ICsvGenerator {
	override void generate(Model content, Language language, IFileSystemAccess2 fsa) { // TODO Auto-generated method stub
		fsa.generateFile('''«content.name»/«language.name»/Dockerfile''', '''
			FROM python
			COPY . /project
			WORKDIR project
		''')

		fsa.generateFile(
			'''«content.name»/«language.name»/«language.target».py''',
			'''
				import csv
				«FOR action : content.actions»
					«action.pythonAction»
				«ENDFOR»
				
			'''
		)
	}

	def dispatch CharSequence pythonAction(OpenCSV open) '''
		«open.name» = open('«open.file»', 'rt')
		«open.name»_read = csv.reader(«open.name»)
	'''

	def dispatch CharSequence pythonAction(PrintCSV print) '''
		for «print.name»_e in «print.name»_read:
		  print(', '.join(«print.name»_e))
	'''

	def dispatch CharSequence pythonAction(SaveCSV save) {
		val f = if (save.file !== null)
				save.file
			else
				save.getContainerOfType(Model).actions.filter(OpenCSV).filter [
					it.name == save.name
				].head.file
		'''
		«save.name»_write = csv.writer(open('«f»', 'wt'))
		for «save.name»_e in «save.name»_read:
		  print(«save.name»_e)
		  «save.name»_write.writerow(tuple(«save.name»_e))
		'''

	}

	override Map<String, Boolean> properties() {
		return newHashMap("python" -> true)
	}
}
