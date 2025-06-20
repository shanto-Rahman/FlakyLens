@Test public void testNoHttpsOnlyWorks() throws Exception {
assertEquals(false,cookieCaptor.getValue().isSecure());
}