package qa.guru.allure;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.okhttp3.AllureOkHttp3;
import io.qameta.allure.selenide.AllureSelenide;
import okhttp3.OkHttpClient;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

@Feature("Work with issues")
public class GitHubIssueTest {

//    private final static int ISSUE_NUMBER = 1;
//    private final static String REPOSITORY = "cheshi-mantu/qa-guru";
    private final static String REPOSITORY = "qa-guru";
    private final static String USERNAME = "cheshi-mantu";

    //using ApiSteps we created
    private ApiSteps apiSteps = new ApiSteps();
    //using basic steps we created
    private BasicSteps basicSteps = new BasicSteps();

    //private GitHubClient github; // don't need it here as we moved github client code to steps


    @Before // <= this is JUnit notation
    //Adding listener of selenide before all tests execution
    public void initSelenideListener () {
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true));
    }
//  this is sent to API steps
//    @Before
//    public void initGitHubClient() {
//        final OkHttpClient client = new OkHttpClient.Builder()
//                .addInterceptor(new AllureOkHttp3())
//                .build();
//        final Retrofit retrofit = new Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl("https://api.github.com")
//                .client(client) // needed for integration with OkHttp3, i.e. we can listen the events
//                .build();
//
//        github = retrofit.create(GitHubClient.class);
//    }
    @Before
    public void initGithubClient() {
    }

    @Test
    @Story("Check if issues do exist")
    @DisplayName("Allure Example - issue must exists in github repository")

    public void testIssueExists() throws Exception {
//        final Issue issue = new Issue();
//        issue.setTitle("test issue creation");
//        issue.setBody("the very test body");
//        Issue created = github.createIssue("cheshi-mantu", "qa-guru", issue).execute().body();

// this code below will be replaced with steps, see below
//        step("1. Open main page", () -> {
//            open("https://github.com");
//        });
//        //step("2. Authentication as user");
//        step("3. Open user's homepage with repo", ()-> {
//            $(".header-search-input").click();
//            $(".header-search-input").sendKeys(REPOSITORY);
//            $(".header-search-input").submit();
//            $(By.linkText(REPOSITORY)).shouldHave(Condition.visible);
//            $(By.linkText(REPOSITORY)).click();
//        });
//        step("4. Open user's page with issues", ()-> {
//            $(withText("Issues")).click();
//        });
//        step("5. Open check if we have issue with ID=" + created.getNumber(), ()-> {
//            $(withText("#"+created.getNumber())).exists();
//        });

        final Issue issue = apiSteps.createIssue(
                "cheshi-mantu",
                "qa-guru",
                "test issue from code with steps",
                "This is the body, indeed"
        );

        basicSteps.openMainPage(USERNAME);
        basicSteps.searchForRepository(USERNAME +"/" + REPOSITORY);
        basicSteps.openRepositoryIssues();
        basicSteps.shouldSeeIssueWithID(issue.getNumber());



    }
}
