package dbUrIdea.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magnus on 15/06/2017.
 */
public class EmployeesEntity extends BaseEntity {




    private Connection conn = null;
    private Statement st = null;
    private ResultSet rs = null;

    public boolean validar(String nom ,
                           String clave ){
        boolean encontrado = false;
        try {
            conn = this.getConnection();
            st = conn.createStatement();
            rs=st.executeQuery("select * from" +
                    " employees where employee_name  = '"+nom+"' and password = '"+clave+"'");
            if (rs.next()){
                encontrado=true;
            }
            this.closesConnection();

        }catch (Exception e){

        }
        return encontrado;
    }

    public EmployeesEntity() {
        super();

    }

    public EmployeesEntity(Connection connection) {

        super(connection,"employees");
    }

    public List<Employee> findAll(
            CompaniesEntity companiesEntity,
                                  EmailAddressesEntity emailAddressesEntity,AreasEntity areasEntity) {
        return findByCriteria("", companiesEntity, emailAddressesEntity,areasEntity);
    }
    public Employee findById(int id,
                             CompaniesEntity companiesEntity,

                             EmailAddressesEntity emailAddressesEntity,AreasEntity areasEntity
                            ) {
        String criteria = "id = " + String.valueOf(id);
        return findByCriteria(criteria, companiesEntity,
                emailAddressesEntity,areasEntity).get(0);
    }


    public List<Employee> listFindById(int id,
                             CompaniesEntity companiesEntity,

                             EmailAddressesEntity emailAddressesEntity,AreasEntity areasEntity
    ) {
        String criteria = "id = " + id;
        return findByCriteria(criteria, companiesEntity,
                emailAddressesEntity,areasEntity);
    }


    public Employee findByName(String name,
                               CompaniesEntity companiesEntity,

                               EmailAddressesEntity emailAddressesEntity,AreasEntity areasEntity
                              ) {
        String criteria = "employee_name = " + "'" + name + "'";
        return findByCriteria(criteria, companiesEntity,
                emailAddressesEntity,areasEntity).get(0);
    }

    public Employee findByFirstLastName(String firstLastName,
                                        CompaniesEntity companiesEntity,

                                        EmailAddressesEntity emailAddressesEntity,AreasEntity areasEntity
                                        ) {
        String criteria = "employee_first_last_name = " + "'" + firstLastName + "'";
        return findByCriteria(criteria, companiesEntity,
                emailAddressesEntity,areasEntity).get(0);
    }

    public Employee findByIdCompany(String id,
                                    CompaniesEntity companiesEntity,

                                    EmailAddressesEntity emailAddressesEntity,AreasEntity areasEntity
                                    ) {
        String criteria = "id_company = " + String.valueOf(id);
        return findByCriteria(criteria, companiesEntity,
                emailAddressesEntity,areasEntity).get(0);
    }

//-------------------
    public List<Employee> findAdministradores(int type ,int id_company,
                                               CompaniesEntity companiesEntity,

                                               EmailAddressesEntity emailAddressesEntity,AreasEntity areasEntity
    ) {
        String criteria = "employee_type = "+type+" and id_company= "+id_company;
        return findByCriteria(criteria, companiesEntity,
                emailAddressesEntity,areasEntity);
    }

    public List<Employee> findEmpXarea(int type ,int id_company, int area,
                                              CompaniesEntity companiesEntity,

                                              EmailAddressesEntity emailAddressesEntity,
                                       AreasEntity areasEntity
    )
    {
        String criteria = "employee_type = "+type+" and id_company= "+id_company+" and id_areas = "+area;
        return findByCriteria(criteria, companiesEntity,
                emailAddressesEntity,areasEntity);
    }





    public List<Employee> findEmployee(int id_company,
                                              CompaniesEntity companiesEntity,

                                              EmailAddressesEntity emailAddressesEntity,AreasEntity areasEntity
    ) {
        String criteria = "id_company= "+id_company;
        return findByCriteria(criteria, companiesEntity,
                emailAddressesEntity,areasEntity);
    }


    public Employee findByIdUserType(String id,
                                     CompaniesEntity companiesEntity,

                                     EmailAddressesEntity emailAddressesEntity,AreasEntity areasEntity
                                     ) {
        String criteria = "id_user_type = " + String.valueOf(id);
        return findByCriteria(criteria, companiesEntity,
                emailAddressesEntity,areasEntity).get(0);
    }


    public Employee findBySecondLastName(String secondLastName,
                                         CompaniesEntity companiesEntity,

                                         EmailAddressesEntity emailAddressesEntity,AreasEntity areasEntity
                                         ) {
        String criteria = "employee_second_last_name = " + "'" + secondLastName + "'";
        return findByCriteria(criteria, companiesEntity,
                emailAddressesEntity,areasEntity).get(0);
    }

    public List<Employee> findByCriteria(String criteria, CompaniesEntity companiesEntity,
                                         EmailAddressesEntity emailAddressesEntity,AreasEntity areasEntity) {

        String sql = getDefaultQuery() +
                (criteria.equalsIgnoreCase("") ? "" : " WHERE " + criteria);

        List<Employee> employees = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            if(rs == null) return null;
            while(rs.next()) employees.add(Employee.build(rs,
                    companiesEntity,emailAddressesEntity,areasEntity));
            return employees;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
    public boolean update(Employee employee) {
        String sql = "UPDATE employees SET " +
                "password = "+employee.getPasswordAsValue()+ ", " +
                "employee_name = " +employee.getNameAsValue()+ ", " +
                "employee_first_last_name = " + employee.getFirstLastNameAsValue()+ ", " +
                "employee_second_last_name = "+ employee.getSecondLastNameAsValue()+ ", " +
                "dni = "+ employee.getDniAsString()+ ", " +
                "phone_number = "+ employee.getPhoneNumberAsString()+ ", " +
                "cell_phone_number = " + employee.getCellPhoneNumberAsString()+ ", " +
                "address = "+ employee.getAddressAsValue()+ ", " +
                "department = "+employee.getDepartmentAsValue()+ ", " +
               "birthdate = "+employee.getBirthdateAsValue()+
                " WHERE id = " + employee.getIdAsString();

        return change(sql);
    }


    public boolean updateData(Employee employee) {
        String sql = "UPDATE employees SET " +
                "password = "+employee.getPasswordAsValue()+ ", " +
                "employee_name = " +employee.getNameAsValue()+ ", " +
                "employee_first_last_name = " + employee.getFirstLastNameAsValue()+ ", " +
                "employee_second_last_name = "+ employee.getSecondLastNameAsValue()+ ", " +
                "dni = "+ employee.getDniAsString()+ ", " +
                "phone_number = "+ employee.getPhoneNumberAsString()+ ", " +
                "cell_phone_number = " + employee.getCellPhoneNumberAsString()+ ", " +
                "address = "+ employee.getAddressAsValue()+ ", " +
                "department = "+employee.getDepartmentAsValue()+ ", " +
                "birthdate = "+employee.getBirthdateAsValue()+
                " WHERE id = " + employee.getIdAsString();

        return change(sql);
    }

    public boolean CambioArea(Employee employee) {
        String sql = "UPDATE employees SET " +
                "id_areas = "+employee.getArea().getIdAsString()+
                " WHERE id = " + employee.getIdAsString();

        return change(sql);
    }



    public boolean changeEmployee(Employee employee) {
        String sql = "UPDATE employees SET " +
                "employee_type = "+employee.getEmployeeTypeAsString()+
                " WHERE id = " + employee.getIdAsString();
        return change(sql);
    }





    public boolean add(Employee employee) {
        String sql = "INSERT employees(" +
                "id_company, id_email_address, id_areas, employee_type, password, " +
                "employee_name, employee_first_last_name, employee_second_last_name," +
                " dni, phone_number, cell_phone_number, address, department, birthdate) " +
                "VALUES("
                +employee.getCompany().getIdAsString()+ ", "
                +employee.getEmailAddress().getIdAsString()+ ", "
                +employee.getArea().getIdAsString()+", "
                +employee.getEmployeeTypeAsString()+ ", "
                +employee.getPasswordAsValue()+ ", "
                +employee.getNameAsValue()+ ", "
                +employee.getFirstLastNameAsValue()+ ", "
                +employee.getSecondLastNameAsValue()+ ", "
                +employee.getDniAsString()+", "
                +employee.getPhoneNumberAsString()+ ", "
                +employee.getCellPhoneNumberAsString()+ ", "
                +employee.getAddressAsValue()+ ", "
                +employee.getDepartmentAsValue()+ ", "
                 +employee.getBirthdateAsValue()
                + ")";
        return change(sql);
    }


    public boolean add2(Employee employee) {
        String sql = "INSERT employees(" +
                "id_company, id_email_address, id_areas, employee_type, password, " +
                "employee_name, dni, birthdate) "+
                "VALUES("
                +employee.getCompany().getIdAsString()+", "
                +employee.getEmailAddress().getIdAsString()+ ", "
                +employee.getArea().getIdAsString()+", "
                +employee.getEmployeeTypeAsString()+ ", "
                +employee.getPasswordAsValue()+ ", "
                +employee.getNameAsValue()+", "
                +employee.getDni()+", "
                +employee.getBirthdateAsValue()
                + ")";
        return change(sql);
    }



    public boolean delete(Employee employee) {
        String sql = "DELETE FROM employees WHERE id = " +
                employee.getIdAsString();
        return change(sql);
    }
    public boolean delete(String id) {
        String sql = "DELETE FROM employees WHERE id = " +
                "'" + id + "'";
        return change(sql);
    }
/*
    public boolean verAdministrador(Employee employee) {
        String sql = "SELECT * from employees where employee_type = " +
                "'" + id + "'";
        return change(sql);
    }*/

//VALIDAR CORREO Y CONTRASEÑA
    public Employee findByNameAndPass(String email,String password ,

                                      EmailAddressesEntity emailAddressEntity,
                                      CompaniesEntity companiesEntity,AreasEntity areasEntity) {
        return findIdByEmailAndPassword(email,password ,emailAddressEntity,
                companiesEntity,areasEntity).get(0);
    }

    public List<Employee> findIdByEmailAndPassword(String email, String password,
                                                   EmailAddressesEntity emailAddressEntity,
                                                   CompaniesEntity companiesEntity,AreasEntity areasEntity) {

        String sql ="select a.id,a.id_company,a.id_email_address,a.id_areas," +
                "a.employee_type,a.password,a.employee_name,a.employee_first_last_name" +
                ",a.employee_second_last_name,a.dni,a.phone_number," +
                "a.cell_phone_number,a.photo,a.address,a.department," +
                "a.birthdate from employees a left join email_addresses b on " +
                "a.id_email_address = b.id where email_data= '"+email+"' and " +
                "a.password = '"+password+"'";
        List<Employee> employees = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            if(rs == null) return null;
            while(rs.next()) employees.add
                    (Employee.build(rs, companiesEntity,
                            emailAddressEntity,areasEntity));
            return employees;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }


/*
    public List<Employee> findEvaluationPromedioById(//int id,
                                                   EmailAddressesEntity emailAddressEntity,
                                                   CompaniesEntity companiesEntity,AreasEntity areasEntity) {
        String sql ="select id_user_employee, avg(grade), avg(communication), " +
                "avg(ethic), avg(team_management),avg(decision_making), "+
        "avg(strategic_thinking), avg(customer_orientation), avg(social_responsability),avg(time_management),"+
                "avg(use_of_resources), avg(cost_orientation), avg(knowledge_of_languages),avg(digital_skills) from"+
        " evaluations where id_user_employee = 15";
        List<Employee> employees = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            if(rs == null) return null;
            while(rs.next()) employees.add(Employee.build(rs, companiesEntity, emailAddressEntity,areasEntity));
            return employees;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
*/

}