@Test public void testHttpsOnlyWorks() throws Exception {
assertEquals(true,cookieCaptor.getValue().isSecure());
}