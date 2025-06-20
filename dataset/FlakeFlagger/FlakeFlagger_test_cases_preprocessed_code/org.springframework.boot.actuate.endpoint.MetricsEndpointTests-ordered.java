@Test public void ordered(){
assertEquals("a",iterator.next().getKey());
assertEquals("b",iterator.next().getKey());
assertEquals("c",iterator.next().getKey());
assertFalse(iterator.hasNext());
}