package gameoflife;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class GameOfLife {

	private boolean[][] tablero;
	
	/**
	 * Método constructor. Crea un tablero finito de tipo booleano
	 * dados los datos pasados a través del fichero pasado como argumento.
	 * 
	 * @param fichero 
	 * @throws IOException 
	 */
	public GameOfLife(String fichero) throws IOException{
		
		FileReader input = null;
		try {
			input = new FileReader(fichero);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");;
		}
		BufferedReader bufRead = new BufferedReader(input);
		String myLine = bufRead.readLine();
		//System.out.println("Dimensions: "+ myLine);
		String[] parsedLine = myLine.split(" ");
		
		tablero = new boolean[Integer.parseInt(parsedLine[0])][Integer.parseInt(parsedLine[1])];
		
		int i= 0;
		while ( (myLine = bufRead.readLine()) != null){
		    for (int j = 0; j < myLine.length(); j++) {
		    	if(myLine.charAt(j) == '*'){
		    		tablero[i][j] = false;
		    	}else{
		    		tablero[i][j] = true;
		    	}
		    }
		    i++;
		}
		
	}
	
	 /**
	 * Método que, dada una celda, devuelve el número de celdas adyacentes 'vivas'.
	 * 
	 * @param row
	 * @param column
	 * @return numero de celdas 'vivas' adyacentes 
	 */
	public int cuentaVecinos(int fila, int col) {
		int contador = 0;
		
		for (int x = fila - 1; x <= fila + 1; x++) {
		    for (int y = col - 1; y <= col + 1; y++) {
		        if (isAlive(x, y) && (fila != x || col != y)) {
		            contador++;
		        }
		    }
		}
		
		return contador;
	 }

	/**
	 * Método que devuelve si una celda se encuentra dentro
	 * de los límites del tablero y está 'viva'.
	 * 
	 * @param fila
	 * @param col
	 * @return
	 */
	private boolean isAlive(int fila, int col) {
		
		return fila >= 0 && col >= 0 && fila < tablero.length && col < tablero[0].length && tablero[fila][col];
	}
	
	public void siguienteTurno() {
		boolean[][] siguienteTablero = new boolean[tablero.length][tablero[0].length];
		
		 for (int x = 0; x < tablero.length; x++) {

	            for (int y = 0; y < tablero[0].length; y++) {
	            	
	            }
		 }
		 
		 tablero = siguienteTablero.clone();
	}

	public String toString() {
		String cadena = "";
		
		for(int i=0; i<tablero.length; i++){
		    for (int j = 0; j < tablero[i].length; j++) {
		    	if(tablero[i][j]== true){
		    		cadena += "*";
		    	}else{
		    		cadena += ".";
		    	}
		    }
		    cadena += "\n";
			
		}
		
		return cadena;
	} 
	
	public static void main(String[] args) throws IOException {
		
		
		GameOfLife partida = new GameOfLife(args[0]);
		
		System.out.println(partida);
		
		
		
	}

}