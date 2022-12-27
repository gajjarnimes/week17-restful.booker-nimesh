package com.restful.booker.crudtest;

import com.restful.booker.model.CustomerPojo;
import com.restful.booker.model.LoginPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class BookingCRUDTest extends TestBase {

    @Test
    public void createToken() {
        LoginPojo loginPojo = new LoginPojo();
        loginPojo.setUsername("admin");
        loginPojo.setPassword("password123");
        Response response = given()
                .header("Content-Type", "application/json")
                .body(loginPojo)
                .when()
                .post("/auth");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void createBooking() {
        CustomerPojo customerPojo = new CustomerPojo();
        HashMap<Object, Object> bookingDatesData = new HashMap<>();
        bookingDatesData.put("checkin", 2024 - 01 - 01);
        bookingDatesData.put("checkout", 2025 - 01 - 01);
        customerPojo.setFirstname("Manan");
        customerPojo.setLastname("Shah");
        customerPojo.setTotalprice(111);
        customerPojo.setDepositpaid(true);
        customerPojo.setBookingdates(bookingDatesData);
        customerPojo.setAdditionalneeds("Breakfast");
        Response response = given()
                .header("Content-Type", "application/json")
                .header("cookie", "token=ab6bcd40bef3eb4")
                .body(customerPojo)
                .when()
                .post("/booking");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void updateBooking() {
        CustomerPojo customerPojo = new CustomerPojo();
        HashMap<Object, Object> bookingDatesData = new HashMap<>();
        bookingDatesData.put("checkin", 2024 - 01 - 01);
        bookingDatesData.put("checkout", 2025 - 01 - 01);
        customerPojo.setFirstname("James");
        customerPojo.setLastname("Brown");
        customerPojo.setTotalprice(111);
        customerPojo.setDepositpaid(true);
        customerPojo.setBookingdates(bookingDatesData);
        customerPojo.setAdditionalneeds("Breakfast");
        Response response = given()
                .header("Content-Type", "application/json")
                .auth().preemptive().basic("admin", "password123")
                .header("Accept", "application/json")
                .body(customerPojo)
                .when()
                .put("/booking/1132");
        response.prettyPrint();

    }

}
