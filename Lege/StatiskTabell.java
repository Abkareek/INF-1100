import java.util.Iterator;


class StatiskTabell<T> implements Tabell<T>{
  int arrayLength;
  T []table ;
  int counter =0;
public StatiskTabell (int a){
	this.arrayLength = a;
	table =(T[]) new Object[arrayLength];

}
@Override
public int storrelse(){
  /**
  * Beregner antall elementer i tabellen
  * @return antall elementer i tabellen
  *
  */
	return counter;
	}

public Iterator<T> iterator(){
	return new MineIterator();

}
private class MineIterator implements Iterator<T>{
	private int  pos = 0;

	public boolean hasNext() {

		if ( (! erTom())&& (pos < table.length)&&(table[pos] != null)){

			return true;
		}else {
			return false;
		}
	}
	public T next()  {
		if(hasNext()) {

		}return table[pos++];
	}




	@Override
	public void remove() {}




}



@Override
public boolean erTom() {
	// check if the array inEmpty

	return (counter == 0  ) ;




}
@Override
public void settInn(T element) {
	// check if the Array is not full , then assign the element to the next place


	if ( counter >= table.length ) {
		throw new FullTabellUnntak(storrelse());
	}else {
		table[counter] = element;
		counter++;
	}/**else {
		// if the array is full , copy the array into a bigger one then insert the element
		T [] extendedTable = (T[]) new Object[arrayLength*2];
		extendedTable = table;
		extendedTable[counter] = element;
		counter++;

	}
	*/
}
@Override
public T hentFraPlass  (int plass) {
	// TODO Auto-generated method stub
	//if (plass < 0 || plass > arrayLength) {
		//throw UgyldigPlassUnntak;
	//}
	if (( plass >= 0) && (plass < arrayLength)) {
		return table[plass];

	}else {
		throw new UgyldigPlassUnntak(plass,counter);

	}
}
}
