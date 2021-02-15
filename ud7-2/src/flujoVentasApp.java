
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class flujoVentasApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<String,Double[]> lista = new Hashtable<String,Double[]>();
		
		while(true) {
			int t= Integer.parseInt(JOptionPane.showInputDialog("¿Deseas introducir algún artículo? [0=no, otro=sí]"));
			if(t==0) break;
			else {
				Double[] articulo = new Double[3];//posición 0= precio bruto posición 1 = IVA posición 2 = cantidad de artículos
				String k = JOptionPane.showInputDialog("Introduce el nombre del producto");
				articulo[0] = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio"));
				while(!(articulo[0]>=0)) articulo[0] = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio"));
				articulo[1] = Double.parseDouble(JOptionPane.showInputDialog("Introduce el IVA (4 = 4% o 21 = 21%"));
				while(articulo[1]!=4 && articulo[1]!=21) articulo[1] = Double.parseDouble(JOptionPane.showInputDialog("Introduce el IVA (4 = 4% o 21 = 21%"));
				articulo[2] = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad de artículos"));
				while(!(articulo[2]>0)) articulo[2] = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad de artículos"));

				lista.put(k,articulo);
			}
		}
		Enumeration<Double[]> enumeration = lista.elements();
		Enumeration<String> llaves = lista.keys();
		double totalBruto=0;
		double total = 0;
		double cantidad=0;
		while (llaves.hasMoreElements()) {
			Double[] contenido = enumeration.nextElement();
			System.out.println("Artículo "+llaves.nextElement()+" con precio="+contenido[0]+" IVA="+contenido[1]+" cantidad="+contenido[2]);
			totalBruto+=contenido[0]*contenido[2];
			total+=(contenido[0]+(contenido[0]*(contenido[1]/100)))*contenido[2];
			cantidad+=contenido[2];
		}
		System.out.println("Total Bruto = "+totalBruto);
		System.out.println("Precio con IVA = "+total);
		double pago = Double.parseDouble(JOptionPane.showInputDialog("Introduce el pago"));
		while((pago-total)<0) pago = Double.parseDouble(JOptionPane.showInputDialog("(Cantidad insuficiente) Introduce el pago"));
		System.out.println("Aquí tiene su cambio: "+(pago-total));

	}

}
