import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Definition for a Node.
class Node {
  public int val;
  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<>();
  }

  public Node(int _val) {
    val = _val;
    neighbors = new ArrayList<>();
  }

  public Node(int _val, ArrayList<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
}

class CloneGraph {
  public Node dfs(Node curr, HashMap<Node, Node> map) {

    Node clone = new Node(curr.val);
    map.put(curr, clone);

    for (Node neighbor : curr.neighbors) {
      if (map.containsKey(neighbor)) {
        clone.neighbors.add(map.get(neighbor));
      } else {
        clone.neighbors.add(dfs(neighbor, map));
      }
    }
    return clone;
  }

  public Node cloneGraph(Node node) {
    HashMap<Node, Node> map = new HashMap<>();
    if (node == null) {
      return null;
    }
    return dfs(node, map);
  }
}