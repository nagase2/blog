


CREATE TABLE family (
 fam_id VARCHAR(100) NOT NULL PRIMARY KEY,
 family_name VARCHAR(100),
 description VARCHAR(100)
);

CREATE TABLE person (
 id bigserial  NOT NULL PRIMARY KEY,
 first_name VARCHAR(100),
  last_name VARCHAR(100),
   nonsense_field VARCHAR(100),
   family_id VARCHAR(100)
);

CREATE TABLE job(
  id bigserial NOT NULL PRIMARY KEY,
  salery float,
   job_descr VARCHAR(200),
   owner_id bigint
  );


CREATE TABLE todo (
 id bigserial NOT NULL PRIMARY KEY,
 summary VARCHAR(100),
  description VARCHAR(100),
  owner_id bigint
);