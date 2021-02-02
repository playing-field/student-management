package lk.ijse.dep.web.stm.api;

import lk.ijse.dep.web.stm.business.BOFactory;
import lk.ijse.dep.web.stm.business.BOTypes;
import lk.ijse.dep.web.stm.business.SuperBO;
import lk.ijse.dep.web.stm.business.custom.StudentBO;
import lk.ijse.dep.web.stm.dto.StudentDTO;
import lk.ijse.dep.web.stm.exception.HttpResponseException;
import lk.ijse.dep.web.stm.exception.ResponseExceptionUtil;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

@WebServlet(name = "StudentServlet", urlPatterns = "/api/v1/students/*")
public class StudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            super.service(req, resp);
        } catch (Throwable t) {
            ResponseExceptionUtil.handle(t, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();
        final EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();

//        StudentDTO dto = jsonb.fromJson(req.getReader(), StudentDTO.class);
//        System.out.println(dto);

        try{
            StudentDTO dto = jsonb.fromJson(req.getReader(), StudentDTO.class);

//            if (dto.getId() == null || dto.getId().trim().isEmpty() || dto.getName() == null || dto.getName().trim().isEmpty() || dto.getAddress() == null || dto.getAddress().trim().isEmpty()) {
//                throw new HttpResponseException(400, "Invalid customer details", null);
//            }

            StudentBO studentBO = BOFactory.getInstance().getBO(BOTypes.STUDENT);
            studentBO.setEntityManager(em);

            studentBO.saveStudent(dto);
            resp.setStatus(HttpServletResponse.SC_CREATED);
            resp.setContentType("application/json");
            resp.getWriter().println(jsonb.toJson(dto));
        } catch (SQLIntegrityConstraintViolationException exp) {
            throw new HttpResponseException(400, "Duplicate entry", exp);
        } catch (JsonbException exp) {
            throw new HttpResponseException(400, "Failed to read the JSON", exp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            em.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();

        final EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();

        try{
            resp.setContentType("application/json");
            StudentBO bo = BOFactory.getInstance().getBO(BOTypes.STUDENT);
            bo.setEntityManager(em);
            resp.getWriter().println(jsonb.toJson(bo.findAllStudents()));

        } catch (Throwable t) {
            ResponseExceptionUtil.handle(t, resp);
        } finally {
            em.close();
        }
    }
}
