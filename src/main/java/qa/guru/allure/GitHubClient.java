package qa.guru.allure;

import retrofit2.Call;
import retrofit2.http.*;
import okhttp3.ResponseBody;

public interface GitHubClient {
// header will be added dynamically
//    @Headers({
//            "Authorization: token {token here}"
//    })
    @POST("/repos/{owner}/{repo}/issues")
    // see https://developer.github.com/v3/issues/#create-an-issue
    Call<Issue> createIssue(@Path("owner") String owner,
                            @Path("repo") String repo,
                            @Body Issue issue);
}
