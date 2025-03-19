package utility;

import com.github.javafaker.Faker;

public class Faker_Utility {
   Faker faker = new Faker();
   public String generateFirstName() {
	   return faker.name().firstName();
   }
   public String genertaeFullName() {
	   return faker.name().fullName();
   }
   public String generateEmail() {
	   return faker.internet().emailAddress();
   }
   public String generateAddress() {
	   return faker.address().fullAddress();
   }
   public int generateRandomNumber() {
	   return (int) faker.number().randomNumber();
   }
   public String generatePhoneNumber() {
	   return faker.phoneNumber().toString();
   }
   
}
