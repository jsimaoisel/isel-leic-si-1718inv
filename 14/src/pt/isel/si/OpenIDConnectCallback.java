package pt.isel.si;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenIDConnectCallback extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String code = req.getParameter("code");
        System.out.println("Authorization code is = " + code);

        System.out.println("Send code to token endpoint");
        URL url = new URL("https://www.googleapis.com/oauth2/v3/token");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        PrintWriter output = new PrintWriter(
                new OutputStreamWriter(connection.getOutputStream()));
        output.print("code=" + code + "&");
        output.print("client_id=" + OpenIDConnectServlet.CLIENT_ID + "&");
        output.print("client_secret=" + OpenIDConnectServlet.CLIENT_SECRET + "&");
        output.print("redirect_uri=" + OpenIDConnectServlet.REDIRECT_URI + "&");
        output.print("grant_type=authorization_code");
        output.flush();

        /* exchange 'code' by 'id_token' and 'access_token' */
        System.out.println("Collect access_token in the response");
        BufferedReader input = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String line;

        while ((line = input.readLine()) != null) {
            System.out.println(line);
            //output.write(line);
        }
        output.close();
        input.close();

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(resp.getOutputStream()));
        writer.write("Authorization endpoint sent code: " + code);
        writer.close();
        resp.setStatus(200);

    }
}