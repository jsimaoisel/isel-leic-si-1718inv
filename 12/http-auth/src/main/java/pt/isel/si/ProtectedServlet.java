package pt.isel.si;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class ProtectedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String authnHeaderValue = req.getHeader("Authorization");
        if ( authnHeaderValue == null) {
            resp.addHeader("WWW-Authenticate", "Basic realm=\"SIDomain\"");
            resp.setStatus(401);
        } else {
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(resp.getOutputStream()));
            writer.write("Success with : " + authnHeaderValue);
            writer.close();
            resp.setStatus(200);
        }
    }
}
