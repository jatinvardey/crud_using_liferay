create table stud_student (
	uuid_ VARCHAR(75) null,
	studentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	mobilenumber VARCHAR(75) null,
	gender VARCHAR(75) null,
	email VARCHAR(75) null,
	birthdate VARCHAR(75) null
);