/**
 * generated by Xtext 2.13.0
 */
package polymorphic.csv;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Open CSV</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link polymorphic.csv.OpenCSV#getFile <em>File</em>}</li>
 * </ul>
 *
 * @see polymorphic.csv.CsvPackage#getOpenCSV()
 * @model
 * @generated
 */
public interface OpenCSV extends Actions
{
  /**
   * Returns the value of the '<em><b>File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>File</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>File</em>' attribute.
   * @see #setFile(String)
   * @see polymorphic.csv.CsvPackage#getOpenCSV_File()
   * @model
   * @generated
   */
  String getFile();

  /**
   * Sets the value of the '{@link polymorphic.csv.OpenCSV#getFile <em>File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>File</em>' attribute.
   * @see #getFile()
   * @generated
   */
  void setFile(String value);

} // OpenCSV
