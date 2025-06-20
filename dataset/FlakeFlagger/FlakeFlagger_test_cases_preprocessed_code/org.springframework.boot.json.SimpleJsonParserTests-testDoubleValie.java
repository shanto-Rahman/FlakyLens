@Test public void testDoubleValie(){
assertEquals(2,map.size());
assertEquals("bar",map.get("foo"));
assertEquals(1.23d,map.get("spam"));
}