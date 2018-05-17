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
import polymorphic.csv.Action;
import polymorphic.csv.Language;
import polymorphic.csv.Model;
import polymorphic.csv.NbRow;
import polymorphic.csv.OpenCSV;
import polymorphic.csv.PrintCSV;
import polymorphic.csv.RefOpenAction;
import polymorphic.csv.SaveCSV;
import polymorphic.generator.csv.ICsvGenerator;

@SuppressWarnings("all")
public class PythonCsvGenerator implements ICsvGenerator {
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
      EList<Action> _actions = content.getActions();
      for(final Action action : _actions) {
        CharSequence _pythonAction = this.pythonAction(action);
        _builder_3.append(_pythonAction);
        _builder_3.newLineIfNotEmpty();
      }
    }
    _builder_3.newLine();
    fsa.generateFile(_builder_2.toString(), _builder_3);
  }
  
  private String encodingFormat(final String encoding) {
    String _switchResult = null;
    if (encoding != null) {
      switch (encoding) {
        case "latin1":
          _switchResult = "latin-1";
          break;
        case "utf8":
          _switchResult = "utf-8";
          break;
      }
    }
    return _switchResult;
  }
  
  private CharSequence openAction(final Action action) {
    CharSequence _xblockexpression = null;
    {
      final OpenCSV open = this.getRelatedOpen(action);
      final String file = open.getFile();
      final String encoding = open.getCharset();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("open(\'");
      _builder.append(file);
      _builder.append("\', \'rt\', encoding=\'");
      String _encodingFormat = this.encodingFormat(encoding);
      _builder.append(_encodingFormat);
      _builder.append("\')");
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected OpenCSV _getRelatedOpen(final OpenCSV a) {
    return a;
  }
  
  protected OpenCSV _getRelatedOpen(final RefOpenAction a) {
    return a.getOpen();
  }
  
  private CharSequence _pythonAction(final OpenCSV open) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  private CharSequence _pythonAction(final PrintCSV print) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for ");
    String _name = print.getOpen().getName();
    _builder.append(_name);
    _builder.append("_e in csv.reader(");
    CharSequence _openAction = this.openAction(print);
    _builder.append(_openAction);
    _builder.append("):");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("print(\', \'.join(");
    String _name_1 = print.getOpen().getName();
    _builder.append(_name_1, "  ");
    _builder.append("_e))");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _pythonAction(final NbRow nbRow) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("print(sum(1 for row in csv.reader(");
    CharSequence _openAction = this.openAction(nbRow);
    _builder.append(_openAction);
    _builder.append(")))");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _pythonAction(final SaveCSV save) {
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
          String _name_1 = save.getOpen().getName();
          return Boolean.valueOf(Objects.equal(_name, _name_1));
        };
        _xifexpression = IterableExtensions.<OpenCSV>head(IterableExtensions.<OpenCSV>filter(Iterables.<OpenCSV>filter(EcoreUtil2.<Model>getContainerOfType(save, Model.class).getActions(), OpenCSV.class), _function)).getFile();
      }
      final String outputfile = _xifexpression;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("with open(\'");
      _builder.append(outputfile);
      _builder.append("\', \'wt\') as output_file:");
      _builder.newLineIfNotEmpty();
      _builder.append("  ");
      String _name = save.getOpen().getName();
      _builder.append(_name, "  ");
      _builder.append("_write = csv.writer(output_file)");
      _builder.newLineIfNotEmpty();
      _builder.append("  ");
      _builder.append("for ");
      String _name_1 = save.getOpen().getName();
      _builder.append(_name_1, "  ");
      _builder.append("_e in csv.reader(");
      CharSequence _openAction = this.openAction(save);
      _builder.append(_openAction, "  ");
      _builder.append("):");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      String _name_2 = save.getOpen().getName();
      _builder.append(_name_2, "    ");
      _builder.append("_write.writerow(tuple(");
      String _name_3 = save.getOpen().getName();
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
  
  public OpenCSV getRelatedOpen(final Action a) {
    if (a instanceof OpenCSV) {
      return _getRelatedOpen((OpenCSV)a);
    } else if (a instanceof RefOpenAction) {
      return _getRelatedOpen((RefOpenAction)a);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(a).toString());
    }
  }
  
  private CharSequence pythonAction(final Action nbRow) {
    if (nbRow instanceof NbRow) {
      return _pythonAction((NbRow)nbRow);
    } else if (nbRow instanceof PrintCSV) {
      return _pythonAction((PrintCSV)nbRow);
    } else if (nbRow instanceof SaveCSV) {
      return _pythonAction((SaveCSV)nbRow);
    } else if (nbRow instanceof OpenCSV) {
      return _pythonAction((OpenCSV)nbRow);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(nbRow).toString());
    }
  }
}
