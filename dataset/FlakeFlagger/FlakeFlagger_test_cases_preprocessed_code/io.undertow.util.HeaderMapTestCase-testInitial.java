@Test public void testInitial(){
assertEquals(0,headerMap.size());
assertEquals(-1L,headerMap.fastIterate());
assertFalse(headerMap.iterator().hasNext());
}