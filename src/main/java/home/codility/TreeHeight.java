package home.codility;

public class TreeHeight {

	
	private int getHeight(Tree T) 	{
		if ( T == null)	
			return 0;
		return Math.max(getHeight(T.left) , getHeight(T.right)) + 1 ;
	}
	public int solution ( Tree T)	{
		return Math.max(getHeight(T.left ), getHeight(T.right));
	}
	
	class Tree {
		public int x ;
		public Tree left ;
		public Tree right ;
	}

	public static void main(String[] args) {
		Tree treeNode = new TreeHeight().new Tree() ;
		treeNode.x = 5 ;
		Tree treeNode1 = new TreeHeight().new Tree() ;
		treeNode1.x = 3;
		treeNode.left = treeNode1 ;
		int result = new TreeHeight().solution(treeNode) ;
        System.out.println(result);

	}
}
