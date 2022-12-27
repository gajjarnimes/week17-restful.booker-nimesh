package com.restful.booker.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BookingIDExtraction {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI= "http://restfull-booker.herokuapp.com";

        response =given()
                .when()
                .get("/api/users?page=2")
                .then().statusCode(200);
    }
    //Extract the total object per page is 6
    @Test
    public void test001() {
        int per_page=response.extract().path("per_page");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of per_page is : "+per_page);
        System.out.println("------------------End of Test---------------------------");

    }
    //Extract the data 1 id is 8
    @Test
    public void test002() {
        int date1ID=response.extract().path("data[1].id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("data[1].id  is : "+ date1ID);
        System.out.println("------------------End of Test---------------------------");
    }


}
