package com.mesentllc.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Graph {
	private Map<Node, LinkedList<Node>> neighborMap;
	private boolean directed;

	public Graph(boolean directed) {
		this.directed = directed;
		neighborMap = new HashMap<>();
	}

	public void addEdgeHelper(Node a, Node b) {
		LinkedList<Node> tmp = neighborMap.get(a);

		if (tmp != null) {
			tmp.remove(b);
		} else {
			tmp = new LinkedList<>();
		}
		tmp.add(b);
		neighborMap.put(a, tmp);
	}

	public void addEdge(Node source, Node destination) {
		if (!neighborMap.containsKey(source)) {
			neighborMap.put(source, null);
		}
		if (!neighborMap.containsKey(destination)) {
			neighborMap.put(destination, null);
		}
		addEdgeHelper(source, destination);
		if (!directed) {
			addEdgeHelper(destination, source);
		}
	}

	public Node depthFirstSearch(Node startNode, Object objectToFind) {
		startNode.visit();
		if (startNode.getObject().equals(objectToFind)) {
			return startNode;
		}

		LinkedList<Node> neighborNodes = neighborMap.get(startNode);
		if (neighborNodes == null) {
			return null;
		}

		for (Node neighbor : neighborNodes) {
			if (!neighbor.checked()) {
				Node node = depthFirstSearch(neighbor, objectToFind);
				if (node != null) {
					return node;
				}
			}
		}
		return null;
	}

	public Node depthFirstSearchCompleteGraph(Node startNode, Object objectToFind) {
		Node node = depthFirstSearch(startNode, objectToFind);
		if (node == null) {
			for (Node nodeFromKeySet : neighborMap.keySet()) {
				if (!nodeFromKeySet.checked()) {
					Node nodeReturned = depthFirstSearch(nodeFromKeySet, objectToFind);
					if (nodeReturned != null) {
						return nodeReturned;
					}
				}
			}
		}
		return node;
	}

	public Node breadthFirstSearch(Node startNode, Object objectToFind) {
		if (startNode == null) {
			return null;
		}

		LinkedList<Node> queue = new LinkedList<>();
		queue.add(startNode);

		while (!queue.isEmpty()) {
			Node currentFirst = queue.removeFirst();
			if (currentFirst.checked()) {
				continue;
			}
			currentFirst.visit();
			if (currentFirst.getObject().equals(objectToFind)) {
				return currentFirst;
			}
			LinkedList<Node> neighborNodes = neighborMap.get(currentFirst);
			if (neighborNodes == null) {
				continue;
			}
			for (Node neighbor : neighborNodes) {
				if (!neighbor.checked()) {
					queue.add(neighbor);
				}
			}
		}
		return null;
	}

	public Node breadthFirstSearchCompleteGraph(Node startNode, Object objectToFind) {
		Node node = breadthFirstSearch(startNode, objectToFind);
		if (node == null) {
			for (Node nodeFromKeys : neighborMap.keySet()) {
				if (!nodeFromKeys.checked()) {
					Node nodeReturned = breadthFirstSearch(nodeFromKeys, objectToFind);
					if (nodeReturned != null) {
						return nodeReturned;
					}
				}
			}
		}
		return node;
	}
}
