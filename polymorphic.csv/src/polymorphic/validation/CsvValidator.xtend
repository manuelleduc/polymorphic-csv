/*
 * generated by Xtext 2.13.0
 */
package polymorphic.validation

import polymorphic.csv.OpenCSV

import static extension org.eclipse.xtext.EcoreUtil2.*
import polymorphic.csv.Model
import polymorphic.csv.CsvPackage
import org.eclipse.xtext.validation.Check
import polymorphic.csv.Language
import polymorphic.generator.GeneratorCollection

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class CsvValidator extends AbstractCsvValidator {

	public static val DUPLICATE_OPEN_NAME = "DUPLICATE_OPEN_NAME"
	public static val LANGUAGE_CONSTRAINTS_ERROR = "LANGUAGE_CONSTRAINTS_ERROR"
	public static val LANGUAGE_DOES_NOT_EXIST = "LANGUAGE_DOES_NOT_EXIST"

	public static val generators = new GeneratorCollection

	@Check
	def matchConstraints(Language language) {
		val names = getContainerOfType(language, Model).constraints.filter [
			val prop = generators.map.get(language.name).properties.get(it.name)
			!(prop === null || it.^true == prop)
		].map[it.name]

		if (!names.empty) {
			error('''«language.name» does not conform to rules «names.join(', ')»''',
				CsvPackage::eINSTANCE.language_Name, LANGUAGE_CONSTRAINTS_ERROR)
		}
	}

	@Check
	def checkDuplicateOpen(OpenCSV openCSV) {
		if (getContainerOfType(openCSV, Model).actions.filter(OpenCSV).
			exists[it != openCSV && it.name == openCSV.name]) {
			error("Duplicate csv identifier '" + openCSV.name + "'", CsvPackage::eINSTANCE.actions_Name,
				DUPLICATE_OPEN_NAME)
		}
	}
	
	@Check
	def checkLanguageExists(Language language) {
		if(!generators.map.containsKey(language.name)) {
			error('''Language «language.name» does not exist.''', language, CsvPackage::eINSTANCE.language_Name,
				LANGUAGE_DOES_NOT_EXIST, language.name)
		}
	}

}
