package pl.edu.pw.ee;

import pl.edu.pw.ee.services.HashTable;

public class HashListChaining<T extends Comparable<T>> implements HashTable<T> {

	private final Elem<T> nil = null;
	private Elem<T>[] hashElems;
	private int nElem;

	private class Elem<T> {

		private T value;
		private Elem<T> next;

		Elem(T value, Elem<T> nextElem) {
			this.value = value;
			this.next = nextElem;
		}
	}

	public HashListChaining(int size) {
		if (size < 1) {
			throw new IllegalArgumentException("size must be >= 1");
		}
		hashElems = new Elem[size];
		initializeHash();
	}

	@Override
	public void add(T value) {
		if (value == null) {
			throw new IllegalArgumentException("added value cannot be null");
		}
		int hashCode = value.hashCode();
		int hashId = countHashId(hashCode);

		Elem<T> oldElem = hashElems[hashId];
		while (oldElem != nil && !oldElem.value.equals(value)) {
			oldElem = oldElem.next;
		}
		if (oldElem != nil) {
			oldElem.value = value;
		} else {
			hashElems[hashId] = new Elem<>(value, hashElems[hashId]);
			nElem++;
		}
	}

	@Override
	public T get(T value) {
		if (value == null) {
			throw new IllegalArgumentException("added value cannot be null");
		}
		int hashCode = value.hashCode();
		int hashId = countHashId(hashCode);

		Elem<T> elem = hashElems[hashId];

		while (elem != nil && !elem.value.equals(value)) {
			elem = elem.next;
		}

		return elem != nil ? elem.value : null;
	}

	@Override
	public void delete(T value) {
		if (value == null) {
			throw new IllegalArgumentException("added value cannot be null");
		}
		int hashCode = value.hashCode();
		int hashId = countHashId(hashCode);

		Elem<T> elem = hashElems[hashId];
		if (elem == nil) {
			return;
		}
		if (elem.value.equals(value)) {
			hashElems[hashId] = elem.next;
			nElem--;
			return;
		}

		while (elem.next.next != nil && !elem.next.value.equals(value)) {
			elem = elem.next;
		}

		if (elem.next.next == nil && !elem.next.value.equals(value)) {
			return;
		}

		if (elem.next.next == nil) {
			elem.next = nil;
			nElem--;
			return;
		}

		if (elem.next.value.equals(value)) {
			elem.next = elem.next.next;
			nElem--;
		}
	}

	public double countLoadFactor() {
		double size = hashElems.length;
		return nElem / size;
	}

	private void initializeHash() {
		int n = hashElems.length;

		for (int i = 0; i < n; i++) {
			hashElems[i] = nil;
		}
	}

	private int countHashId(int hashCode) {
		int n = hashElems.length;
		return Math.abs(hashCode) % n;
	}

}
