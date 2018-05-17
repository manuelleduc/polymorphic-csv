/*
 * generated by Xtext 2.12.0
 */
package polymorphic.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmInnerTypeReference;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.xbase.serializer.XtypeSemanticSequencer;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.eclipse.xtext.xtype.XtypePackage;
import polymorphic.csv.CsvPackage;
import polymorphic.csv.Language;
import polymorphic.csv.Model;
import polymorphic.csv.NbCol;
import polymorphic.csv.NbRow;
import polymorphic.csv.OpenCSV;
import polymorphic.csv.PrintCSV;
import polymorphic.csv.SaveCSV;
import polymorphic.services.CsvGrammarAccess;

@SuppressWarnings("all")
public class CsvSemanticSequencer extends XtypeSemanticSequencer {

	@Inject
	private CsvGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == CsvPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case CsvPackage.LANGUAGE:
				sequence_Language(context, (Language) semanticObject); 
				return; 
			case CsvPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case CsvPackage.NB_COL:
				sequence_NbCol(context, (NbCol) semanticObject); 
				return; 
			case CsvPackage.NB_ROW:
				sequence_NbRow(context, (NbRow) semanticObject); 
				return; 
			case CsvPackage.OPEN_CSV:
				sequence_OpenCSV(context, (OpenCSV) semanticObject); 
				return; 
			case CsvPackage.PRINT_CSV:
				sequence_PrintCSV(context, (PrintCSV) semanticObject); 
				return; 
			case CsvPackage.SAVE_CSV:
				sequence_SaveCSV(context, (SaveCSV) semanticObject); 
				return; 
			}
		else if (epackage == TypesPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case TypesPackage.JVM_GENERIC_ARRAY_TYPE_REFERENCE:
				sequence_JvmTypeReference(context, (JvmGenericArrayTypeReference) semanticObject); 
				return; 
			case TypesPackage.JVM_INNER_TYPE_REFERENCE:
				sequence_JvmParameterizedTypeReference(context, (JvmInnerTypeReference) semanticObject); 
				return; 
			case TypesPackage.JVM_LOWER_BOUND:
				if (rule == grammarAccess.getJvmLowerBoundAndedRule()) {
					sequence_JvmLowerBoundAnded(context, (JvmLowerBound) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getJvmLowerBoundRule()) {
					sequence_JvmLowerBound(context, (JvmLowerBound) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_PARAMETERIZED_TYPE_REFERENCE:
				if (action == grammarAccess.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0()) {
					sequence_JvmParameterizedTypeReference_JvmInnerTypeReference_1_4_0_0_0(context, (JvmParameterizedTypeReference) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getJvmTypeReferenceRule()
						|| action == grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()
						|| rule == grammarAccess.getJvmParameterizedTypeReferenceRule()
						|| rule == grammarAccess.getJvmArgumentTypeReferenceRule()) {
					sequence_JvmParameterizedTypeReference(context, (JvmParameterizedTypeReference) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_TYPE_PARAMETER:
				sequence_JvmTypeParameter(context, (JvmTypeParameter) semanticObject); 
				return; 
			case TypesPackage.JVM_UPPER_BOUND:
				if (rule == grammarAccess.getJvmUpperBoundAndedRule()) {
					sequence_JvmUpperBoundAnded(context, (JvmUpperBound) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getJvmUpperBoundRule()) {
					sequence_JvmUpperBound(context, (JvmUpperBound) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_WILDCARD_TYPE_REFERENCE:
				sequence_JvmWildcardTypeReference(context, (JvmWildcardTypeReference) semanticObject); 
				return; 
			}
		else if (epackage == XtypePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case XtypePackage.XFUNCTION_TYPE_REF:
				sequence_XFunctionTypeRef(context, (XFunctionTypeRef) semanticObject); 
				return; 
			case XtypePackage.XIMPORT_DECLARATION:
				sequence_XImportDeclaration(context, (XImportDeclaration) semanticObject); 
				return; 
			case XtypePackage.XIMPORT_SECTION:
				sequence_XImportSection(context, (XImportSection) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Language returns Language
	 *
	 * Constraint:
	 *     (name=ID target=QualifiedName)
	 */
	protected void sequence_Language(ISerializationContext context, Language semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, CsvPackage.Literals.LANGUAGE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CsvPackage.Literals.LANGUAGE__NAME));
			if (transientValues.isValueTransient(semanticObject, CsvPackage.Literals.LANGUAGE__TARGET) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CsvPackage.Literals.LANGUAGE__TARGET));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLanguageAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getLanguageAccess().getTargetQualifiedNameParserRuleCall_2_0(), semanticObject.getTarget());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     (name=ID languages+=Language* actions+=Action*)
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Action returns NbCol
	 *     RefOpenAction returns NbCol
	 *     NbCol returns NbCol
	 *
	 * Constraint:
	 *     open=[OpenCSV|ID]
	 */
	protected void sequence_NbCol(ISerializationContext context, NbCol semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, CsvPackage.Literals.REF_OPEN_ACTION__OPEN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CsvPackage.Literals.REF_OPEN_ACTION__OPEN));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNbColAccess().getOpenOpenCSVIDTerminalRuleCall_2_0_1(), semanticObject.eGet(CsvPackage.Literals.REF_OPEN_ACTION__OPEN, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Action returns NbRow
	 *     RefOpenAction returns NbRow
	 *     NbRow returns NbRow
	 *
	 * Constraint:
	 *     open=[OpenCSV|ID]
	 */
	protected void sequence_NbRow(ISerializationContext context, NbRow semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, CsvPackage.Literals.REF_OPEN_ACTION__OPEN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CsvPackage.Literals.REF_OPEN_ACTION__OPEN));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNbRowAccess().getOpenOpenCSVIDTerminalRuleCall_2_0_1(), semanticObject.eGet(CsvPackage.Literals.REF_OPEN_ACTION__OPEN, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Action returns OpenCSV
	 *     OpenCSV returns OpenCSV
	 *
	 * Constraint:
	 *     (name=ID file=STRING (charset='latin1' | charset='utf8') header?='true'?)
	 */
	protected void sequence_OpenCSV(ISerializationContext context, OpenCSV semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Action returns PrintCSV
	 *     RefOpenAction returns PrintCSV
	 *     PrintCSV returns PrintCSV
	 *
	 * Constraint:
	 *     open=[OpenCSV|ID]
	 */
	protected void sequence_PrintCSV(ISerializationContext context, PrintCSV semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, CsvPackage.Literals.REF_OPEN_ACTION__OPEN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CsvPackage.Literals.REF_OPEN_ACTION__OPEN));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPrintCSVAccess().getOpenOpenCSVIDTerminalRuleCall_2_0_1(), semanticObject.eGet(CsvPackage.Literals.REF_OPEN_ACTION__OPEN, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Action returns SaveCSV
	 *     RefOpenAction returns SaveCSV
	 *     SaveCSV returns SaveCSV
	 *
	 * Constraint:
	 *     (open=[OpenCSV|ID] file=STRING?)
	 */
	protected void sequence_SaveCSV(ISerializationContext context, SaveCSV semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
