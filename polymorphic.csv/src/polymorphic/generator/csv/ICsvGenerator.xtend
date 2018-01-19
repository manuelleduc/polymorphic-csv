package polymorphic.generator.csv

import java.util.Map
import org.eclipse.xtext.generator.IFileSystemAccess2
import polymorphic.csv.Language
import polymorphic.csv.Model

interface ICsvGenerator {
	def void generate(Model content, Language language, IFileSystemAccess2 fsa)
	def Map<String, Boolean> properties();
}