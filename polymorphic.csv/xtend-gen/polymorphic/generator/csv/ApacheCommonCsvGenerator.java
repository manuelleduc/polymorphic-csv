package polymorphic.generator.csv;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import polymorphic.csv.Actions;
import polymorphic.csv.Language;
import polymorphic.csv.Model;
import polymorphic.csv.OpenCSV;
import polymorphic.csv.PrintCSV;
import polymorphic.csv.SaveCSV;
import polymorphic.generator.csv.ICsvGenerator;

@SuppressWarnings("all")
public class ApacheCommonCsvGenerator implements ICsvGenerator {
  @Override
  public void generate(final Model content, final Language language, final IFileSystemAccess2 fsa) {
    final String className = IterableExtensions.<String>head(ListExtensions.<String>reverse(((List<String>)Conversions.doWrapArray(language.getTarget().split("\\.")))));
    final String package_ = IterableExtensions.join(ListExtensions.<String>reverse(IterableExtensions.<String>toList(IterableExtensions.<String>tail(ListExtensions.<String>reverse(((List<String>)Conversions.doWrapArray(language.getTarget().split("\\."))))))), ".");
    StringConcatenation _builder = new StringConcatenation();
    String _name = content.getName();
    _builder.append(_name);
    _builder.append("/");
    String _name_1 = language.getName();
    _builder.append(_name_1);
    _builder.append("/Dockerfile");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("FROM maven");
    _builder_1.newLine();
    _builder_1.append("COPY . /project");
    _builder_1.newLine();
    _builder_1.append("WORKDIR project");
    _builder_1.newLine();
    _builder_1.append("RUN mvn compile");
    _builder_1.newLine();
    fsa.generateFile(_builder.toString(), _builder_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    String _name_2 = content.getName();
    _builder_2.append(_name_2);
    _builder_2.append("/");
    String _name_3 = language.getName();
    _builder_2.append(_name_3);
    _builder_2.append("/pom.xml");
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("<project>");
    _builder_3.newLine();
    _builder_3.append("    ");
    _builder_3.append("<modelVersion>4.0.0</modelVersion>");
    _builder_3.newLine();
    _builder_3.append("    ");
    _builder_3.append("<groupId>");
    String _name_4 = content.getName();
    _builder_3.append(_name_4, "    ");
    _builder_3.append("</groupId>");
    _builder_3.newLineIfNotEmpty();
    _builder_3.append("    ");
    _builder_3.append("<artifactId>");
    String _target = language.getTarget();
    _builder_3.append(_target, "    ");
    _builder_3.append("</artifactId>");
    _builder_3.newLineIfNotEmpty();
    _builder_3.append("    ");
    _builder_3.append("<version>1</version>");
    _builder_3.newLine();
    _builder_3.append("    ");
    _builder_3.newLine();
    _builder_3.append("      ");
    _builder_3.append("<properties>");
    _builder_3.newLine();
    _builder_3.append("        ");
    _builder_3.append("<maven.compiler.source>1.8</maven.compiler.source>");
    _builder_3.newLine();
    _builder_3.append("        ");
    _builder_3.append("<maven.compiler.target>1.8</maven.compiler.target>");
    _builder_3.newLine();
    _builder_3.append("         ");
    _builder_3.append("<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>");
    _builder_3.newLine();
    _builder_3.append("      ");
    _builder_3.append("</properties>");
    _builder_3.newLine();
    _builder_3.append("    ");
    _builder_3.newLine();
    _builder_3.append("    ");
    _builder_3.append("<dependencies>");
    _builder_3.newLine();
    _builder_3.append("\t    ");
    _builder_3.append("<dependency>");
    _builder_3.newLine();
    _builder_3.append("\t\t\t");
    _builder_3.append("<groupId>org.apache.commons</groupId>");
    _builder_3.newLine();
    _builder_3.append("\t\t\t");
    _builder_3.append("<artifactId>commons-csv</artifactId>");
    _builder_3.newLine();
    _builder_3.append("\t\t\t");
    _builder_3.append("<version>1.5</version>");
    _builder_3.newLine();
    _builder_3.append("\t\t");
    _builder_3.append("</dependency>");
    _builder_3.newLine();
    _builder_3.append("\t");
    _builder_3.append("</dependencies>");
    _builder_3.newLine();
    _builder_3.append("</project>");
    _builder_3.newLine();
    fsa.generateFile(_builder_2.toString(), _builder_3);
    StringConcatenation _builder_4 = new StringConcatenation();
    String _name_5 = content.getName();
    _builder_4.append(_name_5);
    _builder_4.append("/");
    String _name_6 = language.getName();
    _builder_4.append(_name_6);
    _builder_4.append("/src/main/java/");
    String _replaceAll = language.getTarget().replaceAll("\\.", "/");
    _builder_4.append(_replaceAll);
    _builder_4.append(".java");
    StringConcatenation _builder_5 = new StringConcatenation();
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("package ");
    _builder_5.append(package_, "\t");
    _builder_5.append(";");
    _builder_5.newLineIfNotEmpty();
    _builder_5.append("\t");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("import java.io.*;");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("import java.util.*;");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("import org.apache.commons.csv.*;");
    _builder_5.newLine();
    _builder_5.append("\t ");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("public class ");
    _builder_5.append(className, "\t");
    _builder_5.append(" {");
    _builder_5.newLineIfNotEmpty();
    _builder_5.append("\t  ");
    _builder_5.append("private static final String NL = System.getProperty(\"line.separator\");");
    _builder_5.newLine();
    _builder_5.append("\t  ");
    _builder_5.append("public static void main(String[] args) throws  FileNotFoundException, IOException {");
    _builder_5.newLine();
    {
      EList<Actions> _actions = content.getActions();
      for(final Actions action : _actions) {
        CharSequence _javaAction = this.javaAction(action, className);
        _builder_5.append(_javaAction);
        _builder_5.newLineIfNotEmpty();
      }
    }
    _builder_5.append("\t  ");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t ");
    _builder_5.newLine();
    _builder_5.append("\t  ");
    _builder_5.append("public static void processCsv(Reader iCvs, Writer oCvs, String COL_NAME_SUM) throws IOException {");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("CSVPrinter printer = null;");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("try {");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("printer = new CSVPrinter(oCvs, CSVFormat.DEFAULT.withRecordSeparator(NL));");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("List<String> oCvsHeaders;");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("List<String> oCvsRecord;");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("CSVParser records = CSVFormat.DEFAULT.withHeader().parse(iCvs);");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("Map<String, Integer> irHeader = records.getHeaderMap();");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("oCvsHeaders = new ArrayList<String>(Arrays.asList((irHeader.keySet()).toArray(new String[0])));");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("oCvsHeaders.add(COL_NAME_SUM);");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("printer.printRecord(oCvsHeaders);");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("for (CSVRecord record : records) {");
    _builder_5.newLine();
    _builder_5.append("\t        ");
    _builder_5.append("oCvsRecord = record2list(record, oCvsHeaders, COL_NAME_SUM);");
    _builder_5.newLine();
    _builder_5.append("\t        ");
    _builder_5.append("printer.printRecord(oCvsRecord);");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("finally {");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("if (printer != null) {");
    _builder_5.newLine();
    _builder_5.append("\t        ");
    _builder_5.append("printer.close();");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("return;");
    _builder_5.newLine();
    _builder_5.append("\t  ");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t ");
    _builder_5.newLine();
    _builder_5.append("\t  ");
    _builder_5.append("private static List<String> record2list(CSVRecord record, List<String> oCvsHeaders, String COL_NAME_SUM) {");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("List<String> cvsRecord;");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("Map<String, String> rMap = record.toMap();");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("long recNo = record.getRecordNumber();");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("rMap = alterRecord(rMap, recNo);");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("int sum = 0;");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("sum = summation(rMap);");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("rMap.put(COL_NAME_SUM, String.valueOf(sum));");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("cvsRecord = new ArrayList<String>();");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("for (String key : oCvsHeaders) {");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("cvsRecord.add(rMap.get(key));");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("return cvsRecord;");
    _builder_5.newLine();
    _builder_5.append("\t  ");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t ");
    _builder_5.newLine();
    _builder_5.append("\t  ");
    _builder_5.append("private static Map<String, String> alterRecord(Map<String, String> rMap, long recNo) {");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("int rv;");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("Random rg = new Random(recNo);");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("rv = rg.nextInt(50);");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("String[] ks = rMap.keySet().toArray(new String[0]);");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("int ix = rg.nextInt(ks.length);");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("long yv = 0;");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("String ky = ks[ix];");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("String xv = rMap.get(ky);");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("if (xv != null && xv.length() > 0) {");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("yv = Long.valueOf(xv) + rv;");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("rMap.put(ks[ix], String.valueOf(yv));");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("return rMap;");
    _builder_5.newLine();
    _builder_5.append("\t  ");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t ");
    _builder_5.newLine();
    _builder_5.append("\t  ");
    _builder_5.append("private static int summation(Map<String, String> rMap) {");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("int sum = 0;");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("for (String col : rMap.keySet()) {");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("String nv = rMap.get(col);");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("sum += nv != null && nv.length() > 0 ? Integer.valueOf(nv) : 0;");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("return sum;");
    _builder_5.newLine();
    _builder_5.append("\t  ");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t ");
    _builder_5.newLine();
    _builder_5.append("\t  ");
    _builder_5.append("private static String textFileContentsToString(String filename) {");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("StringBuilder lineOut = new StringBuilder();");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("Scanner fs = null;");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("try {");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("fs = new Scanner(new File(filename));");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("lineOut.append(filename);");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("lineOut.append(NL);");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("while (fs.hasNextLine()) {");
    _builder_5.newLine();
    _builder_5.append("\t        ");
    _builder_5.append("String line = fs.nextLine();");
    _builder_5.newLine();
    _builder_5.append("\t        ");
    _builder_5.append("lineOut.append(line);");
    _builder_5.newLine();
    _builder_5.append("\t        ");
    _builder_5.append("lineOut.append(NL);");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("catch (FileNotFoundException ex) {");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("// TODO Auto-generated catch block");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("ex.printStackTrace();");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("finally {");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("if (fs != null) {");
    _builder_5.newLine();
    _builder_5.append("\t        ");
    _builder_5.append("fs.close();");
    _builder_5.newLine();
    _builder_5.append("\t      ");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t    ");
    _builder_5.append("return lineOut.toString();");
    _builder_5.newLine();
    _builder_5.append("\t  ");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("}");
    _builder_5.newLine();
    fsa.generateFile(_builder_4.toString(), _builder_5);
  }
  
  protected CharSequence _javaAction(final OpenCSV open, final CharSequence className) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("final Iterable<CSVRecord> ");
    String _name = open.getName();
    _builder.append(_name);
    _builder.append(" = CSVFormat.RFC4180.parse(new FileReader(\"");
    String _file = open.getFile();
    _builder.append(_file);
    _builder.append("\"));");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _javaAction(final PrintCSV open, final CharSequence className) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = open.getName();
    _builder.append(_name);
    _builder.append(".forEach(x -> System.out.println(x));");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _javaAction(final SaveCSV save, final CharSequence className) {
    CharSequence _xblockexpression = null;
    {
      String _xifexpression = null;
      String _file = save.getFile();
      boolean _tripleNotEquals = (_file != null);
      if (_tripleNotEquals) {
        _xifexpression = save.getFile();
      } else {
        final Function1<OpenCSV, Boolean> _function = (OpenCSV it) -> {
          String _name = it.getName();
          String _name_1 = save.getName();
          return Boolean.valueOf(Objects.equal(_name, _name_1));
        };
        _xifexpression = IterableExtensions.<OpenCSV>head(IterableExtensions.<OpenCSV>filter(Iterables.<OpenCSV>filter(EcoreUtil2.<Model>getContainerOfType(save, Model.class).getActions(), OpenCSV.class), _function)).getFile();
      }
      final String file = _xifexpression;
      StringConcatenation _builder = new StringConcatenation();
      String _name = save.getName();
      _builder.append(_name);
      _builder.append(".save(new File(\"");
      _builder.append(file);
      _builder.append("\"));");
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  @Override
  public Map<String, Boolean> properties() {
    Pair<String, Boolean> _mappedTo = Pair.<String, Boolean>of("java", Boolean.valueOf(true));
    Pair<String, Boolean> _mappedTo_1 = Pair.<String, Boolean>of("maven", Boolean.valueOf(true));
    return CollectionLiterals.<String, Boolean>newHashMap(_mappedTo, _mappedTo_1);
  }
  
  public CharSequence javaAction(final Actions open, final CharSequence className) {
    if (open instanceof OpenCSV) {
      return _javaAction((OpenCSV)open, className);
    } else if (open instanceof PrintCSV) {
      return _javaAction((PrintCSV)open, className);
    } else if (open instanceof SaveCSV) {
      return _javaAction((SaveCSV)open, className);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(open, className).toString());
    }
  }
}
