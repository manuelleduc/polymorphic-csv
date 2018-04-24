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

class PythonCsvGenerator implements ICsvGenerator {
	
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
			import csv
			«FOR action : content.actions»
				«action.pythonAction»
			«ENDFOR»
		''')
	}

	def dispatch getRelatedOpen(OpenCSV a) { a }

	def dispatch getRelatedOpen(RefOpenAction a) { a.open }
	
	private def target(RefOpenAction roa) {
		val open = roa.getRelatedOpen.file
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
«««		with open("«open.file»", "r", encoding="«open.charset.encodingFormat»") as CSV_file:
«««			read_file = CSV_file.readlines()
	'''

	private def dispatch CharSequence pythonAction(PrintCSV print) '''
		with open(sys.argv[1]+"«print.target»", "r", encoding="«print.encoding»") as CSV_file:
			read = csv.reader(CSV_file)
			for elt in read:
				print(elt)
	'''

	private def dispatch CharSequence pythonAction(NbRow nbRow) '''
		with open(sys.argv[1]+"«nbRow.target»", "r", encoding="«nbRow.encoding»") as CSV_file:
			read = csv.reader(CSV_file)
			print(sum(1 for elt in read) -1)
	'''
	
	private def dispatch CharSequence pythonAction(NbCol nbCol) '''
		with open(sys.argv[1]+"«nbCol.target»", "r", encoding="«nbCol.encoding»") as CSV_file:
			read = csv.reader(CSV_file)
			first_line = next(read)
			print(sum(1 for elt in first_line))
	'''

	private def dispatch CharSequence pythonAction(SaveCSV save) { '''
		with open(sys.argv[1]+"«save.file»", "w", encoding="«save.encoding»") as read_file:
		    read_W = csv.writer(read_file)
		    with open(sys.argv[1]+"«save.target»", "r", encoding="«save.encoding»") as write_file:
		        read_R = csv.reader(write_file)
		        read_W.writerows(read_R)
	'''
	}

	override Map<String, Boolean> properties() {
		return newHashMap("python3" -> true)
	}
}
