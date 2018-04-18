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
				#!/usr/bin/python
				# -*- coding: utf-8 -*-
				from __future__ import print_function
				import csv
				«FOR action : content.actions»
					«action.pythonAction»
				«ENDFOR»
				
			'''
		)
	}

	private def dispatch CharSequence pythonAction(OpenCSV open) ''''''

	private def dispatch CharSequence pythonAction(PrintCSV print) '''
		with open("«print.open.file»", "r") as CSV_file:
			read = csv.reader(CSV_file)
			for elt in read:
				print(elt)
	'''

	private def dispatch CharSequence pythonAction(NbRow nbRow) '''
		with open("«nbRow.open.file»", "r") as CSV_file:
			read = csv.reader(CSV_file)
			print(sum(1 for elt in read))
	'''
	
	private def dispatch CharSequence pythonAction(NbCol nbCol) '''
		with open("«nbCol.open.file»", "r") as CSV_file:
			read = csv.reader(CSV_file)
			print(sum(1 for elt in read))
	'''

	private def dispatch CharSequence pythonAction(SaveCSV save) { '''

	'''
	}

	override Map<String, Boolean> properties() {
		return newHashMap("python" -> true)
	}

}
