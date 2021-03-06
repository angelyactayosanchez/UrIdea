package dbUrIdea.viewcontrollers;

import dbUrIdea.models.*;
import dbUrIdea.services.HRService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Yoshinon on 14/07/2017.
 */
@WebServlet(name = "SesionCompanyServlet",urlPatterns = "/v")

public class SesionCompanyServlet extends HttpServlet {
    // Service Layer access object
    HRService service = new HRService();
    // Action View Paths
    public static String VaMensajeEntra_URI = "/VaMensajeEntrada.jsp";



    public static String EDItCompany_URI = "/_CompaniesForm.jsp";




    public static String Menu_Root_URI = "/VaRoot.jsp";


    public static String outCompany_URI = "/index.jsp";

    public static String MenuRoot_URI = "/menuRoot.jsp";

    public static String UpdateCompanyEmail_URI = "/_EmailsForm.jsp";

    public static String Adm_URI = "/menuRoot.jsp";

    public static String ListEmpleados_URI = "/listEmpleado.jsp";

    public static String NuevoEmailEmp_URI = "/newEmpEmail.jsp";

    public static String NuevoEmpleadoAdm_URI = "/newEmpAdm.jsp";


    public static String createComp_URI = "/CreateComp.jsp";
    public static String primeraSesionComp_URI = "/priMesaje.jsp";

    public static String listaAdministradores = "listAdministrators.jsp";

    public static String ChangeAdm_URI = "/changeAdmin.jsp";

    public static String ChangeEmpl_URI = "/changeEmployee.jsp";

    public static String perfilEmployee_uri = "/PerfilPrueba.jsp";
    public static String perfilAdmin_uri = "/PerfilAdminRoot.jsp";


    public static String perfilHistorialEvaluEmployee_uri = "/PerfilHistorialEvaluation1Root.jsp";;
    public static String perfilHistoEvaluAdminitracionEmployee_uri = "/PerfilHistorialEvaluationAdministracionRoot.jsp";
    public static String perfilHistoEvaluInformaticaEmployee_uri = "/PerfilHistorialEvaluationInformaticaRoot.jsp";
    public static String perfilHistoEvaluMarketingEmployee_uri = "/PerfilHistorialEvaluationMarketingRoot.jsp";
    public static String perfilHistoProduccionEmployee_uri = "/PerfilHistorialEvaluationProduccionRoot.jsp";

    public static String listaAreaEmployee_uri = "/listaXarea.jsp";
    public static String perfilCompany_uri = "/PerfilCompañia.jsp";

    public static String changeAreaEmpl_uri = "/CambioArea.jsp";
    public static String addCv_uri = "/addCvRoot.jsp";

    public static String noTimeCv = "/noTimeCv.jsp";
    public static String EditarCv = "/CvAdmEditar.jsp";


    int codCom;
    int EmpEvaluado;
    int idArea;
    String email;
    String nameCompany;
    int areaId;
    int changeEmpl;
    int  EmpCv;
    int idCv;




    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {








        String action = request.getParameter("action");
        switch(action) {



            case "update": {
                //Company company = service.getCompanyById(request.getParameter("id"));

                Company company= new Company();
                company.setId(codCom);
                company.setPassword(new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8"));
                nameCompany=new String(request.getParameter("nameCompany").getBytes("ISO-8859-1"),"UTF-8");
                company.setNameCompany(nameCompany);
                company.setDescription(new String(request.getParameter("description").getBytes("ISO-8859-1"),"UTF-8"));
                company.setCompanyState(Integer.parseInt
                        (request.getParameter("companyState")));
                company.setAddress(new String(request.getParameter("address").getBytes("ISO-8859-1"),"UTF-8"));
                company.setPhoneNumber(Integer.parseInt
                        (request.getParameter("phoneNumber")));
                String message = service.updateCompany(company) ?
                        "Update success" :
                        "Error while updating";

                company = service.getCompanyById(codCom);
                request.setAttribute("company", company);
                request.setAttribute("action", "edit");



                log(message);
                RequestDispatcher dispatcher =
                        request.getRequestDispatcher(MenuRoot_URI);
                dispatcher.forward(request, response);
                break;


            }


            case "EditarCv2": {

                Cv cv= new Cv();
                cv.setId(idCv);
                cv.setCvType(Integer.parseInt(request.getParameter("cv_type")));
                cv.setDescription(new String(request.getParameter("description").getBytes("ISO-8859-1"),"UTF-8"));
                String message = service.updateCv(cv) ?
                        "Update success" :
                        "Error while updating";
                log(message);

                Company company = service.getCompanyById(codCom);
                request.setAttribute("company", company);
                request.setAttribute("action", "edit");

                RequestDispatcher dispatcher =
                        request.getRequestDispatcher(MenuRoot_URI);
                dispatcher.forward(request, response);
                break;
            }

            case "addCv2": {
                Cv cv= new Cv();
                Employee employee=new Employee();
                cv.setEmployee(employee.setId(EmpCv));

                cv.setCvType(Integer.parseInt(request.getParameter("cv_type")));
                cv.setDescription(new String(request.getParameter("description").getBytes("ISO-8859-1"),"UTF-8"));
                String message = service.createCv(cv) ?
                        "Create success" :
                        "Error while creating";
                log(message);

                Company company = service.getCompanyById(codCom);
                request.setAttribute("company", company);
                request.setAttribute("action", "edit");

                RequestDispatcher dispatcher =
                        request.getRequestDispatcher(MenuRoot_URI);
                dispatcher.forward(request, response);
                break;

            }

            case "listTypeArea": {
                idArea=Integer.parseInt(request.getParameter("idArea"));
                if (idArea==6){
                    Company company = service.getCompanyById(codCom);

                    request.setAttribute("company", company);
                    request.setAttribute("action", "edit");

                    RequestDispatcher dispatcher =
                            request.getRequestDispatcher(ListEmpleados_URI);
                    dispatcher.forward(request, response);
                    break;
                }
                else {
                    Company company = service.getCompanyById(codCom);

                    request.setAttribute("company", company);
                    request.setAttribute("action", "edit");
                    request.setAttribute("idArea", idArea);

                    RequestDispatcher dispatcher =
                            request.getRequestDispatcher(listaAreaEmployee_uri);
                    dispatcher.forward(request, response);
                    break;
                }
            }

            case "updatechangeAdmin": {

                Company company = new Company();
                Employee employee= new Employee();
                employee.setId(Integer.parseInt(request.getParameter("idEmployee")));
                employee.setEmployeeType(1);

                String message = service.changeEmployee(employee) ?
                        "Update success" :
                        "Error while updating";
                company = service.getCompanyById(
                        codCom
                        //Integer.parseInt(request.getParameter("idCompany"))
                );
                request.setAttribute("company", company);
                request.setAttribute("action", "edit");


                log(message);
                RequestDispatcher dispatcher =
                        request.getRequestDispatcher(MenuRoot_URI);
                dispatcher.forward(request, response);

                break;
            }

            case "updatechangeEmployee": {

                Company company = new Company();
                Employee employee= new Employee();
                employee.setId(Integer.parseInt(request.getParameter("idEmployee")));
                employee.setEmployeeType(2);

                String message = service.changeEmployee(employee) ?
                        "Update success" :
                        "Error while updating";
                company = service.getCompanyById(
                        codCom
                        //Integer.parseInt(request.getParameter("idCompany"))
                );
                request.setAttribute("company", company);
                request.setAttribute("action", "edit");


                log(message);
                RequestDispatcher dispatcher =
                        request.getRequestDispatcher(MenuRoot_URI);
                dispatcher.forward(request, response);

                break;
            }


            case "createComp":{

                EmailAddress emailAddress =new EmailAddress();
                Company company =new Company();
                //company.setId(Integer.parseInt(request.getParameter("id")));
                company.setPassword(new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8"));
                company.setNameCompany(new String(request.getParameter("nameCompany").getBytes("ISO-8859-1"),"UTF-8"));
                company.setCompanyState
                        (1);


                ///-------------------Probando
                company.setEmailAdress(service.findIdByEmail(email));
                String message = service.addComp2(company) ?
                        "Create success" :
                        "Error while creating";
                log(message);

                RequestDispatcher dispatcher =
                        request.getRequestDispatcher(primeraSesionComp_URI);
                dispatcher.forward(request, response);
                break;


            }


            case "changeAre":{

                Employee employee =new Employee();
                Area area =new Area();
                employee.setId(changeEmpl);
                employee.setArea(area.setId(Integer.parseInt(request.getParameter("idArea"))));
                String message = service.changeArea(employee) ?
                        "Create success" :
                        "Error while creating";
                log(message);

                RequestDispatcher dispatcher =
                        request.getRequestDispatcher(Menu_Root_URI);
                dispatcher.forward(request, response);
                break;


            }

            case "createCompEmail":{
                EmailAddress emailAddress1= new EmailAddress();
                email=new String(request.getParameter("emailData").getBytes("ISO-8859-1"),"UTF-8");
                emailAddress1.setEmailData(email);
                String message = service.createEmail(emailAddress1) ?
                        "Create success" :
                        "Error while creating";
                log(message);
                RequestDispatcher dispatcher =
                        request.getRequestDispatcher(createComp_URI);
                dispatcher.forward(request, response);
                break;
            }



            case "prSesion":{
                Company company = service.getCompanyById(
                        service.getCompanyCount());
                codCom=service.getCompanyCount();


                request.setAttribute("company", company);
                request.setAttribute("action", "menu");

                RequestDispatcher dispatcher =
                        request.getRequestDispatcher(MenuRoot_URI);
                dispatcher.forward(request, response);
              break;
            }





            case "menu": {


                Company company = service.getIdByCompany(
                        new String(request.getParameter("txtusuario").getBytes("ISO-8859-1"),"UTF-8"),
                        new String(request.getParameter("txtclave").getBytes("ISO-8859-1"),"UTF-8"));

                request.setAttribute("company", company);
                request.setAttribute("action", "menu");

                RequestDispatcher dispatcher =
                        request.getRequestDispatcher(VaMensajeEntra_URI);
                dispatcher.forward(request, response);
                break;
            }

            case "edit": {



                Company company = service.getCompanyById(codCom);

                request.setAttribute("company", company);
                request.setAttribute("action", "edit");
                request.setAttribute("nombreCompañia",nameCompany);
                RequestDispatcher dispatcher =
                        request.getRequestDispatcher(EDItCompany_URI);

                dispatcher.forward(request, response);
                break;
            }
////---------------------------------------------
            case "servis": {

                int  idC = Integer.parseInt(request.getParameter("idCompany"));
                codCom = idC;
                nameCompany = new String(request.getParameter("nameCompany").getBytes("ISO-8859-1"),"UTF-8");

                Company company = service.getCompanyById(idC);

                request.setAttribute("company", company);
                request.setAttribute("action", "servis");
                RequestDispatcher dispatcher =
                        request.getRequestDispatcher(Menu_Root_URI);
                dispatcher.forward(request, response);
                break;
            }


            case "updateEmail": {

                EmailAddress emailAddress= new EmailAddress();
                //EmailAddress emailAddress = service.getEmailAddressById(Integer.parseInt(request.getParameter("id")));

                emailAddress.setId(Integer.parseInt(request.getParameter("idEmail")));
                emailAddress.setEmailData(new String(request.getParameter("emailData").getBytes("ISO-8859-1"),"UTF-8"));
                String message = service.updateEmail(emailAddress) ?
                        "Update success" :
                        "Error while updating";

                Company company = service.getCompanyById(
                        codCom
                        //Integer.parseInt(request.getParameter("idCompany"))
                );
                request.setAttribute("company", company);
                request.setAttribute("action", "edit");


                log(message);
                RequestDispatcher dispatcher =
                        request.getRequestDispatcher(MenuRoot_URI);
                dispatcher.forward(request, response);
                break;

            }

            case "createEmail": {
                EmailAddress emailAddress1= new EmailAddress();
                email=new String(request.getParameter("emailData").getBytes("ISO-8859-1"),"UTF-8");
                emailAddress1.setEmailData(email);





                String message = service.createEmail(emailAddress1) ?
                        "Create success" :
                        "Error while creating";

                Company company = service.getCompanyById(
                        codCom
                        //Integer.parseInt(request.getParameter("idCompany"))
                );
                request.setAttribute("company", company);

                request.setAttribute("action", "edit");
                //


                log(message);
                RequestDispatcher dispatcher =
                        request.getRequestDispatcher(NuevoEmpleadoAdm_URI);
                dispatcher.forward(request, response);
                break;
            }



          case "createEmplAdmin": {

                Employee employee =new Employee();
                EmailAddress emailAddress =new EmailAddress();
              Area area = new Area();
                Company company1 =new Company();



              employee.setEmailAddress(service.findIdByEmail(email));


                employee.setCompany(company1.setId(
                        codCom
                        //Integer.parseInt(request.getParameter("idCompany"))
                        )
                );

                employee.setArea(area.setId(Integer.parseInt(request.getParameter("idArea"))));
              employee.setBirthdate(Date.valueOf(request.getParameter("cumple")));
                employee.setEmployeeType(1);



              employee.setPassword(new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8"));
              employee.setName(new String(request.getParameter("employee_name").getBytes("ISO-8859-1"),"UTF-8"));
              employee.setDni(Integer.parseInt(request.getParameter("dni")));
              String message = service.createEmployee2(employee) ?
                      "Create success" :
                      "Error while creating";
              log(message);


              Company company = service.getCompanyById(
                      codCom
                      //Integer.parseInt(request.getParameter("idCompany"))
              );
              request.setAttribute("company", company);
              request.setAttribute("action", "edit");

              RequestDispatcher dispatcher =
                      request.getRequestDispatcher(Adm_URI);
              dispatcher.forward(request, response);
                break;


            }

            case "regresar": {
                Company company = service.getCompanyById(
                        codCom
                        //Integer.parseInt(request.getParameter("idCompany"))
                );
                request.setAttribute("company", company);
                request.setAttribute("action", "edit");
                RequestDispatcher dispatcher =
                        request.getRequestDispatcher(Menu_Root_URI);
                dispatcher.forward(request, response);
                break;

            }

        }



        RequestDispatcher dispatcher =
                request.getRequestDispatcher(MenuRoot_URI);
        dispatcher.forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String action = request.getParameter("action");
        String actionUri;
        switch(action) {

            case "edit": {




                Company company = service.getCompanyById(codCom);
                request.setAttribute("company", company);
                request.setAttribute("action", "edit");
                request.setAttribute("nombreCompañia",nameCompany);
                actionUri = EDItCompany_URI;
                break;
            }
            case "out": {

                actionUri = outCompany_URI;
                codCom=0;
                break;
            }

            case "editCorre": {
                Company company = service.getCompanyById(
                        codCom
                        //Integer.parseInt(request.getParameter("idCompany"))
                );
                request.setAttribute("company", company);
                request.setAttribute("action", "editCorre");
                actionUri = UpdateCompanyEmail_URI;
                break;
            }


            case "seleccion": {


                Company company = service.getCompanyById(
                        codCom
                        //Integer.parseInt(request.getParameter("idCompany"))

                );
                request.setAttribute("company", company);
                request.setAttribute("action", "seleccion");
                actionUri = Adm_URI;
                break;
            }

            case "seleccionEmpleados": {


                Company company = service.getCompanyById(
                        codCom
                        //Integer.parseInt(request.getParameter("idCompany"))

                );
                request.setAttribute("company", company);
                request.setAttribute("action", "seleccion");
                actionUri = ListEmpleados_URI;
                break;
            }

            case "regresar": {
                Company company = service.getCompanyById(
                        codCom
                        //Integer.parseInt(request.getParameter("idCompany"))
                );
                request.setAttribute("company", company);
                request.setAttribute("action", "edit");
                actionUri = MenuRoot_URI;
                break;


            }

            case "creEmail": {
                Company company = service.getCompanyById(
                        codCom
                        //Integer.parseInt(request.getParameter("idCompany"))

                );
                request.setAttribute("company", company);
                request.setAttribute("action", "edit");
                actionUri = NuevoEmailEmp_URI;
                break;
            }

            case "lista": {
                Company company = service.getCompanyById(
                        codCom
                                //Integer.parseInt(request.getParameter("idCompany"))
                );


                request.setAttribute("company", company);
                request.setAttribute("action", "edit");
                actionUri = listaAdministradores;
                break;
            }

            case "editTypeEmployee": {
                Employee employee = service.getEmployeeById(
                        //codCom
                        Integer.parseInt(request.getParameter("idEmployee"))
                );
                request.setAttribute("employee", employee);
                request.setAttribute("action", "editTypeEmployee");
                actionUri =ChangeEmpl_URI;
                break;
            }


            case "editTypeAdmin": {
                Employee employee = service.getEmployeeById(
                        //codCom
                        Integer.parseInt(request.getParameter("idEmployee"))
                );
                request.setAttribute("employee", employee);
                request.setAttribute("action", "editTypeAdmin");
                actionUri = ChangeAdm_URI;
                break;
            }


            case "editChangeArea": {

                changeEmpl=Integer.parseInt(request.getParameter("idEmployee"));
                actionUri =changeAreaEmpl_uri;
                break;
            }


            case "Perfil": {
                EmpEvaluado =Integer.parseInt(request.getParameter("idEmployee"));

                Employee employee = service.getEmployeeById(EmpEvaluado);
                request.setAttribute("employee", employee);
                request.setAttribute("action", "Perfil");
                actionUri = perfilEmployee_uri;
                break;
            }

            case "PerfilAdmin": {
                EmpEvaluado =Integer.parseInt(request.getParameter("idEmployee"));

                Employee employee = service.getEmployeeById(EmpEvaluado);
                request.setAttribute("employee", employee);
                request.setAttribute("action", "Perfil");
                actionUri = perfilAdmin_uri;
                break;
            }

            case "EvaluationHistorial": {
                EmpEvaluado =Integer.parseInt(request.getParameter("idEmployee"));
                areaId =Integer.parseInt(request.getParameter("idArea"));

                Employee employee = service.getEmployeeById(EmpEvaluado);
                request.setAttribute("employee", employee);
                request.setAttribute("action", "Perfil");
                if (areaId ==5){

                    actionUri = perfilHistorialEvaluEmployee_uri;
                    break;}
                if (areaId ==4){

                    actionUri = perfilHistoEvaluAdminitracionEmployee_uri;
                    break;}
                if (areaId ==3){

                    actionUri = perfilHistoProduccionEmployee_uri;
                    break;}
                if (areaId ==2){

                    actionUri = perfilHistoEvaluMarketingEmployee_uri;
                    break;}
                else{

                    actionUri = perfilHistoEvaluInformaticaEmployee_uri;
                    break;}
            }


            case "perfilCompany": {
                Company company = service.getCompanyById(codCom);

                request.setAttribute("company", company);
                request.setAttribute("action", "edit");
                actionUri = perfilCompany_uri;
                break;
            }

            case "addCv": {

                EmpCv =Integer.parseInt(request.getParameter("idEmpleado"));
                actionUri = addCv_uri;
                break;
            }


            case "EditarCvAdmin": {
                idCv = Integer.parseInt(request.getParameter("idCv"));
                int year = Integer.parseInt(request.getParameter("year"));
                int month = Integer.parseInt(request.getParameter("month"));
                int day = Integer.parseInt(request.getParameter("day"));


                if (month == 12) {
                    month = 1;
                    year++;
                    Timestamp timeNow = new Timestamp(System.currentTimeMillis());
                    Timestamp timeLimite = Timestamp.valueOf(year + "-" + month + "-" + day + " 0:0:0.0");
                    if (timeNow.before(timeLimite)) {

                        actionUri = EditarCv;
                        break;

                    } else {
                        actionUri = noTimeCv;
                        break;
                    }


                } else {
                    month++;
                    Timestamp timeNow = new Timestamp(System.currentTimeMillis());
                    Timestamp timeLimite = Timestamp.valueOf(year + "-" + month + "-" + day + " 0:0:0.0");

                    if (timeNow.before(timeLimite)) {
                        actionUri = EditarCv;
                        break;


                    } else {
                        actionUri = noTimeCv;
                        break;
                    }


                }
            }












            default:
                actionUri = MenuRoot_URI;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(actionUri);
        dispatcher.forward(request, response);
    }
}