/**
 * generated by Xtext 2.13.0
 */
package polymorphic.csv;

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
 * @see polymorphic.csv.CsvFactory
 * @model kind="package"
 * @generated
 */
public interface CsvPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "csv";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.Csv.polymorphic";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "csv";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CsvPackage eINSTANCE = polymorphic.csv.impl.CsvPackageImpl.init();

  /**
   * The meta object id for the '{@link polymorphic.csv.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see polymorphic.csv.impl.ModelImpl
   * @see polymorphic.csv.impl.CsvPackageImpl#getModel()
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
   * The feature id for the '<em><b>Actions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ACTIONS = 3;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link polymorphic.csv.impl.ConstraintImpl <em>Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see polymorphic.csv.impl.ConstraintImpl
   * @see polymorphic.csv.impl.CsvPackageImpl#getConstraint()
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
   * The meta object id for the '{@link polymorphic.csv.impl.LanguageImpl <em>Language</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see polymorphic.csv.impl.LanguageImpl
   * @see polymorphic.csv.impl.CsvPackageImpl#getLanguage()
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
   * The meta object id for the '{@link polymorphic.csv.impl.ActionsImpl <em>Actions</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see polymorphic.csv.impl.ActionsImpl
   * @see polymorphic.csv.impl.CsvPackageImpl#getActions()
   * @generated
   */
  int ACTIONS = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIONS__NAME = 0;

  /**
   * The number of structural features of the '<em>Actions</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIONS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link polymorphic.csv.impl.OpenCSVImpl <em>Open CSV</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see polymorphic.csv.impl.OpenCSVImpl
   * @see polymorphic.csv.impl.CsvPackageImpl#getOpenCSV()
   * @generated
   */
  int OPEN_CSV = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPEN_CSV__NAME = ACTIONS__NAME;

  /**
   * The feature id for the '<em><b>File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPEN_CSV__FILE = ACTIONS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Open CSV</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPEN_CSV_FEATURE_COUNT = ACTIONS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link polymorphic.csv.impl.PrintCSVImpl <em>Print CSV</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see polymorphic.csv.impl.PrintCSVImpl
   * @see polymorphic.csv.impl.CsvPackageImpl#getPrintCSV()
   * @generated
   */
  int PRINT_CSV = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRINT_CSV__NAME = ACTIONS__NAME;

  /**
   * The number of structural features of the '<em>Print CSV</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRINT_CSV_FEATURE_COUNT = ACTIONS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link polymorphic.csv.impl.SaveCSVImpl <em>Save CSV</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see polymorphic.csv.impl.SaveCSVImpl
   * @see polymorphic.csv.impl.CsvPackageImpl#getSaveCSV()
   * @generated
   */
  int SAVE_CSV = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAVE_CSV__NAME = ACTIONS__NAME;

  /**
   * The feature id for the '<em><b>File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAVE_CSV__FILE = ACTIONS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Save CSV</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAVE_CSV_FEATURE_COUNT = ACTIONS_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link polymorphic.csv.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see polymorphic.csv.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute '{@link polymorphic.csv.Model#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see polymorphic.csv.Model#getName()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Name();

  /**
   * Returns the meta object for the containment reference list '{@link polymorphic.csv.Model#getConstraints <em>Constraints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraints</em>'.
   * @see polymorphic.csv.Model#getConstraints()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Constraints();

  /**
   * Returns the meta object for the containment reference list '{@link polymorphic.csv.Model#getLanguages <em>Languages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Languages</em>'.
   * @see polymorphic.csv.Model#getLanguages()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Languages();

  /**
   * Returns the meta object for the containment reference list '{@link polymorphic.csv.Model#getActions <em>Actions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Actions</em>'.
   * @see polymorphic.csv.Model#getActions()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Actions();

  /**
   * Returns the meta object for class '{@link polymorphic.csv.Constraint <em>Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constraint</em>'.
   * @see polymorphic.csv.Constraint
   * @generated
   */
  EClass getConstraint();

  /**
   * Returns the meta object for the attribute '{@link polymorphic.csv.Constraint#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see polymorphic.csv.Constraint#getName()
   * @see #getConstraint()
   * @generated
   */
  EAttribute getConstraint_Name();

  /**
   * Returns the meta object for the attribute '{@link polymorphic.csv.Constraint#isTrue <em>True</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>True</em>'.
   * @see polymorphic.csv.Constraint#isTrue()
   * @see #getConstraint()
   * @generated
   */
  EAttribute getConstraint_True();

  /**
   * Returns the meta object for class '{@link polymorphic.csv.Language <em>Language</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Language</em>'.
   * @see polymorphic.csv.Language
   * @generated
   */
  EClass getLanguage();

  /**
   * Returns the meta object for the attribute '{@link polymorphic.csv.Language#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see polymorphic.csv.Language#getName()
   * @see #getLanguage()
   * @generated
   */
  EAttribute getLanguage_Name();

  /**
   * Returns the meta object for the attribute '{@link polymorphic.csv.Language#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target</em>'.
   * @see polymorphic.csv.Language#getTarget()
   * @see #getLanguage()
   * @generated
   */
  EAttribute getLanguage_Target();

  /**
   * Returns the meta object for class '{@link polymorphic.csv.Actions <em>Actions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Actions</em>'.
   * @see polymorphic.csv.Actions
   * @generated
   */
  EClass getActions();

  /**
   * Returns the meta object for the attribute '{@link polymorphic.csv.Actions#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see polymorphic.csv.Actions#getName()
   * @see #getActions()
   * @generated
   */
  EAttribute getActions_Name();

  /**
   * Returns the meta object for class '{@link polymorphic.csv.OpenCSV <em>Open CSV</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Open CSV</em>'.
   * @see polymorphic.csv.OpenCSV
   * @generated
   */
  EClass getOpenCSV();

  /**
   * Returns the meta object for the attribute '{@link polymorphic.csv.OpenCSV#getFile <em>File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File</em>'.
   * @see polymorphic.csv.OpenCSV#getFile()
   * @see #getOpenCSV()
   * @generated
   */
  EAttribute getOpenCSV_File();

  /**
   * Returns the meta object for class '{@link polymorphic.csv.PrintCSV <em>Print CSV</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Print CSV</em>'.
   * @see polymorphic.csv.PrintCSV
   * @generated
   */
  EClass getPrintCSV();

  /**
   * Returns the meta object for class '{@link polymorphic.csv.SaveCSV <em>Save CSV</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Save CSV</em>'.
   * @see polymorphic.csv.SaveCSV
   * @generated
   */
  EClass getSaveCSV();

  /**
   * Returns the meta object for the attribute '{@link polymorphic.csv.SaveCSV#getFile <em>File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File</em>'.
   * @see polymorphic.csv.SaveCSV#getFile()
   * @see #getSaveCSV()
   * @generated
   */
  EAttribute getSaveCSV_File();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  CsvFactory getCsvFactory();

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
     * The meta object literal for the '{@link polymorphic.csv.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see polymorphic.csv.impl.ModelImpl
     * @see polymorphic.csv.impl.CsvPackageImpl#getModel()
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
     * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__ACTIONS = eINSTANCE.getModel_Actions();

    /**
     * The meta object literal for the '{@link polymorphic.csv.impl.ConstraintImpl <em>Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see polymorphic.csv.impl.ConstraintImpl
     * @see polymorphic.csv.impl.CsvPackageImpl#getConstraint()
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
     * The meta object literal for the '{@link polymorphic.csv.impl.LanguageImpl <em>Language</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see polymorphic.csv.impl.LanguageImpl
     * @see polymorphic.csv.impl.CsvPackageImpl#getLanguage()
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
     * The meta object literal for the '{@link polymorphic.csv.impl.ActionsImpl <em>Actions</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see polymorphic.csv.impl.ActionsImpl
     * @see polymorphic.csv.impl.CsvPackageImpl#getActions()
     * @generated
     */
    EClass ACTIONS = eINSTANCE.getActions();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACTIONS__NAME = eINSTANCE.getActions_Name();

    /**
     * The meta object literal for the '{@link polymorphic.csv.impl.OpenCSVImpl <em>Open CSV</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see polymorphic.csv.impl.OpenCSVImpl
     * @see polymorphic.csv.impl.CsvPackageImpl#getOpenCSV()
     * @generated
     */
    EClass OPEN_CSV = eINSTANCE.getOpenCSV();

    /**
     * The meta object literal for the '<em><b>File</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPEN_CSV__FILE = eINSTANCE.getOpenCSV_File();

    /**
     * The meta object literal for the '{@link polymorphic.csv.impl.PrintCSVImpl <em>Print CSV</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see polymorphic.csv.impl.PrintCSVImpl
     * @see polymorphic.csv.impl.CsvPackageImpl#getPrintCSV()
     * @generated
     */
    EClass PRINT_CSV = eINSTANCE.getPrintCSV();

    /**
     * The meta object literal for the '{@link polymorphic.csv.impl.SaveCSVImpl <em>Save CSV</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see polymorphic.csv.impl.SaveCSVImpl
     * @see polymorphic.csv.impl.CsvPackageImpl#getSaveCSV()
     * @generated
     */
    EClass SAVE_CSV = eINSTANCE.getSaveCSV();

    /**
     * The meta object literal for the '<em><b>File</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SAVE_CSV__FILE = eINSTANCE.getSaveCSV_File();

  }

} //CsvPackage
