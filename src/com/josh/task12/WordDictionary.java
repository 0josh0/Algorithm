package com.josh.task12;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
 * 题意：addWord向字典中添加单词，search在字典中查找单词，支持正则表达式查询，即.代表任意字母
 * 分析：1、用set存储单词,挨个寻找是否匹配，暴力解法，必然超时！！！！
 * 		2、字典树 trie
 */

public class WordDictionary {
	@Test
	public void test(){
		 WordDictionary wordDictionary = new WordDictionary();
		 wordDictionary.addWord("a");
		 System.out.println(wordDictionary.search("."));
	}
	//定义数据结构 字典树
	class TrieNode{
		char node;//当前节点值，单词的一个字母
		boolean isLeaf;//当前位置是否是单词最后一个字母
		Map<Character,TrieNode> children = new HashMap<Character,TrieNode>();//一个单词当前节点位置后面的字母
		public TrieNode(){
			
		}
		public TrieNode(char c){//构造函数
			
		}
	}
	TrieNode root = new TrieNode();//定义一个根节点 root
	// Adds a word into the data structure.
    public void addWord(String word) {//将单词构造成字典树
        if(word.length()==0) return ;
        //得到root的所有孩子节点
        Map<Character,TrieNode> children = root.children;
        for(int i=0;i<word.length();i++){
        	TrieNode child = null;//当前word的第i个字母的指针
        	//判断当前单词word的第i个字母是否在root的children中
            char fChar = word.charAt(i);
            if(children.containsKey(fChar)){//如果root的children中有当前单词的第i个字母，child指针指向该字母
            	child=children.get(fChar);
            }else{//如果root的所有孩子中都没有word的第i个字母，新建root的孩子节点，chilld指针指向新节点
            	child = new TrieNode(fChar);
            	children.put(fChar,child);
            }
            children = child.children;//更新word的第i个字母的childrenmap集合
            if(i==word.length()-1) child.isLeaf=true;//到达单词末尾
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchWord(word,root,0);
    }
    //从根结点的children开始寻找，从word的第一个字母开始递归搜索
    public boolean searchWord(String word,TrieNode root,int start){
    	if(word.length()==start) return root.isLeaf;
    	char fChar = word.charAt(start);
    	if(fChar=='.'){//如果第一个字母是通配符，遍历root的所有孩子节点，word更新为word.substring(1,len)
    		for(Character key:root.children.keySet()){
    			if(searchWord(word, root.children.get(key),start+1)) return true; 
    		}
    		return false;
    	}else if(root.children.containsKey(fChar)){//如果root的孩子节点中有word的第一个字母，递归搜索
    		return searchWord(word,root.children.get(fChar),start+1);
    	}else{
    		return false;
    	}
    	//return false;
    }
}
