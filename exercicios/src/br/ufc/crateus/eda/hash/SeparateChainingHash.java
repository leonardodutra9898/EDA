package br.ufc.crateus.eda.hash;

import br.ufc.crateus.eda.st.ST;

public class SeparateChainingHash<K,V> implements ST<K,V> {

	private Node[] vector;
	
	@SuppressWarnings("unchecked")
	public SeparateChainingHash(int m) {
		this.vector = new Node[m];
	}
	
	private static class Node {
		Object key,value;
		Node next;
	}
	
	@Override
	public void put(K key, V value) {
		if(key == null) throw new IllegalArgumentException("Key null!");
		if(value == null) delete(key);
		
		int hashTemp = hash(key, size());
		if(vector[hashTemp] == get(key)) {
			put(key, value);
		}
	}
	
	
	private int hash(K key, int m) {
		return (key.hashCode() & 0x7fffffff) % m;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public V get(K key) {
		
		if(key == null) throw new IllegalArgumentException("Key null!");
		int hashTemp = hash(key,size());
		return (V) vector[hashTemp].value;
		
	}

	@Override
	public boolean contains(K key) {
		if(key == null) throw new IllegalArgumentException("Key null!");
		return get(key) != null;				
	}

	@Override
	public void delete(K key) {
				
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return vector.length;
	}

	@Override
	public Iterable<K> keys() {
		// TODO Auto-generated method stub
		return null;
	}

}
