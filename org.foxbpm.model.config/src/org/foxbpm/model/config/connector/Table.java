/**
 */
package org.foxbpm.model.config.connector;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.connector.Table#getColsCaption <em>Cols Caption</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.Table#getCols <em>Cols</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.Table#getFixedCols <em>Fixed Cols</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.connector.ConnectorPackage#getTable()
 * @model extendedMetaData="name='table'"
 * @generated
 */
public interface Table extends Widget {
	/**
	 * Returns the value of the '<em><b>Cols Caption</b></em>' containment reference list.
	 * The list contents are of type {@link org.foxbpm.model.config.connector.ColsCaption}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cols Caption</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cols Caption</em>' containment reference list.
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getTable_ColsCaption()
	 * @model containment="true"
	 *        extendedMetaData="name='colsCaption' kind='element'"
	 * @generated
	 */
	EList<ColsCaption> getColsCaption();

	/**
	 * Returns the value of the '<em><b>Cols</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cols</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cols</em>' attribute.
	 * @see #setCols(int)
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getTable_Cols()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	int getCols();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connector.Table#getCols <em>Cols</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cols</em>' attribute.
	 * @see #getCols()
	 * @generated
	 */
	void setCols(int value);

	/**
	 * Returns the value of the '<em><b>Fixed Cols</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fixed Cols</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fixed Cols</em>' attribute.
	 * @see #setFixedCols(String)
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getTable_FixedCols()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getFixedCols();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connector.Table#getFixedCols <em>Fixed Cols</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fixed Cols</em>' attribute.
	 * @see #getFixedCols()
	 * @generated
	 */
	void setFixedCols(String value);

} // Table
