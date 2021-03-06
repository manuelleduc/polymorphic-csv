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
    _builder_6.append("/GRID.txt");
    StringConcatenation _builder_7 = new StringConcatenation();
    fsa.generateFile(_builder_6.toString(), _builder_7);
    StringConcatenation _builder_8 = new StringConcatenation();
    _builder_8.append("../data/");
    String _name_8 = content.getName();
    _builder_8.append(_name_8);
    _builder_8.append("/GRID.html");
    StringConcatenation _builder_9 = new StringConcatenation();
    fsa.generateFile(_builder_8.toString(), _builder_9);
    StringConcatenation _builder_10 = new StringConcatenation();
    _builder_10.append("../data/");
    String _name_9 = content.getName();
    _builder_10.append(_name_9);
    _builder_10.append("/GRID.csv");
    StringConcatenation _builder_11 = new StringConcatenation();
    fsa.generateFile(_builder_10.toString(), _builder_11);
    StringConcatenation _builder_12 = new StringConcatenation();
    _builder_12.append("../exec_main.sh");
    StringConcatenation _builder_13 = new StringConcatenation();
    _builder_13.append("#!/bin/bash");
    _builder_13.newLine();
    _builder_13.newLine();
    _builder_13.append("# main exec.sh");
    _builder_13.newLine();
    _builder_13.append("# syntax : bash exec_main.sh");
    _builder_13.newLine();
    _builder_13.newLine();
    _builder_13.append("echo \"--------------------\"");
    _builder_13.newLine();
    _builder_13.append("echo \"### EXEC_MAIN.SH ###\"");
    _builder_13.newLine();
    _builder_13.append("echo \"--------------------\"");
    _builder_13.newLine();
    _builder_13.newLine();
    _builder_13.append("# for each .pcsv present");
    _builder_13.newLine();
    _builder_13.append("for file in *.pcsv");
    _builder_13.newLine();
    _builder_13.append("do");
    _builder_13.newLine();
    _builder_13.append("    ");
    _builder_13.append("echo \"\"");
    _builder_13.newLine();
    _builder_13.append("\t");
    _builder_13.append("# remove .pcsv to the file == name of the current .pcsv");
    _builder_13.newLine();
    _builder_13.append("    ");
    _builder_13.append("name=${file:0:-5}");
    _builder_13.newLine();
    _builder_13.newLine();
    _builder_13.append("    ");
    _builder_13.append("echo \"####### Launch of $name #######\"");
    _builder_13.newLine();
    _builder_13.append("    ");
    _builder_13.append("echo \"\"");
    _builder_13.newLine();
    _builder_13.append("\t");
    _builder_13.newLine();
    _builder_13.append("\t");
    _builder_13.append("# launch local exec.sh as main");
    _builder_13.newLine();
    _builder_13.append("    ");
    _builder_13.append("./src-gen/$name/exec.sh main");
    _builder_13.newLine();
    _builder_13.newLine();
    _builder_13.append("    ");
    _builder_13.append("echo \"####### End of $name #######\"");
    _builder_13.newLine();
    _builder_13.append("    ");
    _builder_13.append("echo \"--------------------\"");
    _builder_13.newLine();
    _builder_13.append("done");
    _builder_13.newLine();
    _builder_13.newLine();
    _builder_13.append("echo \"\"");
    _builder_13.newLine();
    _builder_13.append("echo \"### END OF EXEC_MAIN.SH ###\"");
    _builder_13.newLine();
    _builder_13.append("echo \"--------------------\"");
    _builder_13.newLine();
    fsa.generateFile(_builder_12.toString(), _builder_13);
    StringConcatenation _builder_14 = new StringConcatenation();
    String _name_10 = content.getName();
    _builder_14.append(_name_10);
    _builder_14.append("/exec.sh");
    StringConcatenation _builder_15 = new StringConcatenation();
    _builder_15.append("#!/bin/bash");
    _builder_15.newLine();
    _builder_15.newLine();
    _builder_15.append("# local exec.sh ");
    String _name_11 = content.getName();
    _builder_15.append(_name_11);
    _builder_15.newLineIfNotEmpty();
    _builder_15.append("# syntax : bash exec.sh");
    _builder_15.newLine();
    _builder_15.newLine();
    _builder_15.append("# path of \"code_X\" for main call / local call");
    _builder_15.newLine();
    _builder_15.append("# path1 = where are data of the .pcsv");
    _builder_15.newLine();
    _builder_15.append("if [ \"$1\" = \"main\" ] ; then path1=\"./data/");
    String _name_12 = content.getName();
    _builder_15.append(_name_12);
    _builder_15.append("/\" ; else path1=\"../../data/");
    String _name_13 = content.getName();
    _builder_15.append(_name_13);
    _builder_15.append("/\" ; fi");
    _builder_15.newLineIfNotEmpty();
    _builder_15.newLine();
    _builder_15.append("# for each data folder in directory_pcsv");
    _builder_15.newLine();
    _builder_15.append("for Data_folder_csv in $path1*/");
    _builder_15.newLine();
    _builder_15.append("do");
    _builder_15.newLine();
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("# data\'s name for main call / local call = code\'s name + data\'s name");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("if [ \"$1\" = \"main\" ] ; then dataName=${Data_folder_csv:7:-1} ; else dataName=${Data_folder_csv:11:-1} ; fi");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("# remove \"/\" for naming");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("dataName2=${dataName/\"/\"/_}");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("# only data\'s name");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("dataName=$( echo $dataName | cut -f2 -d/ )");
    _builder_15.newLine();
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("# path and name of the results\' file\t");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("target=$Data_folder_csv\"result_\"$dataName2");
    _builder_15.newLine();
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("# creation of the results file as target");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("printf \"////////////////////////////// \" > $target");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("date >> $target");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("uname -a >> $target");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("echo \"\" >> $target");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("echo \"## ");
    String _name_14 = content.getName();
    _builder_15.append(_name_14, "\t");
    _builder_15.append(" ## $dataName\" >> $target");
    _builder_15.newLineIfNotEmpty();
    _builder_15.append("\t");
    _builder_15.append("echo \"\" >> $target");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("echo \"########## $dataName\"");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("# path for main call / path for local call");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("# path2 = where are the generated files for the selected languages");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("if [ \"$1\" = \"main\" ] ; then path2=\"./src-gen/");
    String _name_15 = content.getName();
    _builder_15.append(_name_15, "\t");
    _builder_15.append("\" ; else path2=\"./\" ; fi");
    _builder_15.newLineIfNotEmpty();
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("# for each mentioned language");
    _builder_15.newLine();
    {
      EList<Language> _languages_2 = content.getLanguages();
      for(final Language l_2 : _languages_2) {
        _builder_15.append("\t");
        _builder_15.append("echo \"# START ");
        String _name_16 = l_2.getName();
        _builder_15.append(_name_16, "\t");
        _builder_15.append(" #\"");
        _builder_15.newLineIfNotEmpty();
        _builder_15.append("\t");
        _builder_15.append("echo \"# START ");
        String _name_17 = l_2.getName();
        _builder_15.append(_name_17, "\t");
        _builder_15.append(" #\" >> $target");
        _builder_15.newLineIfNotEmpty();
        _builder_15.append("\t");
        _builder_15.append("echo \"\" >> $target");
        _builder_15.newLine();
        _builder_15.append("\t");
        _builder_15.append("# command line\'s syntax by language");
        _builder_15.newLine();
        _builder_15.append("\t");
        String _switchResult = null;
        String _name_18 = l_2.getName();
        if (_name_18 != null) {
          switch (_name_18) {
            case "java":
              String _name_19 = l_2.getName();
              String _plus = ("mvn compile exec:java -Dexec.mainClass=\"myjava\" -Dexec.args=\"${Data_folder_csv}\" -f \"${path2}/" + _name_19);
              String _plus_1 = (_plus + "\"");
              String _plus_2 = (_plus_1 + " | tee >(grep -v \"^.INFO] \" >> $target) ");
              _switchResult = (_plus_2 + "| grep \"^.INFO] \"");
              break;
            case "java_commons":
              String _name_20 = l_2.getName();
              String _plus_3 = ("mvn compile exec:java -Dexec.mainClass=\"myjava_commons\" -Dexec.args=\"${Data_folder_csv}\" -f \"${path2}/" + _name_20);
              String _plus_4 = (_plus_3 + "\"");
              String _plus_5 = (_plus_4 + " | tee >(grep -v \"^.INFO] \" >> $target) ");
              _switchResult = (_plus_5 + "| grep \"^.INFO] \"");
              break;
            default:
              String _bash_command = this.bash_command(l_2.getName());
              String _plus_6 = (_bash_command + "\"${path2}\"/");
              String _name_21 = l_2.getName();
              String _plus_7 = (_plus_6 + _name_21);
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
          String _name_21 = l_2.getName();
          String _plus_7 = (_plus_6 + _name_21);
          String _plus_8 = (_plus_7 + "/");
          String _target = l_2.getTarget();
          String _plus_9 = (_plus_8 + _target);
          String _plus_10 = (_plus_9 + ".");
          String _file_extension = this.file_extension(l_2.getName());
          String _plus_11 = (_plus_10 + _file_extension);
          _switchResult = (_plus_11 + " $Data_folder_csv >> $target");
        }
        _builder_15.append(_switchResult, "\t");
        _builder_15.newLineIfNotEmpty();
        _builder_15.append("\t");
        _builder_15.append("echo \"\" >> $target");
        _builder_15.newLine();
        _builder_15.append("\t");
        _builder_15.append("echo \"# END ");
        String _name_22 = l_2.getName();
        _builder_15.append(_name_22, "\t");
        _builder_15.append(" #\" >> $target");
        _builder_15.newLineIfNotEmpty();
        _builder_15.append("\t");
        _builder_15.append("echo \"# END ");
        String _name_23 = l_2.getName();
        _builder_15.append(_name_23, "\t");
        _builder_15.append(" #\"");
        _builder_15.newLineIfNotEmpty();
        _builder_15.append("\t");
        _builder_15.append("echo \"\"");
        _builder_15.newLine();
        _builder_15.append("\t");
        _builder_15.append("echo \"----------------------------------------\" >> $target");
        _builder_15.newLine();
        _builder_15.append("\t");
        _builder_15.newLine();
      }
    }
    _builder_15.newLine();
    _builder_15.append("done");
    _builder_15.newLine();
    _builder_15.newLine();
    _builder_15.append("# START PARSING results to fill GRID.txt");
    _builder_15.newLine();
    _builder_15.append("# for each data folder in directory_pcsv");
    _builder_15.newLine();
    _builder_15.append("for Data_folder_csv in $path1*/");
    _builder_15.newLine();
    _builder_15.append("do");
    _builder_15.newLine();
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("awk -v path=$path1 \'");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("BEGIN { ");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("second_line = \"false\"");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("}");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("{");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("# name of the .pcsv");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("if ($0 ~ \"^## \") { code_name = $2 }");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("# name of the data");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("if ($0 ~ \"^## \") { data_name = $4 }");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("# languages generated");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("if ($0 ~ \"^# START \") { languages[n++] = $3 ; target_result = NR+2 ; target_result2 = NR+3 }");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("# results collect");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("if (NR == target_result) { results[m++] = \"null\" ; results[m-1] = $1 ; results2[m-1] = \"null\" }");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("if (NR == target_result2 && $0 != \"\") { results2[m-1] = $1 ; second_line = \"true\" }");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("}");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("END {");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("# header already present");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("if ( system(\"test -s \" path \"GRID.txt\") ) {");
    _builder_15.newLine();
    _builder_15.append("\t\t");
    _builder_15.append("l1 = sprintf(\"%-20s\",code_name)");
    _builder_15.newLine();
    _builder_15.append("\t\t");
    _builder_15.append("i = 0");
    _builder_15.newLine();
    _builder_15.append("\t\t");
    _builder_15.append("while ( languages[i] ) { l1 = l1 sprintf(\"|%-15s\",languages[i]); i++ }");
    _builder_15.newLine();
    _builder_15.append("\t\t");
    _builder_15.append("var = 20+(16*i)");
    _builder_15.newLine();
    _builder_15.append("\t\t");
    _builder_15.append("for(c=0;c<var;c++) {printf \"|\"} ; print \"\"");
    _builder_15.newLine();
    _builder_15.append("\t\t");
    _builder_15.append("print l1");
    _builder_15.newLine();
    _builder_15.append("\t\t");
    _builder_15.append("for(c=0;c<var;c++) {printf \"|\"} ; print \"\"");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("}");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("# results line");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("l2 = sprintf(\"%-20s\",data_name)");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("i = 0");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("while ( results[i] ) { l2 = l2 sprintf(\"|%-15s\",results[i] ); i++ }");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("print l2");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("# if second line");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("if ( second_line == \"true\") {");
    _builder_15.newLine();
    _builder_15.append("\t\t");
    _builder_15.append("l3 = sprintf(\"%-20s\",data_name\"_copy\")");
    _builder_15.newLine();
    _builder_15.append("\t\t");
    _builder_15.append("i = 0");
    _builder_15.newLine();
    _builder_15.append("\t\t");
    _builder_15.append("while ( results2[i] ) { l3 = l3 sprintf(\"|%-15s\",results2[i] ); i++ }");
    _builder_15.newLine();
    _builder_15.append("\t\t");
    _builder_15.append("print l3");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("}");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("} # END END");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("\' $Data_folder_csv\"result_\"* >> $path1\"GRID.txt\"");
    _builder_15.newLine();
    _builder_15.newLine();
    _builder_15.append("done");
    _builder_15.newLine();
    _builder_15.append("# END PARSING");
    _builder_15.newLine();
    _builder_15.newLine();
    _builder_15.append("# START PARSING GRID.txt to fill GRID.html");
    _builder_15.newLine();
    _builder_15.append("awk -v path=$path1 \'");
    _builder_15.newLine();
    _builder_15.append("BEGIN {");
    _builder_15.newLine();
    _builder_15.append("print \"<!DOCTYPE html>\"");
    _builder_15.newLine();
    _builder_15.append("print \"<html>\"");
    _builder_15.newLine();
    _builder_15.append("print \"<head>\"");
    _builder_15.newLine();
    _builder_15.append("print \"<title>GRID.html</title>\"");
    _builder_15.newLine();
    _builder_15.append("print \"<meta charset=\"utf-8\" />\"");
    _builder_15.newLine();
    _builder_15.append("print \"</head>\"");
    _builder_15.newLine();
    _builder_15.append("print \"<body style=\\\"font-family:Courier New,Bitstream Vera Sans Mono;white-space:pre\\\">\"");
    _builder_15.newLine();
    _builder_15.newLine();
    _builder_15.append("}");
    _builder_15.newLine();
    _builder_15.append("{");
    _builder_15.newLine();
    _builder_15.append("print $0");
    _builder_15.newLine();
    _builder_15.append("}");
    _builder_15.newLine();
    _builder_15.append("END {");
    _builder_15.newLine();
    _builder_15.append("print \"</body>\"");
    _builder_15.newLine();
    _builder_15.append("print \"</html>\"");
    _builder_15.newLine();
    _builder_15.append("}");
    _builder_15.newLine();
    _builder_15.append("\' $path1\"GRID.txt\" > $path1\"GRID.html\"");
    _builder_15.newLine();
    _builder_15.append("# END PARSING");
    _builder_15.newLine();
    _builder_15.newLine();
    _builder_15.append("# START PARSING results to fill GRID.csv");
    _builder_15.newLine();
    _builder_15.append("# for each data folder in directory_pcsv");
    _builder_15.newLine();
    _builder_15.append("for Data_folder_csv in $path1*/");
    _builder_15.newLine();
    _builder_15.append("do");
    _builder_15.newLine();
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("awk -v path=$path1 \'");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("BEGIN { }");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("{");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("# name of the .pcsv");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("if ($0 ~ \"^## \") { code_name = $2 }");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("# name of the data");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("if ($0 ~ \"^## \") { data_name = $4 }");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("# languages generated");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("if ($0 ~ \"^# START \") { languages[n++] = $3 ; target_result = NR+2 ; target_result2 = NR+3 }");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("# results collect");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("if (NR == target_result) { results[m++] = $1 }");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("if (NR == target_result2 && $0 != \"\") { results2[m-1] = $1 }");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("}");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("END {");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("# header already present");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("if ( system(\"test -s \" path \"GRID.csv\") ) {");
    _builder_15.newLine();
    _builder_15.append("\t\t");
    _builder_15.append("l1 = code_name");
    _builder_15.newLine();
    _builder_15.append("\t\t");
    _builder_15.append("i = 0");
    _builder_15.newLine();
    _builder_15.append("\t\t");
    _builder_15.append("while ( languages[i] ) { l1 = l1\",\"languages[i]; i++ }");
    _builder_15.newLine();
    _builder_15.append("\t\t");
    _builder_15.append("print l1");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("}");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("l2 = data_name");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("i = 0");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("while ( results[i] ) { l2 = l2\",\"results[i]; i++ }");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("print l2");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("# if second line");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("if ( results2[0] ) {");
    _builder_15.newLine();
    _builder_15.append("\t\t");
    _builder_15.append("l3 = data_name\"_copy\"");
    _builder_15.newLine();
    _builder_15.append("\t\t");
    _builder_15.append("i = 0");
    _builder_15.newLine();
    _builder_15.append("\t\t");
    _builder_15.append("while ( results2[i] ) { l3 = l3\",\"results2[i]; i++ }");
    _builder_15.newLine();
    _builder_15.append("\t\t");
    _builder_15.append("print l3");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("}");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("} # END END");
    _builder_15.newLine();
    _builder_15.append("\t");
    _builder_15.append("\' $Data_folder_csv\"result_\"* >> $path1\"GRID.csv\"");
    _builder_15.newLine();
    _builder_15.newLine();
    _builder_15.append("done");
    _builder_15.newLine();
    _builder_15.append("# END PARSING");
    _builder_15.newLine();
    fsa.generateFile(_builder_14.toString(), _builder_15);
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
          case "python3_csv":
            _switchResult = "python3 ";
            break;
          case "python3_pandas":
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
          case "python3_csv":
            _switchResult = "py";
            break;
          case "python3_pandas":
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
