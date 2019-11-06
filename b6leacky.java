import java.util.Random;
import java.io.*;
import java.util.Scanner;
class lb
{
static int t_rand(int n)
{
int rn;
Random r=new Random();
rn=r.nextInt(50);
return rn;
}
public static void main(String args[])
{
int a[]=new int[5];
int buck_rem=0,buck_cap=0,rate=0,i,sent,recieve;
System.out.println("Enter the bucket capacity");
Scanner in=new Scanner(System.in);
buck_cap=in.nextInt();
System.out.println("Enter the rate of transmission");
Scanner input=new Scanner(System.in);
rate=input.nextInt();
for(i=0;i<5;i++)
a[i]=t_rand(6);
System.out.println("CLOCK PACKET_SIZE RECEIVED SENT REMAINING");
for(i=0;i<5;i++)
{
if(a[i]!=0)
{
if((buck_rem+a[i])>buck_cap)
recieve=-1;
else
{
recieve=a[i];
buck_rem=buck_rem+a[i];
}
}
else
recieve=0;
if(buck_rem!=0)
{
if(buck_rem<rate)
{
sent=buck_rem;
buck_rem=0;
}
else
{
sent=rate;
buck_rem=buck_rem-rate;
}
}
else
sent=0;
if(recieve==-1)
System.out.println(i+"\t"+a[i]+"\t[dropped]"+sent+"\t"+buck_rem);
else
System.out.println(i+"\t"+a[i]+"\t"+recieve+"\t"+sent+"\t"+buck_rem);
}
}
}