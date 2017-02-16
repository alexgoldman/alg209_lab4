package edu.pitt.is1017;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import edu.pitt.infsci1017_tree.Node;
import edu.pitt.infsci1017_tree.Tree;
import edu.pitt.infsci1017_tree.TreeFactory;



public class MainCLass {

	public static void main(String[] args) {
		Tree tree = TreeFactory.getTree();
		Node test = tree.getRoot();
		System.out.println(nodeCounter(test));
		System.out.println(getHeight(test));
	
	}
	
	
	public static boolean hasChildren(Node node){
		if(node.getChildren().size()==0){
			return false;
		}else {
			return true;
		}
		
	}
	static int nodeCount=0;
	static int loopCounter=0;
	static int leafCounter=0;
	static int depth=0;
	
	public static int getHeight(Node n){
	    if(n.isLeaf()){
	         return 0;
	    }else{
	        int maxDepth = 0;

			for(Node m : n.getChildren()){
	            maxDepth = Math.max(maxDepth, getHeight(m));
	        }

	        return maxDepth + 1;
	    }
	}

	public static int nodeCounter(Node node){
		
	
		if(hasChildren(node)){
			loopCounter++;
			nodeCount++;
			if(node.isRoot()){
				//System.out.println("Root here");
			}
			Vector<Node> test1 = node.getChildren();
			
			//System.out.println("Children: "+test1.size());
			
			for(int i = 0;i<test1.size();i++){
				if(node.isRoot()){
					System.out.println("I am the root node! " + node.getContent());
				}
				if(!node.isRoot()){
					System.out.println("Node: " + node.getContent() + " Parent: " + node.getParent().getContent());

				}
				//System.out.println("Child "+ i);
				Node n1 = test1.get(i);
				
				nodeCounter(n1);
				//System.out.println(nodeCount);
			} 
				
			} else {
				if(node.isLeaf()){
					nodeCount++;
					leafCounter++;
					System.out.println("Node: " + node.getContent() + " Parent: " +node.getParent().getContent() + " I am a leaf");
				}
		}
		
		return nodeCount;
	}
}
