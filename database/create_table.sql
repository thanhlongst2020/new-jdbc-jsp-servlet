drop TABLE role;

CREATE TABLE role(
	id BIGINT not NULL PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(150) not NULL,
	code VARCHAR(150) not null,
	createddate TIMESTAMP null,
	modifieddate TIMESTAMP NULL,
	createdby VARCHAR(255) null,
	modifiedby VARCHAR(255) null
);


drop table USER;
create TABLE user(
	id BIGINT not NULL PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(150) not NULL,
	password VARCHAR(150) not null,
	fullname VARCHAR(150) null,
	status int not null,
	roleid bigint not null,
	createddate TIMESTAMP null,
	modifieddate TIMESTAMP NULL,
	createdby VARCHAR(255) null,
	modifiedby VARCHAR(255) null
);

alter table user add CONSTRAINT fk_user_role FOREIGN KEY (roleid) REFERENCES role(id);

create TABLE news (
	id BIGINT not NULL PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(255) null,
	thumbnail varchar(255) null,
	shortdescription TEXT null,
	content TEXT null,
	categoryid BIGINT not NULL,
	createddate TIMESTAMP null,
	modifieddate TIMESTAMP NULL,
	createdby VARCHAR(255) null,
	modifiedby VARCHAR(255) null
);

create TABLE category (
	id BIGINT not NULL PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) null,
	code varchar(255) null,
	createddate TIMESTAMP null,
	modifieddate TIMESTAMP NULL,
	createdby VARCHAR(255) null,
	modifiedby VARCHAR(255) null
);

alter table news add CONSTRAINT fk_news_category FOREIGN KEY (categoryid) REFERENCES category(id);

create table comment (
	id bigint not null PRIMARY key auto_increment,
	content TEXT not null,
	user_id bigint not null,
	news_id BIGINT not null,
	createddate TIMESTAMP null,
	modifieddate TIMESTAMP NULL,
	createdby VARCHAR(255) null,
	modifiedby VARCHAR(255) null
);

alter table comment add CONSTRAINT fk_news_comment FOREIGN KEY (news_id) REFERENCES news(id);
alter table comment add CONSTRAINT fk_user_comment FOREIGN KEY (user_id) REFERENCES user(id);