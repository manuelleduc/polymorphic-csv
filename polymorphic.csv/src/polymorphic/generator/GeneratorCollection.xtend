package polymorphic.generator

import java.util.Map
import polymorphic.generator.csv.ApacheCommonCsvGenerator
import polymorphic.generator.csv.ICsvGenerator
import polymorphic.generator.csv.JavaCsvGenerator

/**
 * TODO: should be replaced by a propre dependency injection mechanism.
 */
class GeneratorCollection {
	private Map<String, ICsvGenerator> map = newHashMap
	
	def getMap() {
		map.put("java", new JavaCsvGenerator());
		map.put("commons", new ApacheCommonCsvGenerator());
		map
	}
}