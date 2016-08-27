package queue;

import doublylinkedlist.DoublyLinkedList;

/**
 * Created by mamu on 8/4/16.
 */
public class QueueImp<T> implements Queue<T> {

  private DoublyLinkedList<T> queue;

  public QueueImp() {
    queue = new DoublyLinkedList<>();
  }

  @Override
  public int size() {
    return queue.getSize();
  }

  @Override
  public T dequeue() {
    T data = null;
    if (queue.getSize() != 0){
      data = queue.removeAtHead();
    }
    return data;
  }

  @Override
  public void enqueue(T data) {
    queue.addAtTail(data);
  }

  @Override
  public boolean isEmpty() {
    return queue.isEmpty();
  }
}
