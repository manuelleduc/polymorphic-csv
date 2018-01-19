package polymorphic.generator.csv

import org.eclipse.xtext.generator.IFileSystemAccess2
import polymorphic.csv.Model

interface ICsvGenerator {
	def void generate(Model content, IFileSystemAccess2 fsa)
}