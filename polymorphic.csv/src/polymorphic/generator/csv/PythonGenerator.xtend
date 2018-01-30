package polymorphic.generator.csv

import java.util.Map
import org.eclipse.xtext.generator.IFileSystemAccess2
import polymorphic.csv.Actions
import polymorphic.csv.Language
import polymorphic.csv.Model
import polymorphic.csv.NbRow
import polymorphic.csv.OpenCSV
import polymorphic.csv.PrintCSV
import polymorphic.csv.SaveCSV

import static extension org.eclipse.xtext.EcoreUtil2.*

class PythonGenerator implements ICsvGenerator {
	override void generate(Model content, Language language, IFileSystemAccess2 fsa) { // TODO Auto-generated method stub
		fsa.generateFile('''«content.name»/«language.name»/Dockerfile''', '''
			FROM python
			COPY . /project
			COPY ./inputs /inputs
			WORKDIR project
			ENTRYPOINT python «language.target».py
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

	def encodingFormat(String encoding) {
		switch encoding {
			case 'latin1': 'latin-1'
			case 'utf8': 'utf-8'
		}

	}

	def openAction(Actions action) {
		val open = action.getContainerOfType(Model).actions.filter(OpenCSV).filter [
			it.name == action.name
		].head
		val file = open.file
		val encoding = open.charset
		'''open('«file»', 'rt', encoding='«encoding.encodingFormat»')'''
	}

	def dispatch CharSequence pythonAction(OpenCSV open) ''''''

	def dispatch CharSequence pythonAction(PrintCSV print) '''
		for «print.name»_e in csv.reader(«print.openAction»):
		  print(', '.join(«print.name»_e))
	'''

	def dispatch CharSequence pythonAction(NbRow nbRow) '''
		print(sum(1 for row in csv.reader(«nbRow.openAction»)))
	'''

	def dispatch CharSequence pythonAction(SaveCSV save) {
		val outputfile = if (save.file !== null)
				save.file
			else
				save.getContainerOfType(Model).actions.filter(OpenCSV).filter [
					it.name == save.name
				].head.file
		'''
			with open('«outputfile»', 'wt') as output_file:
			  «save.name»_write = csv.writer(output_file)
			  for «save.name»_e in csv.reader(«save.openAction»):
			    «save.name»_write.writerow(tuple(«save.name»_e))
		'''

	}

	override Map<String, Boolean> properties() {
		return newHashMap("python" -> true)
	}
}
