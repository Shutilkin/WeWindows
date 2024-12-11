CREATE USER 'admin'@'%' IDENTIFIED BY 'wewindows';
GRANT ALL PRIVILEGES ON phone_catalog.* TO 'admin'@'%';

CREATE USER 'root'@'192.168.1.100' IDENTIFIED BY 'some_pass';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'192.168.1.100' WITH GRANT OPTION;

FLUSH PRIVILEGES;

