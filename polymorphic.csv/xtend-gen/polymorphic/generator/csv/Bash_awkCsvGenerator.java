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
import polymorphic.csv.SaveCSV;
import polymorphic.generator.csv.ICsvGenerator;

@SuppressWarnings("all")
public class Bash_awkCsvGenerator implements ICsvGenerator {
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
    _builder.append("awk \'{ print $0 }\' ");
    String _file = print.getOpen().getFile();
    _builder.append(_file);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _bashAction(final NbRow nbrow) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("awk \'END { print NR-1 }\' ");
    String _file = nbrow.getOpen().getFile();
    _builder.append(_file);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _bashAction(final NbCol nbcol) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("awk \'BEGIN { FS = \",\" } ; END { print NF }\' ");
    String _file = nbcol.getOpen().getFile();
    _builder.append(_file);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _bashAction(final SaveCSV save) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("awk \'{ print $0 }\' ");
    String _file = save.getOpen().getFile();
    _builder.append(_file);
    _builder.append(" > ");
    String _file_1 = save.getFile();
    _builder.append(_file_1);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  @Override
  public Map<String, Boolean> properties() {
    Pair<String, Boolean> _mappedTo = Pair.<String, Boolean>of("bash_awk", Boolean.valueOf(true));
    return CollectionLiterals.<String, Boolean>newHashMap(_mappedTo);
  }
  
  private CharSequence bashAction(final Action nbcol) {
    if (nbcol instanceof NbCol) {
      return _bashAction((NbCol)nbcol);
    } else if (nbcol instanceof NbRow) {
      return _bashAction((NbRow)nbcol);
    } else if (nbcol instanceof PrintCSV) {
      return _bashAction((PrintCSV)nbcol);
    } else if (nbcol instanceof SaveCSV) {
      return _bashAction((SaveCSV)nbcol);
    } else if (nbcol instanceof OpenCSV) {
      return _bashAction((OpenCSV)nbcol);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(nbcol).toString());
    }
  }
}
