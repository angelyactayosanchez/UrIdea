package dbUrIdea.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by UrIdea on 14/06/2017.
 */
public class Evaluation {
    private String id;
    private Employee idEmployee;
   private Employee idUserEmployee;
    private Company company;
    private Date date;
    private float grade;

    public Evaluation() {
    }
    public Evaluation(String id, Employee idEmployee, Employee idUserEmployee, Company company, Date date, float grade) {
        this.id = id;
        this.idEmployee = idEmployee;
        this.idUserEmployee = idUserEmployee;
        this.company = company;
        this.date = date;
        this.grade = grade;
    }
    public String getIdAsValue() {
        return "'" + getId() + "'";
    }

    public String getDateAsValue()
    {
        return "'" +String.valueOf(getDate())+ "'";
    }

    public String getGradeAsString()
    {
        return String.valueOf(getGrade());
    }





    public String getId() {
        return id;
    }

    public Evaluation setId(String id) {
        this.id = id;
        return this;
    }

    public Employee getIdEmployee() {
        return idEmployee;
    }

    public Evaluation setIdEmployee(Employee idEmployee) {
        this.idEmployee = idEmployee;
        return this;
    }

    public Employee getIdUserEmployee() {
        return idUserEmployee;
    }

    public Evaluation setIdUserEmployee(Employee idUserEmployee) {
        this.idUserEmployee = idUserEmployee;
        return this;
    }

    public Company getCompany() {
        return company;
    }

    public Evaluation setCompany(Company company) {
        this.company = company;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Evaluation setDate(Date date) {
        this.date = date;
        return this;
    }

    public float getGrade() {
        return grade;
    }

    public Evaluation setGrade(float grade) {
        this.grade = grade;
        return this;
    }

    public static Evaluation build(ResultSet rs,
                           EmployeesEntity employeesEntity,
                           CompaniesEntity companiesEntity,
                           EmailAddressesEntity emailAddressesEntity
    ) {
        try {
            return (new Evaluation())
                    .setId(rs.getString("id"))
                    .setIdEmployee(employeesEntity.findById(
                            rs.getString("id_evaluator")
                            , companiesEntity, emailAddressesEntity
                            ))
                    .setIdUserEmployee(employeesEntity.findById(
                            rs.getString("id_user_employee")
                            , companiesEntity, emailAddressesEntity
                           ))
                    .setCompany(companiesEntity.findById(
                            rs.getString("id_company"),
                            emailAddressesEntity))
                    .setDate(rs.getDate("evaluation_date"))
                    .setGrade(rs.getFloat("grade"));




        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
