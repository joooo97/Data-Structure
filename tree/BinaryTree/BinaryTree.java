
class Node {
	Object data; // 데이터 필드
	Node left; // 왼쪽 링크 필드
	Node right; // 오른쪽 링크 필드
	
	public Node(Object data) {
		this.data = data;
		left = null;
		right = null;
	}
}

public class BinaryTree {
	private Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	// 노드 생성 후 연결하는 메서드
	public Node makeBT(Node left, Object data, Node right) {
		root = new Node(data);
		root.left = left;
		root.right = right;
		return root;
	}
	
	// 이진 트리의 순회
	// 1. 중위 순회 (왼쪽 서브트리 순회 -> 루트 노드 방문 -> 오른쪽 서브트리 순회)
	public void inorder(Node root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}
	
	// 2. 전위 순회 (루트 노드 방문 -> 왼쪽 서브트리 순회 -> 오른쪽 서브트리 순회)
	public void preorder(Node root) {
		if(root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	// 3. 후위 순회 (왼쪽 서브트리 순회 -> 오른쪽 서브트리 순회 -> 루트 노드 방문)
	public void postorder(Node root) {
		if(root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	public static void main(String[] args) {
		//    1
		//  2   3
		// 4 5 6 7
		
		// 이진 트리 생성
		BinaryTree bt = new BinaryTree();
		
		Node n7 = bt.makeBT(null, 7, null);
		Node n6 = bt.makeBT(null, 6, null);
		Node n5 = bt.makeBT(null, 5, null);
		Node n4 = bt.makeBT(null, 4, null);
		Node n3 = bt.makeBT(n6, 3, n7);
		Node n2 = bt.makeBT(n4, 2, n5);
		Node n1 = bt.makeBT(n2, 1, n3);
		
		// 이진 트리 순회
		bt.inorder(n1); // 중위 순회: 4 2 5 1 6 3 7 
		System.out.println();
		bt.preorder(n1); // 전위 순회: 1 2 4 5 3 6 7 
		System.out.println();
		bt.postorder(n1); // 후위 순회: 4 5 2 6 7 3 1 
		System.out.println();
	}
}
