package pt.isel.si;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OpenIDConnectServlet extends HttpServlet {
    /* the client id of your web client */
    public static final String CLIENT_ID
            = "658008239509-2qi1pt9engssqp0e675h0l3mbs69lsmu.apps.googleusercontent.com";
    /* the client secret of your web client */
    public static final String CLIENT_SECRET
            = "evFJcvihNjxbQXKJhGosr9hq";
    public static final String REDIRECT_URI
            = "http://si.myapp.com:8080/google-callback"; /* the callback uri id of your web client */

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("--New request was received --");
        System.out.println(req.getRequestURI());
        System.out.println(req.getMethod());
        System.out.println(req.getHeader("Accept"));

        resp.setStatus(302);
        resp.setHeader("Location",
            // google's authorization endpoint
            "https://accounts.google.com/o/oauth2/v2/auth?"+
            "scope=openid%20email%20profile&"+
            "redirect_uri="+REDIRECT_URI+"&"+
            "response_type=code&"+
            "client_id="+CLIENT_ID);
    }
}

