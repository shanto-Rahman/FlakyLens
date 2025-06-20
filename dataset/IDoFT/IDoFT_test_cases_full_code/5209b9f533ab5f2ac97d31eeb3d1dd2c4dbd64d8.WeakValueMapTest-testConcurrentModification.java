@Test(expected=ConcurrentModificationException.class) public void testConcurrentModification(){
  Map<String,Integer> map=new WeakValueMap<>(3);
  map.put("key_1",123);
  map.put("key_2",42);
  map.put("key_3",543);
  map.put("key_4",321);
  assertEquals(4,map.size());
  for (  Map.Entry<String,Integer> entry : map.entrySet()) {
    if ("key_2".equals(entry.getKey())) {
      map.remove("key_2");
    }
  }
}
