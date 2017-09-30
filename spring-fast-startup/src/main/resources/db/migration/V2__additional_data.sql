

CREATE TABLE mst_item_type(
 item_type_id INT NOT NULL PRIMARY KEY,
 item_type_name VARCHAR(110),
 delete_flag boolean
);

CREATE TABLE purchase_history (
 purchase_history_id INT NOT NULL PRIMARY KEY,
 purchase_date DATE
);


CREATE TABLE mst_item (
 item_id INT NOT NULL PRIMARY KEY,
 item_name VARCHAR(100),
 item_type_id INT,
 item_expire_date TIMESTAMP(10),
 price FLOAT(20),
 version INT,
 delete_flag boolean
);


CREATE TABLE content (
 content_id bigint NOT NULL PRIMARY KEY,
 my_item_id INT,
 content_name VARCHAR(100),count INT,comment VARCHAR(500),
 version bigint,
 updated_function VARCHAR(100),
 created_function VARCHAR(100),
 delete_flag boolean,
 created_date datetime,
 updated_date datetime,
 created_by VARCHAR(100),
 updated_by VARCHAR(100)
);

CREATE TABLE content_detail (
 detail_id bigint NOT NULL PRIMARY KEY,
 content_content_id bigint, 
 detail_name VARCHAR(100),
 price INT,
 
 version bigint,
 updated_function VARCHAR(100),
 created_function VARCHAR(100),
 delete_flag boolean,
 created_date datetime,
 updated_date datetime,
 created_by VARCHAR(100),
 updated_by VARCHAR(100)
);


CREATE TABLE shopping_basket (
 basket_id INT NOT NULL PRIMARY KEY,
 content_id INT,
 comment VARCHAR(500),
 version INT,
 delete_flag boolean,
 purchased_date DATE
);

CREATE TABLE Role (
 roleId CHAR(10) NOT NULL PRIMARY KEY,
 roleName CHAR(10),
 deleteflag BIT(1),
 updatedDate DATE,
 createdDate DATE,
 createdUser bigint,
 updatedUser bigint
);


CREATE TABLE RoleGroup (
 roleGroupId CHAR(10) NOT NULL PRIMARY KEY,
 roleGroupName CHAR(10),
 deleteflag BIT(1),
 updatedDate DATE,
 createdDate DATE,
 createdUser bigint,
 updatedUser bigint
);


CREATE TABLE RoleGroupRole (
 roleGroupRoleId CHAR(10) NOT NULL PRIMARY KEY,
 roleGroupId CHAR(10),
 roleId CHAR(10),
 deleteflag BIT(1),
 updatedDate DATE,
 createdDate DATE,
 createdUser bigint,
 updatedUser bigint
);


CREATE TABLE UserAccount (
 id NUMERIC(10) NOT NULL PRIMARY KEY,
 loginId VARCHAR(100),
 password VARCHAR(100),
 address VARCHAR(500),
 age INT,
 sirName CHAR(10),
 familyName CHAR(10),
 deleteFlag BIT(1),
 updatedDate DATE,
 createdDate DATE,
 createdUser bigint,
 updatedUser bigint
);


CREATE TABLE UserRoleGroup (
 userRoleGroupId CHAR(10) NOT NULL PRIMARY KEY,
 userId CHAR(10),
 roleGroupId CHAR(10),
 deleteflag BIT(1),
 updatedDate DATE,
 createdDate DATE,
 createdUser bigint,
 updatedUser bigint
);






