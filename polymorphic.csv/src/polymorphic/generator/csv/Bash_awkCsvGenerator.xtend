package polymorphic.generator.csv

import polymorphic.csv.Model
import polymorphic.csv.Language
import org.eclipse.xtext.generator.IFileSystemAccess2
import polymorphic.csv.OpenCSV
import polymorphic.csv.PrintCSV
import polymorphic.csv.NbRow
import polymorphic.csv.SaveCSV
import polymorphic.csv.NbCol

class Bash_awkCsvGenerator implements ICsvGenerator {

	override generate(Model content, Language language, IFileSystemAccess2 fsa) {
		fsa.generateFile('''«content.name»/«language.name»/«language.target.replaceAll("\\.", "/")».sh''', '''
			#!/bin/bash
			«FOR action : content.actions»
				«action.bashAction»
			«ENDFOR»
		''')
	}
	
	private def dispatch CharSequence bashAction(OpenCSV open) ''''''
	
	private def dispatch CharSequence bashAction(PrintCSV print) '''
		awk '{ print $0 }' «print.open.file»
	'''
	
	private def dispatch CharSequence bashAction(NbRow nbrow) '''
		awk 'END { print NR-1 }' «nbrow.open.file»
	'''
	
	private def dispatch CharSequence bashAction(NbCol nbcol) '''
		awk 'BEGIN { FS = "," } ; END { print NF }' «nbcol.open.file»
	'''
	
	private def dispatch CharSequence bashAction(SaveCSV save) '''
		awk '{ print $0 }' «save.open.file» > «save.file»
	'''

	override properties() {
		newHashMap("bash" -> true)
	}

}