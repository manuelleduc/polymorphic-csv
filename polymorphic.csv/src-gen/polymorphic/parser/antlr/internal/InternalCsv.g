/*
 * generated by Xtext 2.12.0
 */
grammar InternalCsv;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package polymorphic.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package polymorphic.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import polymorphic.services.CsvGrammarAccess;

}

@parser::members {

 	private CsvGrammarAccess grammarAccess;

    public InternalCsvParser(TokenStream input, CsvGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Model";
   	}

   	@Override
   	protected CsvGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleModel
entryRuleModel returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getModelRule()); }
	iv_ruleModel=ruleModel
	{ $current=$iv_ruleModel.current; }
	EOF;

// Rule Model
ruleModel returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getModelAccess().getModelAction_0(),
					$current);
			}
		)
		otherlv_1='package'
		{
			newLeafNode(otherlv_1, grammarAccess.getModelAccess().getPackageKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getModelRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"org.eclipse.xtext.xbase.Xtype.ID");
				}
			)
		)
		otherlv_3=';'
		{
			newLeafNode(otherlv_3, grammarAccess.getModelAccess().getSemicolonKeyword_3());
		}
		otherlv_4='constraints'
		{
			newLeafNode(otherlv_4, grammarAccess.getModelAccess().getConstraintsKeyword_4());
		}
		otherlv_5='{'
		{
			newLeafNode(otherlv_5, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_5());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getModelAccess().getConstraintsConstraintParserRuleCall_6_0());
				}
				lv_constraints_6_0=ruleConstraint
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModelRule());
					}
					add(
						$current,
						"constraints",
						lv_constraints_6_0,
						"polymorphic.Csv.Constraint");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_7='}'
		{
			newLeafNode(otherlv_7, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_7());
		}
		otherlv_8='languages'
		{
			newLeafNode(otherlv_8, grammarAccess.getModelAccess().getLanguagesKeyword_8());
		}
		otherlv_9='{'
		{
			newLeafNode(otherlv_9, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_9());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getModelAccess().getLanguagesLanguageParserRuleCall_10_0());
				}
				lv_languages_10_0=ruleLanguage
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModelRule());
					}
					add(
						$current,
						"languages",
						lv_languages_10_0,
						"polymorphic.Csv.Language");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_11='}'
		{
			newLeafNode(otherlv_11, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_11());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getModelAccess().getActionsActionParserRuleCall_12_0());
				}
				lv_actions_12_0=ruleAction
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModelRule());
					}
					add(
						$current,
						"actions",
						lv_actions_12_0,
						"polymorphic.Csv.Action");
					afterParserOrEnumRuleCall();
				}
			)
		)*
	)
;

// Entry rule entryRuleConstraint
entryRuleConstraint returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConstraintRule()); }
	iv_ruleConstraint=ruleConstraint
	{ $current=$iv_ruleConstraint.current; }
	EOF;

// Rule Constraint
ruleConstraint returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getConstraintAccess().getNameIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getConstraintRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.xtext.xbase.Xtype.ID");
				}
			)
		)
		otherlv_1='='
		{
			newLeafNode(otherlv_1, grammarAccess.getConstraintAccess().getEqualsSignKeyword_1());
		}
		(
			(
				(
					lv_true_2_0='true'
					{
						newLeafNode(lv_true_2_0, grammarAccess.getConstraintAccess().getTrueTrueKeyword_2_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getConstraintRule());
						}
						setWithLastConsumed($current, "true", true, "true");
					}
				)
			)
			    |
			otherlv_3='false'
			{
				newLeafNode(otherlv_3, grammarAccess.getConstraintAccess().getFalseKeyword_2_1());
			}
		)
	)
;

// Entry rule entryRuleLanguage
entryRuleLanguage returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLanguageRule()); }
	iv_ruleLanguage=ruleLanguage
	{ $current=$iv_ruleLanguage.current; }
	EOF;

// Rule Language
ruleLanguage returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getLanguageAccess().getNameIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getLanguageRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.xtext.xbase.Xtype.ID");
				}
			)
		)
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getLanguageAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getLanguageAccess().getTargetQualifiedNameParserRuleCall_2_0());
				}
				lv_target_2_0=ruleQualifiedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLanguageRule());
					}
					set(
						$current,
						"target",
						lv_target_2_0,
						"org.eclipse.xtext.xbase.Xtype.QualifiedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=')'
		{
			newLeafNode(otherlv_3, grammarAccess.getLanguageAccess().getRightParenthesisKeyword_3());
		}
	)
;

// Entry rule entryRuleAction
entryRuleAction returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getActionRule()); }
	iv_ruleAction=ruleAction
	{ $current=$iv_ruleAction.current; }
	EOF;

// Rule Action
ruleAction returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getActionAccess().getOpenCSVParserRuleCall_0());
		}
		this_OpenCSV_0=ruleOpenCSV
		{
			$current = $this_OpenCSV_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getActionAccess().getRefOpenActionParserRuleCall_1());
		}
		this_RefOpenAction_1=ruleRefOpenAction
		{
			$current = $this_RefOpenAction_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleOpenCSV
entryRuleOpenCSV returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOpenCSVRule()); }
	iv_ruleOpenCSV=ruleOpenCSV
	{ $current=$iv_ruleOpenCSV.current; }
	EOF;

// Rule OpenCSV
ruleOpenCSV returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getOpenCSVAccess().getOpenCSVAction_0(),
					$current);
			}
		)
		otherlv_1='read'
		{
			newLeafNode(otherlv_1, grammarAccess.getOpenCSVAccess().getReadKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getOpenCSVAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getOpenCSVRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"org.eclipse.xtext.xbase.Xtype.ID");
				}
			)
		)
		(
			(
				lv_file_3_0=RULE_STRING
				{
					newLeafNode(lv_file_3_0, grammarAccess.getOpenCSVAccess().getFileSTRINGTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getOpenCSVRule());
					}
					setWithLastConsumed(
						$current,
						"file",
						lv_file_3_0,
						"org.eclipse.xtext.xbase.Xtype.STRING");
				}
			)
		)
		(
			(
				(
					lv_charset_4_1='latin1'
					{
						newLeafNode(lv_charset_4_1, grammarAccess.getOpenCSVAccess().getCharsetLatin1Keyword_4_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getOpenCSVRule());
						}
						setWithLastConsumed($current, "charset", lv_charset_4_1, null);
					}
					    |
					lv_charset_4_2='utf8'
					{
						newLeafNode(lv_charset_4_2, grammarAccess.getOpenCSVAccess().getCharsetUtf8Keyword_4_0_1());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getOpenCSVRule());
						}
						setWithLastConsumed($current, "charset", lv_charset_4_2, null);
					}
				)
			)
		)
	)
;

// Entry rule entryRuleRefOpenAction
entryRuleRefOpenAction returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRefOpenActionRule()); }
	iv_ruleRefOpenAction=ruleRefOpenAction
	{ $current=$iv_ruleRefOpenAction.current; }
	EOF;

// Rule RefOpenAction
ruleRefOpenAction returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getRefOpenActionAccess().getPrintCSVParserRuleCall_0());
		}
		this_PrintCSV_0=rulePrintCSV
		{
			$current = $this_PrintCSV_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getRefOpenActionAccess().getNbRowParserRuleCall_1());
		}
		this_NbRow_1=ruleNbRow
		{
			$current = $this_NbRow_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getRefOpenActionAccess().getSaveCSVParserRuleCall_2());
		}
		this_SaveCSV_2=ruleSaveCSV
		{
			$current = $this_SaveCSV_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRulePrintCSV
entryRulePrintCSV returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrintCSVRule()); }
	iv_rulePrintCSV=rulePrintCSV
	{ $current=$iv_rulePrintCSV.current; }
	EOF;

// Rule PrintCSV
rulePrintCSV returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getPrintCSVAccess().getPrintCSVAction_0(),
					$current);
			}
		)
		otherlv_1='print'
		{
			newLeafNode(otherlv_1, grammarAccess.getPrintCSVAccess().getPrintKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getPrintCSVRule());
					}
				}
				otherlv_2=RULE_ID
				{
					newLeafNode(otherlv_2, grammarAccess.getPrintCSVAccess().getOpenOpenCSVCrossReference_2_0());
				}
			)
		)
	)
;

// Entry rule entryRuleNbRow
entryRuleNbRow returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNbRowRule()); }
	iv_ruleNbRow=ruleNbRow
	{ $current=$iv_ruleNbRow.current; }
	EOF;

// Rule NbRow
ruleNbRow returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getNbRowAccess().getNbRowAction_0(),
					$current);
			}
		)
		otherlv_1='nbrow'
		{
			newLeafNode(otherlv_1, grammarAccess.getNbRowAccess().getNbrowKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getNbRowRule());
					}
				}
				otherlv_2=RULE_ID
				{
					newLeafNode(otherlv_2, grammarAccess.getNbRowAccess().getOpenOpenCSVCrossReference_2_0());
				}
			)
		)
	)
;

// Entry rule entryRuleSaveCSV
entryRuleSaveCSV returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSaveCSVRule()); }
	iv_ruleSaveCSV=ruleSaveCSV
	{ $current=$iv_ruleSaveCSV.current; }
	EOF;

// Rule SaveCSV
ruleSaveCSV returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getSaveCSVAccess().getSaveCSVAction_0(),
					$current);
			}
		)
		otherlv_1='save'
		{
			newLeafNode(otherlv_1, grammarAccess.getSaveCSVAccess().getSaveKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSaveCSVRule());
					}
				}
				otherlv_2=RULE_ID
				{
					newLeafNode(otherlv_2, grammarAccess.getSaveCSVAccess().getOpenOpenCSVCrossReference_2_0());
				}
			)
		)
		(
			(
				lv_file_3_0=RULE_STRING
				{
					newLeafNode(lv_file_3_0, grammarAccess.getSaveCSVAccess().getFileSTRINGTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSaveCSVRule());
					}
					setWithLastConsumed(
						$current,
						"file",
						lv_file_3_0,
						"org.eclipse.xtext.xbase.Xtype.STRING");
				}
			)
		)?
	)
;

// Entry rule entryRuleJvmTypeReference
entryRuleJvmTypeReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJvmTypeReferenceRule()); }
	iv_ruleJvmTypeReference=ruleJvmTypeReference
	{ $current=$iv_ruleJvmTypeReference.current; }
	EOF;

// Rule JvmTypeReference
ruleJvmTypeReference returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0());
			}
			this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference
			{
				$current = $this_JvmParameterizedTypeReference_0.current;
				afterParserOrEnumRuleCall();
			}
			(
				((
					(
					)
					ruleArrayBrackets
				)
				)=>
				(
					(
						{
							$current = forceCreateModelElementAndSet(
								grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0(),
								$current);
						}
					)
					{
						newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getArrayBracketsParserRuleCall_0_1_0_1());
					}
					ruleArrayBrackets
					{
						afterParserOrEnumRuleCall();
					}
				)
			)*
		)
		    |
		{
			newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1());
		}
		this_XFunctionTypeRef_3=ruleXFunctionTypeRef
		{
			$current = $this_XFunctionTypeRef_3.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleArrayBrackets
entryRuleArrayBrackets returns [String current=null]:
	{ newCompositeNode(grammarAccess.getArrayBracketsRule()); }
	iv_ruleArrayBrackets=ruleArrayBrackets
	{ $current=$iv_ruleArrayBrackets.current.getText(); }
	EOF;

// Rule ArrayBrackets
ruleArrayBrackets returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='['
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getArrayBracketsAccess().getLeftSquareBracketKeyword_0());
		}
		kw=']'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getArrayBracketsAccess().getRightSquareBracketKeyword_1());
		}
	)
;

// Entry rule entryRuleXFunctionTypeRef
entryRuleXFunctionTypeRef returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXFunctionTypeRefRule()); }
	iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef
	{ $current=$iv_ruleXFunctionTypeRef.current; }
	EOF;

// Rule XFunctionTypeRef
ruleXFunctionTypeRef returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			otherlv_0='('
			{
				newLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0());
			}
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0());
						}
						lv_paramTypes_1_0=ruleJvmTypeReference
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
							}
							add(
								$current,
								"paramTypes",
								lv_paramTypes_1_0,
								"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_2=','
					{
						newLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0());
							}
							lv_paramTypes_3_0=ruleJvmTypeReference
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
								}
								add(
									$current,
									"paramTypes",
									lv_paramTypes_3_0,
									"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)?
			otherlv_4=')'
			{
				newLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2());
			}
		)?
		otherlv_5='=>'
		{
			newLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0());
				}
				lv_returnType_6_0=ruleJvmTypeReference
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
					}
					set(
						$current,
						"returnType",
						lv_returnType_6_0,
						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleJvmParameterizedTypeReference
entryRuleJvmParameterizedTypeReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule()); }
	iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference
	{ $current=$iv_ruleJvmParameterizedTypeReference.current; }
	EOF;

// Rule JvmParameterizedTypeReference
ruleJvmParameterizedTypeReference returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0());
				}
				ruleQualifiedName
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				('<')=>
				otherlv_1='<'
				{
					newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
				}
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0());
					}
					lv_arguments_2_0=ruleJvmArgumentTypeReference
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
						}
						add(
							$current,
							"arguments",
							lv_arguments_2_0,
							"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_3=','
				{
					newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0());
						}
						lv_arguments_4_0=ruleJvmArgumentTypeReference
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
							}
							add(
								$current,
								"arguments",
								lv_arguments_4_0,
								"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			otherlv_5='>'
			{
				newLeafNode(otherlv_5, grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3());
			}
			(
				(
					((
						(
						)
						'.'
					)
					)=>
					(
						(
							{
								$current = forceCreateModelElementAndSet(
									grammarAccess.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0(),
									$current);
							}
						)
						otherlv_7='.'
						{
							newLeafNode(otherlv_7, grammarAccess.getJvmParameterizedTypeReferenceAccess().getFullStopKeyword_1_4_0_0_1());
						}
					)
				)
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_1_4_1_0());
						}
						ruleValidID
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						('<')=>
						otherlv_9='<'
						{
							newLeafNode(otherlv_9, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_4_2_0());
						}
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0());
							}
							lv_arguments_10_0=ruleJvmArgumentTypeReference
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
								}
								add(
									$current,
									"arguments",
									lv_arguments_10_0,
									"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_11=','
						{
							newLeafNode(otherlv_11, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_4_2_2_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0());
								}
								lv_arguments_12_0=ruleJvmArgumentTypeReference
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
									}
									add(
										$current,
										"arguments",
										lv_arguments_12_0,
										"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)*
					otherlv_13='>'
					{
						newLeafNode(otherlv_13, grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_4_2_3());
					}
				)?
			)*
		)?
	)
;

// Entry rule entryRuleJvmArgumentTypeReference
entryRuleJvmArgumentTypeReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule()); }
	iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference
	{ $current=$iv_ruleJvmArgumentTypeReference.current; }
	EOF;

// Rule JvmArgumentTypeReference
ruleJvmArgumentTypeReference returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0());
		}
		this_JvmTypeReference_0=ruleJvmTypeReference
		{
			$current = $this_JvmTypeReference_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1());
		}
		this_JvmWildcardTypeReference_1=ruleJvmWildcardTypeReference
		{
			$current = $this_JvmWildcardTypeReference_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleJvmWildcardTypeReference
entryRuleJvmWildcardTypeReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule()); }
	iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference
	{ $current=$iv_ruleJvmWildcardTypeReference.current; }
	EOF;

// Rule JvmWildcardTypeReference
ruleJvmWildcardTypeReference returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(),
					$current);
			}
		)
		otherlv_1='?'
		{
			newLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
		}
		(
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0_0());
						}
						lv_constraints_2_0=ruleJvmUpperBound
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
							}
							add(
								$current,
								"constraints",
								lv_constraints_2_0,
								"org.eclipse.xtext.xbase.Xtype.JvmUpperBound");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0());
						}
						lv_constraints_3_0=ruleJvmUpperBoundAnded
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
							}
							add(
								$current,
								"constraints",
								lv_constraints_3_0,
								"org.eclipse.xtext.xbase.Xtype.JvmUpperBoundAnded");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
			    |
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0_0());
						}
						lv_constraints_4_0=ruleJvmLowerBound
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
							}
							add(
								$current,
								"constraints",
								lv_constraints_4_0,
								"org.eclipse.xtext.xbase.Xtype.JvmLowerBound");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0());
						}
						lv_constraints_5_0=ruleJvmLowerBoundAnded
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
							}
							add(
								$current,
								"constraints",
								lv_constraints_5_0,
								"org.eclipse.xtext.xbase.Xtype.JvmLowerBoundAnded");
							afterParserOrEnumRuleCall();
						}
					)
				)*
			)
		)?
	)
;

// Entry rule entryRuleJvmUpperBound
entryRuleJvmUpperBound returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJvmUpperBoundRule()); }
	iv_ruleJvmUpperBound=ruleJvmUpperBound
	{ $current=$iv_ruleJvmUpperBound.current; }
	EOF;

// Rule JvmUpperBound
ruleJvmUpperBound returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='extends'
		{
			newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
				}
				lv_typeReference_1_0=ruleJvmTypeReference
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getJvmUpperBoundRule());
					}
					set(
						$current,
						"typeReference",
						lv_typeReference_1_0,
						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleJvmUpperBoundAnded
entryRuleJvmUpperBoundAnded returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJvmUpperBoundAndedRule()); }
	iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded
	{ $current=$iv_ruleJvmUpperBoundAnded.current; }
	EOF;

// Rule JvmUpperBoundAnded
ruleJvmUpperBoundAnded returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='&'
		{
			newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
				}
				lv_typeReference_1_0=ruleJvmTypeReference
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getJvmUpperBoundAndedRule());
					}
					set(
						$current,
						"typeReference",
						lv_typeReference_1_0,
						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleJvmLowerBound
entryRuleJvmLowerBound returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJvmLowerBoundRule()); }
	iv_ruleJvmLowerBound=ruleJvmLowerBound
	{ $current=$iv_ruleJvmLowerBound.current; }
	EOF;

// Rule JvmLowerBound
ruleJvmLowerBound returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='super'
		{
			newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
				}
				lv_typeReference_1_0=ruleJvmTypeReference
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getJvmLowerBoundRule());
					}
					set(
						$current,
						"typeReference",
						lv_typeReference_1_0,
						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleJvmLowerBoundAnded
entryRuleJvmLowerBoundAnded returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJvmLowerBoundAndedRule()); }
	iv_ruleJvmLowerBoundAnded=ruleJvmLowerBoundAnded
	{ $current=$iv_ruleJvmLowerBoundAnded.current; }
	EOF;

// Rule JvmLowerBoundAnded
ruleJvmLowerBoundAnded returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='&'
		{
			newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAndedAccess().getAmpersandKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getJvmLowerBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
				}
				lv_typeReference_1_0=ruleJvmTypeReference
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getJvmLowerBoundAndedRule());
					}
					set(
						$current,
						"typeReference",
						lv_typeReference_1_0,
						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleQualifiedName
entryRuleQualifiedName returns [String current=null]:
	{ newCompositeNode(grammarAccess.getQualifiedNameRule()); }
	iv_ruleQualifiedName=ruleQualifiedName
	{ $current=$iv_ruleQualifiedName.current.getText(); }
	EOF;

// Rule QualifiedName
ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0());
		}
		this_ValidID_0=ruleValidID
		{
			$current.merge(this_ValidID_0);
		}
		{
			afterParserOrEnumRuleCall();
		}
		(
			kw='.'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
			}
			{
				newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1());
			}
			this_ValidID_2=ruleValidID
			{
				$current.merge(this_ValidID_2);
			}
			{
				afterParserOrEnumRuleCall();
			}
		)*
	)
;

// Entry rule entryRuleQualifiedNameWithWildcard
entryRuleQualifiedNameWithWildcard returns [String current=null]:
	{ newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); }
	iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard
	{ $current=$iv_ruleQualifiedNameWithWildcard.current.getText(); }
	EOF;

// Rule QualifiedNameWithWildcard
ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0());
		}
		this_QualifiedName_0=ruleQualifiedName
		{
			$current.merge(this_QualifiedName_0);
		}
		{
			afterParserOrEnumRuleCall();
		}
		kw='.'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopKeyword_1());
		}
		kw='*'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getAsteriskKeyword_2());
		}
	)
;

// Entry rule entryRuleValidID
entryRuleValidID returns [String current=null]:
	{ newCompositeNode(grammarAccess.getValidIDRule()); }
	iv_ruleValidID=ruleValidID
	{ $current=$iv_ruleValidID.current.getText(); }
	EOF;

// Rule ValidID
ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_ID_0=RULE_ID
	{
		$current.merge(this_ID_0);
	}
	{
		newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall());
	}
;

// Entry rule entryRuleXImportDeclaration
entryRuleXImportDeclaration returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getXImportDeclarationRule()); }
	iv_ruleXImportDeclaration=ruleXImportDeclaration
	{ $current=$iv_ruleXImportDeclaration.current; }
	EOF;

// Rule XImportDeclaration
ruleXImportDeclaration returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='import'
		{
			newLeafNode(otherlv_0, grammarAccess.getXImportDeclarationAccess().getImportKeyword_0());
		}
		(
			(
				(
					(
						lv_static_1_0='static'
						{
							newLeafNode(lv_static_1_0, grammarAccess.getXImportDeclarationAccess().getStaticStaticKeyword_1_0_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getXImportDeclarationRule());
							}
							setWithLastConsumed($current, "static", true, "static");
						}
					)
				)
				(
					(
						lv_extension_2_0='extension'
						{
							newLeafNode(lv_extension_2_0, grammarAccess.getXImportDeclarationAccess().getExtensionExtensionKeyword_1_0_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getXImportDeclarationRule());
							}
							setWithLastConsumed($current, "extension", true, "extension");
						}
					)
				)?
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getXImportDeclarationRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0());
						}
						ruleQualifiedNameInStaticImport
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						(
							lv_wildcard_4_0='*'
							{
								newLeafNode(lv_wildcard_4_0, grammarAccess.getXImportDeclarationAccess().getWildcardAsteriskKeyword_1_0_3_0_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getXImportDeclarationRule());
								}
								setWithLastConsumed($current, "wildcard", true, "*");
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getXImportDeclarationAccess().getMemberNameValidIDParserRuleCall_1_0_3_1_0());
							}
							lv_memberName_5_0=ruleValidID
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getXImportDeclarationRule());
								}
								set(
									$current,
									"memberName",
									lv_memberName_5_0,
									"org.eclipse.xtext.xbase.Xtype.ValidID");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)
			)
			    |
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getXImportDeclarationRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_1_0());
					}
					ruleQualifiedName
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0());
					}
					lv_importedNamespace_7_0=ruleQualifiedNameWithWildcard
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getXImportDeclarationRule());
						}
						set(
							$current,
							"importedNamespace",
							lv_importedNamespace_7_0,
							"org.eclipse.xtext.xbase.Xtype.QualifiedNameWithWildcard");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		(
			otherlv_8=';'
			{
				newLeafNode(otherlv_8, grammarAccess.getXImportDeclarationAccess().getSemicolonKeyword_2());
			}
		)?
	)
;

// Entry rule entryRuleQualifiedNameInStaticImport
entryRuleQualifiedNameInStaticImport returns [String current=null]:
	{ newCompositeNode(grammarAccess.getQualifiedNameInStaticImportRule()); }
	iv_ruleQualifiedNameInStaticImport=ruleQualifiedNameInStaticImport
	{ $current=$iv_ruleQualifiedNameInStaticImport.current.getText(); }
	EOF;

// Rule QualifiedNameInStaticImport
ruleQualifiedNameInStaticImport returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getQualifiedNameInStaticImportAccess().getValidIDParserRuleCall_0());
		}
		this_ValidID_0=ruleValidID
		{
			$current.merge(this_ValidID_0);
		}
		{
			afterParserOrEnumRuleCall();
		}
		kw='.'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQualifiedNameInStaticImportAccess().getFullStopKeyword_1());
		}
	)+
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'$'|'_') ('a'..'z'|'A'..'Z'|'$'|'_'|'0'..'9')*;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'?|'\'' ('\\' .|~(('\\'|'\'')))* '\''?);

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
