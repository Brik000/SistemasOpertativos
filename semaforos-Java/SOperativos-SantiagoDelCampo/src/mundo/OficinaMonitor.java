package mundo;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import hilos.Estudiante;



public class OficinaMonitor {
	
	public final static int SILLAS=3;
	
	private ArrayList<Estudiante> estudiantes;
	
	private Estudiante actual;
	
	private int sillasDisponibles;
	
	private Semaphore semaphore;

	public OficinaMonitor() {
		
		this.estudiantes= new ArrayList<Estudiante>();
		
		this.sillasDisponibles= SILLAS;
		
		this.semaphore=new Semaphore(1);
		
		actual=null;
		
	}
	
	public void newStudent(Estudiante nuevo) {
		try {
			if(estudiantes.size()<SILLAS) {
				
			semaphore.acquire();
			
			estudiantes.add(nuevo);
			
			semaphore.release();
			
			System.out.println("el estudiante "+ nuevo.getId()+" se ha sentado a esperar");
			
			}else {
				// como no hay espacio en la fila se va a la sla a rogramar
				nuevo.setAt(Estudiante.AT_COMPUTO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public int monitorTrabaja() {
		
		int tiempopreguntas;
		try {
			if(!estudiantes.isEmpty()) {
				semaphore.acquire();

				//este es el estudiante que esta atendiendo
				
				tiempopreguntas = (int) (Math.random() * 90 + 10);

				actual=estudiantes.remove(0);
				
				int id=(int) actual.getId();
				
				System.out.println("Monitor: atendere las dudas del estudinte "+ id);
				
				Thread.sleep(tiempopreguntas);
				
				actual.setAt(Estudiante.AT_COMPUTO);
				
				semaphore.release();
				
				actual=null;
				
				System.out.println("Monitor: el estudiante"+ id+" ha sido despchado ");
				
				return (int) id;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public boolean estaVacia() {
		
		return estudiantes.size()==0;
		
	}
	

	public int getSillasDisponibles() {
		return sillasDisponibles;
	}

	
	public Estudiante getActual() {
		
		return actual;
	}
	
	
	
	
	
}
