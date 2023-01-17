package Metier.Reseau;

import java.util.ArrayList;
import java.util.List;

import Metier.Apprentissage.FonctionApprentissage;
import Metier.Apprentissage.NonSupervise;
import Metier.Apprentissage.Supervise;
import Metier.Classes.Couche;
import Metier.Classes.Poid;
import Metier.Transfert.sigmoide;
import Operation.Matrix;

public  class Reseau {

	private Couche EntreCouche= new Couche();
	public Couche SortieCouche= new Couche();
	public Couche hidden= new Couche();

    public FonctionApprentissage fapp;
 
	public double l_rate=0.01;
	
	public Reseau() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void chooseApprentissage(boolean isbool) {
		if (isbool==true) {
			fapp=new Supervise();
		}
		else 
		{
			fapp=new NonSupervise();
		}
	}
	
	public List<Double> predict(double[] X,Matrix weights_ih,Matrix bias_h,Matrix weights_ho,Matrix bias_o)
    {
        Matrix input = Matrix.fromArray(X);
        Matrix hidden = Matrix.multiply(weights_ih, input);
        hidden.add(bias_h);
        sigmoide z = new sigmoide();
		hidden=z.calculSortie(hidden, true);
        
        Matrix output = Matrix.multiply(weights_ho,hidden);
        output.add(bias_o);
        output=z.calculSortie(output, true);

        
        return output.toArray();
    }
  
}
