package gameoflife;

import java.util.Arrays;

public class GameOfLife {

	private boolean[][] tablero;
	
	/**
	 * Constructor. Crea un tablero finito de tipo booleano
	 * dadas las dimensiones pasadas como parámetros y lo inicializa a 'false'.
	 * 
	 * @param filas 
	 * @param columnas
	 */
	public GameOfLife(int filas, int columnas){
		
		tablero = new boolean[filas][columnas];
		
		for(boolean[] b:tablero){
			Arrays.fill(b,false);
		}
		
	}
	
	 /**
	 * Dada una celda, devuelve el número de celdas adyacentes 'vivas'.
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
	


}