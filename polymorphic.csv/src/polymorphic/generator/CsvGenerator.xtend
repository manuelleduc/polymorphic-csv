/*
 * generated by Xtext 2.13.0
 */
package polymorphic.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import polymorphic.csv.Model

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class CsvGenerator extends AbstractGenerator {

	private GeneratorCollection generators = new GeneratorCollection

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val content = resource.contents.head as Model
		content.languages.forEach [ language |
			generators.map.get(language.name).generate(content, language, fsa)
		]
  	
    	fsa.generateFile('''«content.name»/docker-compose.yml''', '''
		version: '3'
		services:
		  «FOR l : content.languages»
		  «l.name»:
		    build:
		      context: ./«l.name»
          «ENDFOR»
    	''')
		
		fsa.generateFile('''«content.name»/build.sh''', '''
		#!/bin/bash
		mkdir -p ./inputs
		«FOR l : content.languages»
			rm -r ./«l.name»/inputs
			cp -r ./inputs ./«l.name»/inputs
	  	«ENDFOR»
		docker-compose build
		''')
		
		fsa.generateFile('''«content.name»/run.sh''', '''
		#!/bin/bash
		rm -r ./logs
		mkdir -p ./logs
		docker-compose up
		''')
		
		// START 1 // generate GRID.txt in /data/... for each .pcsv // YANNICK
		// generate the data folder and subfolders
		fsa.generateFile('''../data/«content.name»/GRID.txt''', '''
		''')
		// END 1 //
		
		// START 2 // generate GRID.html in /data/... for each .pcsv // YANNICK
		// generate the data folder and subfolders
		fsa.generateFile('''../data/«content.name»/GRID.html''', '''
		''')
		// END 2 //
		
		// START 3 // generate GRID.csv in /data/... for each .pcsv // YANNICK
		// generate the data folder and subfolders
		fsa.generateFile('''../data/«content.name»/GRID.csv''', '''
		''')
		// END 3 //
		
		// START 4 // generate the exec_main.sh// YANNICK
		// exec_main.sh launches the local exec.sh files
		fsa.generateFile('''../exec_main.sh''', '''
		#!/bin/bash
		
		# main exec.sh
		# syntax : bash exec_main.sh
		
		echo "--------------------"
		echo "### EXEC_MAIN.SH ###"
		echo "--------------------"
		
		# for each .pcsv present
		for file in *.pcsv
		do
		    echo ""
			# remove .pcsv to the file == name of the current .pcsv
		    name=${file:0:-5}
		
		    echo "####### Launch of $name #######"
		    echo ""
			
			# launch local exec.sh as main
		    ./src-gen/$name/exec.sh main
		
		    echo "####### End of $name #######"
		    echo "--------------------"
		done
		
		echo ""
		echo "### END OF EXEC_MAIN.SH ###"
		echo "--------------------"
		''')
		// END 4 //
		
		// START 5 // generate a exec.sh local for each .pcsv // YANNICK
		// produce results
		// fill GRID.txt and GRID.html
		fsa.generateFile('''«content.name»/exec.sh''', '''
		#!/bin/bash
		
		# local exec.sh «content.name»
		# syntax : bash exec.sh
		
		# path of "code_X" for main call / local call
		# path1 = where are data of the .pcsv
		if [ "$1" = "main" ] ; then path1="./data/«content.name»/" ; else path1="../../data/«content.name»/" ; fi
		
		# for each data folder in directory_pcsv
		for Data_folder_csv in $path1*/
		do
		
			# data's name for main call / local call = code's name + data's name
			if [ "$1" = "main" ] ; then dataName=${Data_folder_csv:7:-1} ; else dataName=${Data_folder_csv:11:-1} ; fi
			# remove "/" for naming
			dataName2=${dataName/"/"/_}
			# only data's name
			dataName=$( echo $dataName | cut -f2 -d/ )

			# path and name of the results' file	
			target=$Data_folder_csv"result_"$dataName2
		
			# creation of the results file as target
			printf "////////////////////////////// " > $target
			date >> $target
			uname -a >> $target
			echo "" >> $target
			echo "## «content.name» ## $dataName" >> $target
			echo "" >> $target
			echo "########## $dataName"
			
			# path for main call / path for local call
			# path2 = where are the generated files for the selected languages
			if [ "$1" = "main" ] ; then path2="./src-gen/«content.name»" ; else path2="./" ; fi

			# for each mentioned language
			«FOR l : content.languages»
				echo "# START «l.name» #"
				echo "# START «l.name» #" >> $target
				echo "" >> $target
				# command line's syntax by language
				«switch l.name {
					case 'java': 'mvn compile exec:java -Dexec.mainClass="myjava" -Dexec.args="${Data_folder_csv}" -f "${path2}/'+l.name+'"'
									+' | tee >(grep -v "^.INFO] " >> $target) '
										+'| grep "^.INFO] "'
					case 'commons': 'mvn compile exec:java -Dexec.mainClass="mycommons" -Dexec.args="${Data_folder_csv}" -f "${path2}/'+l.name+'"'
									+' | tee >(grep -v "^.INFO] " >> $target) '
										+'| grep "^.INFO] "'
					default: bash_command(l.name)+'"${path2}"/'+l.name+'/'+l.target+'.'+file_extension(l.name)+' $Data_folder_csv >> $target'
				}»
				echo "" >> $target
				echo "# END «l.name» #" >> $target
				echo "# END «l.name» #"
				echo ""
				echo "----------------------------------------" >> $target
				
			«ENDFOR»
		
		done
		
		# START PARSING results to fill GRID.txt
		# for each data folder in directory_pcsv
		for Data_folder_csv in $path1*/
		do
		
			awk -v path=$path1 '
			BEGIN { }
			{
			# name of the .pcsv
			if ($0 ~ "^## ") { code_name = $2 }
			# name of the data
			if ($0 ~ "^## ") { data_name = $4 }
			# languages generated
			if ($0 ~ "^# START ") { languages[n++] = $3 ; target_result = NR+2 ; target_result2 = NR+3 }
			# results collect
			if (NR == target_result) { results[m++] = $1 }
			if (NR == target_result2 && $0 != "") { results2[m-1] = $1 }
			}
			END {
			# header already present
			if ( system("test -s " path "GRID.txt") ) {
				l1 = sprintf("%-20s",code_name)
				i = 0
				while ( languages[i] ) { l1 = l1 sprintf("|%-10s",languages[i]); i++ }
				var = 20+(11*i)
				for(c=0;c<var;c++) {printf "|"} ; print ""
				print l1
				for(c=0;c<var;c++) {printf "|"} ; print ""
			}
			# results line
			l2 = sprintf("%-20s",data_name)
			i = 0
			while ( results[i] ) { l2 = l2 sprintf("|%-10s",results[i] ); i++ }
			print l2
			# if second line
			if ( results2[0]) {
				l3 = sprintf("%-20s",data_name"_copy")
				i = 0
				while ( results2[i] ) { l3 = l3 sprintf("|%-10s",results2[i] ); i++ }
				print l3
			}
			} # END END
			' $Data_folder_csv"result_"* >> $path1"GRID.txt"
		
		done
		# END PARSING
		
		# START PARSING GRID.txt to fill GRID.html
		awk -v path=$path1 '
		BEGIN {
		print "<!DOCTYPE html>"
		print "<html>"
		print "<head>"
		print "<title>GRID.html</title>"
		print "<meta charset="utf-8" />"
		print "</head>"
		print "<body style=\"font-family:Courier New,Bitstream Vera Sans Mono;white-space:pre\">"

		}
		{
		print $0
		}
		END {
		print "</body>"
		print "</html>"
		}
		' $path1"GRID.txt" > $path1"GRID.html"
		# END PARSING
		
		# START PARSING results to fill GRID.csv
		# for each data folder in directory_pcsv
		for Data_folder_csv in $path1*/
		do
		
			awk -v path=$path1 '
			BEGIN { }
			{
			# name of the .pcsv
			if ($0 ~ "^## ") { code_name = $2 }
			# name of the data
			if ($0 ~ "^## ") { data_name = $4 }
			# languages generated
			if ($0 ~ "^# START ") { languages[n++] = $3 ; target_result = NR+2 ; target_result2 = NR+3 }
			# results collect
			if (NR == target_result) { results[m++] = $1 }
			if (NR == target_result2 && $0 != "") { results2[m-1] = $1 }
			}
			END {
			# header already present
			if ( system("test -s " path "GRID.csv") ) {
				l1 = code_name
				i = 0
				while ( languages[i] ) { l1 = l1","languages[i]; i++ }
				print l1
			}
			l2 = data_name
			i = 0
			while ( results[i] ) { l2 = l2","results[i]; i++ }
			print l2
			# if second line
			if ( results2[0] ) {
				l3 = data_name"_copy"
				i = 0
				while ( results2[i] ) { l3 = l3","results2[i]; i++ }
				print l3
			}
			} # END END
			' $Data_folder_csv"result_"* >> $path1"GRID.csv"
		
		done
		# END PARSING
		''')
		// END 5 //
	}
	
	private def bash_command(String language) {
		val command = language
		switch command {
			case 'bash': ''
			case 'bash_awk': ''
			case 'R': 'Rscript '
			case 'R_fwrite': 'Rscript '
			case 'python3': 'python3 '
			default: '#'
		}
	}
	
	private def file_extension(String language) {
		val dot_extension = language
		switch dot_extension {
			case 'bash': 'sh'
			case 'bash_awk': 'sh'
			case 'R': 'R'
			case 'R_fwrite': 'R'
			case 'python3': 'py'
			default: '#'
		}
	}

}
