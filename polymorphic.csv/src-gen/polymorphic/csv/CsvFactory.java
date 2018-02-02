/**
 * generated by Xtext 2.13.0
 */
package polymorphic.csv;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see polymorphic.csv.CsvPackage
 * @generated
 */
public interface CsvFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CsvFactory eINSTANCE = polymorphic.csv.impl.CsvFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint</em>'.
   * @generated
   */
  Constraint createConstraint();

  /**
   * Returns a new object of class '<em>Language</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Language</em>'.
   * @generated
   */
  Language createLanguage();

  /**
   * Returns a new object of class '<em>Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Action</em>'.
   * @generated
   */
  Action createAction();

  /**
   * Returns a new object of class '<em>Open CSV</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Open CSV</em>'.
   * @generated
   */
  OpenCSV createOpenCSV();

  /**
   * Returns a new object of class '<em>Ref Open Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ref Open Action</em>'.
   * @generated
   */
  RefOpenAction createRefOpenAction();

  /**
   * Returns a new object of class '<em>Print CSV</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Print CSV</em>'.
   * @generated
   */
  PrintCSV createPrintCSV();

  /**
   * Returns a new object of class '<em>Nb Row</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Nb Row</em>'.
   * @generated
   */
  NbRow createNbRow();

  /**
   * Returns a new object of class '<em>Save CSV</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Save CSV</em>'.
   * @generated
   */
  SaveCSV createSaveCSV();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  CsvPackage getCsvPackage();

} //CsvFactory
