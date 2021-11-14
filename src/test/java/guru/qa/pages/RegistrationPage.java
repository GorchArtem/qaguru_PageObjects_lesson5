package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    //locators & elements
    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName").setValue("2LastName"),
            userEmail = $("#userEmail"),
            userNumber = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            userUploadPicture = $("#uploadPicture"),
            userCurrentAddress = $("#currentAddress"),
            userState = $("#react-select-3-input"),
            userCity = $("#react-select-4-input"),
            resultsTable = $(".table-responsive");
    public CalendarComponent calendarComponent = new CalendarComponent();


    //actions
    public RegistrationPage openPage(){
        open("https://demoqa.com/automation-practice-form");
//        formTitle.shouldHave(text(FORM_TITLE));

        return this;
    }
    public RegistrationPage typeFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPage typeLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPage typeUserEmail(String value){
        userEmail.setValue(value);

        return this;
    }
    public RegistrationPage typeUserNumber(String value){
        userNumber.setValue(value);

        return this;
    }
    public RegistrationPage typeSubjects(String value){
        subjectsInput.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage typeUploadPicture(String value){
        userUploadPicture.uploadFromClasspath(value);

        return this;
    }
    public RegistrationPage typeUserAddress(String value){
        userCurrentAddress.setValue(value);

        return this;
    }
    public RegistrationPage typeUserState(String value){
        userState.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage typeUserCity(String value){
        userCity.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage checkResultsValue(String key, String value){
        resultsTable.$(byText(key)).parent().shouldHave(text(value));

        return this;
    }
}
