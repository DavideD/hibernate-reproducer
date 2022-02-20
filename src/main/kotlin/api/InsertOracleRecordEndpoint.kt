package api

import io.smallrye.mutiny.Uni
import processor.ProcessOracleRecord
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.core.Response
import kotlin.io.path.ExperimentalPathApi

@ExperimentalPathApi
@Path("/")
class InsertOracleRecordEndpoint @Inject constructor(private val processOracleRecord: ProcessOracleRecord) {
    @GET
    @Path("insert")
    fun testOracleInsert() : Uni<Response> {
        return Uni.createFrom().voidItem()
            .call { -> processOracleRecord.processRecord() }
            .map { Response.accepted().build() }
    }
}