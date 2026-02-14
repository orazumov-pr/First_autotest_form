package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
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

        //Заполнение формы
        //Селекторы для Name и Email
        $("#firstName").setValue("Oleg");
        $("#lastName").setValue("Razumov");
        $("#userEmail").setValue("razumov@mail.ru");

        //Селектор для radiobutton Gender
        $("#genterWrapper").$(byText("Male")).click();

        //Селектор для Mobile number
        $("#userNumber").setValue("89067776655");

        //Селекторы для Календаря
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $("option[value='1977']").click();
        $(".react-datepicker__month-select").click();
        $("option[value='1']").click();
        $(".react-datepicker__day.react-datepicker__day--014").click();

        //Селектор для Subjects
        $("#subjectsInput").setValue("Abstract text").pressEnter();

        //Селектор для radiobutton Hobbies
        $("#hobbies-checkbox-2").parent().click();

        //Селектор для вставки картинки
        $("#uploadPicture").uploadFromClasspath("resources/my_abstract_scr.jpg");

        //Селектор для вставки Current Address
        $("#currentAddress").setValue("Ulitsa Lenina, 1");

        //Селекторы для State and City
        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Merrut")).click();
        $("#submit").click();


        //Проверка
        $(".table-responsive").$(byText("Name")).parent().shouldHave(text("Oleg Razumov"));
        $(".table-responsive").$(byText("Email")).parent().shouldHave(text("razumov@mail.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("89067776655"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("14 January, 1977"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Abstract text"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("my_abstract_scr.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Ulitsa Lenina, 1"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Uttar Pradesh Merrut"));
    }
}
