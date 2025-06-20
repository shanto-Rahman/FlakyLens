@Test public void testStore() throws Exception {
assertEquals(0,map.size());
assertEquals(2,map.size());
assertEquals("value1",impl.getValue("key1"));
assertEquals("value2",impl.getValue("key2"));
assertEquals(map.get("key1"),impl.getValue("key1"));
assertEquals("value1-2",impl.getValue("key1"));
assertEquals(2,map.size());
assertEquals(largeValue,impl.getValue("key3"));
}