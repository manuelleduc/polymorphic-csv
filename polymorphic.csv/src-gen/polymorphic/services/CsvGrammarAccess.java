/*
 * generated by Xtext 2.13.0
 */
package polymorphic.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractGrammarElementFinder;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.xbase.services.XtypeGrammarAccess;

@Singleton
public class CsvGrammarAccess extends AbstractGrammarElementFinder {
	
	public class ModelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "polymorphic.Csv.Model");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cModelAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cConstraintsKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cConstraintsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cConstraintsConstraintParserRuleCall_3_0 = (RuleCall)cConstraintsAssignment_3.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Keyword cLanguagesKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Keyword cLeftCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Assignment cLanguagesAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cLanguagesLanguageParserRuleCall_7_0 = (RuleCall)cLanguagesAssignment_7.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_8 = (Keyword)cGroup.eContents().get(8);
		private final Assignment cActionsAssignment_9 = (Assignment)cGroup.eContents().get(9);
		private final RuleCall cActionsActionsParserRuleCall_9_0 = (RuleCall)cActionsAssignment_9.eContents().get(0);
		
		//Model:
		//	{Model}
		//	'constraints' '{'
		//	constraints+=Constraint*
		//	'}'
		//	'languages' '{'
		//	languages+=Language*
		//	'}'
		//	actions+=Actions*;
		@Override public ParserRule getRule() { return rule; }
		
		//{Model} 'constraints' '{' constraints+=Constraint* '}' 'languages' '{' languages+=Language* '}' actions+=Actions*
		public Group getGroup() { return cGroup; }
		
		//{Model}
		public Action getModelAction_0() { return cModelAction_0; }
		
		//'constraints'
		public Keyword getConstraintsKeyword_1() { return cConstraintsKeyword_1; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//constraints+=Constraint*
		public Assignment getConstraintsAssignment_3() { return cConstraintsAssignment_3; }
		
		//Constraint
		public RuleCall getConstraintsConstraintParserRuleCall_3_0() { return cConstraintsConstraintParserRuleCall_3_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
		
		//'languages'
		public Keyword getLanguagesKeyword_5() { return cLanguagesKeyword_5; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_6() { return cLeftCurlyBracketKeyword_6; }
		
		//languages+=Language*
		public Assignment getLanguagesAssignment_7() { return cLanguagesAssignment_7; }
		
		//Language
		public RuleCall getLanguagesLanguageParserRuleCall_7_0() { return cLanguagesLanguageParserRuleCall_7_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_8() { return cRightCurlyBracketKeyword_8; }
		
		//actions+=Actions*
		public Assignment getActionsAssignment_9() { return cActionsAssignment_9; }
		
		//Actions
		public RuleCall getActionsActionsParserRuleCall_9_0() { return cActionsActionsParserRuleCall_9_0; }
	}
	public class ConstraintElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "polymorphic.Csv.Constraint");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cEqualsSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Assignment cTrueAssignment_2_0 = (Assignment)cAlternatives_2.eContents().get(0);
		private final Keyword cTrueTrueKeyword_2_0_0 = (Keyword)cTrueAssignment_2_0.eContents().get(0);
		private final Keyword cFalseKeyword_2_1 = (Keyword)cAlternatives_2.eContents().get(1);
		
		//Constraint:
		//	name=ID '=' (true?='true' | 'false');
		@Override public ParserRule getRule() { return rule; }
		
		//name=ID '=' (true?='true' | 'false')
		public Group getGroup() { return cGroup; }
		
		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }
		
		//'='
		public Keyword getEqualsSignKeyword_1() { return cEqualsSignKeyword_1; }
		
		//true?='true' | 'false'
		public Alternatives getAlternatives_2() { return cAlternatives_2; }
		
		//true?='true'
		public Assignment getTrueAssignment_2_0() { return cTrueAssignment_2_0; }
		
		//'true'
		public Keyword getTrueTrueKeyword_2_0_0() { return cTrueTrueKeyword_2_0_0; }
		
		//'false'
		public Keyword getFalseKeyword_2_1() { return cFalseKeyword_2_1; }
	}
	public class LanguageElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "polymorphic.Csv.Language");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cTargetAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cTargetQualifiedNameParserRuleCall_2_0 = (RuleCall)cTargetAssignment_2.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//Language:
		//	name=ID '(' target=QualifiedName ')';
		@Override public ParserRule getRule() { return rule; }
		
		//name=ID '(' target=QualifiedName ')'
		public Group getGroup() { return cGroup; }
		
		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }
		
		//target=QualifiedName
		public Assignment getTargetAssignment_2() { return cTargetAssignment_2; }
		
		//QualifiedName
		public RuleCall getTargetQualifiedNameParserRuleCall_2_0() { return cTargetQualifiedNameParserRuleCall_2_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
	}
	public class ActionsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "polymorphic.Csv.Actions");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cOpenCSVAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Keyword cReadKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Assignment cNameAssignment_0_2 = (Assignment)cGroup_0.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_0_2_0 = (RuleCall)cNameAssignment_0_2.eContents().get(0);
		private final Assignment cFileAssignment_0_3 = (Assignment)cGroup_0.eContents().get(3);
		private final RuleCall cFileSTRINGTerminalRuleCall_0_3_0 = (RuleCall)cFileAssignment_0_3.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Action cPrintCSVAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cPrintKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cNameAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_1_2_0 = (RuleCall)cNameAssignment_1_2.eContents().get(0);
		private final Group cGroup_2 = (Group)cAlternatives.eContents().get(2);
		private final Action cSaveCSVAction_2_0 = (Action)cGroup_2.eContents().get(0);
		private final Keyword cSaveKeyword_2_1 = (Keyword)cGroup_2.eContents().get(1);
		private final Assignment cNameAssignment_2_2 = (Assignment)cGroup_2.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_2_0 = (RuleCall)cNameAssignment_2_2.eContents().get(0);
		
		//Actions:
		//	{OpenCSV} 'read' name=ID file=STRING | {PrintCSV} 'print' name=ID | {SaveCSV} 'save' name=ID;
		@Override public ParserRule getRule() { return rule; }
		
		//{OpenCSV} 'read' name=ID file=STRING | {PrintCSV} 'print' name=ID | {SaveCSV} 'save' name=ID
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//{OpenCSV} 'read' name=ID file=STRING
		public Group getGroup_0() { return cGroup_0; }
		
		//{OpenCSV}
		public Action getOpenCSVAction_0_0() { return cOpenCSVAction_0_0; }
		
		//'read'
		public Keyword getReadKeyword_0_1() { return cReadKeyword_0_1; }
		
		//name=ID
		public Assignment getNameAssignment_0_2() { return cNameAssignment_0_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0_2_0() { return cNameIDTerminalRuleCall_0_2_0; }
		
		//file=STRING
		public Assignment getFileAssignment_0_3() { return cFileAssignment_0_3; }
		
		//STRING
		public RuleCall getFileSTRINGTerminalRuleCall_0_3_0() { return cFileSTRINGTerminalRuleCall_0_3_0; }
		
		//{PrintCSV} 'print' name=ID
		public Group getGroup_1() { return cGroup_1; }
		
		//{PrintCSV}
		public Action getPrintCSVAction_1_0() { return cPrintCSVAction_1_0; }
		
		//'print'
		public Keyword getPrintKeyword_1_1() { return cPrintKeyword_1_1; }
		
		//name=ID
		public Assignment getNameAssignment_1_2() { return cNameAssignment_1_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_2_0() { return cNameIDTerminalRuleCall_1_2_0; }
		
		//{SaveCSV} 'save' name=ID
		public Group getGroup_2() { return cGroup_2; }
		
		//{SaveCSV}
		public Action getSaveCSVAction_2_0() { return cSaveCSVAction_2_0; }
		
		//'save'
		public Keyword getSaveKeyword_2_1() { return cSaveKeyword_2_1; }
		
		//name=ID
		public Assignment getNameAssignment_2_2() { return cNameAssignment_2_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_2_0() { return cNameIDTerminalRuleCall_2_2_0; }
	}
	
	
	private final ModelElements pModel;
	private final ConstraintElements pConstraint;
	private final LanguageElements pLanguage;
	private final ActionsElements pActions;
	
	private final Grammar grammar;
	
	private final XtypeGrammarAccess gaXtype;

	@Inject
	public CsvGrammarAccess(GrammarProvider grammarProvider,
			XtypeGrammarAccess gaXtype) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaXtype = gaXtype;
		this.pModel = new ModelElements();
		this.pConstraint = new ConstraintElements();
		this.pLanguage = new LanguageElements();
		this.pActions = new ActionsElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("polymorphic.Csv".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	
	
	public XtypeGrammarAccess getXtypeGrammarAccess() {
		return gaXtype;
	}

	
	//Model:
	//	{Model}
	//	'constraints' '{'
	//	constraints+=Constraint*
	//	'}'
	//	'languages' '{'
	//	languages+=Language*
	//	'}'
	//	actions+=Actions*;
	public ModelElements getModelAccess() {
		return pModel;
	}
	
	public ParserRule getModelRule() {
		return getModelAccess().getRule();
	}
	
	//Constraint:
	//	name=ID '=' (true?='true' | 'false');
	public ConstraintElements getConstraintAccess() {
		return pConstraint;
	}
	
	public ParserRule getConstraintRule() {
		return getConstraintAccess().getRule();
	}
	
	//Language:
	//	name=ID '(' target=QualifiedName ')';
	public LanguageElements getLanguageAccess() {
		return pLanguage;
	}
	
	public ParserRule getLanguageRule() {
		return getLanguageAccess().getRule();
	}
	
	//Actions:
	//	{OpenCSV} 'read' name=ID file=STRING | {PrintCSV} 'print' name=ID | {SaveCSV} 'save' name=ID;
	public ActionsElements getActionsAccess() {
		return pActions;
	}
	
	public ParserRule getActionsRule() {
		return getActionsAccess().getRule();
	}
	
	//JvmTypeReference:
	//	JvmParameterizedTypeReference => ({JvmGenericArrayTypeReference.componentType=current} ArrayBrackets)*
	//	| XFunctionTypeRef;
	public XtypeGrammarAccess.JvmTypeReferenceElements getJvmTypeReferenceAccess() {
		return gaXtype.getJvmTypeReferenceAccess();
	}
	
	public ParserRule getJvmTypeReferenceRule() {
		return getJvmTypeReferenceAccess().getRule();
	}
	
	//ArrayBrackets:
	//	'[' ']';
	public XtypeGrammarAccess.ArrayBracketsElements getArrayBracketsAccess() {
		return gaXtype.getArrayBracketsAccess();
	}
	
	public ParserRule getArrayBracketsRule() {
		return getArrayBracketsAccess().getRule();
	}
	
	//XFunctionTypeRef:
	//	('(' (paramTypes+=JvmTypeReference (',' paramTypes+=JvmTypeReference)*)? ')')? '=>' returnType=JvmTypeReference;
	public XtypeGrammarAccess.XFunctionTypeRefElements getXFunctionTypeRefAccess() {
		return gaXtype.getXFunctionTypeRefAccess();
	}
	
	public ParserRule getXFunctionTypeRefRule() {
		return getXFunctionTypeRefAccess().getRule();
	}
	
	//JvmParameterizedTypeReference:
	//	type=[JvmType|QualifiedName] (=> '<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)*
	//	'>' (=> ({JvmInnerTypeReference.outer=current} '.') type=[JvmType|ValidID] (=> '<' arguments+=JvmArgumentTypeReference
	//	(',' arguments+=JvmArgumentTypeReference)* '>')?)*)?;
	public XtypeGrammarAccess.JvmParameterizedTypeReferenceElements getJvmParameterizedTypeReferenceAccess() {
		return gaXtype.getJvmParameterizedTypeReferenceAccess();
	}
	
	public ParserRule getJvmParameterizedTypeReferenceRule() {
		return getJvmParameterizedTypeReferenceAccess().getRule();
	}
	
	//JvmArgumentTypeReference JvmTypeReference:
	//	JvmTypeReference | JvmWildcardTypeReference;
	public XtypeGrammarAccess.JvmArgumentTypeReferenceElements getJvmArgumentTypeReferenceAccess() {
		return gaXtype.getJvmArgumentTypeReferenceAccess();
	}
	
	public ParserRule getJvmArgumentTypeReferenceRule() {
		return getJvmArgumentTypeReferenceAccess().getRule();
	}
	
	//JvmWildcardTypeReference:
	//	{JvmWildcardTypeReference} '?' (constraints+=JvmUpperBound constraints+=JvmUpperBoundAnded*
	//	| constraints+=JvmLowerBound constraints+=JvmLowerBoundAnded*)?;
	public XtypeGrammarAccess.JvmWildcardTypeReferenceElements getJvmWildcardTypeReferenceAccess() {
		return gaXtype.getJvmWildcardTypeReferenceAccess();
	}
	
	public ParserRule getJvmWildcardTypeReferenceRule() {
		return getJvmWildcardTypeReferenceAccess().getRule();
	}
	
	//JvmUpperBound:
	//	'extends' typeReference=JvmTypeReference;
	public XtypeGrammarAccess.JvmUpperBoundElements getJvmUpperBoundAccess() {
		return gaXtype.getJvmUpperBoundAccess();
	}
	
	public ParserRule getJvmUpperBoundRule() {
		return getJvmUpperBoundAccess().getRule();
	}
	
	//JvmUpperBoundAnded JvmUpperBound:
	//	'&' typeReference=JvmTypeReference;
	public XtypeGrammarAccess.JvmUpperBoundAndedElements getJvmUpperBoundAndedAccess() {
		return gaXtype.getJvmUpperBoundAndedAccess();
	}
	
	public ParserRule getJvmUpperBoundAndedRule() {
		return getJvmUpperBoundAndedAccess().getRule();
	}
	
	//JvmLowerBound:
	//	'super' typeReference=JvmTypeReference;
	public XtypeGrammarAccess.JvmLowerBoundElements getJvmLowerBoundAccess() {
		return gaXtype.getJvmLowerBoundAccess();
	}
	
	public ParserRule getJvmLowerBoundRule() {
		return getJvmLowerBoundAccess().getRule();
	}
	
	//JvmLowerBoundAnded JvmLowerBound:
	//	'&' typeReference=JvmTypeReference;
	public XtypeGrammarAccess.JvmLowerBoundAndedElements getJvmLowerBoundAndedAccess() {
		return gaXtype.getJvmLowerBoundAndedAccess();
	}
	
	public ParserRule getJvmLowerBoundAndedRule() {
		return getJvmLowerBoundAndedAccess().getRule();
	}
	
	//JvmTypeParameter:
	//	name=ValidID (constraints+=JvmUpperBound constraints+=JvmUpperBoundAnded*)?;
	public XtypeGrammarAccess.JvmTypeParameterElements getJvmTypeParameterAccess() {
		return gaXtype.getJvmTypeParameterAccess();
	}
	
	public ParserRule getJvmTypeParameterRule() {
		return getJvmTypeParameterAccess().getRule();
	}
	
	//QualifiedName:
	//	ValidID ('.' ValidID)*;
	public XtypeGrammarAccess.QualifiedNameElements getQualifiedNameAccess() {
		return gaXtype.getQualifiedNameAccess();
	}
	
	public ParserRule getQualifiedNameRule() {
		return getQualifiedNameAccess().getRule();
	}
	
	//QualifiedNameWithWildcard:
	//	QualifiedName '.' '*';
	public XtypeGrammarAccess.QualifiedNameWithWildcardElements getQualifiedNameWithWildcardAccess() {
		return gaXtype.getQualifiedNameWithWildcardAccess();
	}
	
	public ParserRule getQualifiedNameWithWildcardRule() {
		return getQualifiedNameWithWildcardAccess().getRule();
	}
	
	//ValidID:
	//	ID;
	public XtypeGrammarAccess.ValidIDElements getValidIDAccess() {
		return gaXtype.getValidIDAccess();
	}
	
	public ParserRule getValidIDRule() {
		return getValidIDAccess().getRule();
	}
	
	//XImportSection:
	//	importDeclarations+=XImportDeclaration+;
	public XtypeGrammarAccess.XImportSectionElements getXImportSectionAccess() {
		return gaXtype.getXImportSectionAccess();
	}
	
	public ParserRule getXImportSectionRule() {
		return getXImportSectionAccess().getRule();
	}
	
	//XImportDeclaration:
	//	'import' (static?='static' extension?='extension'? importedType=[JvmDeclaredType|QualifiedNameInStaticImport]
	//	(wildcard?='*' | memberName=ValidID) | importedType=[JvmDeclaredType|QualifiedName] |
	//	importedNamespace=QualifiedNameWithWildcard) ';'?;
	public XtypeGrammarAccess.XImportDeclarationElements getXImportDeclarationAccess() {
		return gaXtype.getXImportDeclarationAccess();
	}
	
	public ParserRule getXImportDeclarationRule() {
		return getXImportDeclarationAccess().getRule();
	}
	
	//QualifiedNameInStaticImport:
	//	(ValidID '.')+;
	public XtypeGrammarAccess.QualifiedNameInStaticImportElements getQualifiedNameInStaticImportAccess() {
		return gaXtype.getQualifiedNameInStaticImportAccess();
	}
	
	public ParserRule getQualifiedNameInStaticImportRule() {
		return getQualifiedNameInStaticImportAccess().getRule();
	}
	
	//terminal ID:
	//	'^'? ('a'..'z' | 'A'..'Z' | '$' | '_') ('a'..'z' | 'A'..'Z' | '$' | '_' | '0'..'9')*;
	public TerminalRule getIDRule() {
		return gaXtype.getIDRule();
	}
	
	//terminal STRING:
	//	'"' ('\\' . | !('\\' | '"'))* '"'? |
	//	"'" ('\\' . | !('\\' | "'"))* "'"?;
	public TerminalRule getSTRINGRule() {
		return gaXtype.getSTRINGRule();
	}
	
	//terminal ML_COMMENT:
	//	'/*'->'*/';
	public TerminalRule getML_COMMENTRule() {
		return gaXtype.getML_COMMENTRule();
	}
	
	//terminal SL_COMMENT:
	//	'//' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaXtype.getSL_COMMENTRule();
	}
	
	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return gaXtype.getWSRule();
	}
	
	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaXtype.getANY_OTHERRule();
	}
}
