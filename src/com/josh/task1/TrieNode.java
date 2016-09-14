package com.josh.task1;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	char c;
	boolean isLeaf;
	Map<Character,TrieNode> children = new HashMap<Character,TrieNode>();
	
	public TrieNode(char c){
		this.c = c;
	}
	public TrieNode(){
		
	}
}
