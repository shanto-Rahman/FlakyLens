@Test public void testReloadCacheCall() throws Exception {
status.set(sc);
assertEquals(Integer.valueOf(HttpServletResponse.SC_OK),status.get());
}