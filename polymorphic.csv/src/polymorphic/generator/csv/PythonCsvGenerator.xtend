package polymorphic.generator.csv

import java.util.Map
import org.eclipse.xtext.generator.IFileSystemAccess2
import polymorphic.csv.Action
import polymorphic.csv.Language
import polymorphic.csv.Model
import polymorphic.csv.NbRow
import polymorphic.csv.OpenCSV
import polymorphic.csv.PrintCSV
import polymorphic.csv.RefOpenAction
import polymorphic.csv.SaveCSV

import static extension org.eclipse.xtext.EcoreUtil2.*
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
				# -*- coding: utf-8 -*-
				from __future__ import print_function
				import csv
				«FOR action : content.actions»
					«action.pythonAction»
				«ENDFOR»
				
			'''
		)
	}

	private def dispatch CharSequence pythonAction(OpenCSV open) '''
		with open("«open.file»") as read:
			tmp = read.readlines()
	'''

	private def dispatch CharSequence pythonAction(PrintCSV print) '''
		for line in tmp:
		  print(line, end="")
	'''

	private def dispatch CharSequence pythonAction(NbRow nbRow) '''
		print(sum(1 for row in tmp) -1 )
	'''
	
	private def dispatch CharSequence pythonAction(NbCol nbCol) '''
		
	'''

	private def dispatch CharSequence pythonAction(SaveCSV save) { '''

	'''
	}

	override Map<String, Boolean> properties() {
		return newHashMap("python" -> true)
	}

}
