import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SwapNodes {
    
    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        int N = sn.nextInt();
        
        // Binary Tree creation logic.
        Queue<Integer> queueOfNodes = new LinkedList<Integer>();
        
        Node root = new Node(1);
        queueOfNodes.add(1);
        Node nextNode = root;
        boolean isLeftTurn = true;
        boolean isRightTurn = false;
        
        if(N >=1 && N <= 1024){
            
            while(!queueOfNodes.isEmpty()){
                
               int currRoot = queueOfNodes.poll();
            	
                //if(root == null)
                  //  root = nextNode;
                // for every pair of numbers, create new nodes and every pair becomes children of i-th node. 
                int lChild = sn.nextInt();
                int rChild = sn.nextInt();
                
                if(lChild != -1){
                Node left = new Node(lChild);
                nextNode.left = left;
                queueOfNodes.add(lChild);
                }
                
                if(rChild != -1){
                Node right = new Node(rChild);
                nextNode.right = right;
                queueOfNodes.add(rChild);
                }
                
            if(isLeftTurn){
            	if(nextNode.left != null)
            	   nextNode = nextNode.left;
            	isLeftTurn = false;
            	isRightTurn = true;
            } else if(isRightTurn){
            	if(nextNode.right != null)
                	nextNode = nextNode.right;
                	isRightTurn = false;
                	isLeftTurn = true;
                }
            }
        }
        
        // Print the tree
        inOrder(root);
        
        // Assign the depth for each node.
        Node temp = root;
        while(temp != null){
            
            int level = getNodeDepth(root, temp, 1);
            temp.depth = level;
            temp = temp.left != null? temp.left : temp.right;
            
        }
        
        // Get the map of nodes
       Map<Integer, ArrayList<Node>> mapOfNodes = new HashMap<Integer, ArrayList<Node>>();
       Map<Integer, ArrayList<Node>> mapOfLevelAndNodes = populateDepthMap(root, mapOfNodes);
        
       for(int i: mapOfLevelAndNodes.keySet()){
    	   System.out.println();
       System.out.print( i + " --> ");
       for(Node j : mapOfLevelAndNodes.get(i)){
    	   System.out.print(j.data + " "+"("+j.depth+")");
       }
       System.out.println();
       }
       
        // Get the K value from user
        
        int T = sn.nextInt();
        
        while(T != 0){
            
            int K = sn.nextInt();
            
            for(int i:mapOfLevelAndNodes.keySet()){
                
                if(i % K == 0){
                    
                    ArrayList<Node> listOfNodes = mapOfLevelAndNodes.get(i);
                    
                    for(Node n: listOfNodes){
                        
                        // swap the children. 
                        Node t = n.left;
                        n.left = n.right;
                        n.right = t;
                    }
                }
            }
            
            // print the tree
            inOrder(root);
            System.out.println();
            
            T--;
            
        }
        
        
        sn.close();
    }
    
   
    static Map<Integer, ArrayList<Node>> populateDepthMap(Node root, Map<Integer, ArrayList<Node>> mapOfNodes){
        
        if(root == null)
            return mapOfNodes;
        
        mapOfNodes = populateDepthMap(root.left, mapOfNodes);
        
        //visit node
        if(mapOfNodes.containsKey(root.depth)){
            ArrayList<Node> listOfNodes = mapOfNodes.get(root.depth);
            listOfNodes.add(root);
            mapOfNodes.put(root.depth, listOfNodes);
        }else{
            ArrayList<Node> listOfNodes = new ArrayList<Node>();
            listOfNodes.add(root);
            mapOfNodes.put(root.depth, listOfNodes);
        }
        
        mapOfNodes = populateDepthMap(root.right, mapOfNodes);
        
        return mapOfNodes;
    }
    
    // In-Order traversal
    static void inOrder(Node root){
        
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
        
    // Calculate depth of every node in the tree. 
      static int getNodeDepth(Node node, Node x, int level){
            
            if(node == null)
                return 0;
            if(node.data == x.data)
                return level;
            
            int downLevel = getNodeDepth(node.left, x, level+1);
            
            if(downLevel != 0)
                return downLevel; 
            
            downLevel = getNodeDepth(node.right, x, level+1);
            return downLevel;
        }
    
}

class Node{
        int data;
        Node left;
        Node right;
        int depth;
        
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
            depth = 0;
        }
    }