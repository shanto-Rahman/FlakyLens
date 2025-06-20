@Test public void testHttpCreateConnection() throws Exception {
assertEquals(true,conn.isOpen());
assertEquals(100,conn.getSocketTimeout());
}