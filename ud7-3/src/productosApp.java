import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class productosApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<String,Double> lista = new Hashtable<String,Double>();
		lista.put("Leche",3.45);
		lista.put("Naranja",1.45);
		lista.put("Pizza",2.45);
		lista.put("Tortilla de patatas",1.45);
		lista.put("Salmon",5.45);
		lista.put("Yogurt",6.45);
		lista.put("Te",0.45);
		lista.put("Azucar",0.65);
		lista.put("Sal",1.05);
		lista.put("Cafe",4.95);
		
		while(true) {
			int t= Integer.parseInt(JOptionPane.showInputDialog("¿Deseas introducir algún artículo? [0=no, otro=sí]"));
			if(t==0) {
				String d= JOptionPane.showInputDialog("¿Deseas consultar algún artículo? [no=salir, 'nombre del artículo'=consulta el articulo, todos=list todos los artículos]");
				switch (d) {
				case "todos":
					Enumeration<Double> enumeration = lista.elements();
					Enumeration<String> llaves = lista.keys();
					while (llaves.hasMoreElements()) {
						Double contenido = enumeration.nextElement();
						System.out.println("Artículo "+llaves.nextElement()+" con precio="+contenido);
					}
					break;
				case "no":
					break;
				default:
					System.out.println("Artículo "+d+" con precio="+lista.get(d));
				}
				if(d.equals("no")) break;
			}
			else {
				String k = JOptionPane.showInputDialog("Introduce el nombre del producto");
				double articulo = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio"));
				while(!(articulo>=0)) articulo = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio"));
				lista.put(k,articulo);
			}
		}
	}
}
