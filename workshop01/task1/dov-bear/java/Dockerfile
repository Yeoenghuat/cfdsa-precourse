# builder
FROM maven:3.8.4-openjdk-17-slim AS builder

ARG APP_DIR="/app"
WORKDIR ${APP_DIR}
ADD . .

RUN mvn clean install -DskipTests

# app
FROM openjdk:17-alpine

ARG APP_DIR="/app"
ARG PACKAGE="curl"

RUN apk update \
    && apk upgrade \
    && apk add ${PACKAGE}

WORKDIR ${APP_DIR}
COPY --from=builder /app/target/dovbear-0.0.1-SNAPSHOT.jar ./dovbear.jar

ENTRYPOINT [ "java", "-jar", "dovbear.jar" ]