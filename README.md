[![Build Status](https://travis-ci.org/JoveOlga/hello-spring-boot.svg?branch=master)](https://travis-ci.org/JoveOlga/hello-spring-boot)

Алгоритм развертывания проекта


git clone https://github.com/JoveOlga/hello-spring-boot.git

cd hello-spring-boot/

vagrant up

vagrant ssh

sudo apt-get install postgresql postgresql-contrib

sudo -i -u postgres

cd /vagrant

psql -Upostgres <hello.sql

exit


cd /vagrant

mvn clean install

cd target/

java -jar hello-1.0-SNAPSHOT.jar



результат проверять по адресу
http://192.168.33.10:8090/hello/contacts/?nameFilter=M

Если потребуется запустить проект без vagrant скрипт БД в корне проекта hello.sql