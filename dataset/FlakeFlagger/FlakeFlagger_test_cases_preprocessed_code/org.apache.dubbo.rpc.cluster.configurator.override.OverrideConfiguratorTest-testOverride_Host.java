@Test public void testOverride_Host(){
Assert.assertEquals("200",url.getParameter("timeout"));
Assert.assertEquals("200",url.getParameter("timeout"));
Assert.assertNull(url.getParameter("timeout"));
Assert.assertEquals("1000",url.getParameter("timeout"));
}