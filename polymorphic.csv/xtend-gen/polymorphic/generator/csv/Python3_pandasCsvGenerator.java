package polymorphic.generator.csv;

import java.util.Arrays;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;
import polymorphic.csv.Action;
import polymorphic.csv.Language;
import polymorphic.csv.Model;
import polymorphic.csv.NbCol;
import polymorphic.csv.NbRow;
import polymorphic.csv.OpenCSV;
import polymorphic.csv.PrintCSV;
import polymorphic.csv.RefOpenAction;
import polymorphic.csv.SaveCSV;
import polymorphic.generator.csv.ICsvGenerator;

@SuppressWarnings("all")
public class Python3_pandasCsvGenerator implements ICsvGenerator {
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
    _builder_1.append("FROM python3");
    _builder_1.newLine();
    _builder_1.append("COPY . /project");
    _builder_1.newLine();
    _builder_1.append("COPY ./inputs /inputs");
    _builder_1.newLine();
    _builder_1.append("WORKDIR project");
    _builder_1.newLine();
    _builder_1.append("ENTRYPOINT python3 ");
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
    _builder_3.append("#!/usr/bin/env python3");
    _builder_3.newLine();
    _builder_3.append("import sys");
    _builder_3.newLine();
    _builder_3.append("import pandas");
    _builder_3.newLine();
    {
      EList<Action> _actions = content.getActions();
      for(final Action action : _actions) {
        CharSequence _pythonAction = this.pythonAction(action);
        _builder_3.append(_pythonAction);
        _builder_3.newLineIfNotEmpty();
      }
    }
    fsa.generateFile(_builder_2.toString(), _builder_3);
  }
  
  private OpenCSV _getRelatedOpen(final OpenCSV a) {
    return a;
  }
  
  private OpenCSV _getRelatedOpen(final RefOpenAction a) {
    return a.getOpen();
  }
  
  private String target(final OpenCSV a) {
    String _xblockexpression = null;
    {
      final String open = this.getRelatedOpen(a).getFile();
      _xblockexpression = open;
    }
    return _xblockexpression;
  }
  
  private String encoding(final Action action) {
    String _xblockexpression = null;
    {
      final String encoding = this.getRelatedOpen(action).getCharset();
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
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  private CharSequence _pythonAction(final OpenCSV open) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("df = pandas.read_csv(sys.argv[1]+\"");
    String _target = this.target(open);
    _builder.append(_target);
    _builder.append("\", encoding=\"");
    String _encoding = this.encoding(open);
    _builder.append(_encoding);
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _pythonAction(final PrintCSV print) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("print(df)");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence _pythonAction(final NbRow nbRow) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("print(df.shape[0])");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence _pythonAction(final NbCol nbCol) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("print(df.shape[1])");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence _pythonAction(final SaveCSV save) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("df.to_csv(sys.argv[1]+\"");
    String _file = save.getFile();
    _builder.append(_file);
    _builder.append("\", index=False, encoding=\"");
    String _encoding = this.encoding(save);
    _builder.append(_encoding);
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  @Override
  public Map<String, Boolean> properties() {
    Pair<String, Boolean> _mappedTo = Pair.<String, Boolean>of("python3", Boolean.valueOf(true));
    return CollectionLiterals.<String, Boolean>newHashMap(_mappedTo);
  }
  
  private OpenCSV getRelatedOpen(final Action a) {
    if (a instanceof OpenCSV) {
      return _getRelatedOpen((OpenCSV)a);
    } else if (a instanceof RefOpenAction) {
      return _getRelatedOpen((RefOpenAction)a);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(a).toString());
    }
  }
  
  private CharSequence pythonAction(final Action nbCol) {
    if (nbCol instanceof NbCol) {
      return _pythonAction((NbCol)nbCol);
    } else if (nbCol instanceof NbRow) {
      return _pythonAction((NbRow)nbCol);
    } else if (nbCol instanceof PrintCSV) {
      return _pythonAction((PrintCSV)nbCol);
    } else if (nbCol instanceof SaveCSV) {
      return _pythonAction((SaveCSV)nbCol);
    } else if (nbCol instanceof OpenCSV) {
      return _pythonAction((OpenCSV)nbCol);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(nbCol).toString());
    }
  }
}
