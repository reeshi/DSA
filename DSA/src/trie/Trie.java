package trie;

public class Trie {
	
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode('\0');
	}
	
	// add word in a trie.
	public void add(String word) {
		addHelper(root, word);
	}
	
	private void addHelper(TrieNode root, String word) {
		if(word.length() == 0) {
			root.isTerminal = true;
			return;
		}
		
		int childIndex = word.charAt(0) - 'A';
		TrieNode child = root.childrens[childIndex];
		if(child == null) {
			child = new TrieNode(word.charAt(0));
			root.childrens[childIndex] = child;
			root.childCount++;
		}
		
		addHelper(child, word.substring(1));
	}
	
	// search a word
	public boolean search(String word) {
		return searchHelper(root, word);
	}
	
	private boolean searchHelper(TrieNode root, String word) {
		if(word.length() == 0) {
			return root.isTerminal;
		}
		int childIndex = word.charAt(0) - 'A';
		TrieNode child = root.childrens[childIndex];
		if(child == null) {
			return false;
		}
		
		return searchHelper(child, word.substring(1));
	}
	
	// remove a word
	public void remove(String word) {
		removeHelper(root, word);
	}
	
	public void removeHelper(TrieNode root, String word) {
		if(word.length() == 0) {
			root.isTerminal = false;
			return;
		}
		
		int childIndex = word.charAt(0) - 'A';
		TrieNode child = root.childrens[childIndex];
		if(child == null) {
			return;
		}
		
		removeHelper(child, word.substring(1));
		if(!child.isTerminal && child.childCount == 0) {
			root.childrens[childIndex] = null;
			root.childCount--;
		}
		
	}

}
