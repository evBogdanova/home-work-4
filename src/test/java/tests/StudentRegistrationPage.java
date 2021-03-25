package tests;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationPage {


    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

    public void fillForm(String firstName, String lastName, String userEmail, String gender, String userNumber, String dayOfBirth, String monthOfBirth, String yearOfBirth, String subjectsInput1, String subjectsInput2, String hobby, String picture, String currentAddress, String state, String city) {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth);
        $("#subjectsInput").setValue(subjectsInput1).pressEnter();
        $("#subjectsInput").setValue(subjectsInput2).pressEnter();
        $(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();
    }

    public void setBirthDate(String dayOfBirth,String monthOfBirth, String yearOfBirth) {
        $(byId("dateOfBirthInput")).click();
        $(".react-datepicker__month-select").selectOptionContainingText(monthOfBirth);
        $(".react-datepicker__year-select").selectOptionByValue(yearOfBirth);
        $(".react-datepicker__day--0" + dayOfBirth).click();
    }

    public void checkForm (String firstName, String lastName, String userEmail, String gender, String userNumber, String dayOfBirth, String monthOfBirth, String yearOfBirth, String subjectsInput1, String subjectsInput2, String hobby, String picture, String currentAddress, String state, String city) {
        $(".table-responsive").shouldHave(text("Student Name " + firstName + " " + lastName),
                text("Student Email " + userEmail),
                text("Gender " + gender),
                text("Mobile " + userNumber),
                text("Date of Birth " + dayOfBirth + " " + monthOfBirth + "," + yearOfBirth),
                text("Subjects " +  subjectsInput1 + ", " + subjectsInput2),
                text("Hobbies " + hobby),
                text("Picture " + picture),
                text("Address " +  currentAddress),
                text("State and City " + state + " " + city));
    }
}
