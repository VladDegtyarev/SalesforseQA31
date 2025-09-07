package dto;

import com.github.javafaker.Faker;



public class AccountFactory {
    public static Account getAccount(String rating,String industry,String priority,String opportunity){
      Faker faker = new Faker();
      return new Account(
              faker.company().name(),
              faker.phoneNumber().phoneNumber(),
              faker.phoneNumber().phoneNumber(),
              faker.internet().url(),
              rating,
              industry,
              faker.address().streetAddress(),
              faker.address().city(),
              faker.address().zipCode(),
              priority,
              faker.address().buildingNumber(),
              opportunity
      );
    }
}
