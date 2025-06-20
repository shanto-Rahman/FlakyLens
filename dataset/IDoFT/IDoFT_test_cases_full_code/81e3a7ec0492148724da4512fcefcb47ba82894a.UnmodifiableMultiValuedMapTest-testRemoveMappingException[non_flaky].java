public void testRemoveMappingException(){
  final MultiValuedMap<K,V> map=makeFullMap();
  try {
    map.removeMapping("one","uno");
    fail();
  }
 catch (  final UnsupportedOperationException e) {
  }
  this.assertMapContainsAllValues(map);
}
