public class BST<T extends Comparable<T>>{
	private Node root;

	public BST(){
		root=null;
	}

	public class Node<Comparable>{
		private T data;
		private Node left;
		private Node right;

		public Node(T item){
			data = item;
			left=null;
			right=null;
		}
	}

	public boolean find(T item){
			return find(item, root);
	}

	public boolean find(T item, Node node){
			if(node==null)
				return false;

			if(node.data.compareTo(item)==0)
				return true;

			else if(node.data.compareTo(item) < 0)
				return find(item, node.right);

			else
				return find(item, node.left);
	}

	public void insert(T item){
		root = insert(root, item);
	}
	public Node insert(Node node, T item){
		if(node==null)
			return new Node(item);
		else if(node.data.compareTo(item) < 0)
			node.right=insert(node.right, item);
		else
			node.left=insert(node.left, item);

		return node;
	}

	public void print(){
		print(root);
	}

	public void print(Node node){
		if(node != null){
			print(node.left);
			System.out.println(node.data);
			print(node.right);
		}
	}

	public Node delete(Node tree, T elem){
		if(tree == null)
			return null;
		if(tree.data.compareTo(elem)==0){
			if(tree.left==null)
				return tree.right;
			else if(tree.right==null)
				return tree.left;
			else{
				if(tree.right.left==null){
					tree.data=tree.right.data;
					tree.right=tree.right.right;
					return tree;
				}

				else{
					tree.data=removeSmallest(tree.right);
					return tree;
				}
			}
		}

		else if(elem.compareTo((T)tree.data) < 0){
			tree.left = delete(tree.left, elem);
			return tree;
		}

		else{
			tree.right = delete(tree.right, elem);
			return tree;
		}
	}

	public void delete(T item){
		root = delete(root, item);
	}

	public T removeSmallest(Node tree){
		if(tree.left.left==null){
			T smallest = (T)tree.left.data;
			tree.left = tree.left.right;
			return smallest;
		}
		else{
			return removeSmallest(tree.left);
		}
	}
	
}