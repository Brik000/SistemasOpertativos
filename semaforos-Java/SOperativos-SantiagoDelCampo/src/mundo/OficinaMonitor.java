package mundo;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import hilos.Estudiante;



public class OficinaMonitor {
	
	
	/*
	 *  esta constante represetna la cantidad de sillas disponibles en la fila de espera
	 */
	public final static int SILLAS=3;
	
	/*
	 * este arreglo contiene a todos los estudiantes que tienen dudas y estan en fila de espera
	 */
	private ArrayList<Estudiante> estudiantes;
	
	/*
	 * este representa al estuiante que esta sineod atendido actualemnte
	 */
	private Estudiante actual;
	
	/*
	 *  indica cuantas sillas estan disponibles en la fila
	 */
	private int sillasDisponibles;
	
	/*
	 * semaforo de la actividad
	 */
	private Semaphore semaphore;
	
	/*
	 *  cosntructor que permite crear la oficina del monitor
	 */
	public OficinaMonitor() {
		
		this.estudiantes= new ArrayList<Estudiante>();
		
		this.sillasDisponibles= SILLAS;
		
		this.semaphore=new Semaphore(1);
		
		actual=null;
		
	}
	
	/*
	 * Represetna que un estudiante se acerca a la oficina del monitor
	 */
	public void newStudent(Estudiante nuevo) {
		
		try {
			//si hay sills para esperar el estudiante espera que el monitor se desocupe
			if(estudiantes.size()<SILLAS) {
				
			semaphore.acquire();
			
			estudiantes.add(nuevo);
			
			semaphore.release();
			
			System.out.println("el estudiante "+ nuevo.getId()+" se ha sentado a esperar");
			
			}else {
				// como no hay espacio en la fila se va a la sala a programar 
				//hasta tener una nueva duda
				nuevo.setAt(Estudiante.AT_COMPUTO);
				System.out.println("el estudiante "+ nuevo.getId()+" volvera a la sala de computo porque no habia espacio en la fila");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	/*
	 * este metodo representa como un monitor resuelve dudas de un estudiante
	 * 
	 */
	public int monitorTrabaja() {
		
		int tiempopreguntas;
		try {
			if(!estudiantes.isEmpty()) {
				semaphore.acquire();

				//tiempo que le tomara al monitor resolver la duda
				
				tiempopreguntas = (int) (Math.random() * 90 + 10);
				
				//estudiante que se sienta a recivir la monitoria y deja libre su espacio en fila
				actual=estudiantes.remove(0);
				
				int id=(int) actual.getId();
				
				System.out.println("Monitor: atendere las dudas del estudinte "+ id+" y se demorara "+tiempopreguntas);
				
				Thread.sleep(tiempopreguntas);
				
				actual.setAt(Estudiante.AT_COMPUTO);
				
				semaphore.release();
				
				actual=null;
				
				System.out.println("Monitor: el estudiante"+ id+" ha sido despahcado ");
				
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
