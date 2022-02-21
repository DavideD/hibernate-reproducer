package api

import database.OracleEntity
import io.smallrye.mutiny.Uni
import processor.ProcessOracleRecord
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.Response
import kotlin.io.path.ExperimentalPathApi

@ExperimentalPathApi
@Path("/")
@Produces("application/json")
@Consumes("application/json")
class InsertOracleRecordEndpoint @Inject constructor(private val processOracleRecord: ProcessOracleRecord) {

    @GET
    @Path("insert")
    fun testOracleInsert(): Uni<Response> {
        return processOracleRecord.processRecord()
            .map(Response::accepted)
            .map { it.build() }
    }

    @GET
    @Path("listAll")
    fun listAll(): Uni<List<OracleEntity>> {
        return processOracleRecord.readRecords()
    }
}