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
import polymorphic.csv.NbRow;
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
    _builder_1.append("COPY ./inputs /inputs");
    _builder_1.newLine();
    _builder_1.append("WORKDIR project");
    _builder_1.newLine();
    _builder_1.append("ENTRYPOINT python ");
    String _target = language.getTarget();
    _builder_1.append(_target);
    _builder_1.append(".py");
    _builder_1.newLineIfNotEmpty();
    fsa.generateFile(_builder.toString(), _builder_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    String _name_2 = content.getName();
    _builder_2.append(_name_2);
    _builder_2.append("/");
    String _name_3 = language.getName();
    _builder_2.append(_name_3);
    _builder_2.append("/");
    String _target_1 = language.getTarget();
    _builder_2.append(_target_1);
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
    return _builder;
  }
  
  protected CharSequence _pythonAction(final PrintCSV print) {
    CharSequence _xblockexpression = null;
    {
      final Function1<OpenCSV, Boolean> _function = (OpenCSV it) -> {
        String _name = it.getName();
        String _name_1 = print.getName();
        return Boolean.valueOf(Objects.equal(_name, _name_1));
      };
      final String file = IterableExtensions.<OpenCSV>head(IterableExtensions.<OpenCSV>filter(Iterables.<OpenCSV>filter(EcoreUtil2.<Model>getContainerOfType(print, Model.class).getActions(), OpenCSV.class), _function)).getFile();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("for ");
      String _name = print.getName();
      _builder.append(_name);
      _builder.append("_e in csv.reader(open(\'");
      _builder.append(file);
      _builder.append("\', \'rt\')):");
      _builder.newLineIfNotEmpty();
      _builder.append("  ");
      _builder.append("print(\', \'.join(");
      String _name_1 = print.getName();
      _builder.append(_name_1, "  ");
      _builder.append("_e))");
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected CharSequence _pythonAction(final NbRow nbRow) {
    CharSequence _xblockexpression = null;
    {
      final Function1<OpenCSV, Boolean> _function = (OpenCSV it) -> {
        String _name = it.getName();
        String _name_1 = nbRow.getName();
        return Boolean.valueOf(Objects.equal(_name, _name_1));
      };
      final String file = IterableExtensions.<OpenCSV>head(IterableExtensions.<OpenCSV>filter(Iterables.<OpenCSV>filter(EcoreUtil2.<Model>getContainerOfType(nbRow, Model.class).getActions(), OpenCSV.class), _function)).getFile();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("print(sum(1 for row in csv.reader(open(\'");
      _builder.append(file);
      _builder.append("\', \'rt\'))))");
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected CharSequence _pythonAction(final SaveCSV save) {
    CharSequence _xblockexpression = null;
    {
      final Function1<OpenCSV, Boolean> _function = (OpenCSV it) -> {
        String _name = it.getName();
        String _name_1 = save.getName();
        return Boolean.valueOf(Objects.equal(_name, _name_1));
      };
      final String inputfile = IterableExtensions.<OpenCSV>head(IterableExtensions.<OpenCSV>filter(Iterables.<OpenCSV>filter(EcoreUtil2.<Model>getContainerOfType(save, Model.class).getActions(), OpenCSV.class), _function)).getFile();
      String _xifexpression = null;
      String _file = save.getFile();
      boolean _tripleNotEquals = (_file != null);
      if (_tripleNotEquals) {
        _xifexpression = save.getFile();
      } else {
        final Function1<OpenCSV, Boolean> _function_1 = (OpenCSV it) -> {
          String _name = it.getName();
          String _name_1 = save.getName();
          return Boolean.valueOf(Objects.equal(_name, _name_1));
        };
        _xifexpression = IterableExtensions.<OpenCSV>head(IterableExtensions.<OpenCSV>filter(Iterables.<OpenCSV>filter(EcoreUtil2.<Model>getContainerOfType(save, Model.class).getActions(), OpenCSV.class), _function_1)).getFile();
      }
      final String outputfile = _xifexpression;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("with open(\'");
      _builder.append(outputfile);
      _builder.append("\', \'wt\') as output_file:");
      _builder.newLineIfNotEmpty();
      _builder.append("  ");
      String _name = save.getName();
      _builder.append(_name, "  ");
      _builder.append("_write = csv.writer(output_file)");
      _builder.newLineIfNotEmpty();
      _builder.append("  ");
      _builder.append("for ");
      String _name_1 = save.getName();
      _builder.append(_name_1, "  ");
      _builder.append("_e in csv.reader(open(\'");
      _builder.append(inputfile, "  ");
      _builder.append("\', \'rt\')):");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      String _name_2 = save.getName();
      _builder.append(_name_2, "    ");
      _builder.append("_write.writerow(tuple(");
      String _name_3 = save.getName();
      _builder.append(_name_3, "    ");
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
  
  public CharSequence pythonAction(final Actions nbRow) {
    if (nbRow instanceof NbRow) {
      return _pythonAction((NbRow)nbRow);
    } else if (nbRow instanceof OpenCSV) {
      return _pythonAction((OpenCSV)nbRow);
    } else if (nbRow instanceof PrintCSV) {
      return _pythonAction((PrintCSV)nbRow);
    } else if (nbRow instanceof SaveCSV) {
      return _pythonAction((SaveCSV)nbRow);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(nbRow).toString());
    }
  }
}
