## java note

docker run --restart always --name mysqldb -p 3306:3306 -e MYSQL_ROOT_PASSWORD= -v /mysqldata:/var/lib/mysql -d mysql:5.7.39 --default-time_zone='+8:00'