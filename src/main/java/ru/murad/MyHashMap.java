package ru.murad;

import java.util.LinkedList;

public class MyHashMap<K, V> {

    static class Node<K, V> {
        final K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final LinkedList<Node<K, V>>[] buckets;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        this.buckets = new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
        this.size = 0;
    }

    public V put(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<Node<K, V>> bucket = buckets[index];

        for (Node<K, V> node : bucket) {
            if (keysEqual(node.key, key)) {
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
        }

        bucket.add(new Node<>(key, value));
        size++;
        return null;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Node<K, V>> bucket = buckets[index];

        for (Node<K, V> node : bucket) {
            if (keysEqual(node.key, key)) {
                return node.value;
            }
        }
        return null;
    }

    public V remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Node<K, V>> bucket = buckets[index];

        for (Node<K, V> node : bucket) {
            if (keysEqual(node.key, key)) {
                V oldValue = node.value;
                bucket.remove(node);
                size--;
                return oldValue;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getBucketIndex(K key) {
        if (key == null) return 0;
        return Math.abs(key.hashCode()) % buckets.length;
    }

    private boolean keysEqual(K key1, K key2) {
        if (key1 == null && key2 == null) return true;
        if (key1 == null || key2 == null) return false;
        return key1.equals(key2);
    }
}