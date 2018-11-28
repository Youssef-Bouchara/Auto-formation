import java.rmi.Naming;
import java.util.Date;

import org.sid.entities.Compte;
import org.sid.entities.CompteEpargne;
import org.sid.rmi.BanqueRmiRemote;

public class ClientRMI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try 
		{
			BanqueRmiRemote proxy=(BanqueRmiRemote) Naming.lookup("rmi://localhost:1099/BK");
			Compte cp=proxy.getCompte("CC1");
			System.out.println(cp.getSolde());
			System.out.println(cp.getDateCreation());
			proxy.saveCompte(new CompteEpargne("CE2",99999,new Date(), 5.5));
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
