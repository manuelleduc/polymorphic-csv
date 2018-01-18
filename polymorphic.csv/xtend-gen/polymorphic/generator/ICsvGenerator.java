package polymorphic.generator;

import org.eclipse.xtext.generator.IFileSystemAccess2;
import polymorphic.csv.Model;

@SuppressWarnings("all")
public interface ICsvGenerator {
  public abstract void generate(final Model content, final IFileSystemAccess2 fsa);
}
