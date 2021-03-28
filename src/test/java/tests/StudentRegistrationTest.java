package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StudentRegistrationTest {
    StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();

    @BeforeAll
    static void fullScreen() {
        Configuration.startMaximized = true;
    }

    @Test
    void studentRegistrationForm() {
        Student student = new Student();
        studentRegistrationPage.openPage();
        studentRegistrationPage.fillForm(student);
        studentRegistrationPage.checkForm(student);
        }
    }
