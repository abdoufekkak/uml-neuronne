package Metier;

import java.util.ArrayList;
import java.util.List;

import Metier.Classes.Couche;
import Metier.Reseau.Reseau;
import Operation.Matrix;

public class main {
	public Matrix weights_ih,weights_ho,bias_h,bias_o;//2-10.1 
	
	public void NeuralNetwork() {
        
        
    }
	public static void main(String[] args) {
		Matrix	 weights_ih = new Matrix(10,2);
		Matrix   weights_ho = new Matrix(1,10);
        
		Matrix     bias_h = new Matrix(10,1);
		Matrix     bias_o = new Matrix(1,1);
		double  [][] X= { 
	            {0,0}, 
	            {1,0}, 
	            {0,1}, 
	            {1,1} 
	    } ; 
	double  [][] Y= { 
			{0},{1},{1},{1} 
	    } ;
	Reseau x=new Reseau();
	x.chooseApprentissage(true);
	Couche hidden = x.hidden;
	Matrix bias_hh = hidden.getBias();
    Matrix weights_ihh = hidden.getPoisEntreePoid(10,2);
	Couche SortieCouche=x.SortieCouche;
	Matrix bias_oo = SortieCouche.getBias();
	Matrix weights_hoo = SortieCouche.getPoisEntreePoid(1,10);
	bias_hh=bias_h;
	bias_oo=bias_o;
	weights_ihh=weights_ih;
	weights_hoo=weights_ho;
	ArrayList<Matrix> z = x.fapp.correctionPoids(X, Y, 1000000, weights_ihh, bias_hh, weights_hoo, bias_oo,x.l_rate);
	double [][] input ={ {0,0}, 
            {1,0}, 
            {0,1}, 
            {1,1} };
	for(double d[]:input)
	{
	   List<Double> output = x.predict(d, z.get(0),z.get(1),z.get(2),z.get(3));
	   
	    System.out.println(output.toString());
	}
	}
}
