DROP DATABASE IF EXISTS companionservice;
DROP USER IF EXISTS `companion_service`@`%`;
CREATE DATABASE IF NOT EXISTS companionservice CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `companion_service`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW,
CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `companionservice`.* TO `companion_service`@`%`;
FLUSH PRIVILEGES;

