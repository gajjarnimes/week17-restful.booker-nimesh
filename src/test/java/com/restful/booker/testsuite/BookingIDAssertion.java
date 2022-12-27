package com.restful.booker.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class BookingIDAssertion {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://restfull-booker.herokuapp.com";
        RestAssured.basePath = "/api";
        response = given()
                .when()
                .get("/index.html")
                .then().statusCode(200);
    }
   // Verify the bookingid=594
    @Test
    public void test01() {
        response.body("bookingid", equalTo(594));

    }
    // verify the firstName = Mary
    @Test
    public void test02(){
        response.body("firstname",equalTo("Mary"));
    }
    // verify the lastName = Brown
    @Test
    public void test03(){
        response.body("lastname",equalTo("Brown"));
    }
    // verify the booking id =235
    @Test
    public void test04(){
        response.body("bookingid",equalTo(235));
    }

}
