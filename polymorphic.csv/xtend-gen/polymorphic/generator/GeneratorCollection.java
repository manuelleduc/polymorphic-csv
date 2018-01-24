package polymorphic.generator;

import java.util.Map;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import polymorphic.generator.csv.ApacheCommonCsvGenerator;
import polymorphic.generator.csv.ICsvGenerator;
import polymorphic.generator.csv.JavaCsvGenerator;
import polymorphic.generator.csv.PythonGenerator;

/**
 * TODO: should be replaced by a propre dependency injection mechanism.
 */
@SuppressWarnings("all")
public class GeneratorCollection {
  private Map<String, ICsvGenerator> map = CollectionLiterals.<String, ICsvGenerator>newHashMap();
  
  public Map<String, ICsvGenerator> getMap() {
    Map<String, ICsvGenerator> _xblockexpression = null;
    {
      JavaCsvGenerator _javaCsvGenerator = new JavaCsvGenerator();
      this.map.put("java", _javaCsvGenerator);
      ApacheCommonCsvGenerator _apacheCommonCsvGenerator = new ApacheCommonCsvGenerator();
      this.map.put("commons", _apacheCommonCsvGenerator);
      PythonGenerator _pythonGenerator = new PythonGenerator();
      this.map.put("python", _pythonGenerator);
      _xblockexpression = this.map;
    }
    return _xblockexpression;
  }
}
