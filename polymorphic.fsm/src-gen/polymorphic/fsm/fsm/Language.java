/**
 * generated by Xtext 2.13.0
 */
package polymorphic.fsm.fsm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Language</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link polymorphic.fsm.fsm.Language#getName <em>Name</em>}</li>
 *   <li>{@link polymorphic.fsm.fsm.Language#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see polymorphic.fsm.fsm.FsmPackage#getLanguage()
 * @model
 * @generated
 */
public interface Language extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see polymorphic.fsm.fsm.FsmPackage#getLanguage_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link polymorphic.fsm.fsm.Language#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' attribute.
   * @see #setTarget(String)
   * @see polymorphic.fsm.fsm.FsmPackage#getLanguage_Target()
   * @model
   * @generated
   */
  String getTarget();

  /**
   * Sets the value of the '{@link polymorphic.fsm.fsm.Language#getTarget <em>Target</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' attribute.
   * @see #getTarget()
   * @generated
   */
  void setTarget(String value);

} // Language
