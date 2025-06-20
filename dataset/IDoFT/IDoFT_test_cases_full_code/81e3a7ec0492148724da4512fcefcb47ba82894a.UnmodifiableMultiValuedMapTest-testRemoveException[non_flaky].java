public void testRemoveException(){
  final MultiValuedMap<K,V> map=makeFullMap();
  try {
    map.remove("one");
    fail();
  }
 catch (  final UnsupportedOperationException e) {
  }
  this.assertMapContainsAllValues(map);
}
