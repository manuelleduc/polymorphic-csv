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
		
		// START // generate readme.txt in /data/... for each .pcsv // YANNICK
		// generate the data folder and subfolders
		fsa.generateFile('''../data/«content.name»/readme.txt''', '''
		HOW TO ADD DATA :
		
		1. create a folder with the name of the .csv file
			( whitout blank space or "/": new folder -> new_folder )
		2. rename the .csv file in "file.csv"
		3. move the file.csv into the folder
		
		The execution's result will be in the folder as 
		result_"name of the .pcsv"_"name of the folder"
		''')
		// END //
		
		// START // generate the exec_main.sh// YANNICK
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
		// END //
		
		// START // generate a exec.sh local for each .pcsv // YANNICK
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
		
			# data's name for main call / local call
			if [ "$1" = "main" ] ; then dataName=${Data_folder_csv:7:-1} ; else dataName=${Data_folder_csv:11:-1} ; fi
			dataName2=${dataName/"/"/_}
			dataName=$( echo $dataName | cut -f2 -d/)

			# path of the results' file	
			echo $target
			target=$Data_folder_csv"result_"$dataName2
		
			printf "////////////////////////////// " >> $target
			date >> $target
			uname -a >> $target
			echo "" >> $target
			echo "## «content.name» ##" >> $target
			echo "" >> $target
			echo "########## $dataName"
			
			# path for main call / path for local call
			# path2 = where are the generated files for the selected languages
			if [ "$1" = "main" ] ; then path2="./src-gen/«content.name»" ; else path2="./" ; fi

			# for each mentioned language
			«FOR l : content.languages»
				echo "# «l.name» #"
				echo "# «l.name» #" >> $target
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
		''')
		// END //
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
