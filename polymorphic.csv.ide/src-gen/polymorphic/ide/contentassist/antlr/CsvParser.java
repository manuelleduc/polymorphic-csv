/*
 * generated by Xtext 2.13.0
 */
package polymorphic.ide.contentassist.antlr;

import com.google.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import polymorphic.ide.contentassist.antlr.internal.InternalCsvParser;
import polymorphic.services.CsvGrammarAccess;

public class CsvParser extends AbstractContentAssistParser {

	@Inject
	private CsvGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected InternalCsvParser createParser() {
		InternalCsvParser result = new InternalCsvParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getConstraintAccess().getAlternatives_2(), "rule__Constraint__Alternatives_2");
					put(grammarAccess.getActionsAccess().getAlternatives(), "rule__Actions__Alternatives");
					put(grammarAccess.getJvmTypeReferenceAccess().getAlternatives(), "rule__JvmTypeReference__Alternatives");
					put(grammarAccess.getJvmArgumentTypeReferenceAccess().getAlternatives(), "rule__JvmArgumentTypeReference__Alternatives");
					put(grammarAccess.getJvmWildcardTypeReferenceAccess().getAlternatives_2(), "rule__JvmWildcardTypeReference__Alternatives_2");
					put(grammarAccess.getXImportDeclarationAccess().getAlternatives_1(), "rule__XImportDeclaration__Alternatives_1");
					put(grammarAccess.getXImportDeclarationAccess().getAlternatives_1_0_3(), "rule__XImportDeclaration__Alternatives_1_0_3");
					put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
					put(grammarAccess.getConstraintAccess().getGroup(), "rule__Constraint__Group__0");
					put(grammarAccess.getLanguageAccess().getGroup(), "rule__Language__Group__0");
					put(grammarAccess.getActionsAccess().getGroup_0(), "rule__Actions__Group_0__0");
					put(grammarAccess.getActionsAccess().getGroup_1(), "rule__Actions__Group_1__0");
					put(grammarAccess.getActionsAccess().getGroup_2(), "rule__Actions__Group_2__0");
					put(grammarAccess.getJvmTypeReferenceAccess().getGroup_0(), "rule__JvmTypeReference__Group_0__0");
					put(grammarAccess.getJvmTypeReferenceAccess().getGroup_0_1(), "rule__JvmTypeReference__Group_0_1__0");
					put(grammarAccess.getJvmTypeReferenceAccess().getGroup_0_1_0(), "rule__JvmTypeReference__Group_0_1_0__0");
					put(grammarAccess.getArrayBracketsAccess().getGroup(), "rule__ArrayBrackets__Group__0");
					put(grammarAccess.getXFunctionTypeRefAccess().getGroup(), "rule__XFunctionTypeRef__Group__0");
					put(grammarAccess.getXFunctionTypeRefAccess().getGroup_0(), "rule__XFunctionTypeRef__Group_0__0");
					put(grammarAccess.getXFunctionTypeRefAccess().getGroup_0_1(), "rule__XFunctionTypeRef__Group_0_1__0");
					put(grammarAccess.getXFunctionTypeRefAccess().getGroup_0_1_1(), "rule__XFunctionTypeRef__Group_0_1_1__0");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup(), "rule__JvmParameterizedTypeReference__Group__0");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1(), "rule__JvmParameterizedTypeReference__Group_1__0");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_2(), "rule__JvmParameterizedTypeReference__Group_1_2__0");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4(), "rule__JvmParameterizedTypeReference__Group_1_4__0");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_0(), "rule__JvmParameterizedTypeReference__Group_1_4_0__0");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_0_0(), "rule__JvmParameterizedTypeReference__Group_1_4_0_0__0");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_2(), "rule__JvmParameterizedTypeReference__Group_1_4_2__0");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_2_2(), "rule__JvmParameterizedTypeReference__Group_1_4_2_2__0");
					put(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup(), "rule__JvmWildcardTypeReference__Group__0");
					put(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup_2_0(), "rule__JvmWildcardTypeReference__Group_2_0__0");
					put(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup_2_1(), "rule__JvmWildcardTypeReference__Group_2_1__0");
					put(grammarAccess.getJvmUpperBoundAccess().getGroup(), "rule__JvmUpperBound__Group__0");
					put(grammarAccess.getJvmUpperBoundAndedAccess().getGroup(), "rule__JvmUpperBoundAnded__Group__0");
					put(grammarAccess.getJvmLowerBoundAccess().getGroup(), "rule__JvmLowerBound__Group__0");
					put(grammarAccess.getJvmLowerBoundAndedAccess().getGroup(), "rule__JvmLowerBoundAnded__Group__0");
					put(grammarAccess.getJvmTypeParameterAccess().getGroup(), "rule__JvmTypeParameter__Group__0");
					put(grammarAccess.getJvmTypeParameterAccess().getGroup_1(), "rule__JvmTypeParameter__Group_1__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
					put(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup(), "rule__QualifiedNameWithWildcard__Group__0");
					put(grammarAccess.getXImportDeclarationAccess().getGroup(), "rule__XImportDeclaration__Group__0");
					put(grammarAccess.getXImportDeclarationAccess().getGroup_1_0(), "rule__XImportDeclaration__Group_1_0__0");
					put(grammarAccess.getQualifiedNameInStaticImportAccess().getGroup(), "rule__QualifiedNameInStaticImport__Group__0");
					put(grammarAccess.getModelAccess().getConstraintsAssignment_3(), "rule__Model__ConstraintsAssignment_3");
					put(grammarAccess.getModelAccess().getLanguagesAssignment_7(), "rule__Model__LanguagesAssignment_7");
					put(grammarAccess.getModelAccess().getActionsAssignment_9(), "rule__Model__ActionsAssignment_9");
					put(grammarAccess.getConstraintAccess().getNameAssignment_0(), "rule__Constraint__NameAssignment_0");
					put(grammarAccess.getConstraintAccess().getTrueAssignment_2_0(), "rule__Constraint__TrueAssignment_2_0");
					put(grammarAccess.getLanguageAccess().getNameAssignment_0(), "rule__Language__NameAssignment_0");
					put(grammarAccess.getLanguageAccess().getTargetAssignment_2(), "rule__Language__TargetAssignment_2");
					put(grammarAccess.getActionsAccess().getNameAssignment_0_2(), "rule__Actions__NameAssignment_0_2");
					put(grammarAccess.getActionsAccess().getFileAssignment_0_3(), "rule__Actions__FileAssignment_0_3");
					put(grammarAccess.getActionsAccess().getNameAssignment_1_2(), "rule__Actions__NameAssignment_1_2");
					put(grammarAccess.getActionsAccess().getNameAssignment_2_2(), "rule__Actions__NameAssignment_2_2");
					put(grammarAccess.getActionsAccess().getFileAssignment_2_3(), "rule__Actions__FileAssignment_2_3");
					put(grammarAccess.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_0(), "rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0");
					put(grammarAccess.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_1_1(), "rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1");
					put(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeAssignment_2(), "rule__XFunctionTypeRef__ReturnTypeAssignment_2");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_0(), "rule__JvmParameterizedTypeReference__TypeAssignment_0");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_1(), "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_2_1(), "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_1_4_1(), "rule__JvmParameterizedTypeReference__TypeAssignment_1_4_1");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_4_2_1(), "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_1");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_4_2_2_1(), "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_2_1");
					put(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_0_0(), "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_0");
					put(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_0_1(), "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_1");
					put(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_1_0(), "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_0");
					put(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_1_1(), "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_1");
					put(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceAssignment_1(), "rule__JvmUpperBound__TypeReferenceAssignment_1");
					put(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceAssignment_1(), "rule__JvmUpperBoundAnded__TypeReferenceAssignment_1");
					put(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceAssignment_1(), "rule__JvmLowerBound__TypeReferenceAssignment_1");
					put(grammarAccess.getJvmLowerBoundAndedAccess().getTypeReferenceAssignment_1(), "rule__JvmLowerBoundAnded__TypeReferenceAssignment_1");
					put(grammarAccess.getJvmTypeParameterAccess().getNameAssignment_0(), "rule__JvmTypeParameter__NameAssignment_0");
					put(grammarAccess.getJvmTypeParameterAccess().getConstraintsAssignment_1_0(), "rule__JvmTypeParameter__ConstraintsAssignment_1_0");
					put(grammarAccess.getJvmTypeParameterAccess().getConstraintsAssignment_1_1(), "rule__JvmTypeParameter__ConstraintsAssignment_1_1");
					put(grammarAccess.getXImportSectionAccess().getImportDeclarationsAssignment(), "rule__XImportSection__ImportDeclarationsAssignment");
					put(grammarAccess.getXImportDeclarationAccess().getStaticAssignment_1_0_0(), "rule__XImportDeclaration__StaticAssignment_1_0_0");
					put(grammarAccess.getXImportDeclarationAccess().getExtensionAssignment_1_0_1(), "rule__XImportDeclaration__ExtensionAssignment_1_0_1");
					put(grammarAccess.getXImportDeclarationAccess().getImportedTypeAssignment_1_0_2(), "rule__XImportDeclaration__ImportedTypeAssignment_1_0_2");
					put(grammarAccess.getXImportDeclarationAccess().getWildcardAssignment_1_0_3_0(), "rule__XImportDeclaration__WildcardAssignment_1_0_3_0");
					put(grammarAccess.getXImportDeclarationAccess().getMemberNameAssignment_1_0_3_1(), "rule__XImportDeclaration__MemberNameAssignment_1_0_3_1");
					put(grammarAccess.getXImportDeclarationAccess().getImportedTypeAssignment_1_1(), "rule__XImportDeclaration__ImportedTypeAssignment_1_1");
					put(grammarAccess.getXImportDeclarationAccess().getImportedNamespaceAssignment_1_2(), "rule__XImportDeclaration__ImportedNamespaceAssignment_1_2");
				}
			};
		}
		return nameMappings.get(element);
	}
			
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public CsvGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(CsvGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
