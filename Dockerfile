FROM openjdk:11-jdk-slim AS build
WORKDIR /src
COPY . .
RUN ./gradlew build

FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /src/build/libs .
COPY --from=build /src/build/test-results/test/TEST-com.example.recruitment.RecruitmentApplicationTests.xml ./junit.xml
ENTRYPOINT ["java", "-jar", "recruitment-0.0.1-SNAPSHOT.jar"]