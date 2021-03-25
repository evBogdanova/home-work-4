package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StudentRegistrationTest {
    StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();
    Faker faker = new Faker();

    @BeforeAll
    static void fullScreen() {
        Configuration.startMaximized = true;
    }

    @Test
    void studentRegistrationForm() {

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                gender = "Female",
                userNumber = faker.number().digits(10),
                dayOfBirth = "19",
                monthOfBirth = "November",
                yearOfBirth = "1997",
                subjectsInput1 = "Biology",
                subjectsInput2 = "Computer Science",
                hobby = "Music",
                picture = "test.jpg",
                currentAddress = faker.address().fullAddress(),
                state = "NCR",
                city = "Delhi";

        studentRegistrationPage.openPage();
        studentRegistrationPage.fillForm(firstName, lastName, userEmail, gender, userNumber, dayOfBirth, monthOfBirth, yearOfBirth, subjectsInput1, subjectsInput2, hobby, picture, currentAddress, state, city);
        studentRegistrationPage.checkForm(firstName, lastName, userEmail, gender, userNumber, dayOfBirth, monthOfBirth, yearOfBirth, subjectsInput1, subjectsInput2, hobby, picture, currentAddress, state, city);
        }
    }
