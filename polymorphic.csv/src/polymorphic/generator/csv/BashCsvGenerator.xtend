package polymorphic.generator.csv

import polymorphic.csv.Model
import polymorphic.csv.Language
import org.eclipse.xtext.generator.IFileSystemAccess2
import polymorphic.csv.OpenCSV
import polymorphic.csv.PrintCSV
import polymorphic.csv.NbRow
import polymorphic.csv.SaveCSV

class BashCsvGenerator implements ICsvGenerator {

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
		cat «print.open.file»
	'''
	
	private def dispatch CharSequence bashAction(NbRow nbrow) '''
		echo $[$(wc -l < «nbrow.open.file»)-1]
	'''
	
	private def dispatch CharSequence bashAction(SaveCSV save) '''
		cp «save.open.file» «save.file»
	'''

	override properties() {
		newHashMap()
	}

}
