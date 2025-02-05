package servlet;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")  // web.xml 대신 어노테이션으로 매핑 가능
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // HTML 파일 경로 설정
        String htmlPath = "/WEB-INF/hello.html";

        // RequestDispatcher 생성
        RequestDispatcher dispatcher = request.getRequestDispatcher(htmlPath);

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Hello, Servlet!</h1>");
        response.getWriter().println("</body></html>");
        // HTML 파일로 포워딩
//        dispatcher.forward(request, response);
        dispatcher.include(request, response);
    }
}