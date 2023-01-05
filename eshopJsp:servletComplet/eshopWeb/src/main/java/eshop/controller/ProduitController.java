package eshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eshop.dao.DaoFournisseur;
import eshop.dao.DaoProduit;
import eshop.entity.Fournisseur;
import eshop.entity.Produit;
import eshop.util.JpaContext;

/**
 * Servlet implementation class ProduitController
 */
@WebServlet("/produit")
public class ProduitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoProduit daoProduit;
	private DaoFournisseur daoFournisseur;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProduitController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {

		daoProduit = JpaContext.getDaoProduit();
		daoFournisseur=JpaContext.getDaoFournisseur();
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
			rd = goForm(request, response);
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

	private RequestDispatcher edit(HttpServletRequest request, HttpServletResponse response) {
		Produit produit = daoProduit.findByKey(Long.parseLong(request.getParameter("id")));
		request.setAttribute("produit", produit);
		return goForm(request, response);
	}

	private RequestDispatcher delete(HttpServletRequest request, HttpServletResponse response) {
		daoProduit.deleteByKey(Long.parseLong(request.getParameter("id")));
		return list(request, response);
	}

	private RequestDispatcher list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("produits", daoProduit.findAll());
		return request.getRequestDispatcher("/WEB-INF/produit/list.jsp");
	}

	private RequestDispatcher goForm(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("fournisseurs", daoFournisseur.findAll());
		return request.getRequestDispatcher("/WEB-INF/produit/edit.jsp");
	}

	private RequestDispatcher save(HttpServletRequest request, HttpServletResponse response) {

		String libelle = request.getParameter("libelle");
		String description = request.getParameter("description");
		double prix = 0;
		if (request.getParameter("prix") != null) {
			prix = Double.parseDouble(request.getParameter("prix"));
		}

		Produit produit = new Produit(libelle, description, prix);
		if (request.getParameter("fournisseur.id") != null && !request.getParameter("fournisseur.id").isEmpty()) {
			Long idFournisseur = Long.parseLong(request.getParameter("fournisseur.id"));
			produit.setFournisseur(daoFournisseur.findByKey(idFournisseur));
		}
		if (request.getParameter("id") != null) {
			Long id = Long.parseLong(request.getParameter("id"));
			int version = Integer.parseInt(request.getParameter("version"));
			produit.setId(id);
			produit.setVersion(version);
			daoProduit.update(produit);
		} else {
			daoProduit.insert(produit);
		}
		return list(request, response);
	}

}
