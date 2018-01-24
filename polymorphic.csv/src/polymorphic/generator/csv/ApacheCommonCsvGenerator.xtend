package polymorphic.generator.csv

import org.eclipse.xtext.generator.IFileSystemAccess2
import polymorphic.csv.Language
import polymorphic.csv.Model
import polymorphic.csv.OpenCSV
import polymorphic.csv.PrintCSV
import polymorphic.csv.SaveCSV

import static extension org.eclipse.xtext.EcoreUtil2.*

class ApacheCommonCsvGenerator implements ICsvGenerator {

	override generate(Model content, Language language, IFileSystemAccess2 fsa) {
		val className = language.target.split("\\.").reverse.head
		val package = language.target.split("\\.").reverse.tail.toList.reverse.join(".")

		fsa.generateFile('''«language.target.replaceAll("\\.", "/")».java''', '''
		
			/*
			<dependency>
				<groupId>org.apache.commons</groupId>
				<artifactId>commons-csv</artifactId>
				<version>1.5</version>
			</dependency>
			*/
			package «package»;
			
			import java.io.*;
			import java.util.*;
			import org.apache.commons.csv.*;
			 
			public class «className» {
			  private static final String NL = System.getProperty("line.separator");
			«««			  private static final String FILENAME_IR = "data/csvtest_in.csv";
«««			  private static final String FILENAME_OR = "data/csvtest_sum.csv";
«««			  private static final String COL_NAME_SUM = "SUM,ntegers\""; // demonstrwhite space, comma & quhand
			  public static void main(String[] args) FileNotFoundException, IOException {
			 
«««			    Reader iCvs = null;
«««			    Writer oCvs = null;
			    
			    «FOR action : content.actions»
				«action.javaAction(className)»
			«ENDFOR»
			
«««			System.out.println(textFileContentsToString(FILENAME_IR));
«««			try {
«««			  iCvs = new BufferedReader(new FileReader(FILENAME_IR));
«««			  oCvs = new BufferedWriter(new FileWriter(FILENAME_OR));
«««			  processCsv(iCvs, oCvs);
«««			}
«««			catch (IOException ex) {
«««			  ex.printStackTrace();
«««			}
«««			finally {
«««			  try {
«««			    if (iCvs != null) { iCvs.close(); }
«««			    if (oCvs != null) { oCvs.close(); }
«««			  }
«««			  catch (IOException ex) {
«««			    ex.printStackTrace();
«««			  }
«««			}
«««			System.out.println(textFileContentsToString(FILENAME_OR));
«««			return;
			  }
			 
			  public static void processCsv(Reader iCvs, Writer oCvs, String COL_NAME_SUM) throws IOException {
			    CSVPrinter printer = null;
			    try {
			      printer = new CSVPrinter(oCvs, CSVFormat.DEFAULT.withRecordSeparator(NL));
			      List<String> oCvsHeaders;
			      List<String> oCvsRecord;
			      CSVParser records = CSVFormat.DEFAULT.withHeader().parse(iCvs);
			      Map<String, Integer> irHeader = records.getHeaderMap();
			      oCvsHeaders = new ArrayList<String>(Arrays.asList((irHeader.keySet()).toArray(new String[0])));
			      oCvsHeaders.add(COL_NAME_SUM);
			      printer.printRecord(oCvsHeaders);
			      for (CSVRecord record : records) {
			        oCvsRecord = record2list(record, oCvsHeaders, COL_NAME_SUM);
			        printer.printRecord(oCvsRecord);
			      }
			    }
			    finally {
			      if (printer != null) {
			        printer.close();
			      }
			    }
			    return;
			  }
			 
			  private static List<String> record2list(CSVRecord record, List<String> oCvsHeaders, String COL_NAME_SUM) {
			    List<String> cvsRecord;
			    Map<String, String> rMap = record.toMap();
			    long recNo = record.getRecordNumber();
			    rMap = alterRecord(rMap, recNo);
			    int sum = 0;
			    sum = summation(rMap);
			    rMap.put(COL_NAME_SUM, String.valueOf(sum));
			    cvsRecord = new ArrayList<String>();
			    for (String key : oCvsHeaders) {
			      cvsRecord.add(rMap.get(key));
			    }
			    return cvsRecord;
			  }
			 
			  private static Map<String, String> alterRecord(Map<String, String> rMap, long recNo) {
			    int rv;
			    Random rg = new Random(recNo);
			    rv = rg.nextInt(50);
			    String[] ks = rMap.keySet().toArray(new String[0]);
			    int ix = rg.nextInt(ks.length);
			    long yv = 0;
			    String ky = ks[ix];
			    String xv = rMap.get(ky);
			    if (xv != null && xv.length() > 0) {
			      yv = Long.valueOf(xv) + rv;
			      rMap.put(ks[ix], String.valueOf(yv));
			    }
			    return rMap;
			  }
			 
			  private static int summation(Map<String, String> rMap) {
			    int sum = 0;
			    for (String col : rMap.keySet()) {
			      String nv = rMap.get(col);
			      sum += nv != null && nv.length() > 0 ? Integer.valueOf(nv) : 0;
			    }
			    return sum;
			  }
			 
			  private static String textFileContentsToString(String filename) {
			    StringBuilder lineOut = new StringBuilder();
			    Scanner fs = null;
			    try {
			      fs = new Scanner(new File(filename));
			      lineOut.append(filename);
			      lineOut.append(NL);
			      while (fs.hasNextLine()) {
			        String line = fs.nextLine();
			        lineOut.append(line);
			        lineOut.append(NL);
			      }
			    }
			    catch (FileNotFoundException ex) {
			      // TODO Auto-generated catch block
			      ex.printStackTrace();
			    }
			    finally {
			      if (fs != null) {
			        fs.close();
			      }
			    }
			    return lineOut.toString();
			  }
			}
		''')
	}

	def dispatch CharSequence javaAction(OpenCSV open, CharSequence className) {
		'''
		final Iterable<CSVRecord> «open.name» = CSVFormat.RFC4180.parse(new FileReader("«open.file»"));
		'''
	}

	def dispatch CharSequence javaAction(PrintCSV open, CharSequence className) {
		// probably easier with a good scoping...
		'''
		«open.name».stream().forEach(x -> System.out.println(x));
		'''
	}
	
	
	def dispatch CharSequence javaAction(SaveCSV save, CharSequence className) {
		val file = if(save.file !== null) save.file else save.getContainerOfType(Model).actions.filter(OpenCSV).filter [
				it.name == save.name
			].head.file

		'''
			«save.name».save(new File("«file»"));
		'''
	}
	
	override def properties() {
		newHashMap("java" -> true, "maven" -> true)
	}

}
