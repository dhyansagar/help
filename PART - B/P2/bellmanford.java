/*
PART-B: Program - 2
Write a program to find the shortest path using bellman-ford Algorithm.
*/
import java.util.Scanner;

public class bellmanford 
{
    private int D[];
    private int n;
    public static final int MAX_VALUE=999;

    public bellmanford(int n)
    {
    	this.n=n;
    	D=new int[n+1];
    }

    public void bellmanfordEvaluation(int source,int A[][])
    {
    	for(int node=1;node<=n;node++)
    	{
    		D[node]=MAX_VALUE;
    	}
    	D[source]=0;
    	for(int node=1;node<=n;node++)
    	{
    		for(int i=1;i<=n;i++)
    		{
    			for(int j=1;j<=n;j++)
    			{
    				if(A[i][j]!=MAX_VALUE)
    				{
    					if(D[j]>D[i]+A[i][j])
    						D[j]=D[i]+A[i][j];
    				}
    			}
    		}
    	}
    	for(int vertex=1;vertex<=n;vertex++)
       	{
       		System.out.println(" Distance of source "+ source +" to "+vertex+" is "+D[vertex]);
       	}
    }
    
    public static void main(String[]args)
    {
    	int n=0;
    	int source;
    	Scanner Scanner=new Scanner(System.in);
    	System.out.print("Enter the number of vertices:");
    	n=Scanner.nextInt();
    	int A[][]=new int[n+1][n+1];
    	System.out.println("Enter the adjacency matrix");
    	for(int i=1;i<=n;i++)
    	{
    		for(int j=1;j<=n;j++)
    		{
    			A[i][j]=Scanner.nextInt();
    			if(i==j)
    			{
    				A[i][j]=0;
    				continue;
    			}
    			if(A[i][j]==0)
    			{
    				A[i][j]=MAX_VALUE;
    			}
    		}
    	}
    	System.out.println("Enter the source vertex:");
    	source=Scanner.nextInt();
    	bellmanford b=new bellmanford(n);
    	b.bellmanfordEvaluation(source, A);
    	Scanner.close();
    }
}
			
