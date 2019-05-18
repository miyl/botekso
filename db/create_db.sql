DROP DATABASE IF EXISTS botxo;
CREATE DATABASE botxo;
USE botxo;

-- The default CHARACTER SET should be utf8mb4 so it doesn't have to be specified for each table
DROP TABLE IF EXISTS webhooks;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS frontend_users;
DROP TABLE IF EXISTS api_keys;

CREATE TABLE customers (
  name VARCHAR(60) PRIMARY KEY,
  email VARCHAR(60) NOT NULL,
  tel VARCHAR(60) NOT NULL
);

CREATE TABLE frontend_users (
  name VARCHAR(60) PRIMARY KEY,
  password VARCHAR(255) NOT NULL,
  access_level TINYINT  NOT NULL
);

CREATE TABLE auth_types (
  auth_type VARCHAR(50) PRIMARY KEY
);

CREATE TABLE http_request_types (
  http_request_type VARCHAR(50) PRIMARY KEY
);


CREATE TABLE webhooks (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100),
  http_request_type VARCHAR(60) NOT NULL, -- TINYINT or FOREIGN KEY to table of types?
  auth_type VARCHAR(60) NOT NULL,   -- TINYINT or FOREIGN KEY to table of authentication methods?
  url VARCHAR(255) NOT NULL,
  body TEXT NOT NULL,
  response_on_success INT NOT NULL, -- Maybe there's several different responses for success and error, so it should really be a foreign key into a response table?
  response_on_error INT NOT NULL,   -- Also unsure what type these should be. Currently we assume they're HTTP Response Status codes.

  customer VARCHAR(60) NOT NULL,
  FOREIGN KEY (customer) REFERENCES customers(name),
  FOREIGN KEY (http_request_type) REFERENCES http_request_types(http_request_type),
  FOREIGN KEY (auth_type) REFERENCES auth_types(auth_type)
);

-- Describes the specific ships in a scenario
CREATE TABLE api_keys (
  `key` VARCHAR(255) PRIMARY KEY,

  customer VARCHAR(60) NOT NULL,
  FOREIGN KEY (customer) REFERENCES customers(name)
  -- CHECK (direction BETWEEN 30 AND 330)
);
