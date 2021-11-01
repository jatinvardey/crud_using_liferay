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

package com.ignek.student.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ignek.student.service.http.studentServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class studentSoap implements Serializable {

	public static studentSoap toSoapModel(student model) {
		studentSoap soapModel = new studentSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setStudentId(model.getStudentId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setMobilenumber(model.getMobilenumber());
		soapModel.setGender(model.getGender());
		soapModel.setEmail(model.getEmail());
		soapModel.setBirthdate(model.getBirthdate());

		return soapModel;
	}

	public static studentSoap[] toSoapModels(student[] models) {
		studentSoap[] soapModels = new studentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static studentSoap[][] toSoapModels(student[][] models) {
		studentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new studentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new studentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static studentSoap[] toSoapModels(List<student> models) {
		List<studentSoap> soapModels = new ArrayList<studentSoap>(
			models.size());

		for (student model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new studentSoap[soapModels.size()]);
	}

	public studentSoap() {
	}

	public long getPrimaryKey() {
		return _studentId;
	}

	public void setPrimaryKey(long pk) {
		setStudentId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getStudentId() {
		return _studentId;
	}

	public void setStudentId(long studentId) {
		_studentId = studentId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getMobilenumber() {
		return _mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		_mobilenumber = mobilenumber;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getBirthdate() {
		return _birthdate;
	}

	public void setBirthdate(String birthdate) {
		_birthdate = birthdate;
	}

	private String _uuid;
	private long _studentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _mobilenumber;
	private String _gender;
	private String _email;
	private String _birthdate;

}