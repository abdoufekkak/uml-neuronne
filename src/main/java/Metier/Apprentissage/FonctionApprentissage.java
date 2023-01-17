package Metier.Apprentissage;

import java.util.ArrayList;

import Metier.Classes.Poid;
import Operation.Matrix;

public interface FonctionApprentissage {
	public ArrayList<Matrix> correctionPoids(double[][]X,double [][]Y,int iteration,Matrix weights_ih,Matrix bias_h,Matrix weights_ho,Matrix bias_o,double l_rate);

}
