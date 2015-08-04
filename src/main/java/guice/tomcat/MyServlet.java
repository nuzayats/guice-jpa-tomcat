package guice.tomcat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@javax.inject.Singleton
public class MyServlet extends HttpServlet {

    @javax.inject.Inject
    private MyService myService;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyEntity myEntity = new MyEntity();
        myEntity.setTs(new Date());
        myService.save(myEntity);

        PrintWriter writer = resp.getWriter();
        writer.write("<html><body><ul>");
        for(MyEntity e : myService.findAll()){
            writer.write("<li>");
            writer.write(e.toString());
            writer.write("</li>");
        }
        writer.write("</ul></body></html>");

    }
}
