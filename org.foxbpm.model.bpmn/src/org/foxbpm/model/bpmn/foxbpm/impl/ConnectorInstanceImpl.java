/**
 */
package org.foxbpm.model.bpmn.foxbpm.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.foxbpm.model.bpmn.foxbpm.ConnectorInstance;
import org.foxbpm.model.bpmn.foxbpm.ConnectorParameterInput;
import org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutput;
import org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutputDef;
import org.foxbpm.model.bpmn.foxbpm.Documentation;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;
import org.foxbpm.model.bpmn.foxbpm.SkipComment;
import org.foxbpm.model.bpmn.foxbpm.TimeExpression;
import org.foxbpm.model.bpmn.foxbpm.TimeSkipExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connector Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceImpl#getConnectorId <em>Connector Id</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceImpl#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceImpl#getConnectorInstanceId <em>Connector Instance Id</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceImpl#getConnectorInstanceName <em>Connector Instance Name</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceImpl#getEventType <em>Event Type</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceImpl#getErrorHandling <em>Error Handling</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceImpl#getErrorCode <em>Error Code</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceImpl#getConnectorParameterInputs <em>Connector Parameter Inputs</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceImpl#getConnectorParameterOutputs <em>Connector Parameter Outputs</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceImpl#getConnectorParameterOutputsDef <em>Connector Parameter Outputs Def</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceImpl#getSkipComment <em>Skip Comment</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceImpl#getTimeExpression <em>Time Expression</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceImpl#isIsTimeExecute <em>Is Time Execute</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceImpl#getTimeSkipExpression <em>Time Skip Expression</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceImpl#getDocumentation <em>Documentation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectorInstanceImpl extends MinimalEObjectImpl.Container implements ConnectorInstance {
	/**
	 * The default value of the '{@link #getConnectorId() <em>Connector Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectorId()
	 * @generated
	 * @ordered
	 */
	protected static final String CONNECTOR_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConnectorId() <em>Connector Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectorId()
	 * @generated
	 * @ordered
	 */
	protected String connectorId = CONNECTOR_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getPackageName() <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageName()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPackageName() <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageName()
	 * @generated
	 * @ordered
	 */
	protected String packageName = PACKAGE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected String className = CLASS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getConnectorInstanceId() <em>Connector Instance Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectorInstanceId()
	 * @generated
	 * @ordered
	 */
	protected static final String CONNECTOR_INSTANCE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConnectorInstanceId() <em>Connector Instance Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectorInstanceId()
	 * @generated
	 * @ordered
	 */
	protected String connectorInstanceId = CONNECTOR_INSTANCE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getConnectorInstanceName() <em>Connector Instance Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectorInstanceName()
	 * @generated
	 * @ordered
	 */
	protected static final String CONNECTOR_INSTANCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConnectorInstanceName() <em>Connector Instance Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectorInstanceName()
	 * @generated
	 * @ordered
	 */
	protected String connectorInstanceName = CONNECTOR_INSTANCE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getEventType() <em>Event Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventType()
	 * @generated
	 * @ordered
	 */
	protected static final String EVENT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEventType() <em>Event Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventType()
	 * @generated
	 * @ordered
	 */
	protected String eventType = EVENT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getErrorHandling() <em>Error Handling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorHandling()
	 * @generated
	 * @ordered
	 */
	protected static final String ERROR_HANDLING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getErrorHandling() <em>Error Handling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorHandling()
	 * @generated
	 * @ordered
	 */
	protected String errorHandling = ERROR_HANDLING_EDEFAULT;

	/**
	 * The default value of the '{@link #getErrorCode() <em>Error Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorCode()
	 * @generated
	 * @ordered
	 */
	protected static final String ERROR_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getErrorCode() <em>Error Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorCode()
	 * @generated
	 * @ordered
	 */
	protected String errorCode = ERROR_CODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConnectorParameterInputs() <em>Connector Parameter Inputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectorParameterInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectorParameterInput> connectorParameterInputs;

	/**
	 * The cached value of the '{@link #getConnectorParameterOutputs() <em>Connector Parameter Outputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectorParameterOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectorParameterOutput> connectorParameterOutputs;

	/**
	 * The cached value of the '{@link #getConnectorParameterOutputsDef() <em>Connector Parameter Outputs Def</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectorParameterOutputsDef()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectorParameterOutputDef> connectorParameterOutputsDef;

	/**
	 * The cached value of the '{@link #getSkipComment() <em>Skip Comment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSkipComment()
	 * @generated
	 * @ordered
	 */
	protected SkipComment skipComment;

	/**
	 * The cached value of the '{@link #getTimeExpression() <em>Time Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeExpression()
	 * @generated
	 * @ordered
	 */
	protected TimeExpression timeExpression;

	/**
	 * The default value of the '{@link #isIsTimeExecute() <em>Is Time Execute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTimeExecute()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_TIME_EXECUTE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsTimeExecute() <em>Is Time Execute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTimeExecute()
	 * @generated
	 * @ordered
	 */
	protected boolean isTimeExecute = IS_TIME_EXECUTE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTimeSkipExpression() <em>Time Skip Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeSkipExpression()
	 * @generated
	 * @ordered
	 */
	protected TimeSkipExpression timeSkipExpression;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDocumentation() <em>Documentation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentation()
	 * @generated
	 * @ordered
	 */
	protected Documentation documentation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectorInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoxBPMPackage.Literals.CONNECTOR_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConnectorId() {
		return connectorId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectorId(String newConnectorId) {
		String oldConnectorId = connectorId;
		connectorId = newConnectorId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_ID, oldConnectorId, connectorId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackageName(String newPackageName) {
		String oldPackageName = packageName;
		packageName = newPackageName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.CONNECTOR_INSTANCE__PACKAGE_NAME, oldPackageName, packageName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassName(String newClassName) {
		String oldClassName = className;
		className = newClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.CONNECTOR_INSTANCE__CLASS_NAME, oldClassName, className));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConnectorInstanceId() {
		return connectorInstanceId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectorInstanceId(String newConnectorInstanceId) {
		String oldConnectorInstanceId = connectorInstanceId;
		connectorInstanceId = newConnectorInstanceId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_INSTANCE_ID, oldConnectorInstanceId, connectorInstanceId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConnectorInstanceName() {
		return connectorInstanceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectorInstanceName(String newConnectorInstanceName) {
		String oldConnectorInstanceName = connectorInstanceName;
		connectorInstanceName = newConnectorInstanceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_INSTANCE_NAME, oldConnectorInstanceName, connectorInstanceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEventType() {
		return eventType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventType(String newEventType) {
		String oldEventType = eventType;
		eventType = newEventType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.CONNECTOR_INSTANCE__EVENT_TYPE, oldEventType, eventType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Documentation getDocumentation() {
		return documentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDocumentation(Documentation newDocumentation, NotificationChain msgs) {
		Documentation oldDocumentation = documentation;
		documentation = newDocumentation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FoxBPMPackage.CONNECTOR_INSTANCE__DOCUMENTATION, oldDocumentation, newDocumentation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDocumentation(Documentation newDocumentation) {
		if (newDocumentation != documentation) {
			NotificationChain msgs = null;
			if (documentation != null)
				msgs = ((InternalEObject)documentation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FoxBPMPackage.CONNECTOR_INSTANCE__DOCUMENTATION, null, msgs);
			if (newDocumentation != null)
				msgs = ((InternalEObject)newDocumentation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FoxBPMPackage.CONNECTOR_INSTANCE__DOCUMENTATION, null, msgs);
			msgs = basicSetDocumentation(newDocumentation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.CONNECTOR_INSTANCE__DOCUMENTATION, newDocumentation, newDocumentation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getErrorHandling() {
		return errorHandling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrorHandling(String newErrorHandling) {
		String oldErrorHandling = errorHandling;
		errorHandling = newErrorHandling;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.CONNECTOR_INSTANCE__ERROR_HANDLING, oldErrorHandling, errorHandling));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrorCode(String newErrorCode) {
		String oldErrorCode = errorCode;
		errorCode = newErrorCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.CONNECTOR_INSTANCE__ERROR_CODE, oldErrorCode, errorCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConnectorParameterInput> getConnectorParameterInputs() {
		if (connectorParameterInputs == null) {
			connectorParameterInputs = new EObjectContainmentEList<ConnectorParameterInput>(ConnectorParameterInput.class, this, FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_INPUTS);
		}
		return connectorParameterInputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConnectorParameterOutput> getConnectorParameterOutputs() {
		if (connectorParameterOutputs == null) {
			connectorParameterOutputs = new EObjectContainmentEList<ConnectorParameterOutput>(ConnectorParameterOutput.class, this, FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_OUTPUTS);
		}
		return connectorParameterOutputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConnectorParameterOutputDef> getConnectorParameterOutputsDef() {
		if (connectorParameterOutputsDef == null) {
			connectorParameterOutputsDef = new EObjectContainmentEList<ConnectorParameterOutputDef>(ConnectorParameterOutputDef.class, this, FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_OUTPUTS_DEF);
		}
		return connectorParameterOutputsDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SkipComment getSkipComment() {
		return skipComment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSkipComment(SkipComment newSkipComment, NotificationChain msgs) {
		SkipComment oldSkipComment = skipComment;
		skipComment = newSkipComment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FoxBPMPackage.CONNECTOR_INSTANCE__SKIP_COMMENT, oldSkipComment, newSkipComment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSkipComment(SkipComment newSkipComment) {
		if (newSkipComment != skipComment) {
			NotificationChain msgs = null;
			if (skipComment != null)
				msgs = ((InternalEObject)skipComment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FoxBPMPackage.CONNECTOR_INSTANCE__SKIP_COMMENT, null, msgs);
			if (newSkipComment != null)
				msgs = ((InternalEObject)newSkipComment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FoxBPMPackage.CONNECTOR_INSTANCE__SKIP_COMMENT, null, msgs);
			msgs = basicSetSkipComment(newSkipComment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.CONNECTOR_INSTANCE__SKIP_COMMENT, newSkipComment, newSkipComment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeExpression getTimeExpression() {
		return timeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimeExpression(TimeExpression newTimeExpression, NotificationChain msgs) {
		TimeExpression oldTimeExpression = timeExpression;
		timeExpression = newTimeExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FoxBPMPackage.CONNECTOR_INSTANCE__TIME_EXPRESSION, oldTimeExpression, newTimeExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeExpression(TimeExpression newTimeExpression) {
		if (newTimeExpression != timeExpression) {
			NotificationChain msgs = null;
			if (timeExpression != null)
				msgs = ((InternalEObject)timeExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FoxBPMPackage.CONNECTOR_INSTANCE__TIME_EXPRESSION, null, msgs);
			if (newTimeExpression != null)
				msgs = ((InternalEObject)newTimeExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FoxBPMPackage.CONNECTOR_INSTANCE__TIME_EXPRESSION, null, msgs);
			msgs = basicSetTimeExpression(newTimeExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.CONNECTOR_INSTANCE__TIME_EXPRESSION, newTimeExpression, newTimeExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsTimeExecute() {
		return isTimeExecute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsTimeExecute(boolean newIsTimeExecute) {
		boolean oldIsTimeExecute = isTimeExecute;
		isTimeExecute = newIsTimeExecute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.CONNECTOR_INSTANCE__IS_TIME_EXECUTE, oldIsTimeExecute, isTimeExecute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeSkipExpression getTimeSkipExpression() {
		return timeSkipExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimeSkipExpression(TimeSkipExpression newTimeSkipExpression, NotificationChain msgs) {
		TimeSkipExpression oldTimeSkipExpression = timeSkipExpression;
		timeSkipExpression = newTimeSkipExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FoxBPMPackage.CONNECTOR_INSTANCE__TIME_SKIP_EXPRESSION, oldTimeSkipExpression, newTimeSkipExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeSkipExpression(TimeSkipExpression newTimeSkipExpression) {
		if (newTimeSkipExpression != timeSkipExpression) {
			NotificationChain msgs = null;
			if (timeSkipExpression != null)
				msgs = ((InternalEObject)timeSkipExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FoxBPMPackage.CONNECTOR_INSTANCE__TIME_SKIP_EXPRESSION, null, msgs);
			if (newTimeSkipExpression != null)
				msgs = ((InternalEObject)newTimeSkipExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FoxBPMPackage.CONNECTOR_INSTANCE__TIME_SKIP_EXPRESSION, null, msgs);
			msgs = basicSetTimeSkipExpression(newTimeSkipExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.CONNECTOR_INSTANCE__TIME_SKIP_EXPRESSION, newTimeSkipExpression, newTimeSkipExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.CONNECTOR_INSTANCE__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.CONNECTOR_INSTANCE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_INPUTS:
				return ((InternalEList<?>)getConnectorParameterInputs()).basicRemove(otherEnd, msgs);
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_OUTPUTS:
				return ((InternalEList<?>)getConnectorParameterOutputs()).basicRemove(otherEnd, msgs);
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_OUTPUTS_DEF:
				return ((InternalEList<?>)getConnectorParameterOutputsDef()).basicRemove(otherEnd, msgs);
			case FoxBPMPackage.CONNECTOR_INSTANCE__SKIP_COMMENT:
				return basicSetSkipComment(null, msgs);
			case FoxBPMPackage.CONNECTOR_INSTANCE__TIME_EXPRESSION:
				return basicSetTimeExpression(null, msgs);
			case FoxBPMPackage.CONNECTOR_INSTANCE__TIME_SKIP_EXPRESSION:
				return basicSetTimeSkipExpression(null, msgs);
			case FoxBPMPackage.CONNECTOR_INSTANCE__DOCUMENTATION:
				return basicSetDocumentation(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_ID:
				return getConnectorId();
			case FoxBPMPackage.CONNECTOR_INSTANCE__PACKAGE_NAME:
				return getPackageName();
			case FoxBPMPackage.CONNECTOR_INSTANCE__CLASS_NAME:
				return getClassName();
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_INSTANCE_ID:
				return getConnectorInstanceId();
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_INSTANCE_NAME:
				return getConnectorInstanceName();
			case FoxBPMPackage.CONNECTOR_INSTANCE__EVENT_TYPE:
				return getEventType();
			case FoxBPMPackage.CONNECTOR_INSTANCE__ERROR_HANDLING:
				return getErrorHandling();
			case FoxBPMPackage.CONNECTOR_INSTANCE__ERROR_CODE:
				return getErrorCode();
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_INPUTS:
				return getConnectorParameterInputs();
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_OUTPUTS:
				return getConnectorParameterOutputs();
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_OUTPUTS_DEF:
				return getConnectorParameterOutputsDef();
			case FoxBPMPackage.CONNECTOR_INSTANCE__SKIP_COMMENT:
				return getSkipComment();
			case FoxBPMPackage.CONNECTOR_INSTANCE__TIME_EXPRESSION:
				return getTimeExpression();
			case FoxBPMPackage.CONNECTOR_INSTANCE__IS_TIME_EXECUTE:
				return isIsTimeExecute();
			case FoxBPMPackage.CONNECTOR_INSTANCE__TIME_SKIP_EXPRESSION:
				return getTimeSkipExpression();
			case FoxBPMPackage.CONNECTOR_INSTANCE__VERSION:
				return getVersion();
			case FoxBPMPackage.CONNECTOR_INSTANCE__TYPE:
				return getType();
			case FoxBPMPackage.CONNECTOR_INSTANCE__DOCUMENTATION:
				return getDocumentation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_ID:
				setConnectorId((String)newValue);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__PACKAGE_NAME:
				setPackageName((String)newValue);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__CLASS_NAME:
				setClassName((String)newValue);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_INSTANCE_ID:
				setConnectorInstanceId((String)newValue);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_INSTANCE_NAME:
				setConnectorInstanceName((String)newValue);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__EVENT_TYPE:
				setEventType((String)newValue);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__ERROR_HANDLING:
				setErrorHandling((String)newValue);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__ERROR_CODE:
				setErrorCode((String)newValue);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_INPUTS:
				getConnectorParameterInputs().clear();
				getConnectorParameterInputs().addAll((Collection<? extends ConnectorParameterInput>)newValue);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_OUTPUTS:
				getConnectorParameterOutputs().clear();
				getConnectorParameterOutputs().addAll((Collection<? extends ConnectorParameterOutput>)newValue);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_OUTPUTS_DEF:
				getConnectorParameterOutputsDef().clear();
				getConnectorParameterOutputsDef().addAll((Collection<? extends ConnectorParameterOutputDef>)newValue);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__SKIP_COMMENT:
				setSkipComment((SkipComment)newValue);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__TIME_EXPRESSION:
				setTimeExpression((TimeExpression)newValue);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__IS_TIME_EXECUTE:
				setIsTimeExecute((Boolean)newValue);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__TIME_SKIP_EXPRESSION:
				setTimeSkipExpression((TimeSkipExpression)newValue);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__VERSION:
				setVersion((String)newValue);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__TYPE:
				setType((String)newValue);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__DOCUMENTATION:
				setDocumentation((Documentation)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_ID:
				setConnectorId(CONNECTOR_ID_EDEFAULT);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__PACKAGE_NAME:
				setPackageName(PACKAGE_NAME_EDEFAULT);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__CLASS_NAME:
				setClassName(CLASS_NAME_EDEFAULT);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_INSTANCE_ID:
				setConnectorInstanceId(CONNECTOR_INSTANCE_ID_EDEFAULT);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_INSTANCE_NAME:
				setConnectorInstanceName(CONNECTOR_INSTANCE_NAME_EDEFAULT);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__EVENT_TYPE:
				setEventType(EVENT_TYPE_EDEFAULT);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__ERROR_HANDLING:
				setErrorHandling(ERROR_HANDLING_EDEFAULT);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__ERROR_CODE:
				setErrorCode(ERROR_CODE_EDEFAULT);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_INPUTS:
				getConnectorParameterInputs().clear();
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_OUTPUTS:
				getConnectorParameterOutputs().clear();
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_OUTPUTS_DEF:
				getConnectorParameterOutputsDef().clear();
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__SKIP_COMMENT:
				setSkipComment((SkipComment)null);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__TIME_EXPRESSION:
				setTimeExpression((TimeExpression)null);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__IS_TIME_EXECUTE:
				setIsTimeExecute(IS_TIME_EXECUTE_EDEFAULT);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__TIME_SKIP_EXPRESSION:
				setTimeSkipExpression((TimeSkipExpression)null);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE__DOCUMENTATION:
				setDocumentation((Documentation)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_ID:
				return CONNECTOR_ID_EDEFAULT == null ? connectorId != null : !CONNECTOR_ID_EDEFAULT.equals(connectorId);
			case FoxBPMPackage.CONNECTOR_INSTANCE__PACKAGE_NAME:
				return PACKAGE_NAME_EDEFAULT == null ? packageName != null : !PACKAGE_NAME_EDEFAULT.equals(packageName);
			case FoxBPMPackage.CONNECTOR_INSTANCE__CLASS_NAME:
				return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals(className);
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_INSTANCE_ID:
				return CONNECTOR_INSTANCE_ID_EDEFAULT == null ? connectorInstanceId != null : !CONNECTOR_INSTANCE_ID_EDEFAULT.equals(connectorInstanceId);
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_INSTANCE_NAME:
				return CONNECTOR_INSTANCE_NAME_EDEFAULT == null ? connectorInstanceName != null : !CONNECTOR_INSTANCE_NAME_EDEFAULT.equals(connectorInstanceName);
			case FoxBPMPackage.CONNECTOR_INSTANCE__EVENT_TYPE:
				return EVENT_TYPE_EDEFAULT == null ? eventType != null : !EVENT_TYPE_EDEFAULT.equals(eventType);
			case FoxBPMPackage.CONNECTOR_INSTANCE__ERROR_HANDLING:
				return ERROR_HANDLING_EDEFAULT == null ? errorHandling != null : !ERROR_HANDLING_EDEFAULT.equals(errorHandling);
			case FoxBPMPackage.CONNECTOR_INSTANCE__ERROR_CODE:
				return ERROR_CODE_EDEFAULT == null ? errorCode != null : !ERROR_CODE_EDEFAULT.equals(errorCode);
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_INPUTS:
				return connectorParameterInputs != null && !connectorParameterInputs.isEmpty();
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_OUTPUTS:
				return connectorParameterOutputs != null && !connectorParameterOutputs.isEmpty();
			case FoxBPMPackage.CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_OUTPUTS_DEF:
				return connectorParameterOutputsDef != null && !connectorParameterOutputsDef.isEmpty();
			case FoxBPMPackage.CONNECTOR_INSTANCE__SKIP_COMMENT:
				return skipComment != null;
			case FoxBPMPackage.CONNECTOR_INSTANCE__TIME_EXPRESSION:
				return timeExpression != null;
			case FoxBPMPackage.CONNECTOR_INSTANCE__IS_TIME_EXECUTE:
				return isTimeExecute != IS_TIME_EXECUTE_EDEFAULT;
			case FoxBPMPackage.CONNECTOR_INSTANCE__TIME_SKIP_EXPRESSION:
				return timeSkipExpression != null;
			case FoxBPMPackage.CONNECTOR_INSTANCE__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case FoxBPMPackage.CONNECTOR_INSTANCE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case FoxBPMPackage.CONNECTOR_INSTANCE__DOCUMENTATION:
				return documentation != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (connectorId: ");
		result.append(connectorId);
		result.append(", packageName: ");
		result.append(packageName);
		result.append(", className: ");
		result.append(className);
		result.append(", connectorInstanceId: ");
		result.append(connectorInstanceId);
		result.append(", connectorInstanceName: ");
		result.append(connectorInstanceName);
		result.append(", eventType: ");
		result.append(eventType);
		result.append(", errorHandling: ");
		result.append(errorHandling);
		result.append(", errorCode: ");
		result.append(errorCode);
		result.append(", isTimeExecute: ");
		result.append(isTimeExecute);
		result.append(", version: ");
		result.append(version);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //ConnectorInstanceImpl
