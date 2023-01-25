-- Drop table if exists oauth_client_details;
-- Do not use in production environement
---------------------------------------------
-- Create table if not exists  OAUTH_CLIENT_DETAILS
---------------------------------------------
create table OAUTH_CLIENT_DETAILS (
  client_id VARCHAR2(255) PRIMARY KEY,
  resource_ids VARCHAR2(255),
  client_secret VARCHAR2(255),
  scope VARCHAR2(255),
  authorized_grant_types VARCHAR2(255),
  web_server_redirect_uri VARCHAR2(255),
  authorities VARCHAR2(255),
  access_token_validity NUMBER(30),
  refresh_token_validity NUMBER(30),
  additional_information VARCHAR2(4000),
  autoapprove VARCHAR2(255)
);

---------------------------------------------
-- Create table if not exists  OAUTH_CLIENT_TOKEN
---------------------------------------------
create table OAUTH_CLIENT_TOKEN (
  token_id VARCHAR2(255),
  token BLOB,
  authentication_id VARCHAR2(255) PRIMARY KEY,
  user_name VARCHAR2(255),
  client_id VARCHAR2(255)
);

---------------------------------------------
-- Create table if not exists  OAUTH_ACCESS_TOKEN
---------------------------------------------
create table OAUTH_ACCESS_TOKEN (
  token_id VARCHAR2(255),
  token BLOB,
  authentication_id VARCHAR2(255) PRIMARY KEY,
  user_name VARCHAR2(255),
  client_id VARCHAR2(255),
  authentication BLOB,
  refresh_token VARCHAR2(255)
);

---------------------------------------------
-- Create table if not exists  OAUTH_REFRESH_TOKEN
---------------------------------------------
create table OAUTH_REFRESH_TOKEN (
  token_id VARCHAR2(255),
  token BLOB,
  authentication BLOB
);
---------------------------------------------
-- Create table if not exists  OAUTH_CODE
---------------------------------------------
create table OAUTH_CODE (
  code VARCHAR2(255),
  authentication BLOB
);
---------------------------------------------
-- Create table if not exists  OAUTH_APPROVALS
---------------------------------------------
create table OAUTH_APPROVALS (
	userId VARCHAR2(255),
	clientId VARCHAR2(255),
	scope VARCHAR2(255),
	status VARCHAR2(10),
	expiresAt TIMESTAMP,
	lastModifiedAt TIMESTAMP
);

---------------------------------------------
-- Create table if not exists  CLIENTDETAILS
---------------------------------------------
create table CLIENTDETAILS (
  appId VARCHAR2(255) PRIMARY KEY,
  resourceIds VARCHAR2(255),
  appSecret VARCHAR2(255),
  scope VARCHAR2(255),
  grantTypes VARCHAR2(255),
  redirectUrl VARCHAR2(255),
  authorities VARCHAR2(255),
  access_token_validity NUMBER(30),
  refresh_token_validity NUMBER(30),
  additionalInformation VARCHAR2(4000),
  autoApproveScopes VARCHAR2(255)
);
---------------------------------------------
-- commit
---------------------------------------------
commit;
---------------------------------------------
-- insert configuration
---------------------------------------------
-- FIXME Chantier changement de nom de schéma ADMIN
INSERT INTO "MUTIX"."OAUTH_CLIENT_DETAILS" (CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET,SCOPE , AUTHORIZED_GRANT_TYPES, ACCESS_TOKEN_VALIDITY)
VALUES ('owl', 'owlink-access', 'secret','read', 'password,client_credentials', '3600')
/*
ajout de la colonne USER_PWD à la table des utilisateurs de l'application
-- les password sont stockés  crypté (en utilisant org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder)
*/
-- FIXME Chantier changement de nom de table ALL_USERS_APP
alter table ALL_USERS_MUTIX ADD USER_PWD varchar2(2000);
/*
mise à jour de la table des utilisateur de l'application
*/
-- FIXME Chantier changement de nom utilisateur administrateur ADMIN
update ALL_USERS_MUTIX set USER_PWD='$2a$10$h271KXSuds45h9s.3.ECou6JkMNnUFwbPrpViX/COsqjF6NmOzS9G'	 where user_nom = 	'MUTIX'	;
update ALL_USERS_MUTIX set USER_PWD='$2a$10$ZLwabEvFkIauI3y5ebeC1.9.OqcintPA6uzyWxoP3rnzHTCLQrLCS'	 where user_nom = 	'MBUR'	;
update ALL_USERS_MUTIX set USER_PWD='$2a$10$uk5/VL9pPCdz3hlz8jYbTOItf9gxff82JyFSuO/fb.q9sGzo.Qgkq'	 where user_nom = 	'YLE'	;
update ALL_USERS_MUTIX set USER_PWD='$2a$10$IibYTdQ4ofV0osoPAetxA.ce7cf5AiTeugV1VQl4vKb/KsQ1MuoGm'	 where user_nom = 	'CGAV'	;
update ALL_USERS_MUTIX set USER_PWD='$2a$10$f19xwQqtMWIJrpn3FYj5Aen74UwHIKM0nxqyOopAYUadNymDfh1Ay'	 where user_nom = 	'SLEP'	;
update ALL_USERS_MUTIX set USER_PWD='$2a$10$BHyNy6sreAGPxY8r.bzZt.WgKvrvjQQ/yUtswGviXi2Wofy.WNAtC'	 where user_nom = 	'MCOU'	;
commit;
