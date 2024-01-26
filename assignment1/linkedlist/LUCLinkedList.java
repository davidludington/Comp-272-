public class LUCLinkedList {// a Singly Linked List
    static class Node {
        int data;
        Node next;
        Node(int d) // Constructor
        {
            data = d;
            next = null;
        }
    }
  
    Node head; // head of list
  
    public void insert(int data) // Method to insert a new node
    {
        Node new_node = new Node(data); // Create a new node with given data
        new_node.next = null;
        if (this.head == null) { // If the Linked List is empty, then make the new node as head
            this.head = new_node;
        }
        else {// Else traverse till the last node and insert the new_node there
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node; // Insert the new_node at last node
        }
    }

    public String toString() // Method to output the LinkedList as a String
    {   String output="[";
        Node currNode = this.head;
        //System.out.print("LinkedList: ");
        while (currNode != null) { // Traverse through the LinkedList
            //System.out.print(currNode.data + " "); // Print the data at current node
            output+=currNode.data + " ";
            currNode = currNode.next; // Go to next node
        }
        return output.trim()+"]";
    }

    
  
  
  //remove all the nodes that store a given value less than the passed value (ltValue)
    public void removeElementsLT(int ltValue) {
      Node curr = null;
      Node prev = null;

      while(head != null && head.data < ltValue){ // removes elements that are < the ltValue at the begining of the list
        head = head.next;
      }

      if(head != null){ //creates current and previous nodes after elemets les than the ltValue are removed from the begining of the list
        prev = head;
        curr = head.next;
      }

      while(curr != null){ //trverses the list 
        if(curr.data < ltValue){
          prev.next = curr.next; //removes elemet from middle of list
        } else{
          prev = curr; //iterates previous node 
        }

        if(curr != null){
          curr = curr.next; //iterates current node
        }
      }

    }



  

    public static void main(String[] args)
    {
        LUCLinkedList list = new LUCLinkedList();/* Start with the empty list. */
        // Insert the values
        list.insert(1);  
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(9);
        list.insert(100);
        list.insert(35);
        System.out.println(list); // Print the LinkedList
        list.removeElementsLT(8);
        System.out.println(list);
//
    }
}