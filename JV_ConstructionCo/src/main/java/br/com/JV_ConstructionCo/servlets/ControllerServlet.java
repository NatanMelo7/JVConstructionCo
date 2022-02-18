package br.com.JV_ConstructionCo.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JV_ConstructionCo.JPAUtil.JPAUtil;
import br.com.JV_ConstructionCo.actions.Action;

@WebServlet("/")
public class ControllerServlet extends HttpServlet {
	public EntityManager entityManager = JPAUtil.callEntity();
	private static final long serialVersionUID = 1L;

	// Fluxe Controller to Class
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String linkAction = linkParameter(request);

		String tipoRedirect = null;

		try {
			@SuppressWarnings("rawtypes")
			Class classe = Class.forName("br.com.JV_ConstructionCo.actions." + linkAction);
			@SuppressWarnings("deprecation")
			Action action = (Action) classe.newInstance();
			tipoRedirect = action.call(request, response, entityManager);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		String[] redirection = tipoRedirect.split(":");
		if (redirection[0].equals("forward"))
			request.getRequestDispatcher("WEB-INF/view/" + redirection[1]).forward(request, response);
		else
			response.sendRedirect(redirection[1]);

	}

	public static String linkParameter(HttpServletRequest rq) {
		String parameterURI = rq.getRequestURI();
		String[] linkParameter = parameterURI.split("/");
		return linkParameter[2];
	}

}
