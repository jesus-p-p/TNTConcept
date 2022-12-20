FROM mysql:5.6

ENV MYSQL_DATABASE tntconcept
ENV MYSQL_USER tnt
ENV MYSQL_ROOT_PASSWORD root

RUN mkdir update-script
COPY . /update-script
#COPY generate_updated_database.sh /update-script
#COPY tntconcept-core/src/main/resources/com/autentia/tnt/sql/mysql /update-script

WORKDIR /update-script

RUN chmod +rwx generate_updated_database.sh

RUN ./generate_updated_database.sh
RUN cp upgrade-db/updatedDatabase.sql /docker-entrypoint-initdb.d

RUN rm -rf /update-script


EXPOSE 3306
