package reproducer.test

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.apache.http.HttpStatus
import org.junit.jupiter.api.Test

@QuarkusTest
class InsertTest {

    @Test
    fun testInsertEndpoint() {
        given()
            .`when`().get("/insert")
            .then()
            .statusCode(HttpStatus.SC_ACCEPTED)
    }

}