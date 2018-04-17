package polymorphic.generator

import java.util.Map
import polymorphic.generator.csv.ApacheCommonCsvGenerator
import polymorphic.generator.csv.BashCsvGenerator
import polymorphic.generator.csv.ICsvGenerator
import polymorphic.generator.csv.JavaCsvGenerator
import polymorphic.generator.csv.PythonCsvGenerator
import polymorphic.generator.csv.RCsvGenerator

/**
 * TODO: should be replaced by a propre dependency injection mechanism.
 */
class GeneratorCollection {
	private Map<String, ICsvGenerator> map = newHashMap
	
	def Map<String, ICsvGenerator> getMap() {
		map.put("java", new JavaCsvGenerator)
		map.put("commons", new ApacheCommonCsvGenerator)
		map.put("python", new PythonCsvGenerator)
		map.put("bash", new BashCsvGenerator)
		map.put("R", new RCsvGenerator)
		return map
	}
}