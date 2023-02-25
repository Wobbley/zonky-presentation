package no.lozo.zonkypresentation.office

import org.springframework.stereotype.Service
import java.util.*

@Service
class OfficeService(private val officeRepository: OfficeRepository) {

    fun getOfficeById(id: UUID): Office? {
        return officeRepository.findById(id).orElse(null)
    }

    fun createOffice(office: Office): Office {
        return officeRepository.save(office)
    }
}