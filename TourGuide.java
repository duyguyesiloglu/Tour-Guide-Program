import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class TourGuide {
	
    public static void main(String[] args) {
    	
        Scanner dyg = new Scanner(System.in);
        int islandCount = dyg.nextInt();
        int roadCount = dyg.nextInt();
        manage(islandCount,roadCount,dyg);
    }


    public static void manage(int iCount,int rCount,Scanner dyg){
        int[][] adjList = new int[iCount][rCount];
        boolean[] visited = new boolean[iCount];
        int[] path;
        int[] distance = new int[iCount];
        int[] parent = new int[iCount];
        int[] roadPerCity = new int[iCount];
        int c1,c2,start,target,current,newest;
        for (int i = 0; i < rCount; i++) {
            c1 = dyg.nextInt()-1;
            c2 = dyg.nextInt()-1;
            adjList[c1][roadPerCity[c1]] = c2;
            adjList[c2][roadPerCity[c2]] = c1;
            roadPerCity[c2] =  roadPerCity[c2] + 1;
            roadPerCity[c1] = roadPerCity[c1] + 1;
        }
          /*for (int i = 0; i < iCount; i++) {
            for (int j = 0; j < rCount; j++) {
                if(j < roadPerCity[i])
                    System.out.print(adjList[i][j] + " ");
            }
            System.out.println();
        }*/
        start = dyg.nextInt()-1;
        target = dyg.nextInt()-1;
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(start);
        
        parent[start] = -1;
        
        distance[start] = 1;

        while(!queue.isEmpty()){
            current = queue.poll();
            
            if(visited[current] == false)
                System.out.print(current+1 + " ");
            visited[current] = true;

            if(current == target){
                return;
            }
            for (int i = 0; i < roadPerCity[current]; i++) {
                newest = adjList[current][i];
                if(!visited[newest]){
                    queue.add(newest);
                    distance[newest] = distance[current]+1;
                    parent[newest] = current;
                }
            }
        }
    }
}



