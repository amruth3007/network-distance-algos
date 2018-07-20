import java.io.*;
import java.util.*;
public class Dvr
{
static int graph[][];
static int rt[][];
static int via[][];
static int v;
static int s;


public static void main(String[] args)
{

Scanner in=new Scanner(System.in);
System.out.println("Enter no. of vertices:");
v=in.nextInt();
graph=new int[v][v];
rt=new int[v][v];
via=new int[v][v];



System.out.println("Enter source:");
s=in.nextInt();
System.out.println("Enter matrix:");
for(int i = 0;i < v;i++)
{
for(int j = 0;j < v;j++)
{
graph[i][j]=in.nextInt();

}
}
calc("The routing distances are");
}

static void calc(String msg)
{
System.out.println();
init_table();
update_table();
printTable();

}

static void init_table()
{
for(int i=0;i<v;i++)
{
for(int j=0;j<v;j++)
{
if(i==j)
{
rt[i][j]=0;
via[i][j]=i;
}
else
{
rt[i][j]=999;
via[i][j]=100;
}
}
}
}

static void update_table()
{
int k=0;
for(int i=0;i< 4*v;i++)
{
update_tables(k);
k++;
if(k==v)
{
k=0;
}
}
}
static void update_tables(int source)
{
for(int i=0;i<v;i++)
{
if(graph[source][i] != 999)
{
int dist=graph[source][i];
for(int j=0;j<v;j++)
{
int inter_dist=rt[i][j];
if(via[i][j]==source)
{

inter_dist=999;
}
if(dist+inter_dist < rt[source][j]){
rt[source][j]=dist+inter_dist;
}


}
}
}
}

static void printTable()
{

for(int i=0;i<v;i++)
{
for(int j=0;j<v;j++)
{

System.out.println("Dist:"+rt[i][j]);

}
}
}


}



