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

public class RestAssuredCommentsTest {

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
    public void getAllCommentTest() {

        RestAssured
            .given()
            .spec(requestSpecification)
            .header("Authorization", "Bearer f40a00c8c07d3cf0b184ddcf78d2984cfe356f60ed23d331336367a92d7e38f7")
            .when()
            .get("/comments")
            .then()
            .spec(responseSpecification)
            .statusCode(200);
    }

    @DataProvider
    public Object[][] CommentDataProvider() {
        return new Object[][] {
            {"1573", "32", "Name1", "name1@google.com", "Body1"},
            {"1574", "33", "Name2", "name2@google.com", "Body2"}
        };
    }

    @Test(dataProvider = "CommentDataProvider")
    public void getOneCommentTest(String id, String post_id, String name, String email, String body) {

        RestAssured
            .given()
            .spec(requestSpecification)
            .header("Authorization", "Bearer f40a00c8c07d3cf0b184ddcf78d2984cfe356f60ed23d331336367a92d7e38f7")
            .pathParam("id", id)
            .when()
            .get("/comments/{id}")
            .then()
            .spec(responseSpecification)
            .statusCode(200)
            .body("data.post_id", Matchers.equalTo(Integer.valueOf(post_id)),
                "data.name", Matchers.equalTo(name),
                "data.email", Matchers.equalTo(email),
                "data.body", Matchers.equalTo(body));
    }

    @Test(dataProvider = "CommentDataProvider")
    public void changeCommentTest(String id, String post_id, String name, String email, String body) {

        String newName = "Changing name";

        RestAssured
            .given()
            .spec(requestSpecification)
            .header("Authorization", "Bearer f40a00c8c07d3cf0b184ddcf78d2984cfe356f60ed23d331336367a92d7e38f7")
            .pathParam("id", id)
            .body("{\n"

                + "    \"name\": \"" + newName + "\"\n"
                + "}")
            .when()
            .put("/comments/{id}")
            .then()
            .spec(responseSpecification)
            .body("data.name", Matchers.equalTo(newName));
    }

    @Test(dataProvider = "CommentDataProvider")
    public void deleteCommentTest(String id, String post_id, String name, String email, String body) {

        RestAssured
            .given()
            .spec(requestSpecification)
            .header("Authorization", "Bearer f40a00c8c07d3cf0b184ddcf78d2984cfe356f60ed23d331336367a92d7e38f7")
            .pathParam("id", id)
            .when()
            .delete("/comments/{id}")
            .then()
            .spec(responseSpecification)
            .statusCode(200);
    }

    @DataProvider
    public Object[][] CreateCommentDataProvider() {
        return new Object[][] {
            {"32", "Name1", "name1@google.com", "Body1"},
            {"33", "Name2", "name2@google.com", "Body2"}
        };
    }

    @Test(dataProvider = "CreateCommentDataProvider")

    public void createCommentTest(String post_id, String name, String email, String body) {

        RestAssured
            .given()
            .spec(requestSpecification)
            .header("Authorization", "Bearer f40a00c8c07d3cf0b184ddcf78d2984cfe356f60ed23d331336367a92d7e38f7")
            .body("{\n"
                + "    \"post_id\": \"" + post_id + "\",\n"
                + "    \"name\": \"" + name + "\",\n"
                + "    \"email\": \"" + email + "\",\n"
                + "    \"body\": \"" + body + "\"\n"
                + "}")
            .when()
            .post("/comments")
            .then()
            .spec(responseSpecification)
            .statusCode(200)
            .body("data.post_id", Matchers.equalTo(Integer.valueOf(post_id)))
            .body("data.name", Matchers.equalTo(name))
            .body("data.email", Matchers.equalTo(email))
            .body("data.body", Matchers.equalTo(body));
    }
}
