package pt.isel.si;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Index extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setStatus(200);
        BufferedWriter writer =
                new BufferedWriter(new OutputStreamWriter(resp.getOutputStream()));
        writer.write("<a href=/google-openid> Login </a>");
        writer.close();
    }
}
