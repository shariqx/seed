package com.core.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
import java.util.logging.Logger;
/**
 * 
 * @author shariq.shaikh
 * coauthors: ++ Add your name after you've requested your changes.
 * Weighted graphs work on the assumptions that the weight can never be 0.
 */

public class Graph {
	
	Logger LOGGER = Logger.getLogger(Graph.class.getName());
	
	int noOfVertices = 0;
	int[][] edgeList = null;
	boolean visited[];
	boolean isInitializedWithDefaultConstructor = false;
	boolean isWeighted = false;
	boolean isUndirected = false;

	public Graph(){
		isInitializedWithDefaultConstructor = true;
		noOfVertices = 1001;
		initialize(noOfVertices);
	}
	public Graph(int noOfVertices){
		this.noOfVertices = noOfVertices;
		initialize(noOfVertices);
	}
	public Graph(int noOfVertices,boolean isWeighted){
		this.noOfVertices = noOfVertices;
		initialize(noOfVertices);
		this.isWeighted = isWeighted;
	}
	public Graph(int noOfVertices,boolean isUndirected,boolean isWeighted){
		this.noOfVertices = noOfVertices;
		initialize(noOfVertices);
		this.isWeighted = isWeighted;
		this.isUndirected = isUndirected;
	}
	
	private void initialize(int noOfVertices2) {
			visited = new boolean[noOfVertices];
			edgeList = new int[noOfVertices][noOfVertices];
			for (int i = 0; i < noOfVertices ; i++) {
				visited[i] = false;
				for (int j = 0; j < noOfVertices; j++) {
					edgeList[i][j] = 0;
				}
			}
	}

	public void addEdge(int a,int b){
		if(isWeighted)
			LOGGER.warning("addEdge :: Cannot add an edge, the graph is weighted, please use "
					+ "addEdge(int a,int b,int w) for adding an edge");
			else
			edgeList[a][b]=1;
			LOGGER.info("Added edge from "+ a + " to " + b);	
		}
		
		public void addEdge(int a,int b,int w){
			if(!isWeighted)
				LOGGER.warning("addEdge :: Cannot add the edge, the graph is not weighted, please use"
						+ "addEdge(int a,int b) for adding edge.");
				else{
						edgeList[a][b]=w;
						if(isUndirected)
						edgeList[b][a]=w;
						LOGGER.info("Added edge from "+ a + " to " + b + " with weight " + w);
			}
		}
		
		public boolean hasEdge(int a,int b){
			if(edgeList[a][b] == 0)
				return false;
			else 
				return true;
		}
		
		public void removeEdge(int a, int b){
			edgeList[a][b] = 0;
			LOGGER.info("Removed edge from " + a + " to " + b); 
		}
		
		public void printGraph(){
			for (int i = 0; i < noOfVertices; i++) {
				for (int j = 0; j < noOfVertices; j++) {
					if(edgeList[i][j]!=0){
						System.out.println(i + "-->" + j);
					}
				}
			}
		}
		
		public void bfsIterative(){
			if(!isGraphEmpty())
			//TODO: Figure out how to choose source node.
			bfsIterative(0);
		}

		private boolean isGraphEmpty() {
			boolean isEmpty = true;
			for (int i = 0; i < noOfVertices;i++) {
				for (int j = 0; j < noOfVertices; j++) {
					if(edgeList[i][j]!=0)
						isEmpty = false;
				}
			}
			return isEmpty;
		}
		
		public ArrayList<Integer> bfsIterative(int source){
			ArrayList<Integer> ret  = new ArrayList<Integer>();
			LOGGER.info("::RecursiveDFS::");
			if(isGraphEmpty()){
				LOGGER.warning("Cannot perform DFS, the graph is empty");
				return null;
			}
			StringBuffer sb = new StringBuffer();
			sb.append("BFS ::");
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(source);
			visited[source] = true;
			sb.append("-> " + source);
			ret.add(source);
			while(!queue.isEmpty()){

				int removed = queue.remove();
				for (int i = 0; i < edgeList[removed].length; i++) {
					
					if(edgeList[removed][i] != 0 && !visited[i]){
						visited[i] = true;
						queue.add(i);
						sb.append(" -> " + i);
						ret.add(i);
					}
				}
			}
		return ret;
		}
		
		public String bfsRecursive(){
				//TODO: send correct source node to main BFS method, also add a logger.
			return "";
		}
		
		public ArrayList<Integer> bfsRecursive(int source){
			LOGGER.info("Even if the metho name tips that this one is recursive BFS,\n"
					+ "There can't be an optimized way to implement something that uses\n "
					+ "Queues instead of stack by the means of recursion. Hence for optimality,\n "
					+ "This method will eventually follow iterativeBFS.");
			ArrayList<Integer> ret = bfsIterative(source);
			return ret;
		}
		
		public void dfsRecursive(){
			//TODO: find default source node. 
			ArrayList<Integer> arr = new ArrayList<Integer>();
			dfsRecursive(1,arr);
		}
		public ArrayList<Integer> dfsRecursive(int source,ArrayList<Integer> ret){
			visited[source] = true;
			System.out.print(source + " - > ");
			ret.add(source);
			for (int i = 0; i < edgeList[source].length; i++) {
				
				if(edgeList[source][i] !=0 && !visited[i]){
					dfsRecursive(i,ret);
				}
			}
		return ret;
		}
		
		public String dfsIterative(int source){
			//TODO : Write code for Iterative DFS.
			return "";
		}
		
		public TreeMap<Integer,ArrayList<Integer>> getVerticesMap(){
			TreeMap<Integer,ArrayList<Integer>> ret = new TreeMap<Integer, ArrayList<Integer>>();
			
			for (int i = 0; i < noOfVertices; i++) {
				for (int j = 0; j < noOfVertices; j++) {
					if(edgeList[i][j] != 0){
						if(ret.get(i)==null){
							ArrayList<Integer> addThis = new ArrayList<Integer>();
						addThis.add(j);
						ret.put(i, addThis);
						}
						else
						{
							ret.get(i).add(j);
						}
					}
				}
			}
			return ret;
		}
		
		public HashMap<Integer,ArrayList<Integer>> getTraversalMap(){
			HashMap<Integer,ArrayList<Integer>> ret = new HashMap<Integer, ArrayList<Integer>>();
			
			return ret;
		}
}

	
	

