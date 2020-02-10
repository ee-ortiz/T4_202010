package model.data_structures;

public interface IPila <T extends Comparable<T>> {

	public void push(T elemento);
	public T pop();
	public int consultarTamano();
	public boolean estaVacia();
	public T consultarTope();
	public T[] darElementos();

}
