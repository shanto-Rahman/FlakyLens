@Test public void test_Localhost() throws Exception {
assertEquals("127.0.0.1",url.getHost());
assertTrue(url.isLocalHost());
assertEquals("127.0.1.1",url.getHost());
assertTrue(url.isLocalHost());
assertEquals("localhost",url.getHost());
assertTrue(url.isLocalHost());
}