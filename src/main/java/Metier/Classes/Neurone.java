package Metier.Classes;

import java.util.ArrayList;

import Metier.Agregation.FonctionAgregation;
import Metier.Transfert.FonctionTransfert;

public class Neurone {
	public ArrayList<Double> entreePoid ;
	ArrayList<Double> sortiePoid;
	private FonctionAgregation agreger;
    private FonctionTransfert Transfert;
    Double bias;
    public Neurone(ArrayList<Double> entrePoid, ArrayList<Double> sortiePoid) {
		super();
		this.entreePoid = entrePoid;
		this.sortiePoid = sortiePoid;
	}






	public Neurone(ArrayList<Double> entrePoid, ArrayList<Double> sortiePoid, FonctionAgregation agreger,
			FonctionTransfert transfert) {
		super();
		this.entreePoid = entrePoid;
		this.sortiePoid = sortiePoid;
		this.agreger = agreger;
		Transfert = transfert;
	}



	public Neurone() {
		super();
	}

	

   
    
}
