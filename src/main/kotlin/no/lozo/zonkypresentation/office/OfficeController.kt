package no.lozo.zonkypresentation.office

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import org.springframework.web.bind.annotation.RequestBody

@RestController
class OfficeController(private val officeService: OfficeService) {

    @GetMapping("/office/{id}")
    fun getOfficeById(@PathVariable id: UUID): Office? {
        return officeService.getOfficeById(id)
    }

    @PostMapping("/office")
    fun createOffice(@RequestBody office: Office): Office {
        return officeService.createOffice(office)
    }


}