package polymorphic.fsm.generator.fsm;

import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import polymorphic.fsm.fsm.Language;
import polymorphic.fsm.fsm.Model;
import polymorphic.fsm.fsm.State;
import polymorphic.fsm.fsm.Transition;
import polymorphic.fsm.generator.fsm.IFsmGenerator;

@SuppressWarnings("all")
public class JavaFsmGenerator implements IFsmGenerator {
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
    _builder_3.append("    ");
    _builder_3.append("<properties>");
    _builder_3.newLine();
    _builder_3.append("\t\t");
    _builder_3.append("<maven.compiler.source>1.8</maven.compiler.source>");
    _builder_3.newLine();
    _builder_3.append("\t\t");
    _builder_3.append("<maven.compiler.target>1.8</maven.compiler.target>");
    _builder_3.newLine();
    _builder_3.append("\t\t");
    _builder_3.append("<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>");
    _builder_3.newLine();
    _builder_3.append("\t");
    _builder_3.append("</properties>");
    _builder_3.newLine();
    _builder_3.append("</project>");
    _builder_3.newLine();
    fsa.generateFile(_builder_2.toString(), _builder_3);
    final Function1<State, Boolean> _function = (State it) -> {
      return Boolean.valueOf(it.isInitial());
    };
    final State initialState = IterableExtensions.<State>head(IterableExtensions.<State>filter(content.getMachine().getStates(), _function));
    final Function1<State, Boolean> _function_1 = (State it) -> {
      return Boolean.valueOf(it.isFinal());
    };
    final Iterable<State> finalStates = IterableExtensions.<State>filter(content.getMachine().getStates(), _function_1);
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
    _builder_5.append("public class ");
    _builder_5.append(className);
    _builder_5.append(" {");
    _builder_5.newLineIfNotEmpty();
    _builder_5.newLine();
    _builder_5.append("    ");
    _builder_5.append("public void run(String[] args) {");
    _builder_5.newLine();
    _builder_5.append("    \t");
    _builder_5.append("String currentState = \"");
    String _name_7 = initialState.getName();
    _builder_5.append(_name_7, "    \t");
    _builder_5.append("\";");
    _builder_5.newLineIfNotEmpty();
    _builder_5.append("    \t");
    _builder_5.append("for(String arg: args) {");
    _builder_5.newLine();
    _builder_5.append("    \t\t");
    {
      EList<Transition> _transitions = content.getMachine().getTransitions();
      boolean _hasElements = false;
      for(final Transition transition : _transitions) {
        if (!_hasElements) {
          _hasElements = true;
          _builder_5.append("if ", "    \t\t");
        } else {
          _builder_5.appendImmediate(" else if ", "    \t\t");
        }
        _builder_5.append("(currentState.equals(\"");
        String _name_8 = transition.getFrom().getName();
        _builder_5.append(_name_8, "    \t\t");
        _builder_5.append("\") && arg.equals(\"");
        String _event = transition.getEvent();
        _builder_5.append(_event, "    \t\t");
        _builder_5.append("\")) {");
        _builder_5.newLineIfNotEmpty();
        _builder_5.append("    \t\t");
        _builder_5.append("\t");
        _builder_5.append("currentState = \"");
        String _name_9 = transition.getTo().getName();
        _builder_5.append(_name_9, "    \t\t\t");
        _builder_5.append("\";");
        _builder_5.newLineIfNotEmpty();
        _builder_5.append("    \t\t");
        _builder_5.append("}");
      }
    }
    _builder_5.newLineIfNotEmpty();
    _builder_5.append("    \t\t");
    _builder_5.append("else {");
    _builder_5.newLine();
    _builder_5.append("\t    \t\t");
    _builder_5.append("System.out.println(\"Unexpected transition \" + arg);");
    _builder_5.newLine();
    _builder_5.append("\t    \t\t");
    _builder_5.append("currentState = null;");
    _builder_5.newLine();
    _builder_5.append("\t    \t\t");
    _builder_5.append("break;");
    _builder_5.newLine();
    _builder_5.append("    \t\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("if(currentState == null) {");
    _builder_5.newLine();
    _builder_5.append("\t\t\t");
    _builder_5.append("System.out.println(\"ERROR\");");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("} else {");
    _builder_5.newLine();
    _builder_5.append("\t\t\t");
    _builder_5.append("if(");
    {
      boolean _hasElements_1 = false;
      for(final State fs : finalStates) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder_5.appendImmediate(" || ", "\t\t\t");
        }
        _builder_5.append("\"");
        String _name_10 = fs.getName();
        _builder_5.append(_name_10, "\t\t\t");
        _builder_5.append("\".equals(currentState)");
      }
    }
    _builder_5.append(") {");
    _builder_5.newLineIfNotEmpty();
    _builder_5.append("\t\t\t\t");
    _builder_5.append("System.out.println(\"SUCCESS\");");
    _builder_5.newLine();
    _builder_5.append("\t\t\t");
    _builder_5.append("} else {");
    _builder_5.newLine();
    _builder_5.append("\t\t\t\t");
    _builder_5.append("System.out.println(\"ERROR: final state not reached\");");
    _builder_5.newLine();
    _builder_5.append("\t\t\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.newLine();
    _builder_5.append("\t");
    _builder_5.append("public static void main(String [] args) {");
    _builder_5.newLine();
    _builder_5.append("\t\t");
    _builder_5.append("new ");
    _builder_5.append(className, "\t\t");
    _builder_5.append("().run(args);");
    _builder_5.newLineIfNotEmpty();
    _builder_5.append("\t");
    _builder_5.append("}");
    _builder_5.newLine();
    _builder_5.append("}");
    _builder_5.newLine();
    fsa.generateFile(_builder_4.toString(), _builder_5);
  }
  
  @Override
  public Map<String, Boolean> properties() {
    Pair<String, Boolean> _mappedTo = Pair.<String, Boolean>of("java", Boolean.valueOf(true));
    return CollectionLiterals.<String, Boolean>newHashMap(_mappedTo);
  }
}
