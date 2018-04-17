package polymorphic.generator.csv

import polymorphic.csv.Model
import polymorphic.csv.Language
import org.eclipse.xtext.generator.IFileSystemAccess2
import polymorphic.csv.OpenCSV
import polymorphic.csv.PrintCSV
import polymorphic.csv.NbRow
import polymorphic.csv.SaveCSV

class RCsvGenerator implements ICsvGenerator {
	
	override generate(Model content, Language language, IFileSystemAccess2 fsa) {
		fsa.generateFile('''«content.name»/«language.name»/«language.target.replaceAll("\\.", "/")».R''', '''
			«FOR action : content.actions»
				«action.RAction»
			«ENDFOR»
		''')
	}
	
	private def dispatch CharSequence RAction(OpenCSV open) '''
	table = read.csv("«open.file»", header=TRUE, sep=",")
	'''
	
	private def dispatch CharSequence RAction(PrintCSV print) '''
	table
	'''
	
	private def dispatch CharSequence RAction(NbRow nbrow) '''
	nrow(table)
	'''
	
	private def dispatch CharSequence RAction(SaveCSV save) '''
	write.csv(table, "«save.file»", quote=FALSE, row.names=FALSE)
	'''

	override properties() {
		newHashMap("R" -> true)
	}

}
