package no.lozo.zonkypresentation.office

import io.zonky.test.db.AutoConfigureEmbeddedDatabase
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.ResponseEntity

@AutoConfigureEmbeddedDatabase
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OfficeControllerTest {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Autowired
    lateinit var officeRepository: OfficeRepository

    lateinit var existingOffice: Office

    @BeforeAll
    fun setUp() {
        existingOffice = officeRepository.save(Office("new office"))
    }

    @Test
    fun `getByOfficeId returns office`() {
        val response: ResponseEntity<Office> =
            testRestTemplate.getForEntity(
                "/office/${existingOffice.id}",
                Office::class.java
            )

        assertEquals(existingOffice.id, response.body?.id)
    }
}