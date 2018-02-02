package polymorphic.fsm.generator.fsm

import polymorphic.fsm.fsm.Model
import polymorphic.fsm.fsm.Language
import org.eclipse.xtext.generator.IFileSystemAccess2

class JavaFsmGenerator implements IFsmGenerator {

	override generate(Model content, Language language, IFileSystemAccess2 fsa) {

		val className = language.target.split("\\.").reverse.head
		val package = language.target.split("\\.").reverse.tail.toList.reverse.join(".")

		fsa.generateFile('''«content.name»/«language.name»/Dockerfile''', '''
			FROM maven
			COPY . /project
			COPY ./inputs /inputs
			WORKDIR project
			RUN mvn compile
			ENTRYPOINT  mvn -q exec:java -Dexec.mainClass="«package».«className»"
		''')
		
		fsa.generateFile('''«content.name»/«language.name»/pom.xml''', '''
			<project>
			    <modelVersion>4.0.0</modelVersion>
			    <groupId>«content.name»</groupId>
			    <artifactId>«language.target»</artifactId>
			    <version>1</version>
			    
			    <properties>
					<maven.compiler.source>1.8</maven.compiler.source>
					<maven.compiler.target>1.8</maven.compiler.target>
					<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
				</properties>
			</project>
		''')
		
		
		val initialState = content.machine.states.filter[it.initial].head
		val finalStates = content.machine.states.filter[it.isFinal]
		
		fsa.
			generateFile('''«content.name»/«language.name»/src/main/java/«language.target.replaceAll("\\.", "/")».java''', '''
				package «package»;
				
				public class «className» {
				
				    public void run(String[] args) {
				    	String currentState = "«initialState.name»";
				    	for(String arg: args) {
				    		«FOR transition: content.machine.transitions BEFORE 'if ' SEPARATOR ' else if '»«
								»(currentState.equals("«transition.from.name»") && arg.equals("«transition.event»")) {
				    			currentState = "«transition.to.name»";
				    		}«
				    		»«ENDFOR»
				    		else {
					    		System.out.println("Unexpected transition " + arg);
					    		currentState = null;
					    		break;
				    		}
						}
						
						if(currentState == null) {
							System.out.println("ERROR");
						} else {
							if(«FOR fs: finalStates SEPARATOR ' || '»"«fs.name»".equals(currentState)«ENDFOR») {
								System.out.println("SUCCESS");
							} else {
								System.out.println("ERROR: final state not reached");
							}
						}
					}
				
					public static void main(String [] args) {
						new «className»().run(args);
					}
				}
			''')
	}
	
	override properties() {
		newHashMap("java" -> true)
	}

}
