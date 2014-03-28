import java.io.*;
import java.util.Random;

public class HeapSort{
	public static int heapsize;

	public HeapSort(){
		
	}

	public void sort(int[] array){ 
	    int len = array.length-1;
	    heapsize=len;
	    buildHeap(array);
	    
	    System.out.println("Heap array");
	    printArray(array);
	    System.out.println("len: "+len);
	      	while(heapsize>0){
		swap(array,0,heapsize);
	        System.out.print(heapsize+"\t");
	        heapsize --;	
		heapify(array,0); 
	        printArray(array);
                System.out.println();	
		}
	     printArray(array);	
	    
	}
	
	public void swap(int[] array,int index, int largest){
	
	    System.out.println("Swapping"+array[index]+" and "+array[largest]);

 		       int temp = array[index];
                       array[index]=array[largest];
                       array[largest]=temp;
	//System.out.println("Swapped"+array[index]+" and "+array[largest]);
	 }
	
	//maintain the heap property where parent is >= children
	public void heapify(int[] array, int index){
		int l=2*index+1;
		int r=2*index+2;
		int largest;
		if(l<=heapsize && array[l]>array[index]){
		     largest= l;
		}
                else largest= index;
		
		if(r<=heapsize  && array[r]>array[largest]){
		     largest = r;
		}
	  
		if(largest!=index){
			swap(array,index,largest);
		   	heapify(array,largest);
		}
	   }
	
	//for given array build heap using heapify
	public void buildHeap(int[] array){
                int len = array.length-1; 
		for(int i=(int)Math.floor(len/2);i>=0;i--)
		  {	
	 	    heapify(array,i);
		}
	}

	public void printArray(int[] inputArray){
		for(int i=0;i<inputArray.length;i++){ 
		    System.out.print(" "+inputArray[i]);
		}
	}


	public static void main(String args[]){
		
	    int[] array = new int[11];
	     Random rno  = new Random();
	    for(int i=0;i<array.length-1;i++){
		array[i] = rno.nextInt(100);
	     }
	     System.out.println("Unsorted input array");
	     HeapSort hs = new HeapSort();
	     hs.printArray(array);	
	     System.out.println("Sorted Array");
	     hs.sort(array);
	     
             

	  
	}

}
