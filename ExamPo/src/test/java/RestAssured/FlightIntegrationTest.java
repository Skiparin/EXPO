/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestAssured;

import static com.jayway.restassured.RestAssured.given;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Orvur
 */
public class FlightIntegrationTest {

    public FlightIntegrationTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

//    @Test
//    public void besicPingTest() {
//        given().when().get("http://localhost:8084/ExamPo/api/flight/get/CPH/SXF/2017-01-01T00:00:00.000Z/1").then().statusCode(200);
//    }
}
