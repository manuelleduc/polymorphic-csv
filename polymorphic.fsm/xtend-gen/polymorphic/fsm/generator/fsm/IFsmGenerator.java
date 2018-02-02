package polymorphic.fsm.generator.fsm;

import java.util.Map;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import polymorphic.fsm.fsm.Language;
import polymorphic.fsm.fsm.Model;

@SuppressWarnings("all")
public interface IFsmGenerator {
  public abstract void generate(final Model model, final Language language, final IFileSystemAccess2 access2);
  
  public abstract Map<String, Boolean> properties();
}
