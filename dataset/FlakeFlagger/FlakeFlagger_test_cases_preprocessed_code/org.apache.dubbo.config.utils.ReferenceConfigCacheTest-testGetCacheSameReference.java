@Test public void testGetCacheSameReference() throws Exception {
assertTrue(config.isGetMethodRun());
assertEquals("0",value);
assertFalse(configCopy.isGetMethodRun());
assertEquals("0",value);
}