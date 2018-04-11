package polymorphic.generator.csv;

import java.util.Arrays;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import polymorphic.csv.Action;
import polymorphic.csv.Language;
import polymorphic.csv.Model;
import polymorphic.csv.NbRow;
import polymorphic.csv.OpenCSV;
import polymorphic.csv.PrintCSV;
import polymorphic.csv.SaveCSV;
import polymorphic.generator.csv.ICsvGenerator;

@SuppressWarnings("all")
public class BashCsvGenerator implements ICsvGenerator {
  @Override
  public void generate(final Model content, final Language language, final IFileSystemAccess2 fsa) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = content.getName();
    _builder.append(_name);
    _builder.append("/");
    String _name_1 = language.getName();
    _builder.append(_name_1);
    _builder.append("/");
    String _replaceAll = language.getTarget().replaceAll("\\.", "/");
    _builder.append(_replaceAll);
    _builder.append(".sh");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("#!/bin/bash");
    _builder_1.newLine();
    {
      EList<Action> _actions = content.getActions();
      for(final Action action : _actions) {
        CharSequence _bashAction = this.bashAction(action);
        _builder_1.append(_bashAction);
        _builder_1.newLineIfNotEmpty();
      }
    }
    fsa.generateFile(_builder.toString(), _builder_1);
  }
  
  private CharSequence _bashAction(final OpenCSV open) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  private CharSequence _bashAction(final PrintCSV print) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("cat ");
    String _file = print.getOpen().getFile();
    _builder.append(_file);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _bashAction(final NbRow nbrow) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("echo $[$(wc -l < ");
    String _file = nbrow.getOpen().getFile();
    _builder.append(_file);
    _builder.append(")-1]");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _bashAction(final SaveCSV save) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("cp ");
    String _file = save.getOpen().getFile();
    _builder.append(_file);
    _builder.append(" ");
    String _file_1 = save.getFile();
    _builder.append(_file_1);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  @Override
  public Map<String, Boolean> properties() {
    return CollectionLiterals.<String, Boolean>newHashMap();
  }
  
  private CharSequence bashAction(final Action nbrow) {
    if (nbrow instanceof NbRow) {
      return _bashAction((NbRow)nbrow);
    } else if (nbrow instanceof PrintCSV) {
      return _bashAction((PrintCSV)nbrow);
    } else if (nbrow instanceof SaveCSV) {
      return _bashAction((SaveCSV)nbrow);
    } else if (nbrow instanceof OpenCSV) {
      return _bashAction((OpenCSV)nbrow);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(nbrow).toString());
    }
  }
}
