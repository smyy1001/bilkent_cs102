public class basicDataStructuresPractice {

    public static void main(String[] args) {
        Cell list1 = new Cell(1, new Cell(2, new Cell(3, new Cell(4, null)))); // 1 2 3 4
        SLL list2 = new SLL(); // looks like it is the actual list but is actually just a reference to the second element and so on
        list2.first = new SLLNode("hello", new SLLNode("I", new SLLNode("am", new SLLNode("sumeyye", null))));
        // Traversing through SLLNode
        for( SLLNode sllN = list2.first; sllN != null; sllN = sllN.nodeNext ) {
            // traveling one by one 
            sllN.toStringg();
        }
    
    }
}

class Cell {
         
    int element;
    Cell next;
    
    public Cell( int i, Cell c ) {
        this.element = i;
        this.next = c;
    }
}

class SLLNode { // this class is what actually bounds the elements to each other!
    Object element;
    SLLNode nodeNext;
    SLLNode(Object o, SLLNode sllNode) {
        this.element = o;
        this.nodeNext = sllNode;
    }
    public void toStringg() {
        System.out.println(element);
    }
}

class DLLNode {
    Object element;
    DLLNode nodeBefore;
    DLLNode nodeNext;
    DLLNode(Object o, DLLNode previous, DLLNode next) {
        this.element = o;
        this.nodeBefore = previous;
        this.nodeNext = next;
    }
}

class SLL { // this class is actually only the first node and users might think this is the actual list
            // users are not supposed to know the implementation in the first place
    SLLNode first;
    SLL() {
        this.first = null;
    }
}

class DLL { // doubly linked list (both forward and backwards)
    DLLNode first;
    DLLNode last;
    DLL() {
        this.first = null;
        this.last = null;
    }
}