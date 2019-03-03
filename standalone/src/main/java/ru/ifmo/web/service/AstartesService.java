package ru.ifmo.web.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.postgresql.ds.PGSimpleDataSource;
import ru.ifmo.web.database.dao.AstartesDAO;
import ru.ifmo.web.database.entity.Astartes;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Data
@Slf4j
@Path("/astartes")
@Produces({MediaType.APPLICATION_JSON})
public class AstartesService {
    private AstartesDAO astartesDAO;

    public AstartesService() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/astartes_db", "webuser", "webpassword");
        this.astartesDAO = new AstartesDAO(connection);
    }

    @GET
    @Path("/all")
    public List<Astartes> findAll() throws SQLException {
        return astartesDAO.findAll();
    }

    @GET
    @Path("/filter")
    public List<Astartes> findWithFilters(@QueryParam("id") Long id, @QueryParam("name") String name,
                                          @QueryParam("title") String title, @QueryParam("position") String position,
                                          @QueryParam("planet") String planet, @QueryParam("birthdate") Date birthdate) throws SQLException {
        return astartesDAO.findWithFilters(id, name, title, position, planet, birthdate);
    }
}
