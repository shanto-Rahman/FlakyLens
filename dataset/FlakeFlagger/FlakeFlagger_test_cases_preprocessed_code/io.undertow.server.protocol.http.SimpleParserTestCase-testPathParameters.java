@Test public void testPathParameters(){
Assert.assertSame(Methods.GET,result.getRequestMethod());
Assert.assertEquals("/somepath",result.getRequestPath());
Assert.assertEquals("/somepath;p1",result.getRequestURI());
Assert.assertTrue(result.getPathParameters().containsKey("p1"));
Assert.assertSame(Methods.GET,result.getRequestMethod());
Assert.assertEquals("/somepath",result.getRequestPath());
Assert.assertEquals("/somepath;p1=v1&p2=v2",result.getRequestURI());
Assert.assertEquals("q1=v3",result.getQueryString());
Assert.assertEquals("v1",result.getPathParameters().get("p1").getFirst());
Assert.assertEquals("v2",result.getPathParameters().get("p2").getFirst());
Assert.assertEquals("v3",result.getQueryParameters().get("q1").getFirst());
}