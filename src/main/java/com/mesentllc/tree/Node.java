package com.mesentllc.tree;

public class Node {
	private Object value;
	private Node leftNode;
	private Node rightNode;

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}

	public Node(Object value) {
		this.value = value;
		leftNode = null;
		rightNode = null;
	}
}
