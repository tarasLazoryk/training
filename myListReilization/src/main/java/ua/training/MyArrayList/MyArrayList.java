package ua.training.MyArrayList;

import java.util.*;
import java.util.function.Consumer;

public class MyArrayList<E> implements List<E> {

	// constants
	private final static String NEGATIVE_CAPACITY = "Capacity cant be negative.";
	private static final String OUT_OF_BOUNDS = "Index is out of bounds.";
	private final static int DEFAULT_CAPACITY = 10;
	private final static String NEGATIVE_INDEX = "Index cant be negative.";

	/**
	 * size of this list
	 */
	private int size = 0;

	/**
	 * values container
	 */
	private Object array[];

	public MyArrayList() {
		this(DEFAULT_CAPACITY);
	}

	public MyArrayList(int capacity) {
		checkIsNotNegative(capacity, NEGATIVE_CAPACITY);
		array = new Object[capacity];
	}

	private void checkIsNotNegative(int number, String message) {
		if (number < 0) {
			throw new IllegalArgumentException(message);
		}
	}

	public void ensureCapacity(int capacity) {
		checkIsNotNegative(capacity, NEGATIVE_CAPACITY);
		if (capacity > array.length) {
			int newArrayLength = (int) (array.length * 1.5);
			if (newArrayLength < capacity) {
				newArrayLength = capacity;
			}
			Object newArray[] = new Object[newArrayLength];
			System.arraycopy(array, 0, newArray, 0, size);
			array = newArray;
		}
	}

	@Override
	public boolean add(E e) {
		ensureCapacity(size + 1);
		array[size] = e;
		size++;
		return true;
	}

	@Override
	public void add(int index, E element) {
		checkIndex(index);
		ensureCapacity(size + 1);
		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = element;
		size++;

	}

	@Override
	public E get(int index) {
		checkIndex(index);
		return (E) array[index];
	}

	private void checkIndex(int index) {
		if (index >= size) {
			throw new IllegalArgumentException(OUT_OF_BOUNDS);
		}
		checkIsNotNegative(index, NEGATIVE_INDEX);
	}

	@Override
	public void clear() {
		for (int i = 0; i < array.length; i++) {
			array[i] = null;
		}
		size = 0;

	}

	@Override
	public E remove(int index) {
		checkIndex(index);
		E element = (E) array[index];
		if (index < size - 1) {
			System.arraycopy(array, index + 1, array, index, size - index - 1);
		}
		array[size - 1] = null;
		size--;
		return element;
	}

	@Override
	public E set(int index, E element) {
		checkIndex(index);
		array[index] = element;
		return (E) array[index];
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return new MyListIterator(0);
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		checkIndex(index);
		// TODO Auto-generated method stub
		return new MyListIterator(index);
	}

	private class MyListIterator implements ListIterator<E> {

		/**
		 * current index
		 */
		int currentIndex;
		/**
		 * index of the last returned element
		 */
		int lastReturned = -1;

		public MyListIterator(int index) {
			checkIndex(index);
			this.currentIndex = index;
		}

		@Override
		public boolean hasPrevious() {
			return currentIndex > 0;
		}

		@Override
		public E previous() {
			if (currentIndex < 1) {
				throw new NoSuchElementException();
			}

			currentIndex--;
			lastReturned = currentIndex;
			return (E) array[lastReturned];
		}

		@Override
		public int nextIndex() {
			return currentIndex;
		}

		@Override
		public int previousIndex() {
			return currentIndex - 1;
		}

		@Override
		public void set(E obj) {
			if (lastReturned < 0)
				throw new IllegalStateException();

			MyArrayList.this.set(lastReturned, obj);

		}

		@Override
		public void add(E obj) {

			MyArrayList.this.add(currentIndex, obj);

			currentIndex++;
			lastReturned = -1;
		}

		public boolean hasNext() {
			return currentIndex != size;
		}

		public E next() {

			if (currentIndex >= size) {
				throw new NoSuchElementException();
			} else {
				lastReturned = currentIndex;
				currentIndex++;
				return (E) MyArrayList.this.array[lastReturned];
			}
		}

		public void remove() {
			if (lastReturned < 0) {
				throw new IllegalStateException();

			} else {
				MyArrayList.this.remove(lastReturned);
				currentIndex = lastReturned;
				lastReturned = -1;
			}
		}

	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

}