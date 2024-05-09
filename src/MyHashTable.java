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

    /**
     * constructor with default capacity
     */
    public MyHashTable(){
        this.chainArray = new HashNode[M];
        this.size = 0;
    }

    /**
     * constructor with custom capacity
     *
     * @param M initial capacity
     */
    public MyHashTable(int M){
        this.chainArray = new HashNode[M];
        this.size = 0;
        this.M=M;
    }

    /**
     * method that returns the index in chainArray for the key
     *
     * @param key the key
     * @return the index in chainArray
     */
    private int hash(K key){
        return key.hashCode()%M;
    }

    /**
     * method that returns node by key
     *
     * @param key the key
     * @return the node
     */
    private HashNode<K, V> getNode(K key){
        HashNode<K, V> current = chainArray[hash(key)];
        while (current!=null) {
            if (current.key==key){
                return current;
            }
            current=current.next;
        }
        return null;
    }

    /**
     * method that adds a node to chainArray
     *
     * @param key the key
     * @param value the value
     */
    public void put(K key, V value){
        HashNode<K,V> node = new HashNode<>(key,value);
        if (chainArray[hash(key)]==null){
            chainArray[hash(key)]=node;
        }
        else {
            chainArray[hash(key)].next=node;
        }
        size++;
    }

    public V get(K key){
        return getNode(key).value;
    }

    public V remove(K key){
        HashNode<K, V> removedNode = getNode(key);
        HashNode<K, V> current = chainArray[hash(key)];
        while (current!=null){
            if (current==removedNode){
                current=removedNode.next;
            }
            else if (current.next==removedNode){
                current.next=removedNode.next;
            }
            current=current.next;
        }
        size--;
        return removedNode.value;
    }

    public boolean contains(V value){
        HashNode<K, V> current;
        for (int i = 0; i<M; i++){
            current = chainArray[i];
            while(current!=null){
                if (current.value==value){
                    return true;
                }
                current=current.next;
            }
        }
        return false;
    }

    public K getKey(V value){
        return null;
    }
}

