package no.lozo.zonkypresentation.office

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface OfficeRepository : CrudRepository<Office, UUID>