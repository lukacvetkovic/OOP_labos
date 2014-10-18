package hr.fer.oop.lab1.topic1.prob2;

/**
 * Klasa TreeProgram simulira rad stabla. Sadrži metode
 * main,containsData,sizeOfTree,insert,writeTree
 * 
 * @author Luka Cvetkoviæ
 *
 */
class TreeProgram {
	static class TreeNode {
		TreeNode left;
		TreeNode right;
		String data;
	}

	/**
	 * Pomocu main metode u stablo stavljamo nove elemente te raznim metodama
	 * ispisujemo i okrecemo
	 * 
	 * @param args
	 *            (ne koristi se)
	 */
	public static void main(String[] args) {
		TreeNode node = null;
		node = insert(node, "Jasna");
		node = insert(node, "Ana");
		node = insert(node, "Ivana");
		node = insert(node, "Anamarija");
		node = insert(node, "Vesna");
		node = insert(node, "Kristina");
		System.out.println("Writing tree inorder:");
		writeTree(node);
		node = reverseTreeOrder(node);
		System.out.println("Writing reversed tree inorder:");
		writeTree(node);
		int size = sizeOfTree(node);
		System.out.println("Number of nodes in tree is " + size + ".");
		boolean found = containsData(node, "Ivana");
		System.out.println("Searched element is found: " + found);
	}

	/**
	 * Metoda containsData provjerava da li postoji u stablu odredeni string
	 * 
	 * @param treeRoot
	 *            referenca na stablo u kojem trazimo
	 * @param data
	 *            string koji trazimo u stablu
	 * @return boolean vrijednost koji ako je naden je true, ako nije je false
	 */
	static boolean containsData(TreeNode treeRoot, String data) {
		boolean found;
		// ako je stablo prazno
		if (treeRoot == null) {
			return false;
		}
		// ako je naden element
		if (treeRoot.data.equals(data)) {
			return true;
		}
		// rekurzivno se trazi u lijevom i desnom djetetu
		found = containsData(treeRoot.left, data);
		if (found == false) {
			found = containsData(treeRoot.right, data);
		}

		return found;

	}

	/**
	 * Metoda sizeOfTree daje nam broj elemenata stabla rekurzivnom metodom
	 * 
	 * @param treeRoot
	 *            referenca na stablo u kojem brojimo elemente
	 * @return broj elemenata
	 */
	static int sizeOfTree(TreeNode treeRoot) {
		if (treeRoot == null) {
			return 0;
		} else {
			return 1 + sizeOfTree(treeRoot.left) + sizeOfTree(treeRoot.right);
		}

	}

	/**
	 * Metoda insert upisuje u postojece stablo nove elemente Stablo nakon upisa
	 * je sortirano
	 * 
	 * @param treeRoot
	 *            referenca na stablo u koje dodajemo
	 * @param data
	 *            string(data) novog elementa
	 * @return referencu na pocetak stabla
	 */
	static TreeNode insert(TreeNode treeRoot, String data) {
		TreeNode node = new TreeNode();

		if (treeRoot == null) {
			node.left = null;
			node.right = null;
			node.data = data;
			return node;
		} else {
			if (treeRoot.data.compareTo(data) > 0) {
				treeRoot.left = insert(treeRoot.left, data);
			} else {
				treeRoot.right = insert(treeRoot.right, data);
			}
			return treeRoot;
		}
	}

	/**
	 * Metoda writeTree ispisuje stablo u inorder formatu
	 * 
	 * @param treeRoot
	 *            referenca na stablo koje ispisujemo
	 */
	static void writeTree(TreeNode treeRoot) {
		if (treeRoot == null) {
			return;
		}
		writeTree(treeRoot.left);
		System.out.println(treeRoot.data);
		writeTree(treeRoot.right);
	}

	/**
	 * Metoda reverseTreeOrder okrece stablo (lijevo i desno stablo se okrenu)
	 * 
	 * @param treeRoot
	 *            referenca na stablo koje okrecemo
	 * @return referencu na pocetak stabla
	 */
	static TreeNode reverseTreeOrder(TreeNode treeRoot) {
		TreeNode pom;
		// ako je prazno
		if (treeRoot == null) {
			return treeRoot;
		}

		// manipulacija referenci
		pom = treeRoot.left;
		treeRoot.left = treeRoot.right;
		treeRoot.right = pom;

		// rekurzivno za lijevo i desno djete
		reverseTreeOrder(treeRoot.left);
		reverseTreeOrder(treeRoot.right);

		return treeRoot;

	}
}
