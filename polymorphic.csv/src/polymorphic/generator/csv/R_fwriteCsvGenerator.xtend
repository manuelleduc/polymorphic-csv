package polymorphic.generator.csv

import polymorphic.csv.Model
import polymorphic.csv.Language
import polymorphic.csv.OpenCSV
import polymorphic.csv.PrintCSV
import polymorphic.csv.NbRow
import polymorphic.csv.NbCol
import polymorphic.csv.SaveCSV
import org.eclipse.xtext.generator.IFileSystemAccess2

class R_fwriteCsvGenerator implements ICsvGenerator {
	
	override generate(Model content, Language language, IFileSystemAccess2 fsa) {
		fsa.generateFile('''«content.name»/«language.name»/«language.target.replaceAll("\\.", "/")».R''', '''
			#install.packages("data.table")
			library(data.table)
			args <- commandArgs(trailingOnly=TRUE)
			root <- args[1]
			«FOR action : content.actions»
				«action.RAction»
			«ENDFOR»
		''')
	}
	
	private def dispatch CharSequence RAction(OpenCSV open) '''
	«open.name» = read.csv(paste(root,"«open.file»",sep=""), header=TRUE, sep=",")
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
	fwrite( «save.open.name», file = "paste(root,"«save.file»",sep="")", quote = "auto" )
	'''

	override properties() {
		newHashMap("R_fwrite" -> true)
	}

}