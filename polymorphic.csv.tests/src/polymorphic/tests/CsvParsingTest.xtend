/*
 * generated by Xtext 2.13.0
 */
package polymorphic.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith
import polymorphic.csv.CsvPackage
import polymorphic.csv.Model
import polymorphic.tests.lib.PolymorphicCsvCompilationTestHelper
import polymorphic.validation.CsvValidator

@RunWith(XtextRunner)
@InjectWith(CsvInjectorProvider)
class CsvParsingTest {
	@Inject extension ParseHelper<Model>
	@Inject extension PolymorphicCsvCompilationTestHelper
	@Inject extension ValidationTestHelper

	@Test
	def bashTest_old(){
		'''
		package mpackage;
					
		constraints {
			java = true
			maven = true
		}
		languages {
			bash (a.b.java.C)
		}
		read a "/tmp/test.csv"
		print a
		save a "/tmp/test2.csv"
		'''.assertCompilesTo('''
		MULTIPLE FILES WERE GENERATED
		
		File 1 : /myProject/./src-gen/mpackage/bash/a/b/java/C.sh
		
		#!/bin/bash
		cat $1/tmp/test.csv
		cat $1/tmp/test.csv > $1/tmp/test2.csv
		
		File 2 : /myProject/./src-gen/mpackage/build.sh
		
		#!/bin/bash
		mkdir -p ./inputs
		rm -r ./bash/inputs
		cp -r ./inputs ./bash/inputs
		docker-compose build
		
		File 3 : /myProject/./src-gen/mpackage/docker-compose.yml
		
		version: '3'
		services:
		  bash:
		    build:
		      context: ./bash
		
		File 4 : /myProject/./src-gen/mpackage/exec.sh
		
		#!/bin/bash
		
		# local exec.sh mpackage
		# syntax : bash exec.sh
		
		# path of "code_X"" for main call / local call
		if [ "$1" = "main" ] ; then path1="./data/mpackage/" ; else path1="../../data/mpackage/" ; fi
		
		# for each folder in directory
		for D in $path1*/
		do
		
			# data's name for main call / local call
			if [ "$1" = "main" ] ; then dataNb=${D:14:-1} ; else dataNb=${D:18:-1} ; fi
		
			# path of the results' file	
			target=$D"result_mpackage_"$dataNb
		
			printf "////////////////////////////// " >> $target
			date >> $target
			uname -a >> $target
			echo "" >> $target
			echo "## mpackage ##" >> $target
			echo "" >> $target
			echo "########## $dataNb"
			
			# path for main call / path for local call
			if [ "$1" = "main" ] ; then path2="./src-gen/mpackage" ; else path2="./" ; fi
		
			# for each mentioned language
			echo "# bash #"
			echo "# bash #" >> $target
			echo "" >> $target
			"${path2}"/bash/a.b.java.C.sh $D >> $target
			echo "" >> $target
			echo "# END bash #" >> $target
			echo "# END bash #"
			echo ""
			echo "----------------------------------------" >> $target
			
		
		done

		File 5 : /myProject/./src-gen/mpackage/run.sh
		
		#!/bin/bash
		rm -r ./logs
		mkdir -p ./logs
		docker-compose up
		
		''')
	}
	
	@Test
	def bashTest_awk(){
		'''
		package important;
		
		constraints {
			
		}
		
		languages {
			bash_awk (truc)
		}
		
		read aaa "/home/yannick/Bureau/dossier_test/Sans_nom_1.csv" utf8
		print aaa
		nbrow aaa
		nbcol aaa
		save aaa "/home/yannick/Bureau/dossier_test/Copy_Sans_nom_1.csv"
		read bbb "/home/yannick/Bureau/dossier_test/Copy_Sans_nom_1.csv" utf8
		print bbb
		nbrow bbb
		nbcol bbb

		'''.assertFileCompilesTo(#{'''/myProject/./src-gen/important/bash_awk/truc.sh''' -> '''	
		#!/bin/bash
		awk '{ print $0 }' $1/home/yannick/Bureau/dossier_test/Sans_nom_1.csv
		awk 'END { print NR-1 }' $1/home/yannick/Bureau/dossier_test/Sans_nom_1.csv
		awk 'BEGIN { FS = "," } ; END { print NF }' $1/home/yannick/Bureau/dossier_test/Sans_nom_1.csv
		awk '{ print $0 }' $1/home/yannick/Bureau/dossier_test/Sans_nom_1.csv > $1/home/yannick/Bureau/dossier_test/Copy_Sans_nom_1.csv
		awk '{ print $0 }' $1/home/yannick/Bureau/dossier_test/Copy_Sans_nom_1.csv
		awk 'END { print NR-1 }' $1/home/yannick/Bureau/dossier_test/Copy_Sans_nom_1.csv
		awk 'BEGIN { FS = "," } ; END { print NF }' $1/home/yannick/Bureau/dossier_test/Copy_Sans_nom_1.csv
		'''}
		)
	}
	
	@Test
	def bashTest(){
		'''
		package important;
		
		constraints {
			
		}
		
		languages {
			bash (truc)
		}
		
		read aaa "/home/yannick/Bureau/dossier_test/Sans_nom_1.csv" utf8
		print aaa
		nbrow aaa
		nbcol aaa
		save aaa "/home/yannick/Bureau/dossier_test/Copy_Sans_nom_1.csv"
		read bbb "/home/yannick/Bureau/dossier_test/Copy_Sans_nom_1.csv" utf8
		print bbb
		nbrow bbb
		nbcol bbb

		'''.assertFileCompilesTo(#{'''/myProject/./src-gen/important/bash/truc.sh''' -> '''	
		#!/bin/bash
		cat $1/home/yannick/Bureau/dossier_test/Sans_nom_1.csv
		echo $[$(wc -l < $1/home/yannick/Bureau/dossier_test/Sans_nom_1.csv)-1]
		head -1 $1/home/yannick/Bureau/dossier_test/Sans_nom_1.csv | sed 's/[^,]//g' | wc -c
		cat $1/home/yannick/Bureau/dossier_test/Sans_nom_1.csv > $1/home/yannick/Bureau/dossier_test/Copy_Sans_nom_1.csv
		cat $1/home/yannick/Bureau/dossier_test/Copy_Sans_nom_1.csv
		echo $[$(wc -l < $1/home/yannick/Bureau/dossier_test/Copy_Sans_nom_1.csv)-1]
		head -1 $1/home/yannick/Bureau/dossier_test/Copy_Sans_nom_1.csv | sed 's/[^,]//g' | wc -c
		'''}
		)
	}
	
	@Test
	def RTest(){
		'''
		package important;
		
		constraints {
			
		}
		
		languages {
			R (file_R)
		}
		
		read aaa "/home/yannick/Bureau/dossier_test/Sans_nom_1.csv" utf8
		print aaa
		nbrow aaa
		nbcol aaa
		save aaa "/home/yannick/Bureau/dossier_test/Copy_Sans_nom_1.csv"

		'''.assertFileCompilesTo(#{'''/myProject/./src-gen/important/R/file_R.R''' -> '''
		args <- commandArgs(trailingOnly=TRUE)
		root <- args[1]
		aaa = read.csv(paste(root,"/home/yannick/Bureau/dossier_test/Sans_nom_1.csv",sep=""), header=TRUE, sep=",")
		aaa
		cat( nrow(aaa),"\n" )
		cat( ncol(aaa),"\n" )
		write.csv( aaa, paste(root,"/home/yannick/Bureau/dossier_test/Copy_Sans_nom_1.csv",sep=""), quote=FALSE, row.names=FALSE )
		'''}
		)
	}
	
	@Test
	def RTest_fwrite(){
		'''
		package important;
		
		constraints {
			
		}
		
		languages {
			R_fwrite (file_R_fwrite)
		}
		
		read aaa "/home/yannick/Bureau/dossier_test/Sans_nom_1.csv" utf8
		print aaa
		nbrow aaa
		nbcol aaa
		save aaa "/home/yannick/Bureau/dossier_test/Copy_Sans_nom_1.csv"

		'''.assertFileCompilesTo(#{'''/myProject/./src-gen/important/R_fwrite/file_R_fwrite.R''' -> '''
		#install.packages("data.table")
		library(data.table)
		args <- commandArgs(trailingOnly=TRUE)
		root <- args[1]
		aaa = read.csv(paste(root,"/home/yannick/Bureau/dossier_test/Sans_nom_1.csv",sep=""), header=TRUE, sep=",")
		aaa
		cat( nrow(aaa),"\n" )
		cat( ncol(aaa),"\n" )
		fwrite( aaa, file = paste(root,"/home/yannick/Bureau/dossier_test/Copy_Sans_nom_1.csv",sep=""), quote = "auto" )
		'''}
		)
	}

	@Test
	def pythonTest(){
		'''
		package important;
		
		constraints {
			
		}
		
		languages {
			python3 (truc)
		}
		
		read aaa "/udd/ynamour/Desktop/dossier_test/Sans_nom_1.csv" utf8
		print aaa
		nbrow aaa
		nbcol aaa
		save aaa "/udd/ynamour/Desktop/dossier_test/test_copy.csv"
		read bbb "/udd/ynamour/Desktop/dossier_test/test_copy.csv" latin1
		print bbb
		nbrow bbb
		nbcol bbb

		'''.assertFileCompilesTo(#{'''/myProject/./src-gen/important/python3/truc.py''' -> '''	
		#!/usr/bin/env python3
		import sys
		import csv
		with open(sys.argv[1]+"/udd/ynamour/Desktop/dossier_test/Sans_nom_1.csv", "r", encoding="utf-8") as CSV_file:
			read = csv.reader(CSV_file)
			for elt in read:
				print(elt)
		with open(sys.argv[1]+"/udd/ynamour/Desktop/dossier_test/Sans_nom_1.csv", "r", encoding="utf-8") as CSV_file:
			read = csv.reader(CSV_file)
			print(sum(1 for elt in read) -1)
		with open(sys.argv[1]+"/udd/ynamour/Desktop/dossier_test/Sans_nom_1.csv", "r", encoding="utf-8") as CSV_file:
			read = csv.reader(CSV_file)
			first_line = next(read)
			print(sum(1 for elt in first_line))
		with open(sys.argv[1]+"/udd/ynamour/Desktop/dossier_test/test_copy.csv", "w", encoding="utf-8") as read_file:
		    read_W = csv.writer(read_file)
		    with open(sys.argv[1]+"/udd/ynamour/Desktop/dossier_test/Sans_nom_1.csv", "r", encoding="utf-8") as write_file:
		        read_R = csv.reader(write_file)
		        read_W.writerows(read_R)
		with open(sys.argv[1]+"/udd/ynamour/Desktop/dossier_test/test_copy.csv", "r", encoding="latin-1") as CSV_file:
			read = csv.reader(CSV_file)
			for elt in read:
				print(elt)
		with open(sys.argv[1]+"/udd/ynamour/Desktop/dossier_test/test_copy.csv", "r", encoding="latin-1") as CSV_file:
			read = csv.reader(CSV_file)
			print(sum(1 for elt in read) -1)
		with open(sys.argv[1]+"/udd/ynamour/Desktop/dossier_test/test_copy.csv", "r", encoding="latin-1") as CSV_file:
			read = csv.reader(CSV_file)
			first_line = next(read)
			print(sum(1 for elt in first_line))
		'''}
		)
	}
	
	@Test
	def void loadModel() {
		'''
			package uuu;
			
			constraints {
				java = true
				maven = true
			}
			languages {
				java (a.b.java.C)
				commons (a.b.commons.C)
				python3 (python3_version)
			}
			read a "/tmp/test.csv"
			print a
			//save a
			save a "/tmp/test2.csv"
		'''.assertFileCompilesTo(#{'''/myProject/./src-gen/uuu/build.sh''' -> '''
				#!/bin/bash
				mkdir -p ./inputs
				rm -r ./java/inputs
				cp -r ./inputs ./java/inputs
				rm -r ./commons/inputs
				cp -r ./inputs ./commons/inputs
				rm -r ./python3/inputs
				cp -r ./inputs ./python3/inputs
				docker-compose build
			''', '''/myProject/./src-gen/uuu/commons/Dockerfile''' -> '''
				FROM maven
				COPY . /project
				COPY ./inputs /inputs
				WORKDIR project
				RUN mvn compile
				ENTRYPOINT  mvn -q exec:java -Dexec.mainClass="a.b.commons.C"
			''', '''/myProject/./src-gen/uuu/commons/pom.xml''' -> '''
				<project>
				    <modelVersion>4.0.0</modelVersion>
				    <groupId>uuu</groupId>
				    <artifactId>a.b.commons.C</artifactId>
				    <version>1</version>
				    
				      <properties>
				        <maven.compiler.source>1.8</maven.compiler.source>
				        <maven.compiler.target>1.8</maven.compiler.target>
				         <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
				      </properties>
				    
				    <dependencies>
						<dependency>
							<groupId>org.apache.commons</groupId>
							<artifactId>commons-csv</artifactId>
							<version>1.5</version>
						</dependency>
					</dependencies>
				</project>
			''', '''/myProject/./src-gen/uuu/commons/src/main/java/a/b/commons/C.java''' -> '''
				package a.b.commons;
				
				import java.io.*;
				import java.util.*;
				import org.apache.commons.csv.*;
				import java.util.stream.StreamSupport;
				import java.util.stream.Collectors;
				
				public class C {
				 	public static void main(String[] args) throws  FileNotFoundException, IOException {
					final List<CSVRecord> a = StreamSupport.stream(CSVFormat.RFC4180.parse(new FileReader("/tmp/test.csv")).spliterator(), false).collect(Collectors.toList());
					final StringBuilder sb0 = new StringBuilder();
					try (CSVPrinter tmp0 = new CSVPrinter(sb0, CSVFormat.RFC4180)) {
						tmp0.printRecords(a);
					}
					System.out.println(sb0);
					try (CSVPrinter tmp1 = new CSVPrinter(new FileWriter(new File("/tmp/test2.csv")), CSVFormat.RFC4180)) {
						tmp1.printRecords(a);
					}
					}
				}
			''', '''/myProject/./src-gen/uuu/docker-compose.yml''' -> '''
				version: '3'
				services:
				  java:
				    build:
				      context: ./java
				  commons:
				    build:
				      context: ./commons
				  python3:
				    build:
				      context: ./python3
			''', '''/myProject/./src-gen/uuu/java/Dockerfile''' -> '''
				FROM maven
				COPY . /project
				COPY ./inputs /inputs
				WORKDIR project
				RUN mvn compile
				ENTRYPOINT  mvn -q exec:java -Dexec.mainClass="a.b.java.C"
			''', '''/myProject/./src-gen/uuu/java/pom.xml''' -> '''
				<project>
				    <modelVersion>4.0.0</modelVersion>
				    <groupId>uuu</groupId>
				    <artifactId>a.b.java.C</artifactId>
				    <version>1</version>
				    
				      <properties>
				        <maven.compiler.source>1.8</maven.compiler.source>
				        <maven.compiler.target>1.8</maven.compiler.target>
				         <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
				      </properties>
				</project>
			''', '''/myProject/./src-gen/uuu/java/src/main/java/a/b/java/C.java''' -> '''
				package a.b.java;
				
				import java.io.*;
				import java.awt.Point;
				import java.util.HashMap;
				import java.util.Scanner;
				
				public class C {
				
					private HashMap<Point, String> _map = new HashMap<Point, String>();
					private int _cols;
					private int _rows;
				
					public void open(File file) throws FileNotFoundException, IOException {
					open(file, ',');
					}
				
					public void open(File file, char delimiter) throws FileNotFoundException, IOException {
					Scanner scanner = new Scanner(file);
					scanner.useDelimiter(Character.toString(delimiter));
				
						while(scanner.hasNextLine()) {
					String[] values = scanner.nextLine().split(Character.toString(delimiter));
				
							int col = 0;
							for ( String value: values ) {
					_map.put(new Point(col, _rows), value);
					_cols = Math.max(_cols, ++col);
							}
							_rows++;
						}
						scanner.close();
					}
				
					public void save(File file) throws IOException {
					save(file, ',');
					}
					
					public void save(File file, char delimiter) throws IOException {
						FileWriter fw = new FileWriter(file);
						BufferedWriter bw = new BufferedWriter(fw);
						
						for (int row = 0; row < _rows; row++) {
							for (int col = 0; col < _cols; col++) {
							Point key = new Point(col, row);
								if (_map.containsKey(key)) {
									bw.write(_map.get(key));
								}
								
								if ((col + 1) < _cols) {
									bw.write(delimiter);
								}
							}
							bw.newLine();
						}
						bw.flush();
						bw.close();
					}
					
					public String serialize(final char delimiter) throws IOException {
						final StringBuilder sb = new StringBuilder();
						
						for (int row = 0; row < _rows; row++) {
							for (int col = 0; col < _cols; col++) {
								final Point key = new Point(col, row);
								if (_map.containsKey(key)) {
									sb.append(_map.get(key));
								}
								
								if ((col + 1) < _cols) {
									sb.append(delimiter);
								}
							}
							sb.append(System.lineSeparator());
						}
						return sb.toString();
					}
					
					public String get(int col, int row) {
						String val = "";
						Point key = new Point(col, row);
						if (_map.containsKey(key)) {
							val = _map.get(key);
						}
						return val;
					}
					
					public void put(int col, int row, String value) {
						_map.put(new Point(col, row), value);
						_cols = Math.max(_cols, col+1);
						_rows = Math.max(_rows, row+1);
					}
					
					public int rows() { return this._rows; }
					
					public static void main(String[] args) {
						try {
						     	C a = new C();
						     	a.open(new File("/tmp/test.csv"));
						     	System.out.println(a.serialize(';'));
						     	a.save(new File("/tmp/test2.csv"));
						} catch (Exception e) {
							System.out.println(e);
						}
					}
				}
			''', '''/myProject/./src-gen/uuu/python3/Dockerfile''' -> '''
				FROM python3
				COPY . /project
				COPY ./inputs /inputs
				WORKDIR project
				ENTRYPOINT python3 python3_version.py
			''', '''/myProject/./src-gen/uuu/python3/python3_version.py''' -> '''
				#!/usr/bin/env python3
				import sys
				import csv
				with open(sys.argv[1]+"/tmp/test.csv", "r", encoding="") as CSV_file:
					read = csv.reader(CSV_file)
					for elt in read:
						print(elt)
				with open(sys.argv[1]+"/tmp/test2.csv", "w", encoding="") as read_file:
				    read_W = csv.writer(read_file)
				    with open(sys.argv[1]+"/tmp/test.csv", "r", encoding="") as write_file:
				        read_R = csv.reader(write_file)
				        read_W.writerows(read_R)
			''', '''/myProject/./src-gen/uuu/run.sh''' -> '''
				#!/bin/bash
				rm -r ./logs
				mkdir -p ./logs
				docker-compose up
			'''}
		)
	}

	@Test
	def void loadModelPython() {
		'''
			package foo;
			constraints {
			    java = true
			    maven = true
			}
			languages {
			    python3 (a)
			}
			read a "/tmp/test.csv"
			nbrow a
			//print a
			read b "/tmp/test2.csv"
			nbrow b
			//print b
		'''.assertFileCompilesTo(#{'''/myProject/./src-gen/foo/build.sh''' -> '''
			#!/bin/bash
			mkdir -p ./inputs
			rm -r ./python3/inputs
			cp -r ./inputs ./python3/inputs
			docker-compose build
		''', '''/myProject/./src-gen/foo/docker-compose.yml''' -> '''
			version: '3'
			services:
			  python3:
			    build:
			      context: ./python3
		''', '''/myProject/./src-gen/foo/python3/Dockerfile''' -> '''
			FROM python3
			COPY . /project
			COPY ./inputs /inputs
			WORKDIR project
			ENTRYPOINT python3 a.py
		''', '''/myProject/./src-gen/foo/python3/a.py''' -> '''
			#!/usr/bin/env python3
			import sys
			import csv
			with open(sys.argv[1]+"/tmp/test.csv", "r", encoding="") as CSV_file:
				read = csv.reader(CSV_file)
				print(sum(1 for elt in read) -1)
			with open(sys.argv[1]+"/tmp/test2.csv", "r", encoding="") as CSV_file:
				read = csv.reader(CSV_file)
				print(sum(1 for elt in read) -1)
		''', '''/myProject/./src-gen/foo/run.sh''' -> '''
			#!/bin/bash
			rm -r ./logs
			mkdir -p ./logs
			docker-compose up
		'''}
		)
	}

	@Test
	def void testNbRows() {
		'''
			package uuu;
			
			constraints {
			}
			languages {
				java (a.b.java.C)
				commons (a.b.commons.C)
				python3 (python3_version)
			}
			read a "/tmp/test.csv"
			nbrow a
		'''.assertFileCompilesTo(#{'''/myProject/./src-gen/uuu/build.sh''' -> '''
			#!/bin/bash
			mkdir -p ./inputs
			rm -r ./java/inputs
			cp -r ./inputs ./java/inputs
			rm -r ./commons/inputs
			cp -r ./inputs ./commons/inputs
			rm -r ./python3/inputs
			cp -r ./inputs ./python3/inputs
			docker-compose build
		''', '''/myProject/./src-gen/uuu/commons/Dockerfile''' -> '''
			FROM maven
			COPY . /project
			COPY ./inputs /inputs
			WORKDIR project
			RUN mvn compile
			ENTRYPOINT  mvn -q exec:java -Dexec.mainClass="a.b.commons.C"
		''', '''/myProject/./src-gen/uuu/commons/pom.xml''' -> '''
			<project>
			    <modelVersion>4.0.0</modelVersion>
			    <groupId>uuu</groupId>
			    <artifactId>a.b.commons.C</artifactId>
			    <version>1</version>
			    
			      <properties>
			        <maven.compiler.source>1.8</maven.compiler.source>
			        <maven.compiler.target>1.8</maven.compiler.target>
			         <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
			      </properties>
			    
			    <dependencies>
					<dependency>
						<groupId>org.apache.commons</groupId>
						<artifactId>commons-csv</artifactId>
						<version>1.5</version>
					</dependency>
				</dependencies>
			</project>
		''', '''/myProject/./src-gen/uuu/commons/src/main/java/a/b/commons/C.java''' -> '''
			package a.b.commons;
			
			import java.io.*;
			import java.util.*;
			import org.apache.commons.csv.*;
			import java.util.stream.StreamSupport;
			import java.util.stream.Collectors;
			
			public class C {
			 	public static void main(String[] args) throws  FileNotFoundException, IOException {
				final List<CSVRecord> a = StreamSupport.stream(CSVFormat.RFC4180.parse(new FileReader("/tmp/test.csv")).spliterator(), false).collect(Collectors.toList());
				System.out.println(a.size());
				}
			}
		''', '''/myProject/./src-gen/uuu/docker-compose.yml''' -> '''
			version: '3'
			services:
			  java:
			    build:
			      context: ./java
			  commons:
			    build:
			      context: ./commons
			  python3:
			    build:
			      context: ./python3
		''', '''/myProject/./src-gen/uuu/java/Dockerfile''' -> '''
			FROM maven
			COPY . /project
			COPY ./inputs /inputs
			WORKDIR project
			RUN mvn compile
			ENTRYPOINT  mvn -q exec:java -Dexec.mainClass="a.b.java.C"
		''', '''/myProject/./src-gen/uuu/java/pom.xml''' -> '''
			<project>
			    <modelVersion>4.0.0</modelVersion>
			    <groupId>uuu</groupId>
			    <artifactId>a.b.java.C</artifactId>
			    <version>1</version>
			    
			      <properties>
			        <maven.compiler.source>1.8</maven.compiler.source>
			        <maven.compiler.target>1.8</maven.compiler.target>
			         <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
			      </properties>
			</project>
		''', '''/myProject/./src-gen/uuu/java/src/main/java/a/b/java/C.java''' -> '''
		package a.b.java;
		
		import java.io.*;
		import java.awt.Point;
		import java.util.HashMap;
		import java.util.Scanner;
		
		public class C {
		
			private HashMap<Point, String> _map = new HashMap<Point, String>();
			private int _cols;
			private int _rows;
		
			public void open(File file) throws FileNotFoundException, IOException {
			open(file, ',');
			}
		
			public void open(File file, char delimiter) throws FileNotFoundException, IOException {
			Scanner scanner = new Scanner(file);
			scanner.useDelimiter(Character.toString(delimiter));
		
				while(scanner.hasNextLine()) {
			String[] values = scanner.nextLine().split(Character.toString(delimiter));
		
					int col = 0;
					for ( String value: values ) {
			_map.put(new Point(col, _rows), value);
			_cols = Math.max(_cols, ++col);
					}
					_rows++;
				}
				scanner.close();
			}
		
			public void save(File file) throws IOException {
			save(file, ',');
			}
			
			public void save(File file, char delimiter) throws IOException {
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				
				for (int row = 0; row < _rows; row++) {
					for (int col = 0; col < _cols; col++) {
					Point key = new Point(col, row);
						if (_map.containsKey(key)) {
							bw.write(_map.get(key));
						}
						
						if ((col + 1) < _cols) {
							bw.write(delimiter);
						}
					}
					bw.newLine();
				}
				bw.flush();
				bw.close();
			}
			
			public String serialize(final char delimiter) throws IOException {
				final StringBuilder sb = new StringBuilder();
				
				for (int row = 0; row < _rows; row++) {
					for (int col = 0; col < _cols; col++) {
						final Point key = new Point(col, row);
						if (_map.containsKey(key)) {
							sb.append(_map.get(key));
						}
						
						if ((col + 1) < _cols) {
							sb.append(delimiter);
						}
					}
					sb.append(System.lineSeparator());
				}
				return sb.toString();
			}
			
			public String get(int col, int row) {
				String val = "";
				Point key = new Point(col, row);
				if (_map.containsKey(key)) {
					val = _map.get(key);
				}
				return val;
			}
			
			public void put(int col, int row, String value) {
				_map.put(new Point(col, row), value);
				_cols = Math.max(_cols, col+1);
				_rows = Math.max(_rows, row+1);
			}
			
			public int rows() { return this._rows; }
			
			public static void main(String[] args) {
				try {
				     	C a = new C();
				     	a.open(new File("/tmp/test.csv"));
				     	System.out.println(a.rows());
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		''', '''/myProject/./src-gen/uuu/python3/Dockerfile''' -> '''
			FROM python3
			COPY . /project
			COPY ./inputs /inputs
			WORKDIR project
			ENTRYPOINT python3 python3_version.py
		''', '''/myProject/./src-gen/uuu/python3/python3_version.py''' -> '''
			#!/usr/bin/env python3
			import sys
			import csv
			with open(sys.argv[1]+"/tmp/test.csv", "r", encoding="") as CSV_file:
				read = csv.reader(CSV_file)
				print(sum(1 for elt in read) -1)
		''', '''/myProject/./src-gen/uuu/run.sh''' -> '''
			#!/bin/bash
			rm -r ./logs
			mkdir -p ./logs
			docker-compose up
		'''})
	}

	@Test
	def void loadModelBis() {
		// an example
		/*
		 * '''
		 * package foo2;
		 * constraints {
		 *     java = true
		 *     maven = true
		 * }
		 * languages {
		 *     python (a)
		 *     java (b)
		 *     commons(c)
		 * }
		 * read a "/tmp/test.csv"
		 * nbrow a
		 * print a
		 * read b "/tmp/test2.csv"
		 * nbrow b
		 * //print b
		 * '''
		 */
	}

	@Test
	def void loadUnknowLanguage() {
		'''
			package uuu;
			
			constraints {}
			languages {
				jav (a.b.java.C)
			}
		'''.parse.assertError(CsvPackage.Literals.LANGUAGE, CsvValidator.LANGUAGE_DOES_NOT_EXIST,
			"Language jav does not exist.")
	}
}
