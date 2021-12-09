package trie;

public class TrieNode {
	
	char data;
	boolean isTerminal;
	TrieNode[] childrens;
	int childCount;
	
	public TrieNode(char data) {
		this.data = data;
		this.isTerminal = false;
		this.childrens = new TrieNode[26];
		this.childCount = 0;
	}

}
