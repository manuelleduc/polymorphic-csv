package polymorphic.generator.csv;

import java.util.Map;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import polymorphic.csv.Language;
import polymorphic.csv.Model;

@SuppressWarnings("all")
public interface ICsvGenerator {
  public abstract void generate(final Model content, final Language language, final IFileSystemAccess2 fsa);
  
  public abstract Map<String, Boolean> properties();
}
