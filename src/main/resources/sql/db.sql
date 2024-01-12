DROP DATABASE IF EXISTS shoppe;
CREATE DATABASE shoppe;

use shoppe;

drop table if exists Account;
create table Account (
                         id	        		int auto_increment primary key,
                         username			varchar(50) unique,
                         email				varchar(50) unique not null,
                         password			varchar(50) not null
);

INSERT INTO shoppe.`Account` (username, email, password) VALUES ('Nguyễn Văn A', 'a@gmail.com', '123456');
INSERT INTO shoppe.`Account` (username, email, password) VALUES ('Nguyễn Văn B', 'b@gmail.com', '123456');
INSERT INTO shoppe.`Account` (username, email, password) VALUES ('Nguyễn Văn C', 'c@gmail.com', '123456');

drop table if exists Department;
create table Department (
                            id	        		int auto_increment primary key,
                            name	    		varchar(50) not null unique,
                            total_member			int,
                            type               enum('Dev','Test','ScrumMaster','PM'),
                            created_date			date
);

INSERT INTO shoppe.`Department` (name, total_member, type, created_date) VALUES ('phòng ban 1', '6', 'dev', '2023-01-11 19:29:32');
INSERT INTO shoppe.`Department` (name, total_member, type, created_date) VALUES ('phòng ban 2', '10', 'Test', '2023-01-11 19:29:32');
INSERT INTO shoppe.`Department` (name, total_member, type, created_date) VALUES ('Phòng ban 3', '5', 'PM', '2023-01-11 19:29:32');