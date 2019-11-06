import java.util.Scanner;
public class P1_crc
{
public static int a[]=new int [100];
public static int b[]=new int [100],i,j,len,k,count=0;
public static int gp[]= {1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1};
public static void div()
{
for(i=0; i<k; i++)
{
if(a[i]==gp[0])
{
for(j=i; j<17+i; j++)
a[j]=a[j]^gp[count++];
}
count=0;
}
}
public static void main(String[] args)
{
int ch=0;
Scanner input = new Scanner(System.in);
System.out.print("\nenter the length of data frame:");
len = input.nextInt();
System.out.print("\nenter the message:");
for(i=0; i<len; i++)
a[i]=input.nextInt();
for(i=0; i<16; i++)
a[len++]=0;
for(i=0; i<len; i++)
b[i]=a[i];
k=len-16;
div();
for(i=0; i<len; i++)
b[i]=b[i]^a[i];
System.out.print("\nData to be transmitted:");
for(i=0; i<len; i++)
System.out.print(b[i]+" ");
System.out.print("\n\nEnter the recieved data:");
for(i=0; i<len; i++)
a[i] = input.nextInt();
div();
for(i=0; i<len; i++)
if(a[i]!=0)
{
System.out.println("\n\nERROR in recieved data. . . ");
System.out.println("\nERROR is in "+(i+1)+"th bit");
System.out.print("\nRemainder is:");
for(i=(len-16); i<len; i++)
System.out.print(a[i]+" ");
System.out.println("\n");
ch=1;
}
if(ch==0)
System.out.println("\nData Recived is ERROR FREE. . .");
}
}