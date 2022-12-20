mkdir upgrade-db/
cat src/main/install/sql/mysql/createTables.sql >> upgrade-db/updatedDatabase.sql

mysql_dir="tntconcept-core/src/main/resources/com/autentia/tnt/sql/mysql"

for file in $(ls $mysql_dir | sort -V)
do
    cat "$mysql_dir/$file"/upgrade.sql >> upgrade-db/updatedDatabase.sql
    echo "$mysql_dir/$file" copied!
done
