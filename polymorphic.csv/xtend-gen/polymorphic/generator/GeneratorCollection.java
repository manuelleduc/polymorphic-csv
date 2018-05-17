package polymorphic.generator;

import java.util.Map;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import polymorphic.generator.csv.BashCsvGenerator;
import polymorphic.generator.csv.Bash_awkCsvGenerator;
import polymorphic.generator.csv.ICsvGenerator;
import polymorphic.generator.csv.JavaCsvGenerator;
import polymorphic.generator.csv.Java_commonsCsvGenerator;
import polymorphic.generator.csv.Python3_CsvGenerator;
import polymorphic.generator.csv.Python3_pandasCsvGenerator;
import polymorphic.generator.csv.RCsvGenerator;
import polymorphic.generator.csv.R_fwriteCsvGenerator;

/**
 * TODO: should be replaced by a propre dependency injection mechanism.
 */
@SuppressWarnings("all")
public class GeneratorCollection {
  private Map<String, ICsvGenerator> map = CollectionLiterals.<String, ICsvGenerator>newHashMap();
  
  public Map<String, ICsvGenerator> getMap() {
    JavaCsvGenerator _javaCsvGenerator = new JavaCsvGenerator();
    this.map.put("java", _javaCsvGenerator);
    Java_commonsCsvGenerator _java_commonsCsvGenerator = new Java_commonsCsvGenerator();
    this.map.put("java_commons", _java_commonsCsvGenerator);
    BashCsvGenerator _bashCsvGenerator = new BashCsvGenerator();
    this.map.put("bash", _bashCsvGenerator);
    Bash_awkCsvGenerator _bash_awkCsvGenerator = new Bash_awkCsvGenerator();
    this.map.put("bash_awk", _bash_awkCsvGenerator);
    RCsvGenerator _rCsvGenerator = new RCsvGenerator();
    this.map.put("R", _rCsvGenerator);
    R_fwriteCsvGenerator _r_fwriteCsvGenerator = new R_fwriteCsvGenerator();
    this.map.put("R_fwrite", _r_fwriteCsvGenerator);
    Python3_CsvGenerator _python3_CsvGenerator = new Python3_CsvGenerator();
    this.map.put("python3_csv", _python3_CsvGenerator);
    Python3_pandasCsvGenerator _python3_pandasCsvGenerator = new Python3_pandasCsvGenerator();
    this.map.put("python3_pandas", _python3_pandasCsvGenerator);
    return this.map;
  }
}
