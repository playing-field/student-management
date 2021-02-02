package lk.ijse.dep.web.stm.api;

import lk.ijse.dep.web.stm.business.BOFactory;
import lk.ijse.dep.web.stm.business.BOTypes;
import lk.ijse.dep.web.stm.business.custom.CourseBO;
import lk.ijse.dep.web.stm.exception.HttpResponseException;
import lk.ijse.dep.web.stm.exception.ResponseExceptionUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CourseServlet",urlPatterns = "/api/v1/courses/*")
public class CourseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            super.service(req, resp);
        } catch (Throwable t) {
            ResponseExceptionUtil.handle(t, resp);
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();

        try{

            if (req.getPathInfo() == null || req.getPathInfo().replace("/", "").trim().isEmpty()) {
                throw new HttpResponseException(400, "Invalid course id", null);
            }

            String code = req.getPathInfo().replace("/", "");

            CourseBO courseBO = BOFactory.getInstance().getBO(BOTypes.COURSE);
            courseBO.setEntityManager(em);
            courseBO.deleteCourse(code);
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }
}
