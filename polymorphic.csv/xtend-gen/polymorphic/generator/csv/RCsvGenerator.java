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
import polymorphic.csv.NbRow;
import polymorphic.csv.OpenCSV;
import polymorphic.csv.PrintCSV;
import polymorphic.csv.SaveCSV;
import polymorphic.generator.csv.ICsvGenerator;

@SuppressWarnings("all")
public class RCsvGenerator implements ICsvGenerator {
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
    _builder.append(".R");
    StringConcatenation _builder_1 = new StringConcatenation();
    {
      EList<Action> _actions = content.getActions();
      for(final Action action : _actions) {
        CharSequence _RAction = this.RAction(action);
        _builder_1.append(_RAction);
        _builder_1.newLineIfNotEmpty();
      }
    }
    fsa.generateFile(_builder.toString(), _builder_1);
  }
  
  private CharSequence _RAction(final OpenCSV open) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("table = read.csv(\"");
    String _file = open.getFile();
    _builder.append(_file);
    _builder.append("\", header=TRUE, sep=\",\")");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _RAction(final PrintCSV print) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("table");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence _RAction(final NbRow nbrow) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("nrow(table)");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence _RAction(final SaveCSV save) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("write.csv(table, \"");
    String _file = save.getFile();
    _builder.append(_file);
    _builder.append("\", quote=FALSE, row.names=FALSE)");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  @Override
  public Map<String, Boolean> properties() {
    Pair<String, Boolean> _mappedTo = Pair.<String, Boolean>of("R", Boolean.valueOf(true));
    return CollectionLiterals.<String, Boolean>newHashMap(_mappedTo);
  }
  
  private CharSequence RAction(final Action nbrow) {
    if (nbrow instanceof NbRow) {
      return _RAction((NbRow)nbrow);
    } else if (nbrow instanceof PrintCSV) {
      return _RAction((PrintCSV)nbrow);
    } else if (nbrow instanceof SaveCSV) {
      return _RAction((SaveCSV)nbrow);
    } else if (nbrow instanceof OpenCSV) {
      return _RAction((OpenCSV)nbrow);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(nbrow).toString());
    }
  }
}
