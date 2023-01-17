package Metier.Transfert;

import Operation.Matrix;

public class sigmoide implements FonctionTransfert{

	@Override
	public Matrix calculSortie(Matrix m,Boolean b) {
		if(b==true) {
	        for(int i=0;i<m.rows;i++)
	        {
	            for(int j=0;j<m.cols;j++)
	                m.data[i][j] = 1/(1+Math.exp(-m.data[i][j])); 
	        }
	        return m;
		}
		else {
	        Matrix temp=new Matrix(m.rows,m.cols);
	        for(int i=0;i<m.rows;i++)
	        {
	            for(int j=0;j<m.cols;j++)
	                temp.data[i][j] = m.data[i][j] * (1-m.data[i][j]);
	        }
	        return temp;
		}

	}

}
