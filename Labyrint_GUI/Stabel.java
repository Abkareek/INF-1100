import java.util.Iterator;

public class Stabel <T>implements Liste<T> {
	protected Node head= null;
	protected Node tail;

	protected int counter = 0;
public class Node{
		protected Node next;
		T item ;
		protected Node prev;

		Node(T elm) {
			this.item=elm ;
		}


	}




		public Iterator<T> iterator() {
			// TODO Auto-generated method stub
			return  new MineIterator();
		}
		private class MineIterator implements Iterator<T>{
			protected Node current =head;


			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return current != null;
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				T temp = current.item;
				current = current.next;
				return temp;

			}
			@Override
			public void remove() {}
			}
			/**
			* return the size of the linked list
			* @return int counter
			*/
			public int storrelse() {
				// TODO Auto-generated method stub

				return counter;
			}




			/**
			* check if the linked list is empty
			*/
			public boolean erTom() {
				// TODO Auto-generated method stub
				return (head == null);
			}
			/**
			* inserting Nodes into the linked list
			* @param T element
			* @return nothing
			*/


			public void settInn(T element) {
				// Create newNode , assign it's next to the head , then consider the newNode is the head
				Node newNode = new Node(element);
				newNode.next = head;
				head = newNode;
				counter++;


			}

			/**
			* delete last inserted item from the linked list
			* @return the deleted item tmp
			*/
			public T fjern() {
				// TODO Auto-generated method stub
				Node tmp = head;
				head = tmp.next;
				tmp.next= null;
				counter --;
				return tmp.item;
			}

		}
