@Test public void testNoHttpOnlyWorks() throws Exception {
assertEquals(false,cookieCaptor.getValue().isHttpOnly());
}