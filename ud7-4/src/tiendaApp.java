import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class tiendaApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<String,Double[]> lista = new Hashtable<String,Double[]>();
		
		while(true) {
			int t= Integer.parseInt(JOptionPane.showInputDialog("�Deseas introducir alg�n art�culo? [0=no, otro=s�]"));
			if(t==0) {
				String d= JOptionPane.showInputDialog("�Deseas consultar alg�n art�culo? [no=salir, 'nombre del art�culo'=consulta el articulo, todos=list todos los art�culos]");
				switch (d) {
				case "todos":
					Enumeration<Double[]> enumeration = lista.elements();
					Enumeration<String> llaves = lista.keys();
					while (llaves.hasMoreElements()) {
						Double[] contenido = enumeration.nextElement();
						System.out.println("Art�culo "+llaves.nextElement()+" con precio="+contenido[0]+" IVA="+contenido[1]+" cantidad="+contenido[2]);
					}
					break;
				case "no":
					break;
				default:
					Double[] precio=lista.get(d);
					System.out.println("Art�culo "+d+" con precio="+lista.get(d));
				}
				if(d.equals("no")) break;
			}
			else {
				Double[] articulo = new Double[3];//posici�n 0= precio bruto posici�n 1 = IVA posici�n 2 = cantidad de art�culos
				String k = JOptionPane.showInputDialog("Introduce el nombre del producto");
				articulo[0] = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio"));
				while(!(articulo[0]>=0)) articulo[0] = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio"));
				articulo[1] = Double.parseDouble(JOptionPane.showInputDialog("Introduce el IVA (4 = 4% o 21 = 21%"));
				while(articulo[1]!=4 && articulo[1]!=21) articulo[1] = Double.parseDouble(JOptionPane.showInputDialog("Introduce el IVA (4 = 4% o 21 = 21%"));
				articulo[2] = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad de art�culos"));
				while(!(articulo[2]>0)) articulo[2] = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad de art�culos"));

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
			System.out.println("Art�culo "+llaves.nextElement()+" con precio="+contenido[0]+" IVA="+contenido[1]+" cantidad="+contenido[2]);
			totalBruto+=contenido[0]*contenido[2];
			total+=(contenido[0]+(contenido[0]*(contenido[1]/100)))*contenido[2];
			cantidad+=contenido[2];
		}
		System.out.println("Total Bruto = "+totalBruto);
		System.out.println("Precio con IVA = "+total);
		double pago = Double.parseDouble(JOptionPane.showInputDialog("Introduce el pago"));
		while((pago-total)<0) pago = Double.parseDouble(JOptionPane.showInputDialog("(Cantidad insuficiente) Introduce el pago"));
		System.out.println("Aqu� tiene su cambio: "+(pago-total));
	}

}
