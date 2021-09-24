package top.halo.shiro.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Halo
 * @create 2021/09/24 下午 07:46
 * @description
 */
@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 通过 subject 对象去判断是否登录
        Subject subject = SecurityUtils.getSubject();
        boolean flag = subject.isAuthenticated();
        if (flag) {
            resp.sendRedirect("home.jsp");
        } else {
            req.getRequestDispatcher("/login").forward(req, resp);
        }
    }
}