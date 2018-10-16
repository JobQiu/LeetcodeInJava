class MaxStack{
  Stack<Integer> stack;
  Stack<Integer> maxStack;

  public MaxStack(){
    stack = new Stack();
    maxStack = new Stack();
  }

  public void push(int x){
    pushHelper(x);
  }

  public void pushHelper(int x){

    int tempMax =


  }


}

class MaxStack {

    class Node{
        int value;
        int max;
        Node next;
        Node previous;

        public Node(int value, int max){
            this.value = value;
            this.max = max;
        }
    }

    Node head;
    Node tail;

    /** initialize your data structure here. */
    public MaxStack() {
        head = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);

        head.next = tail;
        tail.previous = head;
    }

    public void push(int x) {
        Node node = new Node(x, Math.max(x, tail.previous.max));
        node.next = tail;
        node.previous = tail.previous;

        node.next.previous = node;
        node.previous.next = node;

    }

    public int pop() {
        Node node = tail.previous;

        node.previous.next = node.next;
        node.next.previous = node.previous;
        node.next = null;
        node.previous = null;

        return node.value;
    }

    public int top() {
        return tail.previous.value;
    }

    public int peekMax() {
        return tail.previous.max;
    }

    public int popMax() {
        int max = peekMax();
        Node curr = tail.previous;

        while(curr.value != max){
            curr = curr.previous;
        }

        Node update = curr.next;


        curr.previous.next = curr.next;
        curr.next.previous = curr.previous;
        curr.next = null;
        curr.previous = null;

        while(update != tail){
            update.max = Math.max(update.value, update.previous.max);
            update = update.next;
        }

        return max;
    }
}



/*

MaxStack stack = new MaxStack();
stack.push(5);
stack.push(1);
stack.push(5);
stack.top(); -> 5
stack.popMax(); -> 5
stack.top(); -> 1
stack.peekMax(); -> 5
stack.pop(); -> 1
stack.top(); -> 5

*/
