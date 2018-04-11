/**
 * generated by Xtext 2.13.0
 */
package polymorphic.fsm.fsm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see polymorphic.fsm.fsm.FsmFactory
 * @model kind="package"
 * @generated
 */
public interface FsmPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "fsm";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.fsm.polymorphic/Fsm";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "fsm";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FsmPackage eINSTANCE = polymorphic.fsm.fsm.impl.FsmPackageImpl.init();

  /**
   * The meta object id for the '{@link polymorphic.fsm.fsm.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see polymorphic.fsm.fsm.impl.ModelImpl
   * @see polymorphic.fsm.fsm.impl.FsmPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__NAME = 0;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__CONSTRAINTS = 1;

  /**
   * The feature id for the '<em><b>Languages</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__LANGUAGES = 2;

  /**
   * The feature id for the '<em><b>Machine</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__MACHINE = 3;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link polymorphic.fsm.fsm.impl.ConstraintImpl <em>Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see polymorphic.fsm.fsm.impl.ConstraintImpl
   * @see polymorphic.fsm.fsm.impl.FsmPackageImpl#getConstraint()
   * @generated
   */
  int CONSTRAINT = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT__NAME = 0;

  /**
   * The feature id for the '<em><b>True</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT__TRUE = 1;

  /**
   * The number of structural features of the '<em>Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link polymorphic.fsm.fsm.impl.LanguageImpl <em>Language</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see polymorphic.fsm.fsm.impl.LanguageImpl
   * @see polymorphic.fsm.fsm.impl.FsmPackageImpl#getLanguage()
   * @generated
   */
  int LANGUAGE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE__NAME = 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE__TARGET = 1;

  /**
   * The number of structural features of the '<em>Language</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link polymorphic.fsm.fsm.impl.MachineImpl <em>Machine</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see polymorphic.fsm.fsm.impl.MachineImpl
   * @see polymorphic.fsm.fsm.impl.FsmPackageImpl#getMachine()
   * @generated
   */
  int MACHINE = 3;

  /**
   * The feature id for the '<em><b>States</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACHINE__STATES = 0;

  /**
   * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACHINE__TRANSITIONS = 1;

  /**
   * The number of structural features of the '<em>Machine</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACHINE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link polymorphic.fsm.fsm.impl.StateImpl <em>State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see polymorphic.fsm.fsm.impl.StateImpl
   * @see polymorphic.fsm.fsm.impl.FsmPackageImpl#getState()
   * @generated
   */
  int STATE = 4;

  /**
   * The feature id for the '<em><b>Initial</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__INITIAL = 0;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__FINAL = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__NAME = 2;

  /**
   * The number of structural features of the '<em>State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link polymorphic.fsm.fsm.impl.TransitionImpl <em>Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see polymorphic.fsm.fsm.impl.TransitionImpl
   * @see polymorphic.fsm.fsm.impl.FsmPackageImpl#getTransition()
   * @generated
   */
  int TRANSITION = 5;

  /**
   * The feature id for the '<em><b>From</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__FROM = 0;

  /**
   * The feature id for the '<em><b>To</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__TO = 1;

  /**
   * The feature id for the '<em><b>Event</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__EVENT = 2;

  /**
   * The number of structural features of the '<em>Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_FEATURE_COUNT = 3;


  /**
   * Returns the meta object for class '{@link polymorphic.fsm.fsm.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see polymorphic.fsm.fsm.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute '{@link polymorphic.fsm.fsm.Model#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see polymorphic.fsm.fsm.Model#getName()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Name();

  /**
   * Returns the meta object for the containment reference list '{@link polymorphic.fsm.fsm.Model#getConstraints <em>Constraints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraints</em>'.
   * @see polymorphic.fsm.fsm.Model#getConstraints()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Constraints();

  /**
   * Returns the meta object for the containment reference list '{@link polymorphic.fsm.fsm.Model#getLanguages <em>Languages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Languages</em>'.
   * @see polymorphic.fsm.fsm.Model#getLanguages()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Languages();

  /**
   * Returns the meta object for the containment reference '{@link polymorphic.fsm.fsm.Model#getMachine <em>Machine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Machine</em>'.
   * @see polymorphic.fsm.fsm.Model#getMachine()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Machine();

  /**
   * Returns the meta object for class '{@link polymorphic.fsm.fsm.Constraint <em>Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constraint</em>'.
   * @see polymorphic.fsm.fsm.Constraint
   * @generated
   */
  EClass getConstraint();

  /**
   * Returns the meta object for the attribute '{@link polymorphic.fsm.fsm.Constraint#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see polymorphic.fsm.fsm.Constraint#getName()
   * @see #getConstraint()
   * @generated
   */
  EAttribute getConstraint_Name();

  /**
   * Returns the meta object for the attribute '{@link polymorphic.fsm.fsm.Constraint#isTrue <em>True</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>True</em>'.
   * @see polymorphic.fsm.fsm.Constraint#isTrue()
   * @see #getConstraint()
   * @generated
   */
  EAttribute getConstraint_True();

  /**
   * Returns the meta object for class '{@link polymorphic.fsm.fsm.Language <em>Language</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Language</em>'.
   * @see polymorphic.fsm.fsm.Language
   * @generated
   */
  EClass getLanguage();

  /**
   * Returns the meta object for the attribute '{@link polymorphic.fsm.fsm.Language#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see polymorphic.fsm.fsm.Language#getName()
   * @see #getLanguage()
   * @generated
   */
  EAttribute getLanguage_Name();

  /**
   * Returns the meta object for the attribute '{@link polymorphic.fsm.fsm.Language#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target</em>'.
   * @see polymorphic.fsm.fsm.Language#getTarget()
   * @see #getLanguage()
   * @generated
   */
  EAttribute getLanguage_Target();

  /**
   * Returns the meta object for class '{@link polymorphic.fsm.fsm.Machine <em>Machine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Machine</em>'.
   * @see polymorphic.fsm.fsm.Machine
   * @generated
   */
  EClass getMachine();

  /**
   * Returns the meta object for the containment reference list '{@link polymorphic.fsm.fsm.Machine#getStates <em>States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>States</em>'.
   * @see polymorphic.fsm.fsm.Machine#getStates()
   * @see #getMachine()
   * @generated
   */
  EReference getMachine_States();

  /**
   * Returns the meta object for the containment reference list '{@link polymorphic.fsm.fsm.Machine#getTransitions <em>Transitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transitions</em>'.
   * @see polymorphic.fsm.fsm.Machine#getTransitions()
   * @see #getMachine()
   * @generated
   */
  EReference getMachine_Transitions();

  /**
   * Returns the meta object for class '{@link polymorphic.fsm.fsm.State <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State</em>'.
   * @see polymorphic.fsm.fsm.State
   * @generated
   */
  EClass getState();

  /**
   * Returns the meta object for the attribute '{@link polymorphic.fsm.fsm.State#isInitial <em>Initial</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Initial</em>'.
   * @see polymorphic.fsm.fsm.State#isInitial()
   * @see #getState()
   * @generated
   */
  EAttribute getState_Initial();

  /**
   * Returns the meta object for the attribute '{@link polymorphic.fsm.fsm.State#isFinal <em>Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Final</em>'.
   * @see polymorphic.fsm.fsm.State#isFinal()
   * @see #getState()
   * @generated
   */
  EAttribute getState_Final();

  /**
   * Returns the meta object for the attribute '{@link polymorphic.fsm.fsm.State#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see polymorphic.fsm.fsm.State#getName()
   * @see #getState()
   * @generated
   */
  EAttribute getState_Name();

  /**
   * Returns the meta object for class '{@link polymorphic.fsm.fsm.Transition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition</em>'.
   * @see polymorphic.fsm.fsm.Transition
   * @generated
   */
  EClass getTransition();

  /**
   * Returns the meta object for the reference '{@link polymorphic.fsm.fsm.Transition#getFrom <em>From</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>From</em>'.
   * @see polymorphic.fsm.fsm.Transition#getFrom()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_From();

  /**
   * Returns the meta object for the reference '{@link polymorphic.fsm.fsm.Transition#getTo <em>To</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>To</em>'.
   * @see polymorphic.fsm.fsm.Transition#getTo()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_To();

  /**
   * Returns the meta object for the attribute '{@link polymorphic.fsm.fsm.Transition#getEvent <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Event</em>'.
   * @see polymorphic.fsm.fsm.Transition#getEvent()
   * @see #getTransition()
   * @generated
   */
  EAttribute getTransition_Event();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  FsmFactory getFsmFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link polymorphic.fsm.fsm.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see polymorphic.fsm.fsm.impl.ModelImpl
     * @see polymorphic.fsm.fsm.impl.FsmPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__NAME = eINSTANCE.getModel_Name();

    /**
     * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__CONSTRAINTS = eINSTANCE.getModel_Constraints();

    /**
     * The meta object literal for the '<em><b>Languages</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__LANGUAGES = eINSTANCE.getModel_Languages();

    /**
     * The meta object literal for the '<em><b>Machine</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__MACHINE = eINSTANCE.getModel_Machine();

    /**
     * The meta object literal for the '{@link polymorphic.fsm.fsm.impl.ConstraintImpl <em>Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see polymorphic.fsm.fsm.impl.ConstraintImpl
     * @see polymorphic.fsm.fsm.impl.FsmPackageImpl#getConstraint()
     * @generated
     */
    EClass CONSTRAINT = eINSTANCE.getConstraint();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTRAINT__NAME = eINSTANCE.getConstraint_Name();

    /**
     * The meta object literal for the '<em><b>True</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTRAINT__TRUE = eINSTANCE.getConstraint_True();

    /**
     * The meta object literal for the '{@link polymorphic.fsm.fsm.impl.LanguageImpl <em>Language</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see polymorphic.fsm.fsm.impl.LanguageImpl
     * @see polymorphic.fsm.fsm.impl.FsmPackageImpl#getLanguage()
     * @generated
     */
    EClass LANGUAGE = eINSTANCE.getLanguage();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LANGUAGE__NAME = eINSTANCE.getLanguage_Name();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LANGUAGE__TARGET = eINSTANCE.getLanguage_Target();

    /**
     * The meta object literal for the '{@link polymorphic.fsm.fsm.impl.MachineImpl <em>Machine</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see polymorphic.fsm.fsm.impl.MachineImpl
     * @see polymorphic.fsm.fsm.impl.FsmPackageImpl#getMachine()
     * @generated
     */
    EClass MACHINE = eINSTANCE.getMachine();

    /**
     * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACHINE__STATES = eINSTANCE.getMachine_States();

    /**
     * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACHINE__TRANSITIONS = eINSTANCE.getMachine_Transitions();

    /**
     * The meta object literal for the '{@link polymorphic.fsm.fsm.impl.StateImpl <em>State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see polymorphic.fsm.fsm.impl.StateImpl
     * @see polymorphic.fsm.fsm.impl.FsmPackageImpl#getState()
     * @generated
     */
    EClass STATE = eINSTANCE.getState();

    /**
     * The meta object literal for the '<em><b>Initial</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE__INITIAL = eINSTANCE.getState_Initial();

    /**
     * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE__FINAL = eINSTANCE.getState_Final();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE__NAME = eINSTANCE.getState_Name();

    /**
     * The meta object literal for the '{@link polymorphic.fsm.fsm.impl.TransitionImpl <em>Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see polymorphic.fsm.fsm.impl.TransitionImpl
     * @see polymorphic.fsm.fsm.impl.FsmPackageImpl#getTransition()
     * @generated
     */
    EClass TRANSITION = eINSTANCE.getTransition();

    /**
     * The meta object literal for the '<em><b>From</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__FROM = eINSTANCE.getTransition_From();

    /**
     * The meta object literal for the '<em><b>To</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__TO = eINSTANCE.getTransition_To();

    /**
     * The meta object literal for the '<em><b>Event</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSITION__EVENT = eINSTANCE.getTransition_Event();

  }

} //FsmPackage