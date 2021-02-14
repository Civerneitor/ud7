import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;
public class notaMediaApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<String,Integer> alumnos = new Hashtable<String,Integer>();
		int t= Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de notas por alumno: "));
		int[] notas=new int[t];
		
		int q = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de alumnos: "));
		
		
		while(q>0) {
			String dni = JOptionPane.showInputDialog("Introduce el identificador del alumno: ");
			for(int i=t;i>0;i--) {//pido las notas
				notas[t-i]=Integer.parseInt(JOptionPane.showInputDialog("Introduce la nota "+(t-i)));
				if(notas[t-i]>10 || notas[t-i]<0) i++;
			}
			int media=0;
			for(int j=0;j<t;j++) {//calculo la media
				media+=notas[j];
			}
			media/=t;
			alumnos.put(dni, media);
			q--;
		}
		Enumeration<Integer> enumeration = alumnos.elements();
		Enumeration<String> llaves = alumnos.keys();
		while (llaves.hasMoreElements()) {
			System.out.println("Alumno/a "+llaves.nextElement()+" con nota media "+enumeration.nextElement());
		}
	}

}
