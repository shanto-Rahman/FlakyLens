@Test public void testSimpleMap(){
assertEquals(2,map.size());
assertEquals("bar",map.get("foo"));
assertEquals(1L,((Number)map.get("spam")).longValue());
}