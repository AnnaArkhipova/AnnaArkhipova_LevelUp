package ru.levelup.at.homework8;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RestAssuredPostsTest {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "https://gorest.co.in/public-api";

        requestSpecification = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .setContentType(ContentType.JSON)
            .build();

        responseSpecification = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .build();
    }

    @Test
    public void getAllPostTest() {

        RestAssured
            .given()
            .spec(requestSpecification)
            .header("Authorization", "Bearer f40a00c8c07d3cf0b184ddcf78d2984cfe356f60ed23d331336367a92d7e38f7")
            .when()
            .get("/posts")
            .then()
            .spec(responseSpecification)
            .statusCode(200);
    }

    @DataProvider
    public Object[][] PostDataProvider() {
        return new Object[][] {
            {"1590", "10", "Title1", "Body1"},
            {"1591", "13", "Title2", "Body2"}
        };
    }

    @Test(dataProvider = "PostDataProvider")
    public void getOnePostTest(String id, String user_id, String title, String body) {

        RestAssured
            .given()
            .spec(requestSpecification)
            .header("Authorization", "Bearer f40a00c8c07d3cf0b184ddcf78d2984cfe356f60ed23d331336367a92d7e38f7")
            .pathParam("id", id)
            .when()
            .get("/posts/{id}")
            .then()
            .spec(responseSpecification)
            .statusCode(200)
            .body("data.user_id", Matchers.equalTo(Integer.valueOf(user_id)),
                "data.title", Matchers.equalTo(title),
                "data.body", Matchers.equalTo(body));
    }

    @Test(dataProvider = "PostDataProvider")
    public void changePostTest(String id, String user_id, String title, String body) {

        String newTitle = "Changing title";

        RestAssured
            .given()
            .spec(requestSpecification)
            .header("Authorization", "Bearer f40a00c8c07d3cf0b184ddcf78d2984cfe356f60ed23d331336367a92d7e38f7")
            .pathParam("id", id)
            .body("{\n"

                + "    \"title\": \"" + newTitle + "\"\n"
                + "}")
            .when()
            .put("/posts/{id}")
            .then()
            .spec(responseSpecification)
            .body("data.title", Matchers.equalTo(newTitle));
    }

    @Test(dataProvider = "PostDataProvider")
    public void deletePostTest(String id, String user_id, String title, String body) {

        RestAssured
            .given()
            .spec(requestSpecification)
            .header("Authorization", "Bearer f40a00c8c07d3cf0b184ddcf78d2984cfe356f60ed23d331336367a92d7e38f7")
            .pathParam("id", id)
            .when()
            .delete("/posts/{id}")
            .then()
            .spec(responseSpecification)
            .statusCode(200);
    }

    @DataProvider
    public Object[][] CreatePostDataProvider() {
        return new Object[][] {
            {"10", "Title1", "Body1"},
            {"13", "Title2", "Body2"}
        };
    }

    @Test(dataProvider = "CreatePostDataProvider")

    public void createPostTest(String user_id, String title, String body) {

        RestAssured
            .given()
            .spec(requestSpecification)
            .header("Authorization", "Bearer f40a00c8c07d3cf0b184ddcf78d2984cfe356f60ed23d331336367a92d7e38f7")
            .body("{\n"
                + "    \"user_id\": \"" + user_id + "\",\n"
                + "    \"title\": \"" + title + "\",\n"
                + "    \"body\": \"" + body + "\"\n"
                + "}")
            .when()
            .post("/posts")
            .then()
            .spec(responseSpecification)
            .statusCode(200)
            .body("data.user_id", Matchers.equalTo(Integer.valueOf(user_id)))
            .body("data.title", Matchers.equalTo(title))
            .body("data.body", Matchers.equalTo(body));
    }
}
