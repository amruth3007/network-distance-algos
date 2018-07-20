import java.io.*;
import java.util.*;
public class Dij
{
 static int graph[][];
 static int via[][];
 static int rt[][];
 static int v;
 static int s;

 public static void main(String args[]) throws IOException
 {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 Scanner in = new Scanner(System.in);
  System.out.println("Please enter the number of Vertices: ");
  v = in.nextInt();
 
  //System.out.println("Please enter the number of Edges: ");
 // e = Integer.parseInt(br.readLine());
  System.out.print("Source: ");
   int s =in.nextInt();
  graph = new int[v][v];
  via = new int[v][v];
  rt = new int[v][v];
  for(int i = 0; i < v; i++)
   for(int j = 0; j < v; j++)
   {
    if(i == j)
     graph[i][j] = 0;
    else
     graph[i][j] = 9999;
   }
 
  for(int i = 0; i < v; i++)
  {
for(int j=0;j<v;j++)
   
   graph[i][j] = in.nextInt();
  
  }
 
  dvr_calc_disp("The Routing Tables are: ");
 
 }
 
 static void dvr_calc_disp(String message)
 {
  System.out.println();
  init_tables();
  update_tables();
  System.out.println(message);
  print_tables();
  System.out.println();
 }
 
 static void update_table(int source)
 {
  for(int i = 0; i < v; i++)
  {
   if(graph[source][i] != 9999)
   {
    int dist = graph[source][i];
    for(int j = 0; j < v; j++)
    {
     int inter_dist = rt[i][j];
     if(via[i][j] == source)
      inter_dist = 9999;
     if(dist + inter_dist < rt[source][j])
     {
      rt[source][j] = dist + inter_dist;
      via[source][j] = i;
     }
    }
   }
  }
 }
 
 static void update_tables()
 {
  int k = 0;
  for(int i = 0; i < 4*v; i++)
  {
   update_table(k);
   k++;
   if(k == v)
    k = 0;
  }
 }
 
 static void init_tables()
 {
  for(int i = 0; i < v; i++)
  {
   for(int j = 0; j < v; j++)
   {
    if(i == j)
    {
     rt[i][j] = 0;
     via[i][j] = i;
    }
    else
    {
     rt[i][j] = 9999;
     via[i][j] = 100;
    }
   }
  }
 }
 
 static void print_tables()
 {
  
   for(int j = 0; j < v; j++)
   {
    System.out.print("Dist: " + rt[s][j] + "    ");
   }
   System.out.println();
  }
 
 
}
