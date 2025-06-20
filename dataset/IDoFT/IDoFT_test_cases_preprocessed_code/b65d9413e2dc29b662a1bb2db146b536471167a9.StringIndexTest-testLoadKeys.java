@Test public void testLoadKeys(){
Helper.removeDir(new File(location));//RO
assertEquals(2,index.getKeys().size());
assertEquals("[, c, a, b]",index.getKeys().toString());
assertTrue(index.loadExisting());
assertEquals("[, c, a, b]",index.getKeys().toString());
assertEquals("test value",index.get(pointerA,"c"));
assertNull(index.get(pointerA,"b"));
assertNull(index.get(pointerB,""));
assertEquals("value",index.get(pointerB,"a"));
assertEquals("another value",index.get(pointerB,"b"));
assertEquals("{a=value, b=another value}",index.getAll(pointerB).toString());
Helper.removeDir(new File(location));//RO
}