
import java.io.IOException;
import java.util.Scanner;
 
class FractionalGreedy 
{  
    public static void main(String args[]) throws IOException  
    {  
    	Scanner sc = new Scanner(System.in);
        int i,j=0,max_qty,m,n, object;  
        float sum=0,max; 
        System.out.print("Enter number of categories: ");  
        n=sc.nextInt(); 
      
        
        System.out.print("Enter maximum capacity of the Evacuation Center: ");  
        max_qty=sc.nextInt();  
        
        //input category 
        String[] category = new String[n];
        for(i=0; i<n; i++) {
        System.out.print("Category "+ (i+1)+ ":");
        category[i] = sc.next();
        }
        int array[][]=new int[2][20]; 
        System.out.println("Enter the number of victims for each categories");
        for(i=0;i<n;i++)  
            array[0][i]=sc.nextInt();    
 
        System.out.println("Enter the priorities of each categories");
        for(i=0;i<n;i++)  
            array[1][i]=sc.nextInt(); 
 
        
        // Print Data
        System.out.println("");
		System.out.println("\t\t\t-------------------");
		System.out.println("\t\t\t------DataSet------");
		System.out.print("\t\t\t-------------------");
		System.out.println("");
        
        System.out.print("Categories");
		for (i = 0; i < category.length; i++) {
			System.out.print( "\t"+ category[i] + "\t" );
		}
		System.out.println();
		System.out.print("Categories No");
		for (i = 0; i < category.length; i++) {
			System.out.print( "\t"+ (i+1) + "\t" );
		}
		System.out.println();
		System.out.print("No. of Victims ");
		for (i = 0; i < n; i++) {
			System.out.print("\t"+ array[0][i] + "\t");
		}
		System.out.println();
		System.out.print("Priority       ");
		for (i = 0; i < n; i++) {
			System.out.print("\t"+array[1][i] + "\t");
		}
		System.out.println();
		
		 System.out.print("Ratio(P/V) ");
	        for(i=0;i<n;i++) {
	        	
	        	System.out.print("\t"+String.format("%.4f", ((float)array[1][i])/((float)array[0][i]))+"\t");
	        	
	        }
	        
	     // Print Solution
	        System.out.println("");
			System.out.println("\t\t\t-------------------");
			System.out.println("\t\t\t-----Solution------");
			System.out.print("\t\t\t-------------------");
			System.out.println("");
        m=max_qty;  
        while(m>=0)  
        {  
            max=0;  
            for(i=0;i<n;i++)  
            {  
                if(((float)array[1][i])/((float)array[0][i])>max)  
                {  
                    max=((float)array[1][i])/((float)array[0][i]);  
                    j=i;  
                }  
            }  
            if(array[0][j]>m)  
            {  
                System.out.println(m + " flood victims from category " +  (j+1) + " will be placed at the evacuation center");  
                sum+=m*max;  
                m=-1;  
            }  
            else  
            {  
                System.out.println(array[0][j]+ " flood victims from category " +  (j+1) + " will be placed at the evacuation center" );  
                m-=array[0][j];  
                sum+=(float)array[1][j];  
                array[1][j]=0;  
            }  
        }  
        System.out.println("The total priority is " + sum);
        sc.close();
    }  
}