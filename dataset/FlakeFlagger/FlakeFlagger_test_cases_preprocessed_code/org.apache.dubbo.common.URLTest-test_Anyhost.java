@Test public void test_Anyhost() throws Exception {
assertEquals("0.0.0.0",url.getHost());
assertTrue(url.isAnyHost());
}