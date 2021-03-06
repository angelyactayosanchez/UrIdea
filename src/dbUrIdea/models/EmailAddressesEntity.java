package dbUrIdea.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yoshinon on 15/06/2017.
 */
public class EmailAddressesEntity extends BaseEntity {

    public EmailAddressesEntity(Connection connection) {

        super(connection,"email_addresses");
    }

    public EmailAddressesEntity() {

        super();
    }

    //+++++++++++++++++++++++++++++
    List<EmailAddress> findAll() {

        return findByCriteria("");
    }


    public EmailAddress findById(int id) {
        String criteria = " id = " + String.valueOf(id);

        return findByCriteria(criteria).get(0);
    }


    public EmailAddress findIdByEmailData(String email) {
        String criteria = "email_data  = '"+
                email+"'";
        return findByCriteriaEmail(criteria).get(0);
    }

    public List<EmailAddress> findAllOrderedByEmail() {
        String criteria = "true ORDER BY email_data";
        return findByCriteria(criteria);
    }

    public List<EmailAddress> findAllOrderById( boolean isAscending) {
        return findByCriteria("true ORDER BY id" +
                (isAscending ? "" : " DESC"));
    }


    public List<EmailAddress> findByCriteria(String criteria) {
        String sql = getDefaultQuery() +
                (criteria.equalsIgnoreCase("") ? "" : " WHERE " + criteria);
        List<EmailAddress> emails_addresses = new ArrayList<>();
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(sql);
            if(rs == null) return null;
            while(rs.next()) {
            emails_addresses.add(EmailAddress.build(rs));

            }
            return emails_addresses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emails_addresses;
    }


    public List<EmailAddress> findByCriteriaEmail(String criteria) {
        String sql = getDefaultEmailQuery() +
                (criteria.equalsIgnoreCase("") ? "" : " WHERE " + criteria);
        List<EmailAddress> emails_addresses = new ArrayList<>();
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(sql);
            if(rs == null) return null;
            while(rs.next()) {
                emails_addresses.add(EmailAddress.build2(rs));

            }
            return emails_addresses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emails_addresses;
    }

    public boolean add(EmailAddress emailAddress) {
        String sql = "INSERT email_addresses (email_data) " +
                "VALUES ("+ emailAddress.getEmailDataAsValue() + ")";
        return change(sql);
    }

    public boolean deleteById(EmailAddress emailAddress) {
        String sql = "DELETE FROM email_addresses WHERE id = " + emailAddress.getIdAsString();
        return change(sql);
    }
    public boolean delete(String email) {
        return change("DELETE FROM email_addresses WHERE email_data = " +
                "'" + email + "'");
    }

    public boolean update(EmailAddress emailAddress) {
        String sql = "UPDATE email_addresses SET email_data = "
                + emailAddress.getEmailDataAsValue() +
                " WHERE id = " + emailAddress.getIdAsString();
        return change(sql);
    }






}
