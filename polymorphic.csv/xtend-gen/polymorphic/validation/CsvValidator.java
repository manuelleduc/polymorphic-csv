/**
 * generated by Xtext 2.13.0
 */
package polymorphic.validation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import polymorphic.csv.Constraint;
import polymorphic.csv.CsvPackage;
import polymorphic.csv.Language;
import polymorphic.csv.Model;
import polymorphic.csv.OpenCSV;
import polymorphic.generator.GeneratorCollection;
import polymorphic.validation.AbstractCsvValidator;

/**
 * This class contains custom validation rules.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@SuppressWarnings("all")
public class CsvValidator extends AbstractCsvValidator {
  public final static String DUPLICATE_OPEN_NAME = "DUPLICATE_OPEN_NAME";
  
  public final static String LANGUAGE_CONSTRAINTS_ERROR = "LANGUAGE_CONSTRAINTS_ERROR";
  
  public final static String LANGUAGE_DOES_NOT_EXIST = "LANGUAGE_DOES_NOT_EXIST";
  
  public final static GeneratorCollection generators = new GeneratorCollection();
  
  @Check
  public void matchConstraints(final Language language) {
    final Function1<Constraint, Boolean> _function = (Constraint it) -> {
      boolean _xblockexpression = false;
      {
        final Boolean prop = CsvValidator.generators.getMap().get(language.getName()).properties().get(it.getName());
        _xblockexpression = (!((prop == null) || (it.isTrue() == (prop).booleanValue())));
      }
      return Boolean.valueOf(_xblockexpression);
    };
    final Function1<Constraint, String> _function_1 = (Constraint it) -> {
      return it.getName();
    };
    final Iterable<String> names = IterableExtensions.<Constraint, String>map(IterableExtensions.<Constraint>filter(EcoreUtil2.<Model>getContainerOfType(language, Model.class).getConstraints(), _function), _function_1);
    boolean _isEmpty = IterableExtensions.isEmpty(names);
    boolean _not = (!_isEmpty);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      String _name = language.getName();
      _builder.append(_name);
      _builder.append(" does not conform to rules ");
      String _join = IterableExtensions.join(names, ", ");
      _builder.append(_join);
      this.error(_builder.toString(), 
        CsvPackage.eINSTANCE.getLanguage_Name(), CsvValidator.LANGUAGE_CONSTRAINTS_ERROR);
    }
  }
  
  @Check
  public void checkDuplicateOpen(final OpenCSV openCSV) {
    final Function1<OpenCSV, Boolean> _function = (OpenCSV it) -> {
      return Boolean.valueOf(((!Objects.equal(it, openCSV)) && Objects.equal(it.getName(), openCSV.getName())));
    };
    boolean _exists = IterableExtensions.<OpenCSV>exists(Iterables.<OpenCSV>filter(EcoreUtil2.<Model>getContainerOfType(openCSV, Model.class).getActions(), OpenCSV.class), _function);
    if (_exists) {
      String _name = openCSV.getName();
      String _plus = ("Duplicate csv identifier \'" + _name);
      String _plus_1 = (_plus + "\'");
      this.error(_plus_1, CsvPackage.eINSTANCE.getActions_Name(), 
        CsvValidator.DUPLICATE_OPEN_NAME);
    }
  }
  
  @Check
  public void checkLanguageExists(final Language language) {
    boolean _containsKey = CsvValidator.generators.getMap().containsKey(language.getName());
    boolean _not = (!_containsKey);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Language ");
      String _name = language.getName();
      _builder.append(_name);
      _builder.append(" does not exist.");
      this.error(_builder.toString(), language, CsvPackage.eINSTANCE.getLanguage_Name(), 
        CsvValidator.LANGUAGE_DOES_NOT_EXIST, language.getName());
    }
  }
}
