FROM openjdk:8
WORKDIR /app
ADD build/libs/CreditCardBillPayment-0.0.1-SNAPSHOT.jar .
EXPOSE 8086
ENTRYPOINT ["java","-jar","CreditCardBillPayment-0.0.1-SNAPSHOT.jar"]