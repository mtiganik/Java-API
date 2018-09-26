package hw2;

import com.fasterxml.jackson.databind.ObjectMapper;
import hw2.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/api/orders")
public class OrderServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        String input = Util.readStream(request.getInputStream());
        String orderNumber;

        System.out.println(input);

        String regexExpression = "(?:\"orderNumber\"\\s*:\\s*\")(.*?)(?:\")";

        Pattern p = Pattern.compile(regexExpression);
        Matcher m = p.matcher(input);
        try{
            m.find();
            orderNumber = m.group(1);
        }catch(IllegalStateException e){
            throw new RuntimeException("Invalid JSON");
        }

        Order p1 = new Order();
        p1.setOrderNumber(orderNumber);

        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().print(
                objectMapper.writeValueAsString(p1));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print("Hello");

    }
}
