package database

import io.quarkus.hibernate.reactive.panache.Panache
import io.quarkus.hibernate.reactive.panache.PanacheRepository
import io.smallrye.mutiny.Uni
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class OracleRepository: PanacheRepository<OracleEntity> {
    fun save(entity: OracleEntity) : Uni<OracleEntity> {
        return Panache.withTransaction { persist(entity) }
    }
}