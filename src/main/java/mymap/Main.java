package mymap;

public class Main {

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("один", 1);
        map.put("два", 2);
        map.put("три", 3);

        System.out.println("get(\"два\") = " + map.get("два"));
        System.out.println("size = " + map.size());

        map.put("два", 22);
        System.out.println("после put(\"два\", 22): " + map.get("два"));

        System.out.println("remove(\"три\") = " + map.remove("три"));
        System.out.println("get(\"три\") = " + map.get("три"));
        System.out.println("size = " + map.size());
    }
}
