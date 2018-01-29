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
import polymorphic.csv.NbRow;
import polymorphic.csv.OpenCSV;
import polymorphic.csv.PrintCSV;
import polymorphic.csv.SaveCSV;
import polymorphic.generator.csv.ICsvGenerator;

@SuppressWarnings("all")
public class ApacheCommonCsvGenerator implements ICsvGenerator {
  private static final class Context {
    private int cptr = 0;
    
    public int nextCptr() {
      int _xblockexpression = (int) 0;
      {
        final int ret = this.cptr;
        this.cptr = (this.cptr + 1);
        _xblockexpression = ret;
      }
      return _xblockexpression;
    }
  }
  
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
    _builder_3.append("\t\t");
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
    final ApacheCommonCsvGenerator.Context ctx = new ApacheCommonCsvGenerator.Context();
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
    _builder_5.append("package ");
    _builder_5.append(package_);
    _builder_5.append(";");
    _builder_5.newLineIfNotEmpty();
    _builder_5.newLine();
    _builder_5.append("import java.io.*;");
    _builder_5.newLine();
    _builder_5.append("import java.util.*;");
    _builder_5.newLine();
    _builder_5.append("import org.apache.commons.csv.*;");
    _builder_5.newLine();
    _builder_5.append("import java.util.stream.StreamSupport;");
    _builder_5.newLine();
    _builder_5.append("import java.util.stream.Collectors;");
    _builder_5.newLine();
    _builder_5.newLine();
    _builder_5.append("public class ");
    _builder_5.append(className);
    _builder_5.append(" {");
    _builder_5.newLineIfNotEmpty();
    _builder_5.append(" \t");
    _builder_5.append("public static void main(String[] args) throws  FileNotFoundException, IOException {");
    _builder_5.newLine();
    {
      EList<Actions> _actions = content.getActions();
      for(final Actions action : _actions) {
        _builder_5.append("\t");
        CharSequence _javaAction = this.javaAction(action, className, ctx);
        _builder_5.append(_javaAction, "\t");
        _builder_5.newLineIfNotEmpty();
      }
    }
    _builder_5.append("\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("}");
    _builder_5.newLine();
    fsa.generateFile(_builder_4.toString(), _builder_5);
  }
  
  protected CharSequence _javaAction(final OpenCSV open, final CharSequence className, final ApacheCommonCsvGenerator.Context ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("final List<CSVRecord> ");
    String _name = open.getName();
    _builder.append(_name);
    _builder.append(" = StreamSupport.stream(CSVFormat.RFC4180.parse(new FileReader(\"");
    String _file = open.getFile();
    _builder.append(_file);
    _builder.append("\")).spliterator(), false).collect(Collectors.toList());");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _javaAction(final PrintCSV print, final CharSequence className, final ApacheCommonCsvGenerator.Context ctx) {
    CharSequence _xblockexpression = null;
    {
      final int varX = ctx.nextCptr();
      StringConcatenation _builder = new StringConcatenation();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("sb");
      _builder_1.append(varX);
      final String sb = _builder_1.toString();
      _builder.newLineIfNotEmpty();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("tmp");
      _builder_2.append(varX);
      final String tmp = _builder_2.toString();
      _builder.newLineIfNotEmpty();
      _builder.append("final StringBuilder ");
      _builder.append(sb);
      _builder.append(" = new StringBuilder();");
      _builder.newLineIfNotEmpty();
      _builder.append("try (CSVPrinter ");
      _builder.append(tmp);
      _builder.append(" = new CSVPrinter(");
      _builder.append(sb);
      _builder.append(", CSVFormat.RFC4180)) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append(tmp, "\t");
      _builder.append(".printRecords(");
      String _name = print.getName();
      _builder.append(_name, "\t");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _builder.append("System.out.println(");
      _builder.append(sb);
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected CharSequence _javaAction(final NbRow nbRow, final CharSequence className, final ApacheCommonCsvGenerator.Context ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("System.out.println(");
    String _name = nbRow.getName();
    _builder.append(_name);
    _builder.append(".size());");
    return _builder;
  }
  
  protected CharSequence _javaAction(final SaveCSV save, final CharSequence className, final ApacheCommonCsvGenerator.Context ctx) {
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
      final int varX = ctx.nextCptr();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("try (CSVPrinter tmp");
      _builder.append(varX);
      _builder.append(" = new CSVPrinter(new FileWriter(new File(\"");
      _builder.append(file);
      _builder.append("\")), CSVFormat.RFC4180)) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("tmp");
      _builder.append(varX, "\t");
      _builder.append(".printRecords(");
      String _name = save.getName();
      _builder.append(_name, "\t");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
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
  
  public CharSequence javaAction(final Actions nbRow, final CharSequence className, final ApacheCommonCsvGenerator.Context ctx) {
    if (nbRow instanceof NbRow) {
      return _javaAction((NbRow)nbRow, className, ctx);
    } else if (nbRow instanceof OpenCSV) {
      return _javaAction((OpenCSV)nbRow, className, ctx);
    } else if (nbRow instanceof PrintCSV) {
      return _javaAction((PrintCSV)nbRow, className, ctx);
    } else if (nbRow instanceof SaveCSV) {
      return _javaAction((SaveCSV)nbRow, className, ctx);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(nbRow, className, ctx).toString());
    }
  }
}
