package polymorphic.fsm.generator.fsm

import polymorphic.fsm.fsm.Model
import polymorphic.fsm.fsm.Language
import org.eclipse.xtext.generator.IFileSystemAccess2

class JavaSquirrelFsmGenerator implements IFsmGenerator {

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
			
			    <dependencies>
					<dependency>
					    <groupId>org.squirrelframework</groupId>
					    <artifactId>squirrel-foundation</artifactId>
					    <version>0.3.8</version>
					</dependency>
				</dependencies>
			</project>
		''')
		
		
		val initialState = content.machine.states.filter[it.initial].head
		val finalStates = content.machine.states.filter[it.isFinal]
		
		fsa.
			generateFile('''«content.name»/«language.name»/src/main/java/«language.target.replaceAll("\\.", "/")».java''', '''
				package «package»;
				
				import org.squirrelframework.foundation.fsm.*;
				import org.squirrelframework.foundation.fsm.annotation.StateMachineParameters;
				import org.squirrelframework.foundation.fsm.impl.AbstractUntypedStateMachine;
				
				public class «className» {
				
				    @StateMachineParameters(stateType=String.class, eventType=String.class, contextType = Void.class)
					private static class FSM extends AbstractUntypedStateMachine {}
				
				    public void run(String[] args) {
						UntypedStateMachineBuilder builder = StateMachineBuilderFactory.create(FSM.class);
						«FOR t: content.machine.transitions»
						builder.externalTransition().from("«t.from.name»").to("«t.to.name»").on("«t.event»");
				    	«ENDFOR»
				    	
				    	// 4. Use State Machine
						UntypedStateMachine fsm = builder.newStateMachine("«initialState.name»");
						for(String arg: args) {
							if(fsm.canAccept(arg)) {
								fsm.fire(arg);
							} else {
								System.out.println("Unexpected transition " + arg);
								break;
							}
						}
						if(fsm.getCurrentState() == null) {
							System.out.println("ERROR");
						} else {
							if(«FOR fs: finalStates SEPARATOR ' || '»"«fs.name»".equals(fsm.getCurrentState())«ENDFOR») {
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
