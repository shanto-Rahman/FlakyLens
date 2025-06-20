@Test public void testAddMultipleGet(){
assertEquals(uri3,impl.getNamespaceURI(prefix3));
assertEquals(prefix,impl.getPrefix(uri));
assertTrue(prefixValue.equals(prefix) || prefixValue.equals(prefix2));
assertEquals(2,i);
}