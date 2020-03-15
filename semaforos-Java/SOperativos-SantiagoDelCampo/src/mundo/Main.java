package mundo;

import hilos.Estudiante;
import hilos.Monitor;

public class Main {

	public static void main(String[] args) {
	
		OficinaMonitor oficina= new OficinaMonitor();
		
		int estudiantesN= (int)((Math.random()*10)+ 1);
		//Inicializamos todos los estudiantes
		for (int i = 0; i < estudiantesN; i++) {
			Estudiante nuevo= new Estudiante(i, oficina);
			Thread hiloStudent = new Thread(nuevo);
			hiloStudent.start();
		}
		//Inicializamos el monitor
		int idMonitor=0;
		Monitor monitor= new Monitor(oficina);
		Thread hiloMonitor = new Thread(monitor);
		hiloMonitor.start();
	}

}
