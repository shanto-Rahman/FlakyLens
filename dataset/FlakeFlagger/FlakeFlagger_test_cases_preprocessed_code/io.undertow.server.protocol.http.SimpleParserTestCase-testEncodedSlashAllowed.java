@Test public void testEncodedSlashAllowed(){
Assert.assertSame(Methods.GET,result.getRequestMethod());
Assert.assertEquals("/somepath/otherPath",result.getRequestPath());
Assert.assertEquals("/somepath%2fotherPath",result.getRequestURI());
}