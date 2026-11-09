package mymap;


public class MyHashMap<K, V> {

    private static final int CAPACITY = 16;

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


    private final Node[] table;
    private int size;

    public MyHashMap() {
        table = new Node[CAPACITY];
        size = 0;
    }

    private int indexFor(K key) {
        int hash = key.hashCode();
        if (hash < 0) {
            hash = -hash;
        }
        return hash % table.length;
    }

    public V get(K key) {
        int index = indexFor(key);
        Node<K, V> node = table[index];

        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public void put(K key, V value) {
        int index = indexFor(key);
        Node<K, V> node = table[index];

        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        Node<K, V> newNode = new Node<>(key, value, table[index]);
        table[index] = newNode;
        size++;
    }

    public V remove(K key) {
        int index = indexFor(key);
        Node<K, V> node = table[index];
        Node<K, V> prev = null;

        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    table[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return node.value;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }

    public int size() {
        return size;
    }
}
