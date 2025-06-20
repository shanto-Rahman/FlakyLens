@Test public void testDoGetConfigV3() throws Exception {
Assert.assertEquals(HttpServletResponse.SC_NOT_FOUND + "",actualValue);
Assert.assertEquals(HttpServletResponse.SC_CONFLICT + "",actualValue);
}