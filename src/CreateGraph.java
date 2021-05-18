import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CreateGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int v = 5;
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < v; i++)
			list.add(new ArrayList<Integer>());

		addEdge(list, 0, 2);
		addEdge(list, 0, 3);
		addEdge(list, 2, 3);
		addEdge(list, 1, 3);
		addEdge(list, 1, 4);
		/*
		 * addEdge(list, 1, 3); addEdge(list, 2, 3);
		 */
		// addEdge(list, 3, 3);

		HashMap<Integer, Integer> degree = printGraph(list);
		topologicalSort(list, v, degree);

		/*
		 * boolean[] visited = new boolean[v];
		 * 
		 * for(int i=0;i<v;i++) { if(visited[i]==false) {
		 * if(findCycleInGraph(list,i,visited,-1)) { System.out.println("Cycle "); } } }
		 */

		/*
		 * for (int i = 0; i < v; i++) { if(visited[i]==false)
		 */
		// shortestPath(list, 0, visited);
		// }
		/*
		 * for (int i = 0; i < v; i++) { if (visited[i] == false) { //bfs(list, i,
		 * visited); dfs(list,i,visited); } }
		 */

	}

	private static void topologicalSort(ArrayList<ArrayList<Integer>> list, int v, HashMap<Integer, Integer> degree) {
		// TODO Auto-generated method stub

		Queue<Integer> queue = new LinkedList<Integer>();
		for(Map.Entry<Integer, Integer> m : degree.entrySet())
		{
			if(m.getValue()==0)
				
			{
				queue.add(m.getKey());
				System.out.println(m.getKey());
			}
				
		}
		while(queue.isEmpty()==false)
		{
			int data= queue.poll();
			System.out.println(data);
			for(int data1:list.get(data))
			{
				degree.put(data1,degree.get(data1)-1);
				if(degree.get(data1)==0)
					queue.add(data1);
			}
		}
		
		
	}

	private static boolean findCycleInGraph(ArrayList<ArrayList<Integer>> list, int i, boolean[] visited, int parent) {
		// TODO Auto-generated method stub
		visited[i] = true;
		ArrayList<Integer> datalist = list.get(i);
		System.out.println("data-----------" + i);
		for (int data : datalist) {
			if (visited[data] == false) {
				if (findCycleInGraph(list, data, visited, i) == true)
					return true;
				else if (i != data)
					return true;
			}
		}
		return false;

	}

	private static void shortestPath(ArrayList<ArrayList<Integer>> list, int i, boolean[] visited) {
		// TODO Auto-generated method stub
		int[] distance = new int[list.size()];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(i);
		visited[i] = true;
		while (queue.isEmpty() == false) {
			int data = queue.poll();
			System.out.println("data--------" + data);
			for (int data1 : list.get(data)) {
				if (visited[data1] == false) {
					distance[data1] = distance[data] + 1;
					visited[data1] = true;
					queue.add(data1);
				}

			}
		}

		for (int j = 0; j < distance.length; j++)
			System.out.println(distance[j]);

	}

	private static void dfs(ArrayList<ArrayList<Integer>> list, int i, boolean[] visited) {
		// TODO Auto-generated method stub
		visited[i] = true;
		ArrayList<Integer> datalist = list.get(i);
		System.out.println("data-----------" + i);
		for (int data : datalist) {
			if (visited[data] == false) {
				visited[data] = true;
				dfs(list, data, visited);
			}

		}

	}

	private static void bfs(ArrayList<ArrayList<Integer>> list, int i, boolean[] visited) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(i);
		visited[i] = true;
		while (queue.isEmpty() == false) {
			int data = queue.poll();
			System.out.println("data--------" + data);
			for (int data1 : list.get(data)) {
				if (visited[data1] = false) {
					visited[data1] = true;
					queue.add(data1);
				}

			}
		}

	}

	private static HashMap<Integer, Integer> printGraph(ArrayList<ArrayList<Integer>> list) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < list.size(); i++) {
			//System.out.println("list ith element--------" + i);
			int count = 0;
			if(map.get(i)==null)
				map.put(i,0);
			for (int j = 0; j < list.get(i).size(); j++) {
				
			if(map.containsKey(list.get(i).get(j)))
			{
				map.put(list.get(i).get(j),map.get(list.get(i).get(j))+1);
			}else
			{
				map.put(list.get(i).get(j),1);
			}
			
			}
		}
				
		return map;

	}

	private static void addEdge(ArrayList<ArrayList<Integer>> list, int i, int j) {
		// TODO Auto-generated method stub
		list.get(i).add(j);
		// list.get(j).add(i);

	}

}
