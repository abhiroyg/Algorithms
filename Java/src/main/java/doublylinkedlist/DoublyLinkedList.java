package doublylinkedlist;

/**
 * Created by mamu on 8/2/16.
 */
public class DoublyLinkedList<T> {

  private Node<T> head;
  private Node<T> tail;
  private Integer size;


  public DoublyLinkedList() {
    size = 0;
  }

  //add at head
  public void addAtHead(T data) {
    Node<T> node = new Node<>();

    //set node data
    node.setData(data);
    node.setNext(head);
    node.setPrevious(null);

    //set head
    if (head != null) {
      head.setPrevious(node);
    }

    //change head
    head = node;

    //check if tail is null
    if (tail == null) {
      tail = node;
    }

    size++;
  }

  //add at tail
  public void addAtTail(T data) {
    Node<T> node = new Node<>();

    //set node data
    node.setData(data);
    node.setNext(null);
    node.setPrevious(tail);

    //add to tail
    if (null != tail) {
      tail.setNext(node);
    }

    //set tail
    tail = node;

    if (head == null) {
      head = node;
    }

    size++;
  }

  //remove at head
  public T removeAtHead() {
    T data = null;

    if (size == 0 && head == null) {
      tail = null;
      return data;
    }

    //Remove at head
    if (head != null && head.getNext() == null) {
      data = head.getData();
      head = null;
      tail = null;
    } else {
      Node<T> temp = head.getNext();
      data = head.getData();

      head.setNext(null);
      temp.setPrevious(null);
      head = temp;
    }
    size--;
    return data;
  }

  //remove at tail
  public T removeAtTail() {
    T data = null;

    if (size == 0 && tail == null) {
      head = null;
      return data;
    }

    //check if only element
    if (tail != null && tail.getPrevious() == null) {
      data = tail.getData();
      head = null;
      tail = null;
    } else {
      Node<T> temp = tail.getPrevious();
      data = tail.getData();

      tail.setPrevious(null);
      temp.setNext(null);
      tail = temp;
    }
    size--;
    return data;
  }

  //check if element exists
  public boolean checkElement(T data) {
    Node<T> temp1 = head;
    Node<T> temp2 = tail;
    
    while (temp1.getPrevious() != temp2
            || temp1.getPrevious().getPrevious() != temp2) {
      if (temp1.getData().equals(data)) {
          return true;
      } else if (temp2.getData().equals(data)) {
          return true;
      }
      temp1 = temp1.getNext();
      temp2 = temp2.getPrevious();
    }
    return false;
  }

  //return first occurence of ele
  public Node<T> getData(T data) {
    Node<T> temp = head;
    Node<T> targetNode = null;
    while (temp != null) {
      if (temp.getData().equals(data)) {
        targetNode = temp;
        break;
      }
      temp = temp.getNext();
    }
    return targetNode;
  }

  //remove first occurence of ele
  public boolean remove(T data) {
    Node<T> targetNode = getData(data);
    //check if null
    if (targetNode == null) {
      return false;
    }

    size--;

    //check if single element
    if (targetNode.getNext() == null && targetNode.getPrevious() == null) {
      head = null;
      tail = null;
      targetNode = null;
      return true;
    }

    //check if start of node
    if (targetNode.getPrevious() == null && targetNode.getNext() != null) {
      head = head.getNext();
      targetNode.setNext(null);
      head.setPrevious(null);
      targetNode = null;
      return true;
    }

    //check if end of node
    if (targetNode.getNext() == null && targetNode.getPrevious() != null) {
      tail = tail.getPrevious();
      targetNode.setPrevious(null);
      tail.setNext(null);
      targetNode = null;
      return true;
    }

    //middle of node
    Node<T> temp = targetNode.getNext();
    temp.setPrevious(targetNode.getPrevious());
    targetNode.getPrevious().setNext(temp);
    targetNode.setPrevious(null);
    targetNode.setNext(null);

    targetNode = null;
    temp = null;

    return true;
  }

}
