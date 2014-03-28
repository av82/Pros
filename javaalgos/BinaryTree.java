import java.util.Random;

public class BinaryTree{ 
        private Node root ;
   	
	private static class Node { 
	   Node right;
	   Node left; 
	   int data;

	   Node(int newData){
	      left=null;right=null;
	      data=newData;
		}
	}
	public void insert(int ins){
	     root= insertNode(root,ins);
	}
        public Node getRoot(){
	    return root;
	}
	
        private Node  insertNode(Node node, int ins ){ 
	   if(node==null){
	        node = new Node(ins) ;
	   }
	   else{
		if(ins <= node.data)
		  node.left=  insertNode(node.left,ins);
                else node.right = insertNode(node.right,ins);
	    }
	
	    return node;
	}

	public int size(){
	    return (size(root));
	}
	
	private int size(Node node){
	   if(node==null) return(0);
	   else return (size(node.left)+1+size(node.right));
	}
 	
	public int MaxDepth(){
	   return (MaxDepth(root));
	}

	private int MaxDepth(Node node){
	    if(node==null) return(0);
	    else {
		   int ldepth = MaxDepth(node.left);
	  	   int rdepth = MaxDepth(node.right);         
	  	   return(Math.max(ldepth,rdepth)+1);
		}
	}
	public void printTree(){
		  printInfix(root);
		}
		
	private void printInfix(Node node){
		if(node==null){
		   return;
		}
	        
		else{
		     printInfix(node.left);
		     System.out.print(node.data+"\t");
		     printInfix(node.right);
		  }
	}
        public Boolean find(int val){
		   System.out.println("root: "+root.data);
		   if(find(root,val)!=null) return true;
		   else return false;
		}
        private Node find(Node node,int val){ 
                  if(node!=null) {
			if(node.data==val) return node ;
			else {	
				Node tmp =find(node.left,val);
				if(tmp==null){
		                       tmp = find(node.right,val);
					}
				 return tmp;
			      }
		     	    }
			   
		   else return null ;
		}



    public static void main(String args[]){
	     Random rgenerate= new Random();
	     BinaryTree bnode = new BinaryTree();
             int key=0;
	     String checkFind="";
	     for(int i=1;i<=20;i++)
		{
		  int randint = rgenerate.nextInt(100);
                  if(i==4) key = randint;
		  bnode.insert(randint);
		}
	      bnode.printTree();
	      System.out.println("Size of tree: "+ bnode.size());
	      System.out.println("Max depth of tree: "+bnode.MaxDepth());
	      if(bnode.find(key)==true) checkFind=" Exists";
	      else checkFind=" Not found";
	      System.out.println(key+checkFind);
	      if(bnode.find(101)==true) checkFind=" Exists";
	      else checkFind=" Not found";
	      System.out.println("101 "+ checkFind);

	}
}



