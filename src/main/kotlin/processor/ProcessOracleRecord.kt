package processor

import database.OracleEntity
import database.OracleRepository
import io.smallrye.mutiny.Uni
import java.time.LocalDateTime
import java.util.UUID
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ProcessOracleRecord(private val oracleRepository: OracleRepository) {

    fun processRecord(): Uni<OracleEntity> {
        val oracleEntity = OracleEntity()
        oracleEntity.uniqueTransactionIdentifier = "9fc61a3f-ae8b-426f-8f63-fc3fec70d94c"
        oracleEntity.createTimestamp = LocalDateTime.now()
        oracleEntity.transactionDetail = "LOB Field"
        oracleEntity.internalPaymentIdentifier = "N/A"
        oracleEntity.transactionFailureReason = "N/A"
        return oracleRepository.save(oracleEntity)
    }

    fun readRecords(): Uni<List<OracleEntity>> {
        return oracleRepository.listAll()
    }
}