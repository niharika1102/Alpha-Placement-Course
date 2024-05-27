import java.util.*;

public class HashMapImplementation {
    static class HashMap<K, V> {    //K and V are generics
        private class Node {    //blueprint of node
            K key;
            V value;
        }

        public Node (key K, value V) {
            this.key = key;
            this.value = value;
        }

        private int n;    //n
        private int N;
        private LinkedList<Node> buckets[];     //array of ll   //N
    
        public HashMap() {     //constructor of HashMap class
            this.n = 0;
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return  Math.abs(hc) % N;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;

            for (int i = 0; i < ll.n(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return di;
                }
                di++;
            }

            return -1;
        }

        private void rehash() {
            LinkedList
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);    //returns bucket index
            int di = searchInLL(key);

            if (di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            }
            else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = n / N;

            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {

        }

        public V remove(K key) {

        }

        public V get(K key) {

        }

        public ArrayList<K> keySet() {
            return null;
        }
    }
    public static void main(String[] args) {

    }
}
