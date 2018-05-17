package polymorphic.generator.csv

import org.eclipse.xtext.generator.IFileSystemAccess2
import polymorphic.csv.Language
import polymorphic.csv.Model
import polymorphic.csv.NbRow
import polymorphic.csv.OpenCSV
import polymorphic.csv.PrintCSV
import polymorphic.csv.SaveCSV
import polymorphic.csv.NbCol

class Java_commonsCsvGenerator implements ICsvGenerator {

	private static final class Context {
		var cptr = 0

		def nextCptr() {
			val ret = cptr
			cptr = cptr + 1
			ret
		}
	}

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
						<groupId>org.apache.commons</groupId>
						<artifactId>commons-csv</artifactId>
						<version>1.5</version>
					</dependency>
				</dependencies>
			</project>
		''')

		val ctx = new Context
		fsa.generateFile('''«content.name»/«language.name»/src/main/java/«language.target.replaceAll("\\.", "/")».java''', '''
			«IF package.length > 0»package «package»;«ENDIF»
			
			import java.io.*;
			import java.util.*;
			import org.apache.commons.csv.*;
			import java.util.stream.StreamSupport;
			import java.util.stream.Collectors;
			
			public class «className» {
			 	public static void main(String[] args) throws  FileNotFoundException, IOException {
				«FOR action : content.actions»
					«action.javaAction(className, ctx)»
				«ENDFOR»
				}
			}
		''')
	}

	private def dispatch CharSequence javaAction(OpenCSV open, CharSequence className, Context ctx) {
		'''
		final List<CSVRecord> «open.name» = StreamSupport.stream(CSVFormat.RFC4180.parse(new FileReader(args[0]+"«open.file»")).spliterator(), false).collect(Collectors.toList());
		'''
	}

	private def dispatch CharSequence javaAction(PrintCSV print, CharSequence className, Context ctx) {
		val varX = ctx.nextCptr
		'''
		«val sb = '''sb«varX»'''»
		«val tmp = '''tmp«varX»'''»
		final StringBuilder «sb» = new StringBuilder();
		try (CSVPrinter «tmp» = new CSVPrinter(«sb», CSVFormat.RFC4180)) {
			«tmp».printRecords(«print.open.name»);
		}
		System.out.println(«sb»);
		'''
	}

	private def dispatch CharSequence javaAction(NbRow nbRow, CharSequence className, Context ctx)
		'''
		System.out.println(«nbRow.open.name».size()-1);
		'''
		
	private def dispatch CharSequence javaAction(NbCol nbCol, CharSequence className, Context ctx)
		'''
		System.out.println(«nbCol.open.name».get(0).size());
		'''

	private def dispatch CharSequence javaAction(SaveCSV save, CharSequence className, Context ctx) {
		val file = if(save.file !== null) save.file else save.open.file
		val varX = ctx.nextCptr
		'''
		try (CSVPrinter tmp«varX» = new CSVPrinter(new FileWriter(new File(args[0]+"«file»")), CSVFormat.RFC4180)) {
			tmp«varX».printRecords(«save.open.name»);
		}
		'''
	}

	override def properties() {
		newHashMap("java" -> true, "maven" -> true)
	}

}
