package metier;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ICatalogueRemote {

	public void addProduit(Produit p);
	public List<Produit> getAllProduits();
	public List<Produit> getProduitsParMC(String mc);
	public Produit getProduit(Long idP);
	public void removeProduit(Long idP);
	public void updateProduit(Produit p);
}
