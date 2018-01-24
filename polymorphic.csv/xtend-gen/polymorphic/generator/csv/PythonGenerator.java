package polymorphic.generator.csv;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Arrays;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import polymorphic.csv.Actions;
import polymorphic.csv.Language;
import polymorphic.csv.Model;
import polymorphic.csv.OpenCSV;
import polymorphic.csv.PrintCSV;
import polymorphic.csv.SaveCSV;
import polymorphic.generator.csv.ICsvGenerator;

@SuppressWarnings("all")
public class PythonGenerator implements ICsvGenerator {
  @Override
  public void generate(final Model content, final Language language, final IFileSystemAccess2 fsa) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = content.getName();
    _builder.append(_name);
    _builder.append("/");
    String _name_1 = language.getName();
    _builder.append(_name_1);
    _builder.append("/Dockerfile");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("FROM python");
    _builder_1.newLine();
    _builder_1.append("COPY . /project");
    _builder_1.newLine();
    _builder_1.append("WORKDIR project");
    _builder_1.newLine();
    fsa.generateFile(_builder.toString(), _builder_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    String _name_2 = content.getName();
    _builder_2.append(_name_2);
    _builder_2.append("/");
    String _name_3 = language.getName();
    _builder_2.append(_name_3);
    _builder_2.append("/");
    String _target = language.getTarget();
    _builder_2.append(_target);
    _builder_2.append(".py");
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("import csv");
    _builder_3.newLine();
    {
      EList<Actions> _actions = content.getActions();
      for(final Actions action : _actions) {
        CharSequence _pythonAction = this.pythonAction(action);
        _builder_3.append(_pythonAction);
        _builder_3.newLineIfNotEmpty();
      }
    }
    _builder_3.newLine();
    fsa.generateFile(_builder_2.toString(), _builder_3);
  }
  
  protected CharSequence _pythonAction(final OpenCSV open) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = open.getName();
    _builder.append(_name);
    _builder.append(" = open(\'");
    String _file = open.getFile();
    _builder.append(_file);
    _builder.append("\', \'rt\')");
    _builder.newLineIfNotEmpty();
    String _name_1 = open.getName();
    _builder.append(_name_1);
    _builder.append("_read = csv.reader(");
    String _name_2 = open.getName();
    _builder.append(_name_2);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _pythonAction(final PrintCSV print) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for ");
    String _name = print.getName();
    _builder.append(_name);
    _builder.append("_e in ");
    String _name_1 = print.getName();
    _builder.append(_name_1);
    _builder.append("_read:");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("print(\', \'.join(");
    String _name_2 = print.getName();
    _builder.append(_name_2, "  ");
    _builder.append("_e))");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _pythonAction(final SaveCSV save) {
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
      final String f = _xifexpression;
      StringConcatenation _builder = new StringConcatenation();
      String _name = save.getName();
      _builder.append(_name);
      _builder.append("_write = csv.writer(open(\'");
      _builder.append(f);
      _builder.append("\', \'wt\'))");
      _builder.newLineIfNotEmpty();
      _builder.append("for ");
      String _name_1 = save.getName();
      _builder.append(_name_1);
      _builder.append("_e in ");
      String _name_2 = save.getName();
      _builder.append(_name_2);
      _builder.append("_read:");
      _builder.newLineIfNotEmpty();
      _builder.append("  ");
      _builder.append("print(");
      String _name_3 = save.getName();
      _builder.append(_name_3, "  ");
      _builder.append("_e)");
      _builder.newLineIfNotEmpty();
      _builder.append("  ");
      String _name_4 = save.getName();
      _builder.append(_name_4, "  ");
      _builder.append("_write.writerow(tuple(");
      String _name_5 = save.getName();
      _builder.append(_name_5, "  ");
      _builder.append("_e))");
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  @Override
  public Map<String, Boolean> properties() {
    Pair<String, Boolean> _mappedTo = Pair.<String, Boolean>of("python", Boolean.valueOf(true));
    return CollectionLiterals.<String, Boolean>newHashMap(_mappedTo);
  }
  
  public CharSequence pythonAction(final Actions open) {
    if (open instanceof OpenCSV) {
      return _pythonAction((OpenCSV)open);
    } else if (open instanceof PrintCSV) {
      return _pythonAction((PrintCSV)open);
    } else if (open instanceof SaveCSV) {
      return _pythonAction((SaveCSV)open);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(open).toString());
    }
  }
}
