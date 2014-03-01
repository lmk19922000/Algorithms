package jp.co.wap.exam.lib;

public class HeadTailNode<E> {
	private Node<E> pointingNode;
	
	public HeadTailNode(){
		this.pointingNode = null;
	}
	
	public HeadTailNode(Node<E> node) {
		this.pointingNode = node;
	}

	public Node<E> getPointingNode() {
		return this.pointingNode;
	}

	public void setPointingNode(Node<E> node) {
		this.pointingNode = node;
	}
}
