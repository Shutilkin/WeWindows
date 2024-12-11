FROM mysql:8.0

ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=phone_catalog
ENV MYSQL_USER=admin
ENV MYSQL_PASSWORD=wewindows

COPY mobiles.sql /docker-entrypoint-initdb.d/
COPY grant_privileges.sql /docker-entrypoint-initdb.d/

