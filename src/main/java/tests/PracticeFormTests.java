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
        $(".react-datepicker__month-select").setValue("1");
        $(".react-datepicker__year-select").setValue("2026");
        $(".react-datepicker__day react-datepicker__day--008 react-datepicker__day--weekend").setValue("1");
        $(".subjects-auto-complete__input").setValue("Some text");

        //Добавить селекторы для radiobutton Hobbies



        $("#submit").click();

        $("#output #name").shouldHave(text("Alex"));
        $("#output #email").shouldHave(text("alex@egorov.com"));
        $("#output #currentAddress").shouldHave(text("Some street 1"));
        $("#output #permanentAddress").shouldHave(text("Another street 1"));
    }
}
