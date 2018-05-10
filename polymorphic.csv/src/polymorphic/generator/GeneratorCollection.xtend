package polymorphic.generator

import java.util.Map
import polymorphic.generator.csv.BashCsvGenerator
import polymorphic.generator.csv.ICsvGenerator
import polymorphic.generator.csv.JavaCsvGenerator
import polymorphic.generator.csv.RCsvGenerator
import polymorphic.generator.csv.R_fwriteCsvGenerator
import polymorphic.generator.csv.Bash_awkCsvGenerator
import polymorphic.generator.csv.Python3CsvGenerator
import polymorphic.generator.csv.Java_commonsCsvGenerator
import polymorphic.generator.csv.Python3_pandasCsvGenerator

/**
 * TODO: should be replaced by a propre dependency injection mechanism.
 */
class GeneratorCollection {
	private Map<String, ICsvGenerator> map = newHashMap
	
	def Map<String, ICsvGenerator> getMap() {
		map.put("java", new JavaCsvGenerator)
		map.put("java_commons", new Java_commonsCsvGenerator)
		map.put("bash", new BashCsvGenerator)
		map.put("bash_awk", new Bash_awkCsvGenerator)
		map.put("R", new RCsvGenerator)
		map.put("R_fwrite", new R_fwriteCsvGenerator)
		map.put("python3", new Python3CsvGenerator)
		map.put("python3_pandas", new Python3_pandasCsvGenerator)
		return map
	}
}