@Test public void testReloadModelCall() throws Exception {
status.set(sc);
assertEquals(Integer.valueOf(HttpServletResponse.SC_OK),status.get());
}