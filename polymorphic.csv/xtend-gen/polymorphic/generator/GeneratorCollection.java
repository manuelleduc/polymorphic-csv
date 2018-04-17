package polymorphic.generator;

import java.util.Map;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import polymorphic.generator.csv.ApacheCommonCsvGenerator;
import polymorphic.generator.csv.BashCsvGenerator;
import polymorphic.generator.csv.ICsvGenerator;
import polymorphic.generator.csv.JavaCsvGenerator;
import polymorphic.generator.csv.PythonCsvGenerator;
import polymorphic.generator.csv.RCsvGenerator;

/**
 * TODO: should be replaced by a propre dependency injection mechanism.
 */
@SuppressWarnings("all")
public class GeneratorCollection {
  private Map<String, ICsvGenerator> map = CollectionLiterals.<String, ICsvGenerator>newHashMap();
  
  public Map<String, ICsvGenerator> getMap() {
    JavaCsvGenerator _javaCsvGenerator = new JavaCsvGenerator();
    this.map.put("java", _javaCsvGenerator);
    ApacheCommonCsvGenerator _apacheCommonCsvGenerator = new ApacheCommonCsvGenerator();
    this.map.put("commons", _apacheCommonCsvGenerator);
    PythonCsvGenerator _pythonCsvGenerator = new PythonCsvGenerator();
    this.map.put("python", _pythonCsvGenerator);
    BashCsvGenerator _bashCsvGenerator = new BashCsvGenerator();
    this.map.put("bash", _bashCsvGenerator);
    RCsvGenerator _rCsvGenerator = new RCsvGenerator();
    this.map.put("R", _rCsvGenerator);
    return this.map;
  }
}
