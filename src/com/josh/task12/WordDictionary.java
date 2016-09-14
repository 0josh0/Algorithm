package com.josh.task12;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
 * ���⣺addWord���ֵ�����ӵ��ʣ�search���ֵ��в��ҵ��ʣ�֧��������ʽ��ѯ����.����������ĸ
 * ������1����set�洢����,����Ѱ���Ƿ�ƥ�䣬�����ⷨ����Ȼ��ʱ��������
 * 		2���ֵ��� trie
 */

public class WordDictionary {
	@Test
	public void test(){
		 WordDictionary wordDictionary = new WordDictionary();
		 wordDictionary.addWord("a");
		 System.out.println(wordDictionary.search("."));
	}
	//�������ݽṹ �ֵ���
	class TrieNode{
		char node;//��ǰ�ڵ�ֵ�����ʵ�һ����ĸ
		boolean isLeaf;//��ǰλ���Ƿ��ǵ������һ����ĸ
		Map<Character,TrieNode> children = new HashMap<Character,TrieNode>();//һ�����ʵ�ǰ�ڵ�λ�ú������ĸ
		public TrieNode(){
			
		}
		public TrieNode(char c){//���캯��
			
		}
	}
	TrieNode root = new TrieNode();//����һ�����ڵ� root
	// Adds a word into the data structure.
    public void addWord(String word) {//�����ʹ�����ֵ���
        if(word.length()==0) return ;
        //�õ�root�����к��ӽڵ�
        Map<Character,TrieNode> children = root.children;
        for(int i=0;i<word.length();i++){
        	TrieNode child = null;//��ǰword�ĵ�i����ĸ��ָ��
        	//�жϵ�ǰ����word�ĵ�i����ĸ�Ƿ���root��children��
            char fChar = word.charAt(i);
            if(children.containsKey(fChar)){//���root��children���е�ǰ���ʵĵ�i����ĸ��childָ��ָ�����ĸ
            	child=children.get(fChar);
            }else{//���root�����к����ж�û��word�ĵ�i����ĸ���½�root�ĺ��ӽڵ㣬chilldָ��ָ���½ڵ�
            	child = new TrieNode(fChar);
            	children.put(fChar,child);
            }
            children = child.children;//����word�ĵ�i����ĸ��childrenmap����
            if(i==word.length()-1) child.isLeaf=true;//���ﵥ��ĩβ
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchWord(word,root,0);
    }
    //�Ӹ�����children��ʼѰ�ң���word�ĵ�һ����ĸ��ʼ�ݹ�����
    public boolean searchWord(String word,TrieNode root,int start){
    	if(word.length()==start) return root.isLeaf;
    	char fChar = word.charAt(start);
    	if(fChar=='.'){//�����һ����ĸ��ͨ���������root�����к��ӽڵ㣬word����Ϊword.substring(1,len)
    		for(Character key:root.children.keySet()){
    			if(searchWord(word, root.children.get(key),start+1)) return true; 
    		}
    		return false;
    	}else if(root.children.containsKey(fChar)){//���root�ĺ��ӽڵ�����word�ĵ�һ����ĸ���ݹ�����
    		return searchWord(word,root.children.get(fChar),start+1);
    	}else{
    		return false;
    	}
    	//return false;
    }
}
