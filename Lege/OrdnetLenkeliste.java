import java.util.*;


public class OrdnetLenkeliste<T extends Comparable< T>> extends Stabel<T> {
    OrdnetLenkeliste(){
        super();

    }


      @Override
      public void settInn(T element) {
        // Create newNode , assign it's next to the head , then consider the newNode is the head
        Node newNode = new Node(element);
        if (erTom()) {
          newNode.next = head;
          head = newNode;
          counter++;
        }else if (element.compareTo(head.item)< 0) {
          newNode.next = head;
          head = newNode;
          counter++;
        }else {
          Node after = head.next;
          Node before = head;

          while(after !=  null) {
            if(element.compareTo(after.item)< 0) {
                break;
            }

            before = after;
            after = before.next;
            
          }
          newNode.next = before.next;
          before.next = newNode;
          counter++;
        }
      }

      /**
      * delete last smallest item
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
