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

class PythonCsvGenerator implements ICsvGenerator {
	
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
				#!/usr/bin/env python
				import csv
				«FOR action : content.actions»
					«action.pythonAction»
				«ENDFOR»
				
			'''
		)
	}
	
	private def encodingFormat(String encoding) {
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
		with open("«print.open.file»", "r", encoding="«print.open.charset.encodingFormat»") as CSV_file:
			read = csv.reader(CSV_file)
			for elt in read:
				print(elt)
	'''

	private def dispatch CharSequence pythonAction(NbRow nbRow) '''
		with open("«nbRow.open.file»", "r", encoding="«nbRow.open.charset.encodingFormat»") as CSV_file:
			read = csv.reader(CSV_file)
			print(sum(1 for elt in read))
	'''
	
	private def dispatch CharSequence pythonAction(NbCol nbCol) '''
		with open("«nbCol.open.file»", "r", encoding="«nbCol.open.charset.encodingFormat»") as CSV_file:
			read = csv.reader(CSV_file)
			first_line = next(read)
			print(sum(1 for elt in first_line))
	'''

	private def dispatch CharSequence pythonAction(SaveCSV save) { '''
		with open("«save.file»", "w", encoding="«save.open.charset.encodingFormat»") as read_file:
		    read = csv.writer(read_file)
		    with open("«save.open.file»", "r", encoding="«save.open.charset.encodingFormat»") as write_file:
		        read_Y = csv.reader(write_file)
		        read.writerows(read_Y)
	'''
	}

	override Map<String, Boolean> properties() {
		return newHashMap("python" -> true)
	}
}
