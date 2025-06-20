@Test public void testThatCookieSavingAndInitingWorks(){
assertEquals("value1",sessionCookie2.get("key1"));
assertEquals("value2",sessionCookie2.get("key2"));
assertEquals("value3",sessionCookie2.get("key3"));
}