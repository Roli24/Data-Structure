import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CreateGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int v = 4;
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < v; i++)
			list.add(new ArrayList<Integer>());

		addEdge(list, 0, 1);
		addEdge(list, 0, 2);
		addEdge(list, 2, 0);
		addEdge(list, 2, 3);
		addEdge(list, 3, 3);

		printGraph(list);
		boolean[] visited = new boolean[v];

		/*
		 * for (int i = 0; i < v; i++) { if(visited[i]==false)
		 */
		shortestPath(list, 0, visited);
		// }
		/*
		 * for (int i = 0; i < v; i++) { if (visited[i] == false) { //bfs(list, i,
		 * visited); dfs(list,i,visited); } }
		 */

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

	private static void printGraph(ArrayList<ArrayList<Integer>> list) {
		// TODO Auto-generated method stub

		for (int i = 0; i < list.size(); i++) {
			System.out.println("list ith element--------" + i);
			for (int j = 0; j < list.get(i).size(); j++) {
				System.out.println(list.get(i).get(j));
			}
		}

	}

	private static void addEdge(ArrayList<ArrayList<Integer>> list, int i, int j) {
		// TODO Auto-generated method stub
		list.get(i).add(j);

	}

}
