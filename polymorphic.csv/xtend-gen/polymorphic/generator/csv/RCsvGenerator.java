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
    _builder_1.append("args <- commandArgs(trailingOnly=TRUE)");
    _builder_1.newLine();
    _builder_1.append("root <- args[1]");
    _builder_1.newLine();
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
    String _name = open.getName();
    _builder.append(_name);
    _builder.append(" = read.csv(paste(root,\"");
    String _file = open.getFile();
    _builder.append(_file);
    _builder.append("\",sep=\"\"), header=TRUE, sep=\",\")");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _RAction(final PrintCSV print) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = print.getOpen().getName();
    _builder.append(_name);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _RAction(final NbRow nbrow) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("cat( nrow(");
    String _name = nbrow.getOpen().getName();
    _builder.append(_name);
    _builder.append("),\"\\n\" )");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _RAction(final NbCol nbcol) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("cat( ncol(");
    String _name = nbcol.getOpen().getName();
    _builder.append(_name);
    _builder.append("),\"\\n\" )");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _RAction(final SaveCSV save) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("write.csv( ");
    String _file = save.getOpen().getFile();
    _builder.append(_file);
    _builder.append(", paste(root,\"");
    String _file_1 = save.getFile();
    _builder.append(_file_1);
    _builder.append("\",sep=\"\"), quote=FALSE, row.names=FALSE )");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  @Override
  public Map<String, Boolean> properties() {
    Pair<String, Boolean> _mappedTo = Pair.<String, Boolean>of("R", Boolean.valueOf(true));
    return CollectionLiterals.<String, Boolean>newHashMap(_mappedTo);
  }
  
  private CharSequence RAction(final Action nbcol) {
    if (nbcol instanceof NbCol) {
      return _RAction((NbCol)nbcol);
    } else if (nbcol instanceof NbRow) {
      return _RAction((NbRow)nbcol);
    } else if (nbcol instanceof PrintCSV) {
      return _RAction((PrintCSV)nbcol);
    } else if (nbcol instanceof SaveCSV) {
      return _RAction((SaveCSV)nbcol);
    } else if (nbcol instanceof OpenCSV) {
      return _RAction((OpenCSV)nbcol);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(nbcol).toString());
    }
  }
}
