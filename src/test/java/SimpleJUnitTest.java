import com.codeborne.selenide.Config;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleJUnitTest {

  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080"; // Расширение браузера
    Configuration.baseUrl = "https://demoqa.com"; // Задать урл
    Configuration.pageLoadStrategy = "eager"; // Параметры загрузки страницы
    Configuration.holdBrowserOpen = true; // Не закрывать браузер
    Configuration.timeout = 5000; // Таймаут дефолт 4000
  }

  @Test
  void fillFormTests() {
    open("/text-box");
    $("#userName").setValue("Igor");
    $("#userEmail").setValue("Igor19@mail.ru");
    $("#currentAddress").setValue("Street 1");
    $("#permanentAddress").setValue("Street 2");
    $("#submit").click();

    $("#output #name").shouldHave(text("Igor"));
    $("#output #email").shouldHave(text("Igor19@mail.ru"));
    $("#output #currentAddress").shouldHave(text("Street 1"));
    $("#output #permanentAddress").shouldHave(text("Street 2"));
  }


}
