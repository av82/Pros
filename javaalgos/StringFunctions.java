import java.io.*;
import java.util.*; 



class StringFunctions{ 

        private String inputString; 

        public String getString(){
	    return this.inputString;
	   }
	public void setString(String input){ 
	    this.inputString=input;
	   }
	 
        public static String getLargestPalindrome(String inputString)
 		{ 
			Stack<Character> inStack= new Stack<Character>(); 
 			for(int i=0;i<inputString.length();i++)
			     { 
 				inStack.push(inputString.charAt(i));
			     }
                         return "test";
                } 
      	public void printCombinations(int[] bitmap ,int k , int n)
		{
		      if (k==n)
			 {
			    bitmap[k]=0;
			    printComb(bitmap,n);
			    bitmap[k]=1;
			    printComb(bitmap,n);  
			    return;
			 }
                        bitmap[k]=0;
                        printCombinations(bitmap,k+1,n);
 			bitmap[k]=1;
			printCombinations(bitmap,k+1,n);
		}
        public void printComb(int[] bmap, int n )
		{
 		     int sum=0; 
		     for(int i=0;i<=n;i++)
			{
 			  if(bmap[i]==1)
			      {	System.out.print(inputString.charAt(i));}
			    sum++;
			}
                     if(sum==0) System.out.println("null string"); 
		     else System.out.println(); 
		}
	public void LCS(String s1,String s2)
		{ 
		    int M=s1.length(),N= s2.length(); 
		    int[][] table = new int[M+1][N+1]; 
 		 
                     for(int i=M-1;i>=0;i--){ 
			     for(int j=N-1;j>=0;j--){
				  if(s1.charAt(i)== s2.charAt(j))
					table[i][j]=table[i+1][j+1]+1; 
				   else	
					table[i][j]=Math.max(table[i+1][j],table[i][j+1]);
				}
			}
 
			int i =0,j=0; 

			while(i<M && j<N)
				{ 
				   if(s1.charAt(i)== s2.charAt(j))
					{
					  System.out.print(s1.charAt(i));  
					  i++;
					  j++; 
					}
                                   else if (table[i+1][j]>=table[i][j+1]) i++; 
                                   else  j++;
				}
		
 	 
		} 	

	public static boolean doesitHaveallChars(String s1, String s2) 
		 { 
			Stack<Character> stk = new Stack<Character>();
			for(int i=0; i<s1.length();i++){ 
 			    stk.push(s1.charAt(i));
			}
 		
			int i=s2.length()-1;	
			while(i>=0){			
			   if(stk.pop()==s2.charAt(i))
				{
					System.out.println(s2.charAt(i)+", "+i);
					i--;
                            	 }  
			}
                        return i<0;
		}
        public static void printpermute(char[] input,int k)
		{
	             if(k==input.length-1)	
			{
			  for(int i=0;i<input.length;i++)
				{
				   System.out.print(input[i]);
				}
			  System.out.println();
			}
		     for(int i=k;i<input.length;i++)
			{
			      char tmp =input[k];input[k]=input[i];input[i]=tmp;
			      printpermute(input,k+1);
			      tmp =input[k];input[k]=input[i];input[i]=tmp;
			}
		  
		}
	public static void main(String[] args)
        	{
		    String s1="forgeeksskeegfor";
		    StringBuffer sbf = new StringBuffer(s1);
		    String s2 =sbf.reverse().toString();
		    StringFunctions sf = new StringFunctions(); 
		    sf.setString("test");
		    System.out.println(sf.inputString);
                    int[] bmap = new int[sf.inputString.length()];
		    sf.printCombinations(bmap,0,bmap.length-1);
		    System.out.print("The lcs of : "+s1+"and "+s1+"is: "); 
		    sf.LCS(s1,s2);
                    System.out.println();
		    System.out.print("Checking if s1 contains s2"); 
                    System.out.println(sf.doesitHaveallChars("test","ts"));
		    String s3 = "abc"; 
		    char[] perm = s3.toCharArray();
		    StringFunctions.printpermute(perm,0);
	        }

}
