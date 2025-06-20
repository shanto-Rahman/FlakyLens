@Test public void testHttpOnlyWorks() throws Exception {
assertEquals(true,cookieCaptor.getValue().isHttpOnly());
}