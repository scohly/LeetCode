import jdk.nashorn.internal.ir.Node;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    Map<Node,Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if(head == null) return null;

        if(map.containsKey(head)){
            return map.get(head);
        }

        Node n = new Node(head.val, null, null);

        map.put(head, n);
        n.next = copyRandomList(head.next);
        n.random = copyRandomList(head.random);

        return n;
    }

    /*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
    class Solution2 {
        public Node copyRandomList(Node head) {

            //handle null conidition:

            if(head == null)
                return head;



            //no gaurantee we dont have a null so create the map
            Map<Node, Node> map = new HashMap<>();

            //no gaurantees we can reach first mode so we should initialize our map

            Node ptr2 = new Node(head.val);
            map.put(head,ptr2);

            //then we create another node to iterate list
            Node ptr = head;

            //no we want to iterate the list, for every node we check the next and the random node
            while(ptr != null){
                Node randomNode = ptr.random;
                Node nextNode = ptr.next;

                if(randomNode != null){
                    if(!map.containsKey(randomNode)){
                        //if there is no mapping we create one
                        map.put(randomNode, new Node(randomNode.val));
                    }
                    //no we want to assign ptr2 to random node
                    ptr2.random = map.get(randomNode);
                }
                if(nextNode != null){
                    if(!map.containsKey(nextNode)){
                        //if there is no mapping we create one
                        map.put(nextNode, new Node(nextNode.val));
                    }
                    //no we want to assign ptr2 to random node
                    ptr2.next = map.get(nextNode);
                }
                //just increment pointeres in forward direction
                ptr = ptr.next;
                ptr2 = ptr2.next;
            }

            return map.get(head);

        }





    }
}
