package Metier.Classes;

import java.util.ArrayList;

import Operation.Matrix;

public class Couche {
	private ArrayList<Neurone> neurones=new ArrayList<Neurone>();
	
	public Matrix getBias() {
		 Matrix bias = new Matrix(neurones.size(),1);
for(int i=0;i<neurones.size();i++) {
	bias.data[i][1]=neurones.get(i).bias;
}
	return bias;
	}
	
	public Matrix getPoisEntreePoid(int i,int j) {
		
		 Matrix poits = new Matrix(i,j);
//		 for(int i=0;i<neurones.size();i++) {
//			 for(int j=0;i<neurones.get(0).entreePoid.size();j++) {
//
//			 poits.data[i][j]=neurones.get(i).entreePoid.get(j);
//			} 
//
//	}
		return poits;
	
	}
	public Matrix getPoisSortie(int i,int j) {
		
		 Matrix poits = new Matrix(i,j);
//		 for(int i=0;i<neurones.size();i++) {
//			 for(int j=0;i<neurones.get(0).sortiePoid.size();j++) {
//
//			 poits.data[i][j]=neurones.get(i).sortiePoid.get(j);
//			} 

//	}
		return poits;
	
	}
//	private ArrayList<Couche> EntreCouches;
//	private ArrayList<Couche> SortieCouches;


}
