public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

        private HashNode<K, V>[] chainArray;
        private int M = 11;
        private int size;

        public MyHashTable(){
            this.chainArray = new HashNode<K, V>[11];
            this.size = 0;
        }

        public MyHashTable(int M){
            this.chainArray = new HashNode<K, V>[];
            this.size = 0;
            this.M=M;
        }

        private int hash(K key){

        }

        public void put(K key, V value){

        }

        public V get(K key){

        }

        public V remove(K key){

        }

        public boolean contains(V value){

        }

        public K getKey(V value){

        }
    }
}
