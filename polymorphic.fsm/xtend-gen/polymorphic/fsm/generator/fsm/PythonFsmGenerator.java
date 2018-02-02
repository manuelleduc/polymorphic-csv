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
public class PythonFsmGenerator implements IFsmGenerator {
  @Override
  public void generate(final Model content, final Language language, final IFileSystemAccess2 fsa) {
    final String className = IterableExtensions.<String>head(ListExtensions.<String>reverse(((List<String>)Conversions.doWrapArray(language.getTarget().split("\\.")))));
    final Function1<State, Boolean> _function = (State it) -> {
      return Boolean.valueOf(it.isInitial());
    };
    final State initialState = IterableExtensions.<State>head(IterableExtensions.<State>filter(content.getMachine().getStates(), _function));
    final Function1<State, Boolean> _function_1 = (State it) -> {
      return Boolean.valueOf(it.isFinal());
    };
    final Iterable<State> finalStates = IterableExtensions.<State>filter(content.getMachine().getStates(), _function_1);
    StringConcatenation _builder = new StringConcatenation();
    String _name = content.getName();
    _builder.append(_name);
    _builder.append("/");
    String _name_1 = language.getName();
    _builder.append(_name_1);
    _builder.append("/src/main/java/");
    String _replaceAll = language.getTarget().replaceAll("\\.", "/");
    _builder.append(_replaceAll);
    _builder.append(".py");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import sys");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class ");
    _builder_1.append(className);
    _builder_1.append(":");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("  ");
    _builder_1.append("def run(self, args):");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("currentState = \"");
    String _name_2 = initialState.getName();
    _builder_1.append(_name_2, "    ");
    _builder_1.append("\"");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("    ");
    _builder_1.append("for arg in args:");
    _builder_1.newLine();
    _builder_1.append("      ");
    {
      EList<Transition> _transitions = content.getMachine().getTransitions();
      boolean _hasElements = false;
      for(final Transition transition : _transitions) {
        if (!_hasElements) {
          _hasElements = true;
          _builder_1.append("if ", "      ");
        } else {
          _builder_1.appendImmediate("\nelif ", "      ");
        }
        _builder_1.append("currentState == \"");
        String _name_3 = transition.getFrom().getName();
        _builder_1.append(_name_3, "      ");
        _builder_1.append("\" and arg == \"");
        String _event = transition.getEvent();
        _builder_1.append(_event, "      ");
        _builder_1.append("\":");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("      ");
        _builder_1.append("  ");
        _builder_1.append("currentState = \"");
        String _name_4 = transition.getTo().getName();
        _builder_1.append(_name_4, "        ");
        _builder_1.append("\"");
      }
    }
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("      ");
    _builder_1.append("else:");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("print(\"Unexpected transition \" + arg)");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("currentState = None");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("break");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if currentState is None:");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("print(\"ERROR\")");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("else:");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("if ");
    {
      boolean _hasElements_1 = false;
      for(final State fs : finalStates) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder_1.appendImmediate(" or ", "      ");
        }
        _builder_1.append("\"");
        String _name_5 = fs.getName();
        _builder_1.append(_name_5, "      ");
        _builder_1.append("\" == currentState");
      }
    }
    _builder_1.append(":");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("        ");
    _builder_1.append("print(\"SUCCESS\")");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("else:");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("print(\"ERROR: final state not reached\")");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("if __name__ == \'__main__\':");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append(className, "  ");
    _builder_1.append("().run(sys.argv[1:])");
    _builder_1.newLineIfNotEmpty();
    fsa.generateFile(_builder.toString(), _builder_1);
  }
  
  @Override
  public Map<String, Boolean> properties() {
    Pair<String, Boolean> _mappedTo = Pair.<String, Boolean>of("java", Boolean.valueOf(true));
    return CollectionLiterals.<String, Boolean>newHashMap(_mappedTo);
  }
}
