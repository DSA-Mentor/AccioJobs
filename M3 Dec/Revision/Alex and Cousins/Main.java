import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Main {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            Node currNode = queue.peek();
            queue.remove();
                
            String currVal = ip[i];
                
            if(!currVal.equals("N")) {
                    
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
                
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            if(!currVal.equals("N")) {
                    
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
            while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
        	    String X = br.readLine();
        	    String arr[] = X.split(" ");
        	    int x , y;
			    x = Integer.parseInt(arr[0]);
			    y = Integer.parseInt(arr[1]);
			    if(g.isCousins(root,x,y))
			        System.out.println(1);
			     else
			        System.out.println(0);
                t--;
            
        }
    }
  
}

class Solution {

    public boolean isCousins(Node root, int x, int y) {
        //Write code here
        Node parX = null;
        Node parY = null;

        int dX = -1;
        int dY = -1;

        if (root == null) {
            return false;
        }

        Queue<Node> que = new ArrayDeque<>();

        que.add(root);

        int level = 0;

        while (que.size() != 0) {
            int size = que.size();

            while (size-->0) {
                Node rnode = que.remove();

                if (rnode.left != null) {
                    if (rnode.left.data == x) {
                        parX = rnode;
                        dX = level + 1;
                    }

                    if (rnode.left.data == y) {
                        parY = rnode;
                        dY = level + 1;
                    }

                    que.add(rnode.left);
                }

                if (rnode.right != null) {
                    if (rnode.right.data == x) {
                        parX = rnode;
                        dX = level + 1;
                    }

                    if (rnode.right.data == y) {
                        parY = rnode;
                        dY = level + 1;
                    }

                    que.add(rnode.right);
                }
            }
            
            level++;
        }

        if (parX != parY && dX == dY) {
            return true;
        } else {
            return false;
        }
    }
}