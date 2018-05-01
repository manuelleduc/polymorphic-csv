/**
 * generated by Xtext 2.13.0
 */
package polymorphic.generator;

import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import polymorphic.csv.Language;
import polymorphic.csv.Model;
import polymorphic.generator.GeneratorCollection;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class CsvGenerator extends AbstractGenerator {
  private GeneratorCollection generators = new GeneratorCollection();
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    EObject _head = IterableExtensions.<EObject>head(resource.getContents());
    final Model content = ((Model) _head);
    final Consumer<Language> _function = (Language language) -> {
      this.generators.getMap().get(language.getName()).generate(content, language, fsa);
    };
    content.getLanguages().forEach(_function);
    StringConcatenation _builder = new StringConcatenation();
    String _name = content.getName();
    _builder.append(_name);
    _builder.append("/docker-compose.yml");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("version: \'3\'");
    _builder_1.newLine();
    _builder_1.append("services:");
    _builder_1.newLine();
    {
      EList<Language> _languages = content.getLanguages();
      for(final Language l : _languages) {
        _builder_1.append("  ");
        String _name_1 = l.getName();
        _builder_1.append(_name_1, "  ");
        _builder_1.append(":");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("  ");
        _builder_1.append("  ");
        _builder_1.append("build:");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("    ");
        _builder_1.append("context: ./");
        String _name_2 = l.getName();
        _builder_1.append(_name_2, "      ");
        _builder_1.newLineIfNotEmpty();
      }
    }
    fsa.generateFile(_builder.toString(), _builder_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    String _name_3 = content.getName();
    _builder_2.append(_name_3);
    _builder_2.append("/build.sh");
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("#!/bin/bash");
    _builder_3.newLine();
    _builder_3.append("mkdir -p ./inputs");
    _builder_3.newLine();
    {
      EList<Language> _languages_1 = content.getLanguages();
      for(final Language l_1 : _languages_1) {
        _builder_3.append("rm -r ./");
        String _name_4 = l_1.getName();
        _builder_3.append(_name_4);
        _builder_3.append("/inputs");
        _builder_3.newLineIfNotEmpty();
        _builder_3.append("cp -r ./inputs ./");
        String _name_5 = l_1.getName();
        _builder_3.append(_name_5);
        _builder_3.append("/inputs");
        _builder_3.newLineIfNotEmpty();
      }
    }
    _builder_3.append("docker-compose build");
    _builder_3.newLine();
    fsa.generateFile(_builder_2.toString(), _builder_3);
    StringConcatenation _builder_4 = new StringConcatenation();
    String _name_6 = content.getName();
    _builder_4.append(_name_6);
    _builder_4.append("/run.sh");
    StringConcatenation _builder_5 = new StringConcatenation();
    _builder_5.append("#!/bin/bash");
    _builder_5.newLine();
    _builder_5.append("rm -r ./logs");
    _builder_5.newLine();
    _builder_5.append("mkdir -p ./logs");
    _builder_5.newLine();
    _builder_5.append("docker-compose up");
    _builder_5.newLine();
    fsa.generateFile(_builder_4.toString(), _builder_5);
    StringConcatenation _builder_6 = new StringConcatenation();
    _builder_6.append("../data/");
    String _name_7 = content.getName();
    _builder_6.append(_name_7);
    _builder_6.append("/readme.txt");
    StringConcatenation _builder_7 = new StringConcatenation();
    _builder_7.append("HOW TO ADD DATA :");
    _builder_7.newLine();
    _builder_7.newLine();
    _builder_7.append("1. create a folder with the name of the .csv file");
    _builder_7.newLine();
    _builder_7.append("\t");
    _builder_7.append("( whitout blank space or \"/\": new folder -> new_folder )");
    _builder_7.newLine();
    _builder_7.append("2. rename the .csv file in \"file.csv\"");
    _builder_7.newLine();
    _builder_7.append("3. move the file.csv into the folder");
    _builder_7.newLine();
    _builder_7.newLine();
    _builder_7.append("The execution\'s result will be in the folder as ");
    _builder_7.newLine();
    _builder_7.append("result_\"name of the .pcsv\"_\"name of the folder\"");
    _builder_7.newLine();
    fsa.generateFile(_builder_6.toString(), _builder_7);
    StringConcatenation _builder_8 = new StringConcatenation();
    _builder_8.append("../exec_main.sh");
    StringConcatenation _builder_9 = new StringConcatenation();
    _builder_9.append("#!/bin/bash");
    _builder_9.newLine();
    _builder_9.newLine();
    _builder_9.append("# main exec.sh");
    _builder_9.newLine();
    _builder_9.append("# syntax : bash exec_main.sh");
    _builder_9.newLine();
    _builder_9.newLine();
    _builder_9.append("echo \"--------------------\"");
    _builder_9.newLine();
    _builder_9.append("echo \"### EXEC_MAIN.SH ###\"");
    _builder_9.newLine();
    _builder_9.append("echo \"--------------------\"");
    _builder_9.newLine();
    _builder_9.newLine();
    _builder_9.append("# for each .pcsv present");
    _builder_9.newLine();
    _builder_9.append("for file in *.pcsv");
    _builder_9.newLine();
    _builder_9.append("do");
    _builder_9.newLine();
    _builder_9.append("    ");
    _builder_9.append("echo \"\"");
    _builder_9.newLine();
    _builder_9.append("\t");
    _builder_9.append("# remove .pcsv to the file == name of the current .pcsv");
    _builder_9.newLine();
    _builder_9.append("    ");
    _builder_9.append("name=${file:0:-5}");
    _builder_9.newLine();
    _builder_9.newLine();
    _builder_9.append("    ");
    _builder_9.append("echo \"####### Launch of $name #######\"");
    _builder_9.newLine();
    _builder_9.append("    ");
    _builder_9.append("echo \"\"");
    _builder_9.newLine();
    _builder_9.append("\t");
    _builder_9.newLine();
    _builder_9.append("\t");
    _builder_9.append("# launch local exec.sh as main");
    _builder_9.newLine();
    _builder_9.append("    ");
    _builder_9.append("./src-gen/$name/exec.sh main");
    _builder_9.newLine();
    _builder_9.newLine();
    _builder_9.append("    ");
    _builder_9.append("echo \"####### End of $name #######\"");
    _builder_9.newLine();
    _builder_9.append("    ");
    _builder_9.append("echo \"--------------------\"");
    _builder_9.newLine();
    _builder_9.append("done");
    _builder_9.newLine();
    _builder_9.newLine();
    _builder_9.append("echo \"\"");
    _builder_9.newLine();
    _builder_9.append("echo \"### END OF EXEC_MAIN.SH ###\"");
    _builder_9.newLine();
    _builder_9.append("echo \"--------------------\"");
    _builder_9.newLine();
    fsa.generateFile(_builder_8.toString(), _builder_9);
    StringConcatenation _builder_10 = new StringConcatenation();
    String _name_8 = content.getName();
    _builder_10.append(_name_8);
    _builder_10.append("/exec.sh");
    StringConcatenation _builder_11 = new StringConcatenation();
    _builder_11.append("#!/bin/bash");
    _builder_11.newLine();
    _builder_11.newLine();
    _builder_11.append("# local exec.sh ");
    String _name_9 = content.getName();
    _builder_11.append(_name_9);
    _builder_11.newLineIfNotEmpty();
    _builder_11.append("# syntax : bash exec.sh");
    _builder_11.newLine();
    _builder_11.newLine();
    _builder_11.append("# path of \"code_X\" for main call / local call");
    _builder_11.newLine();
    _builder_11.append("# path1 = where are data of the .pcsv");
    _builder_11.newLine();
    _builder_11.append("if [ \"$1\" = \"main\" ] ; then path1=\"./data/");
    String _name_10 = content.getName();
    _builder_11.append(_name_10);
    _builder_11.append("/\" ; else path1=\"../../data/");
    String _name_11 = content.getName();
    _builder_11.append(_name_11);
    _builder_11.append("/\" ; fi");
    _builder_11.newLineIfNotEmpty();
    _builder_11.newLine();
    _builder_11.append("# for each data folder in directory_pcsv");
    _builder_11.newLine();
    _builder_11.append("for Data_folder_csv in $path1*/");
    _builder_11.newLine();
    _builder_11.append("do");
    _builder_11.newLine();
    _builder_11.newLine();
    _builder_11.append("\t");
    _builder_11.append("# data\'s name for main call / local call = code\'s name + data\'s name");
    _builder_11.newLine();
    _builder_11.append("\t");
    _builder_11.append("if [ \"$1\" = \"main\" ] ; then dataName=${Data_folder_csv:7:-1} ; else dataName=${Data_folder_csv:11:-1} ; fi");
    _builder_11.newLine();
    _builder_11.append("\t");
    _builder_11.append("# remove \"/\" for naming");
    _builder_11.newLine();
    _builder_11.append("\t");
    _builder_11.append("dataName2=${dataName/\"/\"/_}");
    _builder_11.newLine();
    _builder_11.append("\t");
    _builder_11.append("# only data\'s name");
    _builder_11.newLine();
    _builder_11.append("\t");
    _builder_11.append("dataName=$( echo $dataName | cut -f2 -d/ )");
    _builder_11.newLine();
    _builder_11.newLine();
    _builder_11.append("\t");
    _builder_11.append("# path and name of the results\' file\t");
    _builder_11.newLine();
    _builder_11.append("\t");
    _builder_11.append("target=$Data_folder_csv\"result_\"$dataName2");
    _builder_11.newLine();
    _builder_11.newLine();
    _builder_11.append("\t");
    _builder_11.append("# creation of the results file as target");
    _builder_11.newLine();
    _builder_11.append("\t");
    _builder_11.append("printf \"////////////////////////////// \" > $target");
    _builder_11.newLine();
    _builder_11.append("\t");
    _builder_11.append("date >> $target");
    _builder_11.newLine();
    _builder_11.append("\t");
    _builder_11.append("uname -a >> $target");
    _builder_11.newLine();
    _builder_11.append("\t");
    _builder_11.append("echo \"\" >> $target");
    _builder_11.newLine();
    _builder_11.append("\t");
    _builder_11.append("echo \"## ");
    String _name_12 = content.getName();
    _builder_11.append(_name_12, "\t");
    _builder_11.append(" ## $dataName\" >> $target");
    _builder_11.newLineIfNotEmpty();
    _builder_11.append("\t");
    _builder_11.append("echo \"\" >> $target");
    _builder_11.newLine();
    _builder_11.append("\t");
    _builder_11.append("echo \"########## $dataName\"");
    _builder_11.newLine();
    _builder_11.append("\t");
    _builder_11.newLine();
    _builder_11.append("\t");
    _builder_11.append("# path for main call / path for local call");
    _builder_11.newLine();
    _builder_11.append("\t");
    _builder_11.append("# path2 = where are the generated files for the selected languages");
    _builder_11.newLine();
    _builder_11.append("\t");
    _builder_11.append("if [ \"$1\" = \"main\" ] ; then path2=\"./src-gen/");
    String _name_13 = content.getName();
    _builder_11.append(_name_13, "\t");
    _builder_11.append("\" ; else path2=\"./\" ; fi");
    _builder_11.newLineIfNotEmpty();
    _builder_11.newLine();
    _builder_11.append("\t");
    _builder_11.append("# for each mentioned language");
    _builder_11.newLine();
    {
      EList<Language> _languages_2 = content.getLanguages();
      for(final Language l_2 : _languages_2) {
        _builder_11.append("\t");
        _builder_11.append("echo \"# START ");
        String _name_14 = l_2.getName();
        _builder_11.append(_name_14, "\t");
        _builder_11.append(" #\"");
        _builder_11.newLineIfNotEmpty();
        _builder_11.append("\t");
        _builder_11.append("echo \"# START ");
        String _name_15 = l_2.getName();
        _builder_11.append(_name_15, "\t");
        _builder_11.append(" #\" >> $target");
        _builder_11.newLineIfNotEmpty();
        _builder_11.append("\t");
        _builder_11.append("echo \"\" >> $target");
        _builder_11.newLine();
        _builder_11.append("\t");
        _builder_11.append("# command line\'s syntax by language");
        _builder_11.newLine();
        _builder_11.append("\t");
        String _switchResult = null;
        String _name_16 = l_2.getName();
        if (_name_16 != null) {
          switch (_name_16) {
            case "java":
              String _name_17 = l_2.getName();
              String _plus = ("mvn compile exec:java -Dexec.mainClass=\"myjava\" -Dexec.args=\"${Data_folder_csv}\" -f \"${path2}/" + _name_17);
              String _plus_1 = (_plus + "\"");
              String _plus_2 = (_plus_1 + " | tee >(grep -v \"^.INFO] \" >> $target) ");
              _switchResult = (_plus_2 + "| grep \"^.INFO] \"");
              break;
            case "commons":
              String _name_18 = l_2.getName();
              String _plus_3 = ("mvn compile exec:java -Dexec.mainClass=\"mycommons\" -Dexec.args=\"${Data_folder_csv}\" -f \"${path2}/" + _name_18);
              String _plus_4 = (_plus_3 + "\"");
              String _plus_5 = (_plus_4 + " | tee >(grep -v \"^.INFO] \" >> $target) ");
              _switchResult = (_plus_5 + "| grep \"^.INFO] \"");
              break;
            default:
              String _bash_command = this.bash_command(l_2.getName());
              String _plus_6 = (_bash_command + "\"${path2}\"/");
              String _name_19 = l_2.getName();
              String _plus_7 = (_plus_6 + _name_19);
              String _plus_8 = (_plus_7 + "/");
              String _target = l_2.getTarget();
              String _plus_9 = (_plus_8 + _target);
              String _plus_10 = (_plus_9 + ".");
              String _file_extension = this.file_extension(l_2.getName());
              String _plus_11 = (_plus_10 + _file_extension);
              _switchResult = (_plus_11 + " $Data_folder_csv >> $target");
              break;
          }
        } else {
          String _bash_command = this.bash_command(l_2.getName());
          String _plus_6 = (_bash_command + "\"${path2}\"/");
          String _name_19 = l_2.getName();
          String _plus_7 = (_plus_6 + _name_19);
          String _plus_8 = (_plus_7 + "/");
          String _target = l_2.getTarget();
          String _plus_9 = (_plus_8 + _target);
          String _plus_10 = (_plus_9 + ".");
          String _file_extension = this.file_extension(l_2.getName());
          String _plus_11 = (_plus_10 + _file_extension);
          _switchResult = (_plus_11 + " $Data_folder_csv >> $target");
        }
        _builder_11.append(_switchResult, "\t");
        _builder_11.newLineIfNotEmpty();
        _builder_11.append("\t");
        _builder_11.append("echo \"\" >> $target");
        _builder_11.newLine();
        _builder_11.append("\t");
        _builder_11.append("echo \"# END ");
        String _name_20 = l_2.getName();
        _builder_11.append(_name_20, "\t");
        _builder_11.append(" #\" >> $target");
        _builder_11.newLineIfNotEmpty();
        _builder_11.append("\t");
        _builder_11.append("echo \"# END ");
        String _name_21 = l_2.getName();
        _builder_11.append(_name_21, "\t");
        _builder_11.append(" #\"");
        _builder_11.newLineIfNotEmpty();
        _builder_11.append("\t");
        _builder_11.append("echo \"\"");
        _builder_11.newLine();
        _builder_11.append("\t");
        _builder_11.append("echo \"----------------------------------------\" >> $target");
        _builder_11.newLine();
        _builder_11.append("\t");
        _builder_11.newLine();
      }
    }
    _builder_11.newLine();
    _builder_11.append("done");
    _builder_11.newLine();
    fsa.generateFile(_builder_10.toString(), _builder_11);
  }
  
  private String bash_command(final String language) {
    String _xblockexpression = null;
    {
      final String command = language;
      String _switchResult = null;
      if (command != null) {
        switch (command) {
          case "bash":
            _switchResult = "";
            break;
          case "bash_awk":
            _switchResult = "";
            break;
          case "R":
            _switchResult = "Rscript ";
            break;
          case "R_fwrite":
            _switchResult = "Rscript ";
            break;
          case "python3":
            _switchResult = "python3 ";
            break;
          default:
            _switchResult = "#";
            break;
        }
      } else {
        _switchResult = "#";
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  private String file_extension(final String language) {
    String _xblockexpression = null;
    {
      final String dot_extension = language;
      String _switchResult = null;
      if (dot_extension != null) {
        switch (dot_extension) {
          case "bash":
            _switchResult = "sh";
            break;
          case "bash_awk":
            _switchResult = "sh";
            break;
          case "R":
            _switchResult = "R";
            break;
          case "R_fwrite":
            _switchResult = "R";
            break;
          case "python3":
            _switchResult = "py";
            break;
          default:
            _switchResult = "#";
            break;
        }
      } else {
        _switchResult = "#";
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
}
