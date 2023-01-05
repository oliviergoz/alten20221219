package eshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eshop.dao.DaoFournisseur;
import eshop.entity.Adresse;
import eshop.entity.Fournisseur;
import eshop.util.JpaContext;

/**
 * Servlet implementation class FournisseurController
 */
@WebServlet("/fournisseur")
public class FournisseurController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoFournisseur daoFournisseur;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FournisseurController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {

		daoFournisseur = JpaContext.getDaoFournisseur();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String q = request.getParameter("q");
		if (q == null || q.isEmpty()) {
			rd = list(request, response);
		} else if (q.equals("add")) {
			rd = add(request, response);
		} else if (q.equals("save")) {
			rd = save(request, response);
		} else if (q.equals("delete")) {
			rd = delete(request, response);
		} else if (q.equals("edit")) {
			rd = edit(request, response);
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private RequestDispatcher add(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("fournisseur", new Fournisseur());
		return goForm(request, response);
	}

	private RequestDispatcher edit(HttpServletRequest request, HttpServletResponse response) {
		Fournisseur fournisseur = daoFournisseur.findByKey(Long.parseLong(request.getParameter("id")));
		request.setAttribute("fournisseur", fournisseur);
		return goForm(request, response);
	}

	private RequestDispatcher delete(HttpServletRequest request, HttpServletResponse response) {
		daoFournisseur.deleteByKey(Long.parseLong(request.getParameter("id")));
		return list(request, response);
	}

	private RequestDispatcher list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("fournisseurs", daoFournisseur.findAll());
		return request.getRequestDispatcher("/WEB-INF/fournisseur/list.jsp");
	}

	private RequestDispatcher goForm(HttpServletRequest request, HttpServletResponse response) {
		return request.getRequestDispatcher("/WEB-INF/fournisseur/edit.jsp");
	}

	private RequestDispatcher save(HttpServletRequest request, HttpServletResponse response) {

		String nom = request.getParameter("nom");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		Adresse adresse = new Adresse(request.getParameter("adresse.numero"), request.getParameter("adresse.rue"),
				request.getParameter("adresse.codePostal"), request.getParameter("adresse.ville"));
		Fournisseur fournisseur = new Fournisseur(nom, email, adresse, contact);
		if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
			daoFournisseur.insert(fournisseur);
		} else {
			Long id = Long.parseLong(request.getParameter("id"));
			fournisseur.setId(id);
			daoFournisseur.update(fournisseur);
		}
		return list(request, response);
	}

}
