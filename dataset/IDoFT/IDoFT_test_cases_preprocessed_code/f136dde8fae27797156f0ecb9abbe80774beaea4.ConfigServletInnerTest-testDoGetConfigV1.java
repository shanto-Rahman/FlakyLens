@Test public void testDoGetConfigV1() throws Exception {
Assert.assertEquals(HttpServletResponse.SC_OK + "",actualValue);
Assert.assertEquals("true",response.getHeader("isBeta"));
Assert.assertEquals("isBeta:true, direct read: true",response.getContentAsString());
Assert.assertEquals(HttpServletResponse.SC_OK + "",actualValue);
Assert.assertEquals("true",response.getHeader("isBeta"));
Assert.assertEquals("",response.getContentAsString());
}