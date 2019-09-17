

public class Koe<T> extends Stabel<T>{
		public Koe(){
		super();
	}

	@Override
	public void settInn(T elm) {
		if (erTom()) {
			Node no = new Node(elm);
			no.next = head;
			head = no;
			tail = no;
			counter++;

		}else {
		Node no = new Node(elm);
		//no.next = tail.next;
		tail.next = no;
		tail = no;
		counter++;
		}


	}
	public T fjern() {
		// TODO Auto-generated method stub
		if(iterator().hasNext()) {
	    Node  tmp = head;
		head =  tmp.next;
		tmp.next = null;
		counter --;
		return tmp.item;
	}else {

		return head.item;
	}
}
	}
