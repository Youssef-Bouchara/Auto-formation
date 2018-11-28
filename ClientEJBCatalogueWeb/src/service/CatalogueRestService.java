package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import metier.ICatalogueLocal;
import metier.Produit;


@Stateless
@Path("catalogue")
public class CatalogueRestService {
	
	@EJB
	private ICatalogueLocal metier;
	
	@GET
	@Path("produits")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produit> getAllProduits()
	{
		return metier.getAllProduits();
	}
	
	@GET
	@Path("produitsParMC/{mc}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produit> getProduitsParMotCle(@PathParam(value="mc")String mc)
	{
		return metier.getProduitsParMC(mc);
	}
	
	@GET
	@Path("save/{nom}/{prix}")
	@Produces(MediaType.APPLICATION_JSON)
	public void saveProduit(@PathParam(value="nom")String nom,@PathParam(value="prix") double prix)
	{
		metier.addProduit(new Produit(nom,prix));
	}

}
