FROM gustavoarellano/jdk18
COPY ./sample-1.0-SNAPSHOT-fat.jar /codigo/sample-1.0-SNAPSHOT-fat.jar
ENTRYPOINT java -jar /codigo/sample-1.0-SNAPSHOT-fat.jar
