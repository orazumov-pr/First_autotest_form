package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        //Селекторы для Name и Email
        $("#firstName").setValue("Oleg");
        $("#lastName").setValue("Razumov");
        $("#userEmail").setValue("razumov@mail.ru");

        //Селектор для radiobutton Gender
        $("#gender-radio-1").click();

        //Селектор для Mobile number
        $("#userNumber").setValue("89067776655");

        //Селекторы для Календаря
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $("option[value='1977']").click();
        $(".react-datepicker__month-select").click();
        $("option[value='1']").click();
        $(".react-datepicker__day.react-datepicker__day--014").click();

        $("#subjectsInput").setValue("Abstract text").pressEnter();
        $("#hobbies-checkbox-2").parent().click();
        $("#uploadPicture").uploadFromClasspath("resources/my_abstract_scr.jpg");

        //Добавить селекторы для radiobutton Hobbies
        $("#hobbies-checkbox-2").click();




        $("#output #name").shouldHave(text("Alex"));
        $("#output #email").shouldHave(text("alex@egorov.com"));
        $("#output #currentAddress").shouldHave(text("Some street 1"));
        $("#output #permanentAddress").shouldHave(text("Another street 1"));
    }
}
