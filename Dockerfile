From openjdk:8
copy ./target/SprintBootTest-0.0.1-SNAPSHOT.jar SprintBootTest-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","SprintBootTest-0.0.1-SNAPSHOT.jar"]