package br.ufc.crateus.eda.st;


public interface ST<K, V> {
	void put(K key, V value);
	
	V get(K key);
	
	boolean contains(K key);
	
	void delete(K key);
	
	boolean isEmpty();
	
	int size();
	
	Iterable<K> keys();
}
