package no.lozo.zonkypresentation.office

import jakarta.persistence.*
import java.util.*

@Table(name = "office")
class Office(
        @Column(nullable = false)
        val name: String,

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: UUID? = null,
)