package Metier;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JList;

import Metier.Classes.Couche;
import Metier.Reseau.Reseau;
import Operation.Matrix;

/**
 * Servlet implementation class apprenti
 */
@WebServlet("/apprenti")
public class apprenti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public apprenti() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Matrix	 weights_ih = new Matrix(10,2);
		Matrix   weights_ho = new Matrix(1,10);
        
		Matrix     bias_h = new Matrix(10,1);
		Matrix     bias_o = new Matrix(1,1);
		double  [][] X= { 
	            {1,0}, 
	            {1,1}, 
	            {0,0}, 
	            {0,1} 
	    } ; 
	double  [][] Y= { 
			{1},{1},{0},{1} 
	    } ;
	 for(int i=0;i<4;i++) {
		 for(int j=0;j<2;j++) {
				int x=Integer.parseInt(request.getParameter("x"+(i)+(j)));
              X[i][j]=x;
		 }

	 }
	 
	 for(int i=0;i<4;i++) {
		 for(int j=0;j<1;j++) {

		double y=Double.parseDouble(request.getParameter("y"+(i)+(j)));
		Y[i][j]=y;
	 }}
	 
	 
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
		String network="and_logique";
		String type="x";
		String couche1="entrer";
		String couche2="sortie";
		String couche3="hidden";
		ArrayList<Matrix> z = x.fapp.correctionPoids(X, Y, 100000, weights_ihh, bias_hh, weights_hoo, bias_oo,x.l_rate);
		weights_ihh=z.get(0);
		bias_hh=z.get(1);
		weights_hoo=z.get(2);
		bias_oo=z.get(3);
		
		
		 java.sql.Statement stmt=null;
		 Connection con=null;
		try { 
			Class.forName ("com.mysql.jdbc.Driver");
			  con=(Connection)DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/fonctionnenent_noroune?characterEncoding=utf8","root","");
			stmt = con.createStatement(); 
			 String sql = "INSERT INTO network(Nom,nbr_hiddenCouche,type) " +
		                "VALUES ('"+network+"',3,'"+type+"');";
			stmt.executeUpdate(sql);	
			
			System.out.print("network");
			
            
		}
			catch(Exception e) {
				System.out.print("nonnetwork");

			}
		
		
		try { 
				String sql1 = "select max(Id) from network";
			    ResultSet g = stmt.executeQuery(sql1);
				   

			    g.next();
			 	int id=g.getInt(1);
			System.out.print("fekkak");
				 String sql3 = "INSERT INTO couche(id_network,type) " +
			                "VALUES ('"+id+"','entre');";
					stmt.executeUpdate(sql3);	
					 String sql4 = "INSERT INTO couche(id_network,type) " +
				                "VALUES ('"+id+"','hidden');";
						stmt.executeUpdate(sql4);	
						 String sql5 = "INSERT INTO couche(id_network,type) " +
					                "VALUES ('"+id+"','sortie');";
							stmt.executeUpdate(sql5);	
							
							
							   System.out.print("salma");
							   g.close();

			   
			 
			   System.out.println("abdouuuuuu");


		}
			catch(Exception e) {
				System.out.print(e.getMessage());

			}
		  
		   
		
		try { 
			ArrayList<Integer>coucheo=new ArrayList<Integer>(); 
					 String sqll ="select max(id_couche) from couche";
					 ResultSet res = stmt.executeQuery(sqll);
			res.next();
					int id=res.getInt(1);
					coucheo.add(id-1);
					coucheo.add(id);
			       System.out.println(id+"abdou");
					 for(int i=0;i<10;i++) {
						 String sqlo = "INSERT INTO neurone(id_chouche,bias_h) " +
					                "VALUES ('"+coucheo.get(1)+"','"+bias_hh.data[i][0]+"');";
						stmt.executeUpdate(sqlo);
					       System.out.println(id+"qwer");

				 }
					 for(int i=0;i<1;i++) {
						 String sqlo = "INSERT INTO neurone(id_chouche,bias_h) " +
					                "VALUES ('"+coucheo.get(0)+"','"+bias_oo.data[i][0]+"');";
						stmt.executeUpdate(sqlo);
				 }
				       System.out.println(id+"abdou");
				       res.close();

				
		}
		catch(Exception e) {
			System.out.print("non nou");

		}
		
		
		
		
		
		try { 
			ArrayList<Integer>nouro=new ArrayList<Integer>(); 
					 String sqll ="select max(Id) from neurone,couche  where neurone.id_chouche=couche.id_couche and type='hidden'  ";
					 ResultSet res = stmt.executeQuery(sqll);
			res.next();
			int id=res.getInt(1);
			
			res.close();

			for(int i=1;i<=10;i++) {
				nouro.add(id-10+i-1);
				System.out.print(nouro.size());

				System.out.println(id-10+i);
				for(int j=0;j<2;j++) {
					float z1=(float) weights_ihh.data[i-1][j];
					System.out.println(nouro.get(i-1));
					String b="insert into poid(id_neurone,point) values('"+nouro.get(i-1)+"','"+z1+"')";
      			stmt.executeUpdate(b);
				}
				
			}
				

				
		}
		catch(Exception e) {
			System.out.print("non nou");

		}
		
		
		
		try { 
			ArrayList<Integer>nouro=new ArrayList<Integer>(); 
					 String sqll ="select max(Id) from neurone,couche  where neurone.id_chouche=couche.id_couche and type='sortie'";
					 ResultSet res = stmt.executeQuery(sqll);
			res.next();
			int id=res.getInt(1);
			res.close();

			for(int i=1;i<=1;i++) {
				nouro.add(id+i);
				System.out.print("khoya");

				for(int j=0;j<10;j++) {
					float z1=(float) weights_hoo.data[i-1][j];
					System.out.print(z1);
					String sql="insert into poid(id_neurone,point) values('"+nouro.get(i-1)+"','"+z1+"')";
//					
					stmt.executeUpdate(sql);
				}
				
			}
				

				
		}
		catch(Exception e) {
			System.out.print("non nou");
//
		}
//					 
		
				
		   
		   
		   
			
			
			

          
	
//			
				
			
	

		
		
		
		ArrayList<Double> resultat = new ArrayList<Double>();
		
		for(double d[]:X)
		{
		   List<Double> output = x.predict(d, z.get(0),z.get(1),z.get(2),z.get(3));
		   
		    System.out.println(output.get(0));
		    resultat.add(output.get(0));
		}
		
		request.setAttribute("resultat", resultat);
		RequestDispatcher RequestDispatcher=request.getRequestDispatcher("rs.jsp");
				RequestDispatcher.forward(request,response);
		}
		
	 
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
