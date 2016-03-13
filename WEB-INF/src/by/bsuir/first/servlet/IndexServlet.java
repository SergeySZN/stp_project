package by.bsuir.first.servlet;

import javax.servlet.Servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;


import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet implements Servlet
{
    static Logger logger = Logger.getLogger(IndexServlet.class);

    public IndexServlet() {
        super();
    }

    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException, ServletException
    {



        String fileName = "webapps\\stp_project\\pages\\Index.htm";

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String htmString="";

        String tmp = "";
        while ((tmp=br.readLine())!= null) {
            htmString+= tmp + "\r\n";
        }

        response.setContentType("text/html;charset=UTF-8");
        //String secondString = new String(htmString.getBytes("windows-1251"),"UTF-8");
        response.getWriter().print(htmString);

        logger.info("User was connected!");
        logger.info("IP adress is: " + request.getRemoteAddr());
        logger.info("Askable resource is: "+ this.getClass().getSimpleName());


    }
}