USE xoo;

-- Disable FOREIGN KEY checks before emptying tables
SET FOREIGN_KEY_CHECKS=0;

-- Empty tables
TRUNCATE TABLE webhooks;
TRUNCATE TABLE customers;
TRUNCATE TABLE frontend_users;
TRUNCATE TABLE auth_types;
TRUNCATE TABLE http_request_types;
TRUNCATE TABLE api_keys;

SET FOREIGN_KEY_CHECKS=1;


-- Passwords obviously shouldn't be in plaintext, but we have them in plaintext here until we get proper hashing setup.
INSERT INTO frontend_users (name, password, access_level) 
VALUES ('Dario', 'djalligator', 3);

INSERT INTO frontend_users (name, password, access_level) 
VALUES ('Maria', 'suprememasterfirstclass', 3);

INSERT INTO frontend_users (name, password, access_level) 
VALUES ('Emiiil', 'nyifirma', 1);


INSERT INTO auth_types (auth_type)
VALUES ('None');

INSERT INTO auth_types (auth_type)
VALUES ('JWT');


-- Request types based off: https://en.wikipedia.org/wiki/Representational_state_transfer

INSERT INTO http_request_types (http_request_type)
VALUES ('GET');

INSERT INTO http_request_types (http_request_type)
VALUES ('HEAD');

INSERT INTO http_request_types (http_request_type)
VALUES ('POST');

INSERT INTO http_request_types (http_request_type)
VALUES ('PUT');

INSERT INTO http_request_types (http_request_type)
VALUES ('PATCH');

INSERT INTO http_request_types (http_request_type)
VALUES ('DELETE');

INSERT INTO http_request_types (http_request_type)
VALUES ('CONNECT');

INSERT INTO http_request_types (http_request_type)
VALUES ('OPTIONS');

INSERT INTO http_request_types (http_request_type)
VALUES ('TRACE');


INSERT INTO customers (name, email, tel) 
VALUES ('Tiger of Sweden', 'tiger@sweden.dk', '4670121416');

INSERT INTO customers (name, email, tel) 
VALUES ('Carlsberg', 'carl@carlsberg.dk', '4588888888');

INSERT INTO customers (name, email, tel) 
VALUES ('tariq', 'tariq@zamanien.dk', '4577777777');


-- Omitting special characters

INSERT INTO api_keys (`key`, customer)
VALUES('dx4BhhZPSKaKnJmZ7PdQUGjSpwtFM4mBwUdQa84fCuFDUK4waUtwKqrEyvAhoSy7jMPfdfJSWXYcG4kPqQJMyiFgzVzNquxfsKVD', 'Carlsberg');

INSERT INTO api_keys (`key`, customer)
VALUES('vipGo8LbUdsVPM2vBxBXuLEh46DV78Ya5CSD9vcgEy7pwXuhWYAgB3ANnrWAz7wxEHeSfX9CfsEtzNvGPL4HCvpKXi7KNMSa4ZJd', 'Tiger of Sweden');

INSERT INTO api_keys (`key`, customer)
VALUES('W77P37YzLHp4aegeFFxosxAQq7z4jaZ8UdXJyc89RecKfXMZsXoDjGJAGKSv8uyg7vtB75c7rzdcYuQvWUXjmQPsAk9v9pa78Eib', 'Tiger of Sweden');


-- ID is auto increment
INSERT INTO webhooks (name, url, body, response_on_success, response_on_error, http_request_type, auth_type, customer) 
VALUES ('Send email til Chauffør', 'localhost:9999', 
  'From: "Bob Example" <bob@example.com>
  To: Alice Example <alice@example.com>
  Cc: theboss@example.com
  Date: Tue, 15 Jan 2008 16:02:43 -0500
  Subject: Hello, World!

  Hello Alice.
  TLDR
  Your friend,
  Bob', 
  200, 403, 'POST', 'None', 'Tiger of Sweden');

INSERT INTO webhooks (name, url, body, response_on_success, response_on_error, http_request_type, auth_type, customer) 
VALUES ('Tjek lagerstatus på vare', 'localhost:9999', '', 200, 403, 'POST', 'None', 'Tiger of Sweden');

INSERT INTO webhooks (name, url, body, response_on_success, response_on_error, http_request_type, auth_type, customer) 
VALUES ('Send email til Chauffør', 'localhost:9999', '', 200, 403, 'GET', 'None', 'Carlsberg');
