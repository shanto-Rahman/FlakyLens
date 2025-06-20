@Test public void testPutGet() throws Exception {
assertNull(dataStore.get("xxx","yyy"));
assertEquals("1",dataStore.get("name","key"));
assertNull(dataStore.get("xxx","yyy"));
}