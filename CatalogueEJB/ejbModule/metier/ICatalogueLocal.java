package metier;

import java.util.List;

import javax.ejb.Local;

@Local
public interface ICatalogueLocal {
	
	public void addProduit(Produit p);
	public List<Produit> getAllProduits();
	public List<Produit> getProduitsParMC(String mc);
	public Produit getProduit(Long idP);
	public void removeProduit(Long idP);
	public void updateProduit(Produit p);

}
