package no.lozo.zonkypresentation.office

import java.util.UUID
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.ResponseEntity
import org.springframework.test.context.jdbc.Sql

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql("/office-controller-test-data.sql")
class OfficeControllerTest {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun `getByOfficeId returns office`() {
        val response: ResponseEntity<Office> = testRestTemplate.getForEntity(
            "/office/9eab95f9-5899-428a-a2ca-7ff01579e84f", Office::class.java
        )

        assertEquals(UUID.fromString("9eab95f9-5899-428a-a2ca-7ff01579e84f"), response.body?.id)
    }

    @Test
    fun `createOffice creates a new office`() {
        val response: ResponseEntity<Office> =
            testRestTemplate.postForEntity("/office", Office("new office"), Office::class.java)

        assertNotNull(response.body?.id)
        assertEquals("new office", response.body?.name)
    }
}