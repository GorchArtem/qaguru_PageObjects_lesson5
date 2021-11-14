package guru.qa.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationWithPageObjectTests extends TestBase {

    Faker faker = new Faker(new Locale("en-IND"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String fullName = firstName + " " + lastName;
    String userEmail = faker.internet().emailAddress();
    String userAddress = faker.address().streetAddress();
    String userMobileNumber = "0123456789";


    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmail)
                .typeUserNumber(userMobileNumber);

        $$(".custom-radio").get(1).click();


        registrationPage.calendarComponent.setDate("12", "January", "2020");

        registrationPage.typeSubjects("Maths");

        $(byText("Music")).click();
        $(byText("Sports")).click();

        registrationPage.typeUploadPicture("facemy.jpg");

        registrationPage.typeUserAddress(userAddress)
                .typeUserState("Uttar Pradesh")
                .typeUserCity("Agra");

        $("#submit").click();

        registrationPage.checkResultsValue("Student Name", fullName)
                .checkResultsValue("Student Email", userEmail)
                .checkResultsValue("Gender", "Female")
                .checkResultsValue("Mobile", userMobileNumber)
                .checkResultsValue("Date of Birth", "12 January,2020")
                .checkResultsValue("Subjects", "Maths")
                .checkResultsValue("Hobbies", "Music, Sports")
                .checkResultsValue("Picture", "facemy.jpg")
                .checkResultsValue("Address", userAddress)
                .checkResultsValue("State and City", "Uttar Pradesh Agra");

    }
}