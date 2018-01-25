/**
 * generated by Xtext 2.13.0
 */
package polymorphic.tests;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import polymorphic.csv.CsvPackage;
import polymorphic.csv.Model;
import polymorphic.tests.CsvInjectorProvider;
import polymorphic.validation.CsvValidator;

@RunWith(XtextRunner.class)
@InjectWith(CsvInjectorProvider.class)
@SuppressWarnings("all")
public class CsvParsingTest {
  @Inject
  @Extension
  private ParseHelper<Model> _parseHelper;
  
  @Inject
  @Extension
  private CompilationTestHelper _compilationTestHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void loadModel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package uuu;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("constraints {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("java = true");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("maven = true");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("languages {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("java (a.b.java.C)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("commons (a.b.commons.C)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("python (python_version)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("read a \"/tmp/test.csv\"");
      _builder.newLine();
      _builder.append("print a");
      _builder.newLine();
      _builder.append("//save a");
      _builder.newLine();
      _builder.append("save a \"/tmp/test2.csv\"");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("MULTIPLE FILES WERE GENERATED");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("File 1 : /myProject/./src-gen/uuu/commons/Dockerfile");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("FROM maven");
      _builder_1.newLine();
      _builder_1.append("COPY . /project");
      _builder_1.newLine();
      _builder_1.append("WORKDIR project");
      _builder_1.newLine();
      _builder_1.append("RUN mvn compile");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("File 2 : /myProject/./src-gen/uuu/commons/pom.xml");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("<project>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<modelVersion>4.0.0</modelVersion>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<groupId>uuu</groupId>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<artifactId>a.b.commons.C</artifactId>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<version>1</version>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("<properties>");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("<maven.compiler.source>1.8</maven.compiler.source>");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("<maven.compiler.target>1.8</maven.compiler.target>");
      _builder_1.newLine();
      _builder_1.append("         ");
      _builder_1.append("<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("</properties>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<dependencies>");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("<dependency>");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("<groupId>org.apache.commons</groupId>");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("<artifactId>commons-csv</artifactId>");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("<version>1.5</version>");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("</dependency>");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("</dependencies>");
      _builder_1.newLine();
      _builder_1.append("</project>");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("File 3 : /myProject/./src-gen/uuu/commons/src/main/java/a/b/commons/C.java");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("package a.b.commons;");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("import java.io.*;");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("import java.util.*;");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("import org.apache.commons.csv.*;");
      _builder_1.newLine();
      _builder_1.append("\t ");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public class C {");
      _builder_1.newLine();
      _builder_1.append("\t  ");
      _builder_1.append("private static final String NL = System.getProperty(\"line.separator\");");
      _builder_1.newLine();
      _builder_1.append("\t  ");
      _builder_1.append("public static void main(String[] args) throws  FileNotFoundException, IOException {");
      _builder_1.newLine();
      _builder_1.append("final Iterable<CSVRecord> a = CSVFormat.RFC4180.parse(new FileReader(\"/tmp/test.csv\"));");
      _builder_1.newLine();
      _builder_1.append("a.forEach(x -> System.out.println(x));");
      _builder_1.newLine();
      _builder_1.append("a.save(new File(\"/tmp/test2.csv\"));");
      _builder_1.newLine();
      _builder_1.append("\t  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t ");
      _builder_1.newLine();
      _builder_1.append("\t  ");
      _builder_1.append("public static void processCsv(Reader iCvs, Writer oCvs, String COL_NAME_SUM) throws IOException {");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("CSVPrinter printer = null;");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("try {");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("printer = new CSVPrinter(oCvs, CSVFormat.DEFAULT.withRecordSeparator(NL));");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("List<String> oCvsHeaders;");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("List<String> oCvsRecord;");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("CSVParser records = CSVFormat.DEFAULT.withHeader().parse(iCvs);");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("Map<String, Integer> irHeader = records.getHeaderMap();");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("oCvsHeaders = new ArrayList<String>(Arrays.asList((irHeader.keySet()).toArray(new String[0])));");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("oCvsHeaders.add(COL_NAME_SUM);");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("printer.printRecord(oCvsHeaders);");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("for (CSVRecord record : records) {");
      _builder_1.newLine();
      _builder_1.append("\t        ");
      _builder_1.append("oCvsRecord = record2list(record, oCvsHeaders, COL_NAME_SUM);");
      _builder_1.newLine();
      _builder_1.append("\t        ");
      _builder_1.append("printer.printRecord(oCvsRecord);");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("finally {");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("if (printer != null) {");
      _builder_1.newLine();
      _builder_1.append("\t        ");
      _builder_1.append("printer.close();");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("return;");
      _builder_1.newLine();
      _builder_1.append("\t  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t ");
      _builder_1.newLine();
      _builder_1.append("\t  ");
      _builder_1.append("private static List<String> record2list(CSVRecord record, List<String> oCvsHeaders, String COL_NAME_SUM) {");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("List<String> cvsRecord;");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("Map<String, String> rMap = record.toMap();");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("long recNo = record.getRecordNumber();");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("rMap = alterRecord(rMap, recNo);");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("int sum = 0;");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("sum = summation(rMap);");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("rMap.put(COL_NAME_SUM, String.valueOf(sum));");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("cvsRecord = new ArrayList<String>();");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("for (String key : oCvsHeaders) {");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("cvsRecord.add(rMap.get(key));");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("return cvsRecord;");
      _builder_1.newLine();
      _builder_1.append("\t  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t ");
      _builder_1.newLine();
      _builder_1.append("\t  ");
      _builder_1.append("private static Map<String, String> alterRecord(Map<String, String> rMap, long recNo) {");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("int rv;");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("Random rg = new Random(recNo);");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("rv = rg.nextInt(50);");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("String[] ks = rMap.keySet().toArray(new String[0]);");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("int ix = rg.nextInt(ks.length);");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("long yv = 0;");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("String ky = ks[ix];");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("String xv = rMap.get(ky);");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("if (xv != null && xv.length() > 0) {");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("yv = Long.valueOf(xv) + rv;");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("rMap.put(ks[ix], String.valueOf(yv));");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("return rMap;");
      _builder_1.newLine();
      _builder_1.append("\t  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t ");
      _builder_1.newLine();
      _builder_1.append("\t  ");
      _builder_1.append("private static int summation(Map<String, String> rMap) {");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("int sum = 0;");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("for (String col : rMap.keySet()) {");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("String nv = rMap.get(col);");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("sum += nv != null && nv.length() > 0 ? Integer.valueOf(nv) : 0;");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("return sum;");
      _builder_1.newLine();
      _builder_1.append("\t  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t ");
      _builder_1.newLine();
      _builder_1.append("\t  ");
      _builder_1.append("private static String textFileContentsToString(String filename) {");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("StringBuilder lineOut = new StringBuilder();");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("Scanner fs = null;");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("try {");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("fs = new Scanner(new File(filename));");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("lineOut.append(filename);");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("lineOut.append(NL);");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("while (fs.hasNextLine()) {");
      _builder_1.newLine();
      _builder_1.append("\t        ");
      _builder_1.append("String line = fs.nextLine();");
      _builder_1.newLine();
      _builder_1.append("\t        ");
      _builder_1.append("lineOut.append(line);");
      _builder_1.newLine();
      _builder_1.append("\t        ");
      _builder_1.append("lineOut.append(NL);");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("catch (FileNotFoundException ex) {");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("// TODO Auto-generated catch block");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("ex.printStackTrace();");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("finally {");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("if (fs != null) {");
      _builder_1.newLine();
      _builder_1.append("\t        ");
      _builder_1.append("fs.close();");
      _builder_1.newLine();
      _builder_1.append("\t      ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t    ");
      _builder_1.append("return lineOut.toString();");
      _builder_1.newLine();
      _builder_1.append("\t  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("File 4 : /myProject/./src-gen/uuu/docker-compose.yml");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("version: \'3\'");
      _builder_1.newLine();
      _builder_1.append("services:");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("java:");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("build:");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("context: ./java");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("commons:");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("build:");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("context: ./commons");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("python:");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("build:");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("context: ./python");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("File 5 : /myProject/./src-gen/uuu/java/Dockerfile");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("FROM maven");
      _builder_1.newLine();
      _builder_1.append("COPY . /project");
      _builder_1.newLine();
      _builder_1.append("WORKDIR project");
      _builder_1.newLine();
      _builder_1.append("RUN mvn compile");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("File 6 : /myProject/./src-gen/uuu/java/pom.xml");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("<project>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<modelVersion>4.0.0</modelVersion>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<groupId>uuu</groupId>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<artifactId>a.b.java.C</artifactId>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<version>1</version>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("<properties>");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("<maven.compiler.source>1.8</maven.compiler.source>");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("<maven.compiler.target>1.8</maven.compiler.target>");
      _builder_1.newLine();
      _builder_1.append("         ");
      _builder_1.append("<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("</properties>");
      _builder_1.newLine();
      _builder_1.append("</project>");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("File 7 : /myProject/./src-gen/uuu/java/src/main/java/a/b/java/C.java");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("package a.b.java;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import java.io.*;");
      _builder_1.newLine();
      _builder_1.append("import java.awt.Point;");
      _builder_1.newLine();
      _builder_1.append("import java.util.HashMap;");
      _builder_1.newLine();
      _builder_1.append("import java.util.Scanner;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("public class C {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("private HashMap<Point, String> _map = new HashMap<Point, String>();");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("private int _cols;");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("private int _rows;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public void open(File file) throws FileNotFoundException, IOException {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("open(file, \',\');");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public void open(File file, char delimiter) throws FileNotFoundException, IOException {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Scanner scanner = new Scanner(file);");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("scanner.useDelimiter(Character.toString(delimiter));");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("clear();");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("while(scanner.hasNextLine()) {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("String[] values = scanner.nextLine().split(Character.toString(delimiter));");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("int col = 0;");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("for ( String value: values ) {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("_map.put(new Point(col, _rows), value);");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("_cols = Math.max(_cols, ++col);");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("_rows++;");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("scanner.close();");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public void save(File file) throws IOException {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("save(file, \',\');");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public void save(File file, char delimiter) throws IOException {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("FileWriter fw = new FileWriter(file);");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("BufferedWriter bw = new BufferedWriter(fw);");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("for (int row = 0; row < _rows; row++) {");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("for (int col = 0; col < _cols; col++) {");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("Point key = new Point(col, row);");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("if (_map.containsKey(key)) {");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t\t");
      _builder_1.append("bw.write(_map.get(key));");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("if ((col + 1) < _cols) {");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t\t");
      _builder_1.append("bw.write(delimiter);");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("bw.newLine();");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("bw.flush();");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("bw.close();");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public String serialize(final char delimiter) throws IOException {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("final StringBuilder sb = new StringBuilder();");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("for (int row = 0; row < _rows; row++) {");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("for (int col = 0; col < _cols; col++) {");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("final Point key = new Point(col, row);");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("if (_map.containsKey(key)) {");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t\t");
      _builder_1.append("sb.append(_map.get(key));");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("if ((col + 1) < _cols) {");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t\t");
      _builder_1.append("sb.append(delimiter);");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("sb.append(System.lineSeparator());");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("return sb.toString();");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public String get(int col, int row) {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("String val = \"\";");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("Point key = new Point(col, row);");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("if (_map.containsKey(key)) {");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("val = _map.get(key);");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("return val;");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public void put(int col, int row, String value) {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("_map.put(new Point(col, row), value);");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("_cols = Math.max(_cols, col+1);");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("_rows = Math.max(_rows, row+1);");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public void clear() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("_map.clear();");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("_cols = 0;");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("_rows = 0;");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public int rows() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("return _rows;");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public int cols() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("return _cols;");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t ");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public static void main(String[] args) {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("try {");
      _builder_1.newLine();
      _builder_1.append("\t\t     \t");
      _builder_1.append("C a = new C();");
      _builder_1.newLine();
      _builder_1.append("\t\t     \t");
      _builder_1.append("a.open(new File(\"/tmp/test.csv\"));");
      _builder_1.newLine();
      _builder_1.append("\t\t     \t");
      _builder_1.append("System.out.println(a.serialize(\';\'));");
      _builder_1.newLine();
      _builder_1.append("\t\t     \t");
      _builder_1.append("a.save(new File(\"/tmp/test2.csv\"));");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("} catch (Exception e) {");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("System.out.println(e);");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("File 8 : /myProject/./src-gen/uuu/python/Dockerfile");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("FROM python");
      _builder_1.newLine();
      _builder_1.append("COPY . /project");
      _builder_1.newLine();
      _builder_1.append("WORKDIR project");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("File 9 : /myProject/./src-gen/uuu/python/python_version.py");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import csv");
      _builder_1.newLine();
      _builder_1.append("a = open(\'/tmp/test.csv\', \'rt\')");
      _builder_1.newLine();
      _builder_1.append("a_read = csv.reader(a)");
      _builder_1.newLine();
      _builder_1.append("for a_e in a_read:");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("print(\', \'.join(a_e))");
      _builder_1.newLine();
      _builder_1.append("a_write = csv.writer(open(\'/tmp/test2.csv\', \'wt\'))");
      _builder_1.newLine();
      _builder_1.append("for a_e in a_read:");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("print(a_e)");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("a_write.writerow(tuple(a_e))");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.newLine();
      this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void loadModelPython() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo;");
      _builder.newLine();
      _builder.append("constraints {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("java = true");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("maven = true");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("languages {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("python (a)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("read a \"/tmp/test.csv\"");
      _builder.newLine();
      _builder.append("nbrow a");
      _builder.newLine();
      _builder.append("//print a");
      _builder.newLine();
      _builder.append("read b \"/tmp/test2.csv\"");
      _builder.newLine();
      _builder.append("nbrow b");
      _builder.newLine();
      _builder.append("//print b");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("MULTIPLE FILES WERE GENERATED");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("File 1 : /myProject/./src-gen/foo/docker-compose.yml");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("version: \'3\'");
      _builder_1.newLine();
      _builder_1.append("services:");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("python:");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("build:");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("context: ./python");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("File 2 : /myProject/./src-gen/foo/python/Dockerfile");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("FROM python");
      _builder_1.newLine();
      _builder_1.append("COPY . /project");
      _builder_1.newLine();
      _builder_1.append("WORKDIR project");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("File 3 : /myProject/./src-gen/foo/python/a.py");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import csv");
      _builder_1.newLine();
      _builder_1.append("a = open(\'/tmp/test.csv\', \'rt\')");
      _builder_1.newLine();
      _builder_1.append("a_read = csv.reader(a)");
      _builder_1.newLine();
      _builder_1.append("print(sum(1 for row in a_read))");
      _builder_1.newLine();
      _builder_1.append("b = open(\'/tmp/test2.csv\', \'rt\')");
      _builder_1.newLine();
      _builder_1.append("b_read = csv.reader(b)");
      _builder_1.newLine();
      _builder_1.append("print(sum(1 for row in b_read))");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.newLine();
      this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void loadModelBis() {
  }
  
  @Test
  public void loadUnknowLanguage() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package uuu;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("constraints {}");
      _builder.newLine();
      _builder.append("languages {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("jav (a.b.java.C)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this._parseHelper.parse(_builder), CsvPackage.Literals.LANGUAGE, CsvValidator.LANGUAGE_DOES_NOT_EXIST, 
        "Language jav does not exist.");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
