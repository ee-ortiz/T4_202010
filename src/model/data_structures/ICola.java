package model.data_structures;

public interface ICola <T extends Comparable<T>>{

	public void enqueue(T elemento);
	public T dequeue();
	public int consultarTam();
	public boolean estaVacia();
	public T consultarElementoPrincipio();
	public T[] darElementos();
	public void vaciarCola();
}
