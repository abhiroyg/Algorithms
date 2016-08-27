package stack;

import doublylinkedlist.DoublyLinkedList;

import java.util.List;

/**
 * Created by mamu on 8/2/16.
 */
public class StackImp<T> implements Stack<T>{
  //List
  private DoublyLinkedList<T> stack;

  public StackImp() {
    stack = new DoublyLinkedList<>();
  }

  @Override
  public boolean push(T data) {
    stack.addAtTail(data);
    return true;
  }

  @Override
  public T pop() {
    T data = null;

    if(stack.getSize() != 0) {
      data = stack.removeAtTail();
    }

    return data;
  }

  @Override
  public boolean isEmpty() {
    return stack.isEmpty();
  }

  @Override
  public Integer size() {
    return stack.getSize();
  }
}
