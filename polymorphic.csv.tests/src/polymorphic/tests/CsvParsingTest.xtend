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
	def bashTest1(){
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
		cat /tmp/test.csv
		cp /tmp/test.csv /tmp/test2.csv
		
		File 2 : /myProject/./src-gen/mpackage/build.sh
		
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
		
		File 4 : /myProject/./src-gen/mpackage/run.sh
		
		rm -r ./logs
		mkdir -p ./logs
		docker-compose up
		
		''')
	}
	
	@Test
	def bashTest2(){
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
		'''.assertFileCompilesTo(#{'''/myProject/./src-gen/mpackage/bash/a/b/java/C.sh''' -> '''	
		#!/bin/bash
		cat /tmp/test.csv
		cp /tmp/test.csv /tmp/test2.csv
		'''}
		)
	}
	
	@Test
	def bashTest3(){
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
		save aaa "/home/yannick/Bureau/dossier_test/Copy_Sans_nom_1.csv"

		'''.assertFileCompilesTo(#{'''/myProject/./src-gen/important/bash/truc.sh''' -> '''	
		#!/bin/bash
		cat /home/yannick/Bureau/dossier_test/Sans_nom_1.csv
		echo $[$(wc -l < /home/yannick/Bureau/dossier_test/Sans_nom_1.csv)-1]
		cp /home/yannick/Bureau/dossier_test/Sans_nom_1.csv /home/yannick/Bureau/dossier_test/Copy_Sans_nom_1.csv
		'''}
		)
	}
	
	@Test
	def bashR(){
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
		save aaa "/home/yannick/Bureau/dossier_test/Copy_Sans_nom_1.csv"

		'''.assertFileCompilesTo(#{'''/myProject/./src-gen/important/bash/truc.sh''' -> '''	
		#!/bin/bash
		cat /home/yannick/Bureau/dossier_test/Sans_nom_1.csv
		echo $[$(wc -l < /home/yannick/Bureau/dossier_test/Sans_nom_1.csv)-1]
		cp /home/yannick/Bureau/dossier_test/Sans_nom_1.csv /home/yannick/Bureau/dossier_test/Copy_Sans_nom_1.csv
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
				python (python_version)
			}
			read a "/tmp/test.csv"
			print a
			//save a
			save a "/tmp/test2.csv"
		'''.assertFileCompilesTo(#{'''/myProject/./src-gen/uuu/build.sh''' -> '''
				mkdir -p ./inputs
				rm -r ./java/inputs
				cp -r ./inputs ./java/inputs
				rm -r ./commons/inputs
				cp -r ./inputs ./commons/inputs
				rm -r ./python/inputs
				cp -r ./inputs ./python/inputs
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
			</project>''', '''/myProject/./src-gen/uuu/commons/src/main/java/a/b/commons/C.java''' -> '''
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
				  python:
				    build:
				      context: ./python
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
			''', '''/myProject/./src-gen/uuu/python/Dockerfile''' -> '''
				FROM python
				COPY . /project
				COPY ./inputs /inputs
				WORKDIR project
				ENTRYPOINT python python_version.py
			''', '''/myProject/./src-gen/uuu/python/python_version.py''' -> '''
				import csv
				for a_e in csv.reader(open('/tmp/test.csv', 'rt', encoding='')):
				  print(', '.join(a_e))
				with open('/tmp/test2.csv', 'wt') as output_file:
				  a_write = csv.writer(output_file)
				  for a_e in csv.reader(open('/tmp/test.csv', 'rt', encoding='')):
				    a_write.writerow(tuple(a_e))
			''', '''/myProject/./src-gen/uuu/run.sh''' -> '''
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
			    python (a)
			}
			read a "/tmp/test.csv"
			nbrow a
			//print a
			read b "/tmp/test2.csv"
			nbrow b
			//print b
		'''.assertFileCompilesTo(#{'''/myProject/./src-gen/foo/build.sh''' -> '''
			mkdir -p ./inputs
			rm -r ./python/inputs
			cp -r ./inputs ./python/inputs
			docker-compose build
		''', '''/myProject/./src-gen/foo/docker-compose.yml''' -> '''
			version: '3'
			services:
			  python:
			    build:
			      context: ./python
		''', '''/myProject/./src-gen/foo/python/Dockerfile''' -> '''
			FROM python
			COPY . /project
			COPY ./inputs /inputs
			WORKDIR project
			ENTRYPOINT python a.py
		''', '''/myProject/./src-gen/foo/python/a.py''' -> '''
			import csv
			print(sum(1 for row in csv.reader(open('/tmp/test.csv', 'rt', encoding=''))))
			print(sum(1 for row in csv.reader(open('/tmp/test2.csv', 'rt', encoding=''))))
		''', '''/myProject/./src-gen/foo/run.sh''' -> '''
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
				python (python_version)
			}
			read a "/tmp/test.csv"
			nbrow a
		'''.assertFileCompilesTo(#{'''/myProject/./src-gen/uuu/build.sh''' -> '''
			mkdir -p ./inputs
			rm -r ./java/inputs
			cp -r ./inputs ./java/inputs
			rm -r ./commons/inputs
			cp -r ./inputs ./commons/inputs
			rm -r ./python/inputs
			cp -r ./inputs ./python/inputs
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
			  python:
			    build:
			      context: ./python
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
		}''', '''/myProject/./src-gen/uuu/python/Dockerfile''' -> '''
			FROM python
			COPY . /project
			COPY ./inputs /inputs
			WORKDIR project
			ENTRYPOINT python python_version.py
		''', '''/myProject/./src-gen/uuu/python/python_version.py''' -> '''
			import csv
			print(sum(1 for row in csv.reader(open('/tmp/test.csv', 'rt', encoding=''))))
			
		''', '''/myProject/./src-gen/uuu/run.sh''' -> '''
			rm -r ./logs
			mkdir -p ./logs
			docker-compose up
			
		'''}
		)
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
