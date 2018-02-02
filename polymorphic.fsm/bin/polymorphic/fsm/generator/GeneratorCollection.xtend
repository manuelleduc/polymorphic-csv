package polymorphic.fsm.generator

import polymorphic.fsm.generator.fsm.JavaFsmGenerator
import polymorphic.fsm.generator.fsm.JavaSquirrelFsmGenerator
import polymorphic.fsm.generator.fsm.PythonFsmGenerator

class GeneratorCollection {
	def getMap() {
		newHashMap("java" -> new JavaFsmGenerator, "python" -> new PythonFsmGenerator,
			"squireljava" -> new JavaSquirrelFsmGenerator)
	}
}
