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
    _builder_3.append("# -*- coding: utf-8 -*-");
    _builder_3.newLine();
    _builder_3.append("from __future__ import print_function");
    _builder_3.newLine();
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
  
  private CharSequence _pythonAction(final OpenCSV open) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("with open(\"");
    String _file = open.getFile();
    _builder.append(_file);
    _builder.append("\") as read:");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("tmp = read.readlines()");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence _pythonAction(final PrintCSV print) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for line in tmp:");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("print(line, end=\"\")");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence _pythonAction(final NbRow nbRow) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("print(sum(1 for row in tmp) -1 )");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence _pythonAction(final NbCol nbCol) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t\t");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence _pythonAction(final SaveCSV save) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    return _builder;
  }
  
  @Override
  public Map<String, Boolean> properties() {
    Pair<String, Boolean> _mappedTo = Pair.<String, Boolean>of("python", Boolean.valueOf(true));
    return CollectionLiterals.<String, Boolean>newHashMap(_mappedTo);
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
