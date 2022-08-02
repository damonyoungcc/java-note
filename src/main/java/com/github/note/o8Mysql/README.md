## 启动一个mysql
docker run --name mysql -e MYSQL_ROOT_PASSWORD=123qwe -d mysql:5.7.39

## 启动一个mysql映射端口
docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123qwe -d mysql:5.7.39 