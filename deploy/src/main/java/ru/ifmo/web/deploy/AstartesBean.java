package ru.ifmo.web.deploy;

import lombok.Data;
import ru.ifmo.web.database.dao.AstartesDAO;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

@Data
@ApplicationScoped
public class AstartesBean {
    @Resource(lookup = "jdbc/astartes")
    private DataSource dataSource;

    @Produces
    public AstartesDAO marineDAO() {
        return new AstartesDAO(dataSource);
    }
}
