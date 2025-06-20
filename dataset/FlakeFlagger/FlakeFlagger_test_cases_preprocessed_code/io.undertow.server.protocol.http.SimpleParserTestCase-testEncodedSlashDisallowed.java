@Test public void testEncodedSlashDisallowed(){
Assert.assertSame(Methods.GET,result.getRequestMethod());
Assert.assertEquals("/somepath%2FotherPath",result.getRequestURI());
Assert.assertEquals("/somepath%2FotherPath",result.getRequestPath());
}