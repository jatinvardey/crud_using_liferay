/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ignek.student.model.impl;

import com.ignek.student.model.student;
import com.ignek.student.model.studentModel;
import com.ignek.student.model.studentSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the student service. Represents a row in the &quot;stud_student&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>studentModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link studentImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see studentImpl
 * @generated
 */
@JSON(strict = true)
public class studentModelImpl
	extends BaseModelImpl<student> implements studentModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a student model instance should use the <code>student</code> interface instead.
	 */
	public static final String TABLE_NAME = "stud_student";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"studentId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"name", Types.VARCHAR}, {"mobilenumber", Types.VARCHAR},
		{"gender", Types.VARCHAR}, {"email", Types.VARCHAR},
		{"birthdate", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("studentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("mobilenumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("gender", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("birthdate", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table stud_student (uuid_ VARCHAR(75) null,studentId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,mobilenumber VARCHAR(75) null,gender VARCHAR(75) null,email VARCHAR(75) null,birthdate VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table stud_student";

	public static final String ORDER_BY_JPQL =
		" ORDER BY student.studentId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY stud_student.studentId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long UUID_COLUMN_BITMASK = 4L;

	public static final long STUDENTID_COLUMN_BITMASK = 8L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static student toModel(studentSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		student model = new studentImpl();

		model.setUuid(soapModel.getUuid());
		model.setStudentId(soapModel.getStudentId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setMobilenumber(soapModel.getMobilenumber());
		model.setGender(soapModel.getGender());
		model.setEmail(soapModel.getEmail());
		model.setBirthdate(soapModel.getBirthdate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<student> toModels(studentSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<student> models = new ArrayList<student>(soapModels.length);

		for (studentSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public studentModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _studentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStudentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _studentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return student.class;
	}

	@Override
	public String getModelClassName() {
		return student.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<student, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<student, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<student, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((student)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<student, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<student, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(student)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<student, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<student, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, student>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			student.class.getClassLoader(), student.class, ModelWrapper.class);

		try {
			Constructor<student> constructor =
				(Constructor<student>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<student, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<student, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<student, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<student, Object>>();
		Map<String, BiConsumer<student, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<student, ?>>();

		attributeGetterFunctions.put("uuid", student::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<student, String>)student::setUuid);
		attributeGetterFunctions.put("studentId", student::getStudentId);
		attributeSetterBiConsumers.put(
			"studentId", (BiConsumer<student, Long>)student::setStudentId);
		attributeGetterFunctions.put("groupId", student::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<student, Long>)student::setGroupId);
		attributeGetterFunctions.put("companyId", student::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<student, Long>)student::setCompanyId);
		attributeGetterFunctions.put("userId", student::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<student, Long>)student::setUserId);
		attributeGetterFunctions.put("userName", student::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<student, String>)student::setUserName);
		attributeGetterFunctions.put("createDate", student::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<student, Date>)student::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", student::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<student, Date>)student::setModifiedDate);
		attributeGetterFunctions.put("name", student::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<student, String>)student::setName);
		attributeGetterFunctions.put("mobilenumber", student::getMobilenumber);
		attributeSetterBiConsumers.put(
			"mobilenumber",
			(BiConsumer<student, String>)student::setMobilenumber);
		attributeGetterFunctions.put("gender", student::getGender);
		attributeSetterBiConsumers.put(
			"gender", (BiConsumer<student, String>)student::setGender);
		attributeGetterFunctions.put("email", student::getEmail);
		attributeSetterBiConsumers.put(
			"email", (BiConsumer<student, String>)student::setEmail);
		attributeGetterFunctions.put("birthdate", student::getBirthdate);
		attributeSetterBiConsumers.put(
			"birthdate", (BiConsumer<student, String>)student::setBirthdate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getStudentId() {
		return _studentId;
	}

	@Override
	public void setStudentId(long studentId) {
		_studentId = studentId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@JSON
	@Override
	public String getMobilenumber() {
		if (_mobilenumber == null) {
			return "";
		}
		else {
			return _mobilenumber;
		}
	}

	@Override
	public void setMobilenumber(String mobilenumber) {
		_mobilenumber = mobilenumber;
	}

	@JSON
	@Override
	public String getGender() {
		if (_gender == null) {
			return "";
		}
		else {
			return _gender;
		}
	}

	@Override
	public void setGender(String gender) {
		_gender = gender;
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
	}

	@JSON
	@Override
	public String getBirthdate() {
		if (_birthdate == null) {
			return "";
		}
		else {
			return _birthdate;
		}
	}

	@Override
	public void setBirthdate(String birthdate) {
		_birthdate = birthdate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(student.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), student.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public student toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, student>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		studentImpl studentImpl = new studentImpl();

		studentImpl.setUuid(getUuid());
		studentImpl.setStudentId(getStudentId());
		studentImpl.setGroupId(getGroupId());
		studentImpl.setCompanyId(getCompanyId());
		studentImpl.setUserId(getUserId());
		studentImpl.setUserName(getUserName());
		studentImpl.setCreateDate(getCreateDate());
		studentImpl.setModifiedDate(getModifiedDate());
		studentImpl.setName(getName());
		studentImpl.setMobilenumber(getMobilenumber());
		studentImpl.setGender(getGender());
		studentImpl.setEmail(getEmail());
		studentImpl.setBirthdate(getBirthdate());

		studentImpl.resetOriginalValues();

		return studentImpl;
	}

	@Override
	public int compareTo(student student) {
		long primaryKey = student.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof student)) {
			return false;
		}

		student student = (student)object;

		long primaryKey = student.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		_originalUuid = _uuid;

		_originalGroupId = _groupId;

		_setOriginalGroupId = false;

		_originalCompanyId = _companyId;

		_setOriginalCompanyId = false;

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<student> toCacheModel() {
		studentCacheModel studentCacheModel = new studentCacheModel();

		studentCacheModel.uuid = getUuid();

		String uuid = studentCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			studentCacheModel.uuid = null;
		}

		studentCacheModel.studentId = getStudentId();

		studentCacheModel.groupId = getGroupId();

		studentCacheModel.companyId = getCompanyId();

		studentCacheModel.userId = getUserId();

		studentCacheModel.userName = getUserName();

		String userName = studentCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			studentCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			studentCacheModel.createDate = createDate.getTime();
		}
		else {
			studentCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			studentCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			studentCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		studentCacheModel.name = getName();

		String name = studentCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			studentCacheModel.name = null;
		}

		studentCacheModel.mobilenumber = getMobilenumber();

		String mobilenumber = studentCacheModel.mobilenumber;

		if ((mobilenumber != null) && (mobilenumber.length() == 0)) {
			studentCacheModel.mobilenumber = null;
		}

		studentCacheModel.gender = getGender();

		String gender = studentCacheModel.gender;

		if ((gender != null) && (gender.length() == 0)) {
			studentCacheModel.gender = null;
		}

		studentCacheModel.email = getEmail();

		String email = studentCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			studentCacheModel.email = null;
		}

		studentCacheModel.birthdate = getBirthdate();

		String birthdate = studentCacheModel.birthdate;

		if ((birthdate != null) && (birthdate.length() == 0)) {
			studentCacheModel.birthdate = null;
		}

		return studentCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<student, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<student, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<student, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((student)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<student, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<student, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<student, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((student)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, student>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _uuid;
	private String _originalUuid;
	private long _studentId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private String _mobilenumber;
	private String _gender;
	private String _email;
	private String _birthdate;
	private long _columnBitmask;
	private student _escapedModel;

}