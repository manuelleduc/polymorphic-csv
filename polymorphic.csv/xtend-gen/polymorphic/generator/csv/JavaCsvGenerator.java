package polymorphic.generator.csv;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import polymorphic.csv.Action;
import polymorphic.csv.Language;
import polymorphic.csv.Model;
import polymorphic.csv.NbCol;
import polymorphic.csv.NbRow;
import polymorphic.csv.OpenCSV;
import polymorphic.csv.PrintCSV;
import polymorphic.csv.SaveCSV;
import polymorphic.generator.csv.ICsvGenerator;

@SuppressWarnings("all")
public class JavaCsvGenerator implements ICsvGenerator {
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
    _builder_1.append("COPY ./inputs /inputs");
    _builder_1.newLine();
    _builder_1.append("WORKDIR project");
    _builder_1.newLine();
    _builder_1.append("RUN mvn compile");
    _builder_1.newLine();
    _builder_1.append("ENTRYPOINT  mvn -q exec:java -Dexec.mainClass=\"");
    _builder_1.append(package_);
    _builder_1.append(".");
    _builder_1.append(className);
    _builder_1.append("\"");
    _builder_1.newLineIfNotEmpty();
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
    {
      int _length = package_.length();
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        _builder_5.append("package ");
        _builder_5.append(package_);
        _builder_5.append(";");
      }
    }
    _builder_5.newLineIfNotEmpty();
    _builder_5.newLine();
    _builder_5.append("import java.io.*;");
    _builder_5.newLine();
    _builder_5.append("import java.awt.Point;");
    _builder_5.newLine();
    _builder_5.append("import java.util.HashMap;");
    _builder_5.newLine();
    _builder_5.append("import java.util.Scanner;");
    _builder_5.newLine();
    _builder_5.newLine();
    _builder_5.append("public class ");
    _builder_5.append(className);
    _builder_5.append(" {");
    _builder_5.newLineIfNotEmpty();
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("private HashMap<Point, String> _map = new HashMap<Point, String>();");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("private int _cols;");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("private int _rows;");
    _builder_5.newLine();
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("public void open(File file) throws FileNotFoundException, IOException {");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("open(file, \',\');");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("public void open(File file, char delimiter) throws FileNotFoundException, IOException {");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("Scanner scanner = new Scanner(file);");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("scanner.useDelimiter(Character.toString(delimiter));");
    _builder_5.newLine();
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("while(scanner.hasNextLine()) {");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("String[] values = scanner.nextLine().split(Character.toString(delimiter));");
    _builder_5.newLine();
    _builder_5.newLine();
    _builder_5.append("\t\t\t");
    _builder_5.append("int col = 0;");
    _builder_5.newLine();
    _builder_5.append("\t\t\t");
    _builder_5.append("for ( String value: values ) {");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("_map.put(new Point(col, _rows), value);");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("_cols = Math.max(_cols, ++col);");
    _builder_5.newLine();
    _builder_5.append("\t\t\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t\t\t");
    _builder_5.append("_rows++;");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("scanner.close();");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("public void save(File file) throws IOException {");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("save(file, \',\');");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("public void save(File file, char delimiter) throws IOException {");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("FileWriter fw = new FileWriter(file);");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("BufferedWriter bw = new BufferedWriter(fw);");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("for (int row = 0; row < _rows; row++) {");
    _builder_5.newLine();
    _builder_5.append("\t\t\t");
    _builder_5.append("for (int col = 0; col < _cols; col++) {");
    _builder_5.newLine();
    _builder_5.append("\t\t\t");
    _builder_5.append("Point key = new Point(col, row);");
    _builder_5.newLine();
    _builder_5.append("\t\t\t\t");
    _builder_5.append("if (_map.containsKey(key)) {");
    _builder_5.newLine();
    _builder_5.append("\t\t\t\t\t");
    _builder_5.append("bw.write(_map.get(key));");
    _builder_5.newLine();
    _builder_5.append("\t\t\t\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t\t\t\t");
    _builder_5.newLine();
    _builder_5.append("\t\t\t\t");
    _builder_5.append("if ((col + 1) < _cols) {");
    _builder_5.newLine();
    _builder_5.append("\t\t\t\t\t");
    _builder_5.append("bw.write(delimiter);");
    _builder_5.newLine();
    _builder_5.append("\t\t\t\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t\t\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t\t\t");
    _builder_5.append("bw.newLine();");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("bw.flush();");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("bw.close();");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("public String serialize(final char delimiter) throws IOException {");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("final StringBuilder sb = new StringBuilder();");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("for (int row = 0; row < _rows; row++) {");
    _builder_5.newLine();
    _builder_5.append("\t\t\t");
    _builder_5.append("for (int col = 0; col < _cols; col++) {");
    _builder_5.newLine();
    _builder_5.append("\t\t\t\t");
    _builder_5.append("final Point key = new Point(col, row);");
    _builder_5.newLine();
    _builder_5.append("\t\t\t\t");
    _builder_5.append("if (_map.containsKey(key)) {");
    _builder_5.newLine();
    _builder_5.append("\t\t\t\t\t");
    _builder_5.append("sb.append(_map.get(key));");
    _builder_5.newLine();
    _builder_5.append("\t\t\t\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t\t\t\t");
    _builder_5.newLine();
    _builder_5.append("\t\t\t\t");
    _builder_5.append("if ((col + 1) < _cols) {");
    _builder_5.newLine();
    _builder_5.append("\t\t\t\t\t");
    _builder_5.append("sb.append(delimiter);");
    _builder_5.newLine();
    _builder_5.append("\t\t\t\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t\t\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t\t\t");
    _builder_5.append("sb.append(System.lineSeparator());");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("return sb.toString();");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("public String get(int col, int row) {");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("String val = \"\";");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("Point key = new Point(col, row);");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("if (_map.containsKey(key)) {");
    _builder_5.newLine();
    _builder_5.append("\t\t\t");
    _builder_5.append("val = _map.get(key);");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("return val;");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("public void put(int col, int row, String value) {");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("_map.put(new Point(col, row), value);");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("_cols = Math.max(_cols, col+1);");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("_rows = Math.max(_rows, row+1);");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("public int rows() { return this._rows; }");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("public int cols() { return this._cols; }");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("public static void main(String[] args) {");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("try {");
    _builder_5.newLine();
    {
      EList<Action> _actions = content.getActions();
      for(final Action action : _actions) {
        _builder_5.append("\t\t     \t");
        CharSequence _javaAction = this.javaAction(action, className);
        _builder_5.append(_javaAction, "\t\t     \t");
        _builder_5.newLineIfNotEmpty();
      }
    }
    _builder_5.append("\t\t");
    _builder_5.append("} catch (Exception e) {");
    _builder_5.newLine();
    _builder_5.append("\t\t\t");
    _builder_5.append("System.out.println(e);");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("}");
    _builder_5.newLine();
    fsa.generateFile(_builder_4.toString(), _builder_5);
  }
  
  private CharSequence _javaAction(final OpenCSV open, final CharSequence className) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(className);
    _builder.append(" ");
    String _name = open.getName();
    _builder.append(_name);
    _builder.append(" = new ");
    _builder.append(className);
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    String _name_1 = open.getName();
    _builder.append(_name_1);
    _builder.append(".open(new File(args[0]+\"");
    String _file = open.getFile();
    _builder.append(_file);
    _builder.append("\"));");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _javaAction(final PrintCSV open, final CharSequence className) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("System.out.println(");
    String _name = open.getOpen().getName();
    _builder.append(_name);
    _builder.append(".serialize(\';\'));");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _javaAction(final NbRow nbRow, final CharSequence className) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("System.out.println(");
    String _name = nbRow.getOpen().getName();
    _builder.append(_name);
    _builder.append(".rows()-1);");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _javaAction(final NbCol nbCol, final CharSequence className) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("System.out.println(");
    String _name = nbCol.getOpen().getName();
    _builder.append(_name);
    _builder.append(".cols());");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _javaAction(final SaveCSV save, final CharSequence className) {
    CharSequence _xblockexpression = null;
    {
      String _xifexpression = null;
      String _file = save.getFile();
      boolean _tripleNotEquals = (_file != null);
      if (_tripleNotEquals) {
        _xifexpression = save.getFile();
      } else {
        _xifexpression = save.getOpen().getFile();
      }
      final String file = _xifexpression;
      StringConcatenation _builder = new StringConcatenation();
      String _name = save.getOpen().getName();
      _builder.append(_name);
      _builder.append(".save(new File(args[0]+\"");
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
    return CollectionLiterals.<String, Boolean>newHashMap(_mappedTo);
  }
  
  private CharSequence javaAction(final Action nbCol, final CharSequence className) {
    if (nbCol instanceof NbCol) {
      return _javaAction((NbCol)nbCol, className);
    } else if (nbCol instanceof NbRow) {
      return _javaAction((NbRow)nbCol, className);
    } else if (nbCol instanceof PrintCSV) {
      return _javaAction((PrintCSV)nbCol, className);
    } else if (nbCol instanceof SaveCSV) {
      return _javaAction((SaveCSV)nbCol, className);
    } else if (nbCol instanceof OpenCSV) {
      return _javaAction((OpenCSV)nbCol, className);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(nbCol, className).toString());
    }
  }
}
