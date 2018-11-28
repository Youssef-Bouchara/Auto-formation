package service;

import java.util.List;

public class ClientWS {
	
	public static void main(String[] args) {
		
		BanqueWS stub=new BanqueServiceService().getBanqueWSPort();
		
		double res=stub.conversionEuroToDh(800);
		System.out.println("800 euro en DH= "+res);
		
		Compte cp=stub.getCompte(1L);
		System.out.println(cp.getSolde());
		
		System.out.println("-----------------");
		List<Compte> cptes=stub.getComptes();
		for(Compte c:cptes)
		{
			System.out.println("code: "+c.getCode()+" | solde: "+c.getSolde());
		}
	}

}
