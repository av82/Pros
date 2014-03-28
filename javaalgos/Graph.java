import java.io.*;
import java.util.*;

public class Graph{
	private final int Vsize; //number of vertices
	private int Esize;
        SortedSet<E> Eset;	
	Set<E> Mst;
	Map<V,ArrayList<E>> Gmap;
	Map<V,Boolean> Visited;
	Map<V,V> parentMap; 
        Map<V,Integer> sizeofSet;
	
	public Graph(String file) throws FileNotFoundException,IOException { 
		 BufferedReader br = new BufferedReader(new FileReader(file));
		 this.Vsize=Integer.parseInt(br.readLine());
		 this.Esize=Integer.parseInt(br.readLine());
		 System.out.println("Vsize= "+this.Vsize+" and Esize= " +this.Esize);
		 String current=null;
		 Gmap= new HashMap<V,ArrayList<E>>();
		 Eset = new TreeSet<E>();
		 Mst = new TreeSet<E>();
		 Visited = new HashMap<V,Boolean>();
		 parentMap= new HashMap<V,V>();
		 sizeofSet = new HashMap<V,Integer>();
		 while((current=br.readLine())!=null){ 
			int u=Integer.parseInt(current.trim().split(" ")[0].trim()); //source
			int v=Integer.parseInt(current.trim().split(" ")[1].trim()); //destination	
			int w=Integer.parseInt(current.trim().split(" ")[2].trim());
		        V  c= new V(u);
			V  n = new V(v);
		        parentMap.put(c,c);
			parentMap.put(n,n);
			sizeofSet.put(c,1);
			sizeofSet.put(n,1);
	
			Visited.put(c,false);
			Visited.put(n,false);
			c.u=u;
			if(Gmap.get(c)==null)
				{
				   Gmap.put(c,new ArrayList<E>());
				   Gmap.get(c).add(addEdge(c,new V(v),0));
				   if(Gmap.get(new V(v))==null)Gmap.put(new V(v),new ArrayList<E>());
				}
			else{ 
		        	    Gmap.get(c).add(addEdge(c,new V(v),0));
				   if(Gmap.get(new V(v))==null)Gmap.put(new V(v),new ArrayList<E>());
			    } 
			   
		        Eset.add(new E(new V(u),new V(v),w))    ;
		     
		 }
		 
		 
	} 
	
	public E addEdge(V s,V v, int w ) { 
		if(v.u<0 || s.u<0)  throw new IndexOutOfBoundsException();
		else return new E(s,v,w);
		
	} 
	public void printGraph(){ 
		for(V k: Gmap.keySet()){ 
			System.out.print(k.u);
			if(Gmap.get(k)!=null){
			    
			    for(E e:Gmap.get(k)){ 
				  System.out.print(" -- " + e.v.u);
				}  
			System.out.println();
			}
		}
		
	       System.out.println("Visited values");	
	       for(V v: Visited.keySet()){ 
			System.out.println(v.u + ": " + Visited.get(v).toString());
		}
	}
	public V getUnvisitedChild(V c){
			int i=0;
			while(i<Gmap.get(c).size()){
				if(Visited.get(Gmap.get(c).get(i).v)==false){
				    return Gmap.get(c).get(i).v;
				}
					i++;
				}
			return null;
		}
	public void DFS1(V node){ 
		Stack<V> s = new Stack<V>();
		Visited.put(node,true);
		s.push(node);
		System.out.println("starting at " + node.u);
		if(Gmap.get(node).size()<0){System.out.println("size less"); return;}
               	V cur;	
		while(!s.isEmpty()){
		       cur = s.peek(); 
		       V child = getUnvisitedChild(cur);
		       if(child!=null){ 
				     Visited.put(child,true);
				     System.out.println(child.u);
				     s.push(child);
                 	 }
 		       	else{ 
				 s.pop();
			    }	
		      }
	}  

	public void dfsrec(V node){
		  Visited.put(node,true);
		   System.out.print(node.u+",");
	              for(E e: Gmap.get(node.u)){
			   if(Visited.get(e.v)){
				dfsrec(e.v);
			      }

			}
	}
 	public void BFS(V node){
	          Queue<V> bq = new LinkedList<V>(); 
		  Visited.put(node,true);
		  bq.add(node);
		  System.out.println("starting bfs at:"+ node.u);
		  V child=null;
		  if(Gmap.get(node).size()>0){
		   while(!bq.isEmpty()){
			V v = (V)bq.remove();
			while((child=getUnvisitedChild(v))!=null){
				 Visited.put(child,true);
				 bq.add(child);
				 System.out.println(child.u);
		           }
			}
		     }
		  }
        
	public void clearNodes(){ 
	    for(V v : Visited.keySet()){
		 Visited.put(v,false);
	    }
	}
        public void printEdges(){ 
		for(E e:Eset){ 
		System.out.println(e.u.u+"--"+e.w+"--"+e.v.u);

		}
	}	
	public void KruskallMst(){ 
		for(E e: Eset ){
		    V x = Find(e.u);
		    V y = Find(e.v);
		    System.out.println(e.u.u+" root--"+ x.u +", " + e.v.u+" root--"+y.u);
		    if(x!=y){
			Mst.add(e);
		        Union(x,y);
			}
		}
	     for(E e: Mst){
		  System.out.println(e.u.u+"--"+e.w+"--"+e.v.u);
		}
	}

	public V Find(V v){
	    if(parentMap.get(v)==v){ 
	    	return v;
	      }
            else {
		   parentMap.put(v,parentMap.get(v)); //set this nodes parent to its grand parent 
		    return Find(parentMap.get(v));
		}
	}
	public void  Union(V s1, V s2){
		if(sizeofSet.get(s1)>sizeofSet.get(s2)){
			sizeofSet.put(s1,sizeofSet.get(s1)+sizeofSet.get(s2));
			parentMap.put(s2,s1);
		 }
		else {
			sizeofSet.put(s2,sizeofSet.get(s1)+sizeofSet.get(s2));
			parentMap.put(s1,s2);
		     }
	}

	
	public static void main(String args[]) throws IOException{
		 if(args[0]==null) System.out.println("no file given");

		 else {
	  	 	Graph graph = new Graph(args[0]);
			graph.printGraph();
			System.out.println("dfs");
			graph.DFS1(new V(0));
			graph.clearNodes();
			graph.BFS(new V(0));
		//	graph.dfsrec(new V(0));
			graph.printEdges();
			System.out.println("printing MST");
			graph.KruskallMst();

        	      }
	} 

	
}

class V{ 
     public int u; 
     public V prnt;
     public V(int u){ 
	    this.u=u;
	    this.prnt=this;
	 }
@Override
 public int hashCode()
 {
	 int hash=7;
	 hash=31*hash+u;
	 return hash;
 }
@Override
 public boolean equals(Object o) {
    if (o == null)
       return false;
    if (o == this)
       return true;
    if (o.getClass() != getClass())
       return false;
     V e = (V) o;
       return u==e.u;
    }
} 

class E implements Comparable<E>{
        public V u;
        public V v; //to represent u->v
	public int w; //weight
	public E(V u, V v, int w){ 
		this.u=u;
	        this.v=v;
		this.w=w;
	} 
	
	@Override
	public int compareTo(E other){
		if(this.w < other.w){
		    return -1;
		 }
		else if(this.w > other.w){ 
		    return 1;
		}
		else return 0;
	}
}

