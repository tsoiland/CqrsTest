FROM java:8
#ADD is done by gradle, see build script
EXPOSE 8080
CMD java -jar /abcd/Presentation-latest.jar
