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

public class RestAssuredUsersTest {

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
    public void getAllUserTest() {

        RestAssured
            .given()
            .spec(requestSpecification)
            .header("Authorization", "Bearer f40a00c8c07d3cf0b184ddcf78d2984cfe356f60ed23d331336367a92d7e38f7")
            .when()
            .get("/users")
            .then()
            .spec(responseSpecification)
            .statusCode(200);
    }

    @DataProvider
    public Object[][] UserDataProvider() {
        return new Object[][] {
            {"1953", "Steve Ondricka Sr.", "charles.hintz@hotmail.com", "male", "active"},
            {"1954", "Renaldo Raynor", "eulalia.cummerata@gmail.com", "female", "active"}
        };
    }

    @Test(dataProvider = "UserDataProvider")
    public void getOneUserTest(String id, String name, String email, String gender, String status) {

        RestAssured
            .given()
            .spec(requestSpecification)
            .header("Authorization", "Bearer f40a00c8c07d3cf0b184ddcf78d2984cfe356f60ed23d331336367a92d7e38f7")
            .pathParam("id", id)
            .when()
            .get("/users/{id}")
            .then()
            .spec(responseSpecification)
            .statusCode(200)
            .body("data.name", Matchers.equalTo(name),
                "data.email", Matchers.equalTo(email),
                "data.gender", Matchers.equalTo(gender),
                "data.status", Matchers.equalTo(status));
    }

    @Test(dataProvider = "UserDataProvider")
    public void changeUserTest(String id, String name, String email, String gender, String status) {

        String newStatus = "inactive";

        RestAssured
            .given()
            .spec(requestSpecification)
            .header("Authorization", "Bearer f40a00c8c07d3cf0b184ddcf78d2984cfe356f60ed23d331336367a92d7e38f7")
            .pathParam("id", id)
            .body("{\n"

                + "    \"status\": \"" + newStatus + "\"\n"
                + "}")
            .when()
            .put("/users/{id}")
            .then()
            .spec(responseSpecification)
            .body("data.status", Matchers.equalTo(newStatus));
    }

    @Test(dataProvider = "UserDataProvider")
    public void deleteUserTest(String id, String name, String email, String gender, String status) {

        RestAssured
            .given()
            .spec(requestSpecification)
            .header("Authorization", "Bearer f40a00c8c07d3cf0b184ddcf78d2984cfe356f60ed23d331336367a92d7e38f7")
            .pathParam("id", id)
            .when()
            .delete("/users/{id}")
            .then()
            .spec(responseSpecification)
            .statusCode(200);
    }

    @DataProvider
    public Object[][] CreateUserDataProvider() {
        return new Object[][] {
            {"Steve Ondricka Sr.", "charles.hintz@hotmail.com", "male", "active"},
            {"Renaldo Raynor", "eulalia.cummerata@gmail.com", "female", "active"}
        };
    }

    @Test(dataProvider = "CreateUserDataProvider")

    public void createUserTest(String fullName, String emailAddress, String gender, String status) {

        RestAssured
            .given()
            .spec(requestSpecification)
            .header("Authorization", "Bearer f40a00c8c07d3cf0b184ddcf78d2984cfe356f60ed23d331336367a92d7e38f7")
            .body("{\n"
                + "    \"name\": \"" + fullName + "\",\n"
                + "    \"email\": \"" + emailAddress + "\",\n"
                + "    \"gender\": \"" + gender + "\",\n"
                + "    \"status\": \"" + status + "\"\n"
                + "}")
            .when()
            .post("/users")
            .then()
            .spec(responseSpecification)
            .statusCode(200)
            .body("data.name", Matchers.equalTo(fullName))
            .body("data.email", Matchers.equalTo(emailAddress))
            .body("data.gender", Matchers.equalTo(gender))
            .body("data.status", Matchers.equalTo(status));
    }
}