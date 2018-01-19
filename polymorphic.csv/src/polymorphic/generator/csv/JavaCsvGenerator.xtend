package polymorphic.generator.csv

import org.eclipse.xtext.generator.IFileSystemAccess2
import polymorphic.csv.Model
import polymorphic.csv.OpenCSV
import polymorphic.csv.PrintCSV

class JavaCsvGenerator implements ICsvGenerator {

	override generate(Model content, IFileSystemAccess2 fsa) {

		val className = content.target.split("\\.").reverse.head
		val package = content.target.split("\\.").reverse.tail.toList.reverse.join(".")

		fsa.generateFile('''«content.target.replaceAll("\\.", "/")».java''', '''
			package «package»;

			import java.io.*;
			import java.awt.Point;
			import java.util.HashMap;
			import java.util.Scanner;
			
			public class «className» {

				private HashMap<Point, String> _map = new HashMap<Point, String>();
				private int _cols;
				private int _rows;

				public void open(File file) throws FileNotFoundException, IOException {
					open(file, ',');
				}

				public void open(File file, char delimiter) throws FileNotFoundException, IOException {
					Scanner scanner = new Scanner(file);
					scanner.useDelimiter(Character.toString(delimiter));

					clear();

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
				
				public void clear() {
					_map.clear();
					_cols = 0;
					_rows = 0;
				}
				
				public int rows() {
					return _rows;
				}
				
				public int cols() {
					return _cols;
				}
				 
				public static void main(String[] args) {
					try {
		        	«FOR action : content.actions»
		        		«action.javaAction(className)»
		        	«ENDFOR»
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			}
		''')

	}

	def dispatch CharSequence javaAction(OpenCSV open, CharSequence className) {
'''
	«className» «open.name» = new «className»();
	«open.name».open(new File("«open.file»"));
'''
	}

	def dispatch CharSequence javaAction(PrintCSV open, CharSequence className) {
'''
	System.out.println(«open.name».serialize(';'));
'''
	}

}
