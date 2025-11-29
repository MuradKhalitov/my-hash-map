package ru.murad;

public class Main {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        System.out.println("Map пустая: " + map.isEmpty());

        map.put("Яблоко", 10);
        map.put("Банан", 5);

        System.out.println("Яблоко: " + map.get("Яблоко"));
        System.out.println("Банан: " + map.get("Банан"));

        map.put("Яблоко", 15);
        System.out.println("Яблоко после обновления: " + map.get("Яблоко"));

        map.remove("Банан");
        System.out.println("Банан после удаления: " + map.get("Банан"));

        System.out.println("Размер: " + map.size());

        System.out.println("Map пустая: " + map.isEmpty());

    }
}