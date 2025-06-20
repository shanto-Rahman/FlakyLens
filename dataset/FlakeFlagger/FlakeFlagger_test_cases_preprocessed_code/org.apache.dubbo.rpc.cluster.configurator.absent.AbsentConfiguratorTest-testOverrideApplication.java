@Test public void testOverrideApplication(){
Assert.assertEquals("200",url.getParameter("timeout"));
Assert.assertEquals("1000",url.getParameter("timeout"));
Assert.assertNull(url.getParameter("timeout"));
Assert.assertEquals("1000",url.getParameter("timeout"));
}