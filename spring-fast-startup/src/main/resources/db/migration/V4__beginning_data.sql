
INSERT INTO mst_item_type (item_type_id, item_type_name, delete_flag) VALUES (1,'本',false);
INSERT INTO mst_item_type (item_type_id, item_type_name, delete_flag) VALUES (2,'衣類',false);
INSERT INTO mst_item_type (item_type_id, item_type_name, delete_flag) VALUES (3,'靴',false);
INSERT INTO mst_item_type (item_type_id, item_type_name, delete_flag) VALUES (4,'家電',false);
INSERT INTO mst_item_type (item_type_id, item_type_name, delete_flag) VALUES (5,'PC',false);
INSERT INTO mst_item_type (item_type_id, item_type_name, delete_flag) VALUES (6,'映画',false);

INSERT INTO mst_item (item_id, item_name,item_type_id,item_expire_date,price,version, delete_flag) VALUES (1,'日本の歴史１',1,'2015-08-21', 300,1,false);
INSERT INTO mst_item (item_id, item_name,item_type_id,item_expire_date,price,version, delete_flag) VALUES (2,'日本の歴史２',3,'2015-08-21', 980,1,false);
INSERT INTO mst_item (item_id, item_name,item_type_id,item_expire_date,price,version, delete_flag) VALUES (3,'日本の歴史３',4,'2015-08-21', 980,1,false);
INSERT INTO mst_item (item_id, item_name,item_type_id,item_expire_date,price,version, delete_flag) VALUES (4,'レザージャケット',6,'2015-08-21', 20000,1,false);

Insert into customers(id,first_name,last_name) values(1,'5nobita','nobi');
Insert into customers(id,first_name,last_name) values(2,'nnnnn','nobi');
Insert into customers(id,first_name,last_name) values(3,'llllllll','nobi');
Insert into customers(id,first_name,last_name) values(4,'V_4 data','Newdata');
Insert into customers(id,first_name,last_name) values(5,'V_3 data','Newdata');
Insert into customers(id,first_name,last_name) values(6,'V_3 data','Newdata');
Insert into customers(id,first_name,last_name) values(7,'V_3 data','Newdata');
Insert into customers(id,first_name,last_name) values(8,'V_3 data','Newdata');
Insert into customers(id,first_name,last_name) values(9,'V_3 data','Newdata');


INSERT INTO content (content_id, my_item_id,count,content_name,comment,version,updated_function,created_function,delete_flag) 
VALUES (1,2,999,'aaa','this is comment',3,'com.controller.abc', 'com.controller.bcd',false);
INSERT INTO content (content_id, my_item_id,count,content_name,comment,version,updated_function,created_function,delete_flag) 
VALUES (2,2,777,'this is name','this is comment',2,'com.controller.abc', 'com.controller.bcd',false);
INSERT INTO content (content_id, my_item_id,count,content_name,comment,version,updated_function,created_function,delete_flag) 
VALUES (3,3,888,'this is name','this is comment',4,'com.controller.abc', 'com.controller.bcd',false);
INSERT INTO content (content_id, my_item_id,count,content_name,comment,version,updated_function,created_function,delete_flag) 
VALUES (4,4,888,'aaa','this is comment',4,'com.controller.abc', 'com.controller.bcd',false);
INSERT INTO content (content_id, my_item_id,count,content_name,comment,version,updated_function,created_function,delete_flag) 
VALUES (5,1,888,'aaa','this is comment',4,'com.controller.abc', 'com.controller.bcd',false);
INSERT INTO content (content_id, my_item_id,count,content_name,comment,version,updated_function,created_function,delete_flag) 
VALUES (6,1,888,'aaa','this is comment',1,'com.controller.abc', 'com.controller.bcd',false);
INSERT INTO content (content_id, my_item_id,count,content_name,comment,version,updated_function,created_function,delete_flag) 
VALUES (7,1,888,'aaa','this is comment',1,'com.controller.abc', 'com.controller.bcd',false);
INSERT INTO content (content_id, my_item_id,count,content_name,comment,version,updated_function,created_function,delete_flag) 
VALUES (8,1,888,'aaa','this is comment',1,'com.controller.abc', 'com.controller.bcd',false);
INSERT INTO content (content_id, my_item_id,count,content_name,comment,version,updated_function,created_function,delete_flag) 
VALUES (9,1,888,'aaa','this is comment',1,'com.controller.abc', 'com.controller.bcd',false);
INSERT INTO content (content_id, my_item_id,count,content_name,comment,version,updated_function,created_function,delete_flag) 
VALUES (10,1,888,'aaa','this is comment',1,'com.controller.abc', 'com.controller.bcd',false);
INSERT INTO content (content_id, my_item_id,count,content_name,comment,version,updated_function,created_function,delete_flag) 
VALUES (11,4,123,'★消されたデータ','this is comment',1,'com.controller.abc', 'com.controller.bcd',true);

INSERT INTO content_detail (detail_id, content_content_id, detail_name, price) 
VALUES (1,1,'No.1',300);
INSERT INTO content_detail (detail_id, content_content_id, detail_name, price) 
VALUES (2,2,'No.2',300);
INSERT INTO content_detail (detail_id, content_content_id, detail_name, price) 
VALUES (3,3,'No.3',300);
INSERT INTO content_detail (detail_id, content_content_id, detail_name, price) 
VALUES (4,1,'No.4',300);
INSERT INTO content_detail (detail_id, content_content_id, detail_name, price) 
VALUES (5,2,'No.1',300);
INSERT INTO content_detail (detail_id, content_content_id, detail_name, price) 
VALUES (6,3,'No.1',300);
 
 ----------------------------------------
 
INSERT INTO users (username, encoded_password) VALUES ('user1', '$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i' /*demo*/);
INSERT INTO users (username, encoded_password) VALUES ('user2', '$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i' /*demo*/);

INSERT INTO job (id,salery,job_descr,owner_id) values(1,'1000000','サラリーマン', 1);
INSERT INTO job (id,salery,job_descr,owner_id) values(2,'200000','高校の先生', 2);
INSERT INTO job (id,salery,job_descr,owner_id) values(3,'1000000','校長先生', 3);
INSERT INTO job (id,salery,job_descr,owner_id) values(4,'200000','医者', 4);


INSERT INTO person (id,first_name,last_name,nonsense_field,family_id) VALUES('1','yamada','taro','xxxxxxxxxx','nagase');
INSERT INTO person (id,first_name,last_name,nonsense_field,family_id) VALUES('2','suzuki','taro','xxxxxxxxxx','nagase');
INSERT INTO person (id,first_name,last_name,nonsense_field,family_id) VALUES('3','東海','花子','xxxxxxxxxx','nagase');
INSERT INTO person (id,first_name,last_name,nonsense_field,family_id) VALUES('88','中部','次郎','xxxxxxxxxx','nagase');



INSERT INTO family(fam_id,family_name,description) values('nagase','ナガセ','一般家庭');

INSERT INTO todo(id,owner_id,summary,description) values(1,1,'走る','外を走る。目標30分以上');
INSERT INTO todo(id,owner_id,summary,description) values(2,2,'買い物に行く','今日の晩御飯を買いに行く');
INSERT INTO todo(id,owner_id,summary,description) values(3,1,'洗濯する','洗濯をして干す');
INSERT INTO todo(id,owner_id,summary,description) values(99,2,'なんにもしない','この目標は誰が登録したかわからない。（ユーザ不在）');

