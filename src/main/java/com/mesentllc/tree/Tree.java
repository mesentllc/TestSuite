package com.mesentllc.tree;

public class Tree {
	private Node root;

	public Tree(Object rootValue) {
		root = new Node(rootValue);
	}

	public void insertNode(Node node, Object leafValue) {
		if (leafValue.hashCode() < node.getValue().hashCode()) {
			if (node.getLeftNode() != null) {
				insertNode(node.getLeftNode(), leafValue);
			} else {
				node.setLeftNode(new Node(leafValue));
			}
		} else {
			if (node.getRightNode() != null) {
				insertNode(node.getLeftNode(), leafValue);
			}
		}
		if (leafValue.hashCode() > node.getValue().hashCode()) {
			if (node.getRightNode() != null) {
				insertNode(node.getRightNode(), leafValue);
			} else {
				node.setRightNode(new Node(leafValue));
			}
		}
	}

	public void traverse() {
		traverse(root);
	}

	public void traverse(Node node) {
		if (node != null) {
			traverse(node.getLeftNode());
			System.out.print(" " + node.getValue());
			traverse(node.getRightNode());
		}
	}
}
