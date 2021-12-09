package trie;

public class TrieUse {

	public static void main(String[] args) {
		
		Trie t = new Trie();
		
		t.add("REESHI");
		t.add("AND");
		t.add("YADAV");
		
		System.out.println(t.search("REESHI"));
//		System.out.println(t.search("AND"));
		System.out.println(t.search("YADAV"));
//		System.out.println(t.search("REESHIK"));
		t.remove("REESHI");
		t.remove("YADAV");
		System.out.println(t.search("REESHI"));
		System.out.println(t.search("YADAV"));
	}

}
