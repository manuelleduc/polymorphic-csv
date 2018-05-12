package polymorphic.generator.csv

import java.util.Map
import org.eclipse.xtext.generator.IFileSystemAccess2
import polymorphic.csv.Language
import polymorphic.csv.Model
import polymorphic.csv.NbRow
import polymorphic.csv.OpenCSV
import polymorphic.csv.PrintCSV
import polymorphic.csv.SaveCSV
import polymorphic.csv.NbCol
import polymorphic.csv.Action
import polymorphic.csv.RefOpenAction

class Python3_pandasCsvGenerator implements ICsvGenerator {
	
	override void generate(Model content, Language language, IFileSystemAccess2 fsa) { // TODO Auto-generated method stub
		fsa.generateFile('''«content.name»/«language.name»/Dockerfile''', '''
			FROM python3
			COPY . /project
			COPY ./inputs /inputs
			WORKDIR project
			ENTRYPOINT python3 «language.target».py
		''')

		fsa.generateFile('''«content.name»/«language.name»/«language.target».py''','''
			#!/usr/bin/env python3
			import sys
			import pandas
			«FOR action : content.actions»
				«action.pythonAction»
			«ENDFOR»
		''')
	}

	private def dispatch getRelatedOpen(OpenCSV a) { a }

	private def dispatch getRelatedOpen(RefOpenAction a) { a.open }
	
	private def target(OpenCSV a) {
		val open = a.getRelatedOpen.file
		open
	}

	private def encoding(Action action) {
		val encoding = action.getRelatedOpen.charset
		switch encoding {
			case 'latin1': 'latin-1'
			case 'utf8': 'utf-8'
		}
	}
		
	private def dispatch CharSequence pythonAction(OpenCSV open) '''
		df = pandas.read_csv(sys.argv[1]+"«open.target»", encoding="«open.encoding»")
	'''

	private def dispatch CharSequence pythonAction(PrintCSV print) '''
		print(df)
	'''

	private def dispatch CharSequence pythonAction(NbRow nbRow) '''
		print(df.shape[0])
	'''
	
	private def dispatch CharSequence pythonAction(NbCol nbCol) '''
		print(df.shape[1])
	'''

	private def dispatch CharSequence pythonAction(SaveCSV save) { '''
		df.to_csv(sys.argv[1]+"«save.file»", index=False, encoding="«save.encoding»")
	'''
	}

	override Map<String, Boolean> properties() {
		return newHashMap("python3" -> true)
	}
}
