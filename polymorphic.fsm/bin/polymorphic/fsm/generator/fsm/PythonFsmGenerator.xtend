package polymorphic.fsm.generator.fsm

import polymorphic.fsm.fsm.Model
import polymorphic.fsm.fsm.Language
import org.eclipse.xtext.generator.IFileSystemAccess2

class PythonFsmGenerator implements IFsmGenerator {
	
	override generate(Model content, Language language, IFileSystemAccess2 fsa) {

		val className = language.target.split("\\.").reverse.head
		
		val initialState = content.machine.states.filter[it.initial].head
		val finalStates = content.machine.states.filter[it.isFinal]
		
		fsa.
			generateFile('''«content.name»/«language.name»/src/main/java/«language.target.replaceAll("\\.", "/")».py''', '''
				import sys
				
				class «className»:
				  def run(self, args):
				    currentState = "«initialState.name»"
				    for arg in args:
				      «FOR transition: content.machine.transitions BEFORE 'if ' SEPARATOR '\nelif '»«
				      »currentState == "«transition.from.name»" and arg == "«transition.event»":
				        currentState = "«transition.to.name»"«ENDFOR»
				      else:
				        print("Unexpected transition " + arg)
				        currentState = None
				        break
						
				    if currentState is None:
				      print("ERROR")
				    else:
				      if «FOR fs: finalStates SEPARATOR ' or '»"«fs.name»" == currentState«ENDFOR»:
				        print("SUCCESS")
				      else:
				        print("ERROR: final state not reached")
				
				if __name__ == '__main__':
				  «className»().run(sys.argv[1:])
			''')
	}
	
	override properties() {
		newHashMap("java" -> true)
	}
	
}