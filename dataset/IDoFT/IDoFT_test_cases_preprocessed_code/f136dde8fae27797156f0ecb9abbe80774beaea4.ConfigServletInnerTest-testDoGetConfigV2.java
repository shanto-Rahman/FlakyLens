@Test public void testDoGetConfigV2() throws Exception {
Assert.assertEquals(HttpServletResponse.SC_OK + "",actualValue);
Assert.assertEquals("tag is blank and direct read is true",response.getContentAsString());
Assert.assertEquals(HttpServletResponse.SC_OK + "",actualValue);
Assert.assertEquals("",response.getContentAsString());
Assert.assertEquals(HttpServletResponse.SC_OK + "",actualValue);
Assert.assertEquals("tag is not blank and direct read is true",response.getContentAsString());
Assert.assertEquals(HttpServletResponse.SC_OK + "",actualValue);
Assert.assertEquals("",response.getContentAsString());
Assert.assertEquals(HttpServletResponse.SC_OK + "",actualValue);
Assert.assertEquals("auto tag mode and direct read is true",response.getContentAsString());
Assert.assertEquals(HttpServletResponse.SC_OK + "",actualValue);
Assert.assertEquals("",response.getContentAsString());
}