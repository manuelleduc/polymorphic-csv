package polymorphic.fsm.generator;

import java.util.HashMap;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;
import polymorphic.fsm.generator.fsm.IFsmGenerator;
import polymorphic.fsm.generator.fsm.JavaFsmGenerator;
import polymorphic.fsm.generator.fsm.JavaSquirrelFsmGenerator;
import polymorphic.fsm.generator.fsm.PythonFsmGenerator;

@SuppressWarnings("all")
public class GeneratorCollection {
  public HashMap<String, IFsmGenerator> getMap() {
    JavaFsmGenerator _javaFsmGenerator = new JavaFsmGenerator();
    Pair<String, JavaFsmGenerator> _mappedTo = Pair.<String, JavaFsmGenerator>of("java", _javaFsmGenerator);
    PythonFsmGenerator _pythonFsmGenerator = new PythonFsmGenerator();
    Pair<String, PythonFsmGenerator> _mappedTo_1 = Pair.<String, PythonFsmGenerator>of("python", _pythonFsmGenerator);
    JavaSquirrelFsmGenerator _javaSquirrelFsmGenerator = new JavaSquirrelFsmGenerator();
    Pair<String, JavaSquirrelFsmGenerator> _mappedTo_2 = Pair.<String, JavaSquirrelFsmGenerator>of("squireljava", _javaSquirrelFsmGenerator);
    return CollectionLiterals.<String, IFsmGenerator>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2);
  }
}
