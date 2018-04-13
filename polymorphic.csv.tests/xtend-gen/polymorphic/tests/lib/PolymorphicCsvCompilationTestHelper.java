package polymorphic.tests.lib;

import com.google.common.base.Objects;
import java.io.IOException;
import java.util.Map;
import java.util.function.BiConsumer;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper;
import org.junit.Assert;

@SuppressWarnings("all")
public class PolymorphicCsvCompilationTestHelper extends CompilationTestHelper {
  public void assertFileCompilesTo(final CharSequence source, final Map<String, CharSequence> expected) throws IOException {
    final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result r) -> {
      final BiConsumer<String, CharSequence> _function_1 = (String fileName, CharSequence content) -> {
        final Function2<String, CharSequence, Boolean> _function_2 = (String p1, CharSequence p2) -> {
          return Boolean.valueOf(Objects.equal(p1, fileName));
        };
        final Map<String, CharSequence> generatedFile = MapExtensions.<String, CharSequence>filter(r.getAllGeneratedResources(), _function_2);
        boolean _isEmpty = generatedFile.isEmpty();
        if (_isEmpty) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Excepted file ");
          _builder.append(fileName);
          _builder.append(" not found in generated sources");
          Assert.fail(_builder.toString());
        } else {
          final BiConsumer<String, CharSequence> _function_3 = (String p1, CharSequence p2) -> {
            Assert.assertEquals(content.toString().trim(), p2.toString().trim());
          };
          generatedFile.forEach(_function_3);
        }
      };
      expected.forEach(_function_1);
    };
    this.compile(source, _function);
  }
}
