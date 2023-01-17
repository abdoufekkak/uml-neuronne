package Metier.Apprentissage;

import java.util.ArrayList;

import Metier.Classes.Poid;
import Metier.Transfert.sigmoide;
import Operation.Matrix;

public class Supervise implements FonctionApprentissage  {

	public ArrayList<Matrix> train(double [] X,double [] Y, Matrix weights_ih,Matrix bias_h,Matrix weights_ho,Matrix bias_o,double l_rate)
    {   
		ArrayList<Matrix>c=new ArrayList<Matrix>();
        Matrix input = Matrix.fromArray(X);
        Matrix hidden = Matrix.multiply(weights_ih, input);
        hidden.add(bias_h);
        sigmoide z = new sigmoide();
        hidden=  z.calculSortie(hidden, true);
        
        Matrix output = Matrix.multiply(weights_ho,hidden);
        output.add(bias_o);
        output=   z.calculSortie(output, true);
        
        Matrix target = Matrix.fromArray(Y);
        
        Matrix error = Matrix.subtract(target, output);
        Matrix gradient = z.calculSortie(output, false);
        gradient.multiply(error);
        gradient.multiply(l_rate);
        
        Matrix hidden_T = Matrix.transpose(hidden);
        Matrix who_delta =  Matrix.multiply(gradient, hidden_T);
        
        weights_ho.add(who_delta);
        bias_o.add(gradient);
        
        Matrix who_T = Matrix.transpose(weights_ho);
        Matrix hidden_errors = Matrix.multiply(who_T, error);
        
        Matrix h_gradient =z.calculSortie(hidden, false);
        h_gradient.multiply(hidden_errors);
        h_gradient.multiply(l_rate);
        
        Matrix i_T = Matrix.transpose(input);
        Matrix wih_delta = Matrix.multiply(h_gradient, i_T);
        
        weights_ih.add(wih_delta);
        bias_h.add(h_gradient);
        c.add(weights_ih);
        c.add(bias_h);
        c.add(weights_ho);
        c.add(bias_o);
        return c;
    }
	
	@Override
	public ArrayList<Matrix> correctionPoids(double[][]X,double [][]Y,int iteration,Matrix weights_ih,Matrix bias_h,Matrix weights_ho,Matrix bias_o,double l_rate) 
		{
		
		
		ArrayList<Matrix>	x=new ArrayList<Matrix>();
		
		
	        for(int i=0;i<iteration;i++)
	        {    
	            int sampleN =  (int)(Math.random() * X.length );
	          x=  this.train(X[sampleN], Y[sampleN], weights_ih,  bias_h, weights_ho, bias_o, l_rate);
	        } ;
		return x;
	}


	
 
}
