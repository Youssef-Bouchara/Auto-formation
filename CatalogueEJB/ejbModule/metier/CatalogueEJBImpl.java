package metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name="CAT")
public class CatalogueEJBImpl implements ICatalogueLocal, ICatalogueRemote {

	
	@PersistenceContext(unitName="UP_CAT")
	private EntityManager em;
	
	@Override
	public void addProduit(Produit p) {
		em.persist(p);
	}

	@Override
	public List<Produit> getAllProduits() {
		Query req=em.createQuery("select p from Produit p");
		return req.getResultList();
	}

	@Override
	public List<Produit> getProduitsParMC(String mc) {
		Query req=em.createQuery("select p from Produit p where p.nomProduit like :x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public Produit getProduit(Long idP) {
		Produit p=em.find(Produit.class, idP);
		return p;
	}

	@Override
	public void removeProduit(Long idP) {
		Produit p=em.find(Produit.class, idP);
		if(p==null)
		{
			throw new RuntimeException("Produit introuvable");
		}
		em.remove(p);
	}

	@Override
	public void updateProduit(Produit p) {
		Produit pp=em.find(Produit.class, p.getIdProduit());
		pp.setNomProduit(p.getNomProduit());
		pp.setPrix(p.getPrix());
		em.persist(pp);
	}

}
