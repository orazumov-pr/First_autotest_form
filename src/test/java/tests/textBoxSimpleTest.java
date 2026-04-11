package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class textBoxSimpleTest extends TestBase {


    @Test
    void successfulFillFormTest() {
        open("/text-box");

        $("#userName").setValue("Razumov Oleg");
        $("#userEmail").setValue("orazumov@mail.ru");
        $("#currentAddress").setValue("first user address");
        $("#permanentAddress").setValue("second user address");
        $("#submit").click();
    }
}
