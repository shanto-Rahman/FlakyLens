@Test public void testAddMultipleGet(){
  String prefix="p";
  String uri="aadsad";
  impl.add(prefix,uri);
  String prefix2="z";
  impl.add(prefix2,uri);
  String prefix3="y";
  String uri3="aadsad2121";
  impl.add(prefix3,uri3);
  assertEquals(uri3,impl.getNamespaceURI(prefix3));
  assertEquals(prefix,impl.getPrefix(uri));
  int i=0;
  Iterator<String> iter=impl.getPrefixes(uri);
  while (iter.hasNext()) {
    i++;
    String prefixValue=iter.next();
    assertTrue(prefixValue.equals(prefix) || prefixValue.equals(prefix2));
  }
  assertEquals(2,i);
}
