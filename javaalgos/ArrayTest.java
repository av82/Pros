import java.io.*;

public class ArrayTest{

	private int[]  theArray = new int[50];
	private int arraySize=10; 
	private int[]  sortedArray = new int[arraySize];
	public void generateRandArray()
		{
			for(int i=0;i<arraySize;i++)
				{ 
				  theArray[i]=(int)(Math.random()*10)+10;
				}
		}
	public void printArray(int[] thisArray)
		{
			for(int i=0;i<arraySize;i++)
 				{
				  System.out.print(" " + thisArray[i]); 
				}	
		}	
        public void bubbleSort()
		{ 
	           for(int i=arraySize-1;i>1;i--)
  			{ 
			   for(int j=0;j<i;j++)
				{
 				  if(theArray[j]>theArray[j+1])
					{
						int temp=theArray[j];
						theArray[j]=theArray[j+1];
						theArray[j+1]=temp;
					}
				}
 			}

  		} 
 	public int binarySearch(int key, int st, int end)
		{ 
                   if(st<=end)
                     {
                     
			     int mid = (st+end)/2;

				if(theArray[mid]==key)
				{
				  return mid;
				}
				    
				else if(key<theArray[mid])
					{
					  return  binarySearch(key,st,mid-1);   
					}
				 else 
				       { 
					 return  binarySearch(key,mid+1,end);
				       } 
                     }
                      else return -1;	     
		}
	       //selection sort is find from beginning the least of all numbers lower than current index and swap 
        public void selectionSort() 
               { 
		   for(int i=0;i<arraySize-1;i++)
		     { 
			int min_index = theArray[i];
                          for(int j=i+1;j<arraySize;j++) 
                               {
                                  if(theArray[j]<theArray[min_index])
                                     { 
				       min_index=j;
				     }                                        
                               }
                          int temp=theArray[i];
                              theArray[i] = theArray[min_index];
                              theArray[min_index] = temp;
                     }     
               }

        // scan through already sorted subarray to find spot for new array item 
        public void insertionSort() 
          	{
		     for(int i=1;i<arraySize;i++) 
			 { 
			   int toInsert= theArray[i]; 
			   int j=i;
                           while(j>0 && theArray[j-1]>toInsert)
                                { 
                                      theArray[j]=theArray[j-1]; 
                                      j--;
                                } 
                            theArray[j]=toInsert;
             		}
                }

	public void MergeSort(int lo, int hi)
		{ 
                    if(hi>lo)
                    {
		    int mid = (hi+lo)/2;
		    MergeSort(lo,mid);
                    MergeSort(mid+1,hi); 
                    Merge(lo,mid,hi);
                    } 
		} 
        public void Merge(int lo , int mid, int hi)
		{ 
                   int lo2= mid+1, index=lo,lo1=lo;
                    while(lo1<=mid && lo2 <=hi) 
                        { 
                           if(theArray[lo1]<=theArray[lo2])
                                  {  
                                    sortedArray[index]= theArray[lo1];
                                    lo1++;
 				  } 
                           else   { 
                                    sortedArray[index]=theArray[lo2];
                                    lo2++;
                                  } 
                             index++; 
                             System.out.println();
                             printArray(sortedArray); 
                        } 
                           
                        if(lo1>mid)
				 {
				   for(int k=lo2;k<=hi;k++)
                                          { 
                                 	   sortedArray[index]=theArray[k];
                                           index++;
                                          } 
   	       			 } 
                         else { 
                                  for(int k=lo1; k<=mid;k++)
                                          {  
 					     sortedArray[index] = theArray[k];
					     index++;
 					  } 
			      }
 
		         for( int k=lo;k<=hi;k++) theArray[k]=sortedArray[k]; 
		}
        public void QuickSort(int[] inAry,int lo,int hi)
		{ 
		  int pindex = Partition(inAry,lo,hi);
		   System.out.println("super outside--- lo: "+lo+", hi: "+hi);
		  if(lo<pindex-1)
			 QuickSort(inAry,lo, pindex-1); 
		   if(pindex<hi)
			 QuickSort(inAry,pindex,hi);
		}
	public int Partition(int[] inAry,int lo,int  hi)
		{
		   int i=lo, j=hi; 
                   int tmp;  
                   int pivot =inAry[(lo + hi)/2]; 
		   System.out.println("outside--- lo: "+lo+", hi: "+hi+", arval: " + pivot);
		   while(i<=j)
                     {
                   while(inAry[i]<pivot)
		    { 
	          	System.out.println("inside--- lo: "+lo+", hi: "+hi+", arval: " + pivot); 
                      i++; 
		    } 
		   while(inAry[j]>pivot)
			 {j--; }
                    
                   if(i<=j)
			{ 
			tmp=inAry[i];
			inAry[i]=inAry[j];
			inAry[j]=tmp;
			i++;
			j--; 
 			}
                     } 
		
		    return i;
		} 

int partition(int arr[], int left, int right)
{
      int i = left, j = right;
      int tmp;
      int pivot = arr[(left + right) / 2];
     
      while (i <= j) {
            while (arr[i] < pivot)
                  i++;
            while (arr[j] > pivot)
                  j--;
            if (i <= j) {
                  tmp = arr[i];
                  arr[i] = arr[j];
                  arr[j] = tmp;
                  i++;
                  j--;
            }
      };
     
      return i;
}
 
void quickSort(int arr[], int left, int right) {
      int index = partition(arr, left, right);
      if (left < index - 1)
            quickSort(arr, left, index - 1);
      if (index < right)
            quickSort(arr, index, right);
}
	public static void main(String[] args)
		{
 		    ArrayTest art= new ArrayTest();
                    art.generateRandArray();
		    art.printArray(art.theArray);
                   // System.out.println("The Sorted Array is :");
               	   // art.bubbleSort();  
                   //art.insertionSort();
                    System.out.println("The Un-sorted Array is :");
		    art.printArray(art.theArray);
                    //art.MergeSort(0,art.arraySize-1);
                    art.QuickSort(art.theArray,0,art.arraySize-1);
                    System.out.println("The Sorted Array is :");
         	    art.printArray(art.theArray);
                   // int x = art.binarySearch(art.theArray[0],0,art.arraySize-1);
                    //System.out.println("Number  found at: " + x);
		}

}

