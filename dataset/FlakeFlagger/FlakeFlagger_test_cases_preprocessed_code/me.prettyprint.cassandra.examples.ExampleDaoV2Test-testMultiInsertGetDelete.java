@Test public void testMultiInsertGetDelete() throws HectorException {
assertNotNull(ret);
assertNull("value1",ret.get("key1"));
assertNotNull(ret);
assertEquals("value1",ret.get("key1"));
assertEquals("value2",ret.get("key2"));
assertNotNull(ret);
assertEquals("value2",ret.get("key2"));
assertNull(ret.get("key3"));
assertNull(ret.get("key1"));
assertNotNull(ret);
assertNull(ret.get("key1"));
assertNull(ret.get("key2"));
}