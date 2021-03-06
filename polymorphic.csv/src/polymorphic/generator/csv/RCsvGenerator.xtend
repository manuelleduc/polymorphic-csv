package polymorphic.generator.csv

import polymorphic.csv.Model
import polymorphic.csv.Language
import org.eclipse.xtext.generator.IFileSystemAccess2
import polymorphic.csv.OpenCSV
import polymorphic.csv.PrintCSV
import polymorphic.csv.NbRow
import polymorphic.csv.SaveCSV
import polymorphic.csv.NbCol

class RCsvGenerator implements ICsvGenerator {
	
	override generate(Model content, Language language, IFileSystemAccess2 fsa) {
		fsa.generateFile('''«content.name»/«language.name»/«language.target.replaceAll("\\.", "/")».R''', '''
			args <- commandArgs(trailingOnly=TRUE)
			path <- args[1]
			«FOR action : content.actions»
				«action.RAction»
			«ENDFOR»
		''')
	}
	
	private def dispatch CharSequence RAction(OpenCSV open) '''
	«open.name» = read.csv(paste(path,"«open.file»",sep=""), header=TRUE, sep=",")
	'''
	
	private def dispatch CharSequence RAction(PrintCSV print) '''
	«print.open.name»
	'''
	
	private def dispatch CharSequence RAction(NbRow nbrow) '''
	cat( nrow(«nbrow.open.name»),"\n" )
	'''
	
	private def dispatch CharSequence RAction(NbCol nbcol) '''
	cat( ncol(«nbcol.open.name»),"\n" )
	'''
	
	private def dispatch CharSequence RAction(SaveCSV save) '''
	write.csv( «save.open.name», paste(path,"«save.file»",sep=""), quote=TRUE, row.names=FALSE )
	'''

	override properties() {
		newHashMap("R" -> true)
	}

}
