DROP DATABASE IF EXISTS xoo;
CREATE DATABASE xoo;
USE xoo;

DROP TABLE IF EXISTS webhooks;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS frontend_users;
DROP TABLE IF EXISTS auth_types;
DROP TABLE IF EXISTS http_request_types;
DROP TABLE IF EXISTS api_keys;

-- The default CHARACTER SET should be utf8mb4 so it doesn't have to be specified for each table

CREATE TABLE customers (
  name VARCHAR(60) PRIMARY KEY,
  email VARCHAR(60) NOT NULL,
  tel VARCHAR(15) NOT NULL
);

CREATE TABLE frontend_users (
  name VARCHAR(60) PRIMARY KEY,
  password VARCHAR(255) NOT NULL,
  access_level TINYINT  NOT NULL
);

CREATE TABLE auth_types (
  auth_type VARCHAR(30) PRIMARY KEY
);

CREATE TABLE http_request_types (
  http_request_type VARCHAR(30) PRIMARY KEY
);

CREATE TABLE webhooks (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100),
  url VARCHAR(255) NOT NULL,
  body TEXT,
  response_on_success INT(4) NOT NULL, -- Maybe there's several different responses for success and error, so it should really be a foreign key into a response table?
  response_on_error INT(4) NOT NULL,   -- Also unsure what type these should be. Currently we assume they're HTTP Response Status codes.

  http_request_type VARCHAR(30) NOT NULL, -- TINYINT or FOREIGN KEY to table of types?
  auth_type VARCHAR(30) NOT NULL,   -- TINYINT or FOREIGN KEY to table of authentication methods?
  customer VARCHAR(60) NOT NULL,
  FOREIGN KEY (customer) REFERENCES customers(name),
  FOREIGN KEY (http_request_type) REFERENCES http_request_types(http_request_type),
  FOREIGN KEY (auth_type) REFERENCES auth_types(auth_type)
);

CREATE TABLE api_keys (
  `key` VARCHAR(100) PRIMARY KEY,

  customer VARCHAR(60) NOT NULL,
  FOREIGN KEY (customer) REFERENCES customers(name),
  CHECK ( char_length(`key`) = 100 )
);
