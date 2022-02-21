package processor

import database.OracleEntity
import database.OracleRepository
import io.smallrye.mutiny.Uni
import java.time.LocalDateTime
import java.util.UUID
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ProcessOracleRecord(private val oracleRepository: OracleRepository) {
    private val oracleEntity = OracleEntity()

    fun processRecord(): Uni<Void> {
        oracleEntity.uniqueTransactionIdentifier = UUID.randomUUID().toString()
        oracleEntity.createTimestamp = LocalDateTime.now()
        oracleEntity.transactionDetail = "N/A"
        oracleEntity.internalPaymentIdentifier = "N/A"
        oracleEntity.transactionFailureReason = "N/A"
        return oracleRepository.save(oracleEntity).replaceWithVoid()
    }
}