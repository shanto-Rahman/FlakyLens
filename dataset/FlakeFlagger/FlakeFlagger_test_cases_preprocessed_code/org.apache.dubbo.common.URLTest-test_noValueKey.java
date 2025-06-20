@Test public void test_noValueKey() throws Exception {
assertTrue(url.hasParameter("k0"));
assertEquals("k0",url.getParameter("k0"));
}