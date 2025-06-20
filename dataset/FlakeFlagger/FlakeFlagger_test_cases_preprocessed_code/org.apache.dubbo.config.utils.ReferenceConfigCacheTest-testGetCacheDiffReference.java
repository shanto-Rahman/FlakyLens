@Test public void testGetCacheDiffReference() throws Exception {
assertTrue(config.isGetMethodRun());
assertEquals("0",value);
assertTrue(configCopy.isGetMethodRun());
assertEquals("1",value);
}