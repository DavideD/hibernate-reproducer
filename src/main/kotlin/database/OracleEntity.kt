package database

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "TEST_TABLE")
@Cacheable
class OracleEntity: PanacheEntityBase() {
    @Id
    @Column(name = "UNIQUE_FAIL_TRANS_CT_NO", length = 36)
    lateinit var uniqueTransactionIdentifier: String

    @Column(name = "INTR_PYMT_ID")
    lateinit var internalPaymentIdentifier: String

    @Column(name = "CREAT_TS")
    lateinit var createTimestamp: LocalDateTime

    @Lob
    @Column(name = "TRANS_DTL_TX")
    lateinit var transactionDetail: String

    @Column(name = "LOAD_FAIL_RSN_TX", length = 500)
    lateinit var transactionFailureReason: String
}