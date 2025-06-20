public void testRemoveMappingException(){
  final MultiValuedMap<K,V> map=makeFullMap();
  try {
    map.removeMapping("one","uno");
    fail();
  }
 catch (  final UnsupportedOperationException e) {
  }
  assertEquals("{one=[uno, un], two=[dos, deux], three=[tres, trois]}",map.toString());
}
