

<%@page import="java.util.ArrayList"%>
<%@page contentType="application/json; charset=UTF-8"%>
<%@ page import="database.*" %>



     

    <%
    //Get the Login Credential
    String email = request.getParameter("email");
    String pass = request.getParameter("password");
    
    Login login = new Login();
    boolean decision = login.loginCheck(email, pass);
    
    String result= new String("");
        
    %>

                  <%
                  if(!decision){
                        result = "0";
                        out.print(result);
                  }
                  else{
                      ArrayList<String> loginDetails = new ArrayList<String>();
                      loginDetails = login.loginDetails(email, pass);

                       if(loginDetails.get(0).equals("1")){
                         out.print(loginDetails.get(0));
//                         response.setHeader("Refresh", "2;url=../education.jsp"); 
                         session.setAttribute("organization_id", loginDetails.get(1));
                         session.setAttribute("organization_name", loginDetails.get(2));
                      }
                      else if(loginDetails.get(0).equals("2")){
                         out.print(loginDetails.get(0));
//                         response.setHeader("Refresh", "2;url=../bank.jsp"); 
                         session.setAttribute("organization_id", loginDetails.get(1));
                         session.setAttribute("organization_name", loginDetails.get(2));
//                         
                      }
                      else if(loginDetails.get(0).equals("3")){
                         out.print(loginDetails.get(0));
//                         out.print(result);
//                         response.setHeader("Refresh", "2;url=../criminal.jsp"); 
                         session.setAttribute("organization_id", loginDetails.get(1));
                         session.setAttribute("organization_name", loginDetails.get(2));
                      }
                      else if(loginDetails.get(0).equals("4")){
                         out.print(loginDetails.get(0));
//                         out.print(result);
                      //   response.setHeader("Refresh", "2;url=../medical.jsp"); 
                         session.setAttribute("organization_id", loginDetails.get(1));
                         session.setAttribute("organization_name", loginDetails.get(2));
                      }
                      else if(loginDetails.get(0).equals("5")){
                         out.print(loginDetails.get(0));
//                         out.print(result);
//                         response.setHeader("Refresh", "2;url=../job.jsp"); 
                         session.setAttribute("organization_id", loginDetails.get(1));
                         session.setAttribute("organization_name", loginDetails.get(2));
                      }
                      else if(loginDetails.get(0).equals("6")){
                         out.print(loginDetails.get(0));
//                         out.print(result);
//                         response.setHeader("Refresh", "2;url=../add_new_citizen.jsp"); 
                         session.setAttribute("organization_id", loginDetails.get(1));
                         session.setAttribute("organization_name", loginDetails.get(2));
                      }
                      
                      else{
                         result = "0";
                         out.print(result);
//                         response.setHeader("Refresh", "2;url=../index.jsp"); 
                      }
                  }
                  %>

