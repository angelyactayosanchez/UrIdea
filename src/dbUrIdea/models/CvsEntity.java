package dbUrIdea.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Yoshinon on 15/06/2017.
 */
public class CvsEntity extends BaseEntity {

    public CvsEntity() {
        super();
    }

    public CvsEntity(Connection connection) {
        super(connection,"cvs");
    }

    public List<Cv> findAll(EmployeesEntity employeesEntity,
                            CompaniesEntity companiesEntity,
                            EmailAddressesEntity emailAddressesEntity
                            ) {
        return findByCriteria("", employeesEntity,companiesEntity, emailAddressesEntity
                );
    }

    public Cv findById(int id,
                       EmployeesEntity employeesEntity,
                       CompaniesEntity companiesEntity,
                       EmailAddressesEntity emailAddressesEntity
                       ) {
        String criteria = "id = " + String.valueOf(id);
        return findByCriteria(criteria, employeesEntity, companiesEntity,  emailAddressesEntity).get(0);
    }

    public List<Cv> findByCriteria(String criteria, EmployeesEntity employeesEntity,
                                   CompaniesEntity companiesEntity,
                                   EmailAddressesEntity emailAddressesEntity
                                   ) {
        String sql = getDefaultQuery() +
                (criteria.equalsIgnoreCase("") ? "" : " WHERE " + criteria);
        List<Cv> cvs = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            if(rs == null) return null;
            while(rs.next()) cvs.add(Cv.build(rs, employeesEntity, companiesEntity,  emailAddressesEntity
            ));
            return cvs;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return cvs;
    }

    public List<Cv> findAllOrderByName(EmployeesEntity employeesEntity,
                                       CompaniesEntity companiesEntity,
                                       EmailAddressesEntity emailAddressesEntity,
                                       boolean isAscending) {
        return findByCriteria("true ORDER BY id" +
                (isAscending ? "" : " DESC"), employeesEntity, companiesEntity, emailAddressesEntity
                );
    }
//ponerlo al resto de enititys
    public boolean add(Cv cv) {
        String sql = "INSERT cvs(id_employee, cv_type, description) VALUES(" +
                cv.getEmployee().getIdAsString()+", " +
                cv.getcvTypeAsString()+ ", " +
                cv.getDescriptionAsValue()+
                ")";
        return change(sql);
    }

    public boolean update(Cv cv) {
        String sql = "UPDATE cvs SET " +
                "cv_type = " + cv.getcvTypeAsString() +", "+
                "description = " + cv.getDescriptionAsValue() +
                " WHERE id = " + cv.getIdAsString();
        return change(sql);
    }

    public boolean delete(Cv cv) {
        String sql = "DELETE FROM cvs WHERE id = " +
                cv.getIdAsString();
        return change(sql);
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM cvs WHERE id = " +
                "'" + id + "'";
        return change(sql);
    }




}
