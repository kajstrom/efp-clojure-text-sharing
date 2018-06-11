FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/efp-clojure-text-sharing.jar /efp-clojure-text-sharing/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/efp-clojure-text-sharing/app.jar"]
