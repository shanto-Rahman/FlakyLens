public void testRemoveException(){
  final MultiValuedMap<K,V> map=makeFullMap();
  try {
    map.remove("one");
    fail();
  }
 catch (  final UnsupportedOperationException e) {
  }
  assertEquals("{one=[uno, un], two=[dos, deux], three=[tres, trois]}",map.toString());
}
