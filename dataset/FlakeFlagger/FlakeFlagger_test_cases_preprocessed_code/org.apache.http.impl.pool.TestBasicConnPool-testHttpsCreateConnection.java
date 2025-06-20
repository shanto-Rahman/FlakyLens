@Test public void testHttpsCreateConnection() throws Exception {
assertEquals(true,conn.isOpen());
assertEquals(100,conn.getSocketTimeout());
}