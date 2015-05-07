cd /home/sangjun/code/study/study_j2ee_sample/RMI/tutorial/ttserver/target
java -cp /var/www/html/rmi/server -Djava.rmi.server.codebase=http://yeahsj.com/html/rmi/server/server.jar -Djava.rmi.server.hostname=yeahsj.com -Djava.security.policy=http://localhost/html/rmi/server/server.policy -jar http://localhost/html/rmi/server/server.jar


java -cp /var/www/html/rmi/server -Djava.security.debug=access,failure -Djava.rmi.server.codebase=http://yeahsj.com/html/rmi/server/compute.jar -Djava.rmi.server.hostname=yeahsj.com -Djava.security.policy=/var/www/html/rmi/server/server.policy -jar /var/www/html/rmi/server/server.jar


java -Djava.security.debug=access,failure  -Djava.rmi.server.codebase="file:///var/www/html/rmi/server/compute.jar file:///var/www/html/rmi/server/server.jar" -Djava.rmi.server.hostname=yeahsj.com -Djava.security.policy=/var/www/html/rmi/server/server.policy  -jar /var/www/html/rmi/server/server.jar



java -Djava.security.debug=access,failure  -Djava.rmi.server.codebase="http://localhost/html/rmi/server/compute.jar" -Djava.rmi.server.hostname=yeahsj.com -Djava.security.policy=/var/www/html/rmi/server/server.policy  -jar /var/www/html/rmi/server/server.jar

java -Djava.security.debug=access,failure  -Djava.rmi.server.codebase="http://yeahsj.com/html/rmi/server/compute.jar" -Djava.rmi.server.hostname=yeahsj.com -Djava.security.policy=/var/www/html/rmi/server/server.policy  -jar /var/www/html/rmi/server/server.jar


java -cp /home/ann/src:/home/ann/public_html/classes/compute.jar
     -Djava.rmi.server.codebase=http://mycomputer/~ann/classes/compute.jar
     -Djava.rmi.server.hostname=mycomputer.example.com
     -Djava.security.policy=server.policy
        engine.ComputeEngine

