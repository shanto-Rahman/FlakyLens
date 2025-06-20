@Test public void testHttpCreateEntry() throws Exception {
assertEquals(conn,entry.getConnection());
assertEquals("localhost",entry.getRoute().getHostName());
}