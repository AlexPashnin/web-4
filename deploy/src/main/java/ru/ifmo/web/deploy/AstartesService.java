package ru.ifmo.web.deploy;

import ru.ifmo.web.database.dao.AstartesDAO;
import ru.ifmo.web.database.entity.Astartes;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@RequestScoped
@Path("/astartes")
@Produces({MediaType.APPLICATION_JSON})
public class AstartesService {
    @Inject
    private AstartesDAO astartesDAO;

    @WebMethod
    @GET
    @Path("/all")
    public List<Astartes> findAll() throws SQLException {
        return astartesDAO.findAll();
    }

    @WebMethod
    @GET
    @Path("/filter")
    public List<Astartes> findWithFilters(@QueryParam("id") Long id, @QueryParam("name") String name,
                                          @QueryParam("title") String title, @QueryParam("position") String position,
                                          @QueryParam("planet") String planet, @QueryParam("birthdate") Date birthdate) throws SQLException {
        return astartesDAO.findWithFilters(id, name, title, position, planet, birthdate);
    }
}
