FROM bellsoft/liberica-runtime-container:jre-17-stream-musl
MAINTAINER M.Naeem Akhtar
COPY target/service-two-0.0.1-SNAPSHOT.jar service-two.jar
EXPOSE 9002
ENTRYPOINT ["java","-jar","/service-two.jar"]