package reproducer.test

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.apache.http.HttpStatus
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@QuarkusTest
class InsertTest {

    @Test
    fun test() {
        given()
            .`when`().get("/insert")
            .then()
            .statusCode(HttpStatus.SC_ACCEPTED)

        given()
            .`when`().get("/listAll")
            .then()
            .contentType("application/json")
            .statusCode(HttpStatus.SC_OK)
            .body(containsString("\"transactionDetail\":\"LOB Field\""));
    }

}