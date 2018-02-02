package polymorphic.fsm.generator.fsm

import java.util.Map
import org.eclipse.xtext.generator.IFileSystemAccess2
import polymorphic.fsm.fsm.Language
import polymorphic.fsm.fsm.Model

interface IFsmGenerator {

	def void generate(Model model, Language language, IFileSystemAccess2 access2)
	
	def Map<String, Boolean> properties();

}
