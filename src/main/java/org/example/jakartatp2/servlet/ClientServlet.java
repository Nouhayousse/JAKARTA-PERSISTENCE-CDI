package org.example.jakartatp2.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.jakartatp2.dao.ClientDAO;
import org.example.jakartatp2.entities.Client;
import jakarta.inject.Inject;
import java.io.IOException;

@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
    @Inject
    private ClientDAO clientDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String idStr = req.getParameter("id");

        if ("delete".equals(action) && idStr != null) {
            Long id = Long.parseLong(idStr);
            clientDAO.delete(id);
            resp.sendRedirect(req.getContextPath() + "/ClientServlet");
            return;
        } else if ("edit".equals(action) && idStr != null) {
            Long id = Long.parseLong(idStr);
            Client c = clientDAO.find(id);
            req.setAttribute("clientEdit", c);
        }

        req.setAttribute("clients", clientDAO.findAll());
        req.getRequestDispatcher("/clients.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String email = req.getParameter("email");
        String telephone = req.getParameter("telephone");

        // Simple validation côté serveur
        if (email == null || email.trim().isEmpty()) {
            req.setAttribute("error", "Email ne peut pas être vide");
            req.setAttribute("clients", clientDAO.findAll());
            req.getRequestDispatcher("/clients.jsp").forward(req, resp);
            return;
        }

        if (idStr == null || idStr.isEmpty()) {
            Client c = new Client();
            c.setFirstName(nom);
            c.setLastName(prenom);
            c.setEmail(email);
            c.setPhone(telephone);
            clientDAO.create(c);
        } else {
            Long id = Long.parseLong(idStr);
            Client c = clientDAO.find(id);
            if (c != null) {
                c.setLastName(nom);
                c.setFirstName(prenom);
                c.setEmail(email);
                c.setPhone(telephone);
                clientDAO.update(c);
            }
        }
        resp.sendRedirect(req.getContextPath() + "/ClientServlet");
    }

}
