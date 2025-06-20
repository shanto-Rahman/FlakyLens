@Test public void testQueryParams(){
Assert.assertEquals("/somepath",result.getRelativePath());
Assert.assertEquals("http://www.somehost.net/somepath",result.getRequestURI());
Assert.assertEquals("a=b&b=c&d&e&f=",result.getQueryString());
Assert.assertEquals("b",result.getQueryParameters().get("a").getFirst());
Assert.assertEquals("c",result.getQueryParameters().get("b").getFirst());
Assert.assertEquals("",result.getQueryParameters().get("d").getFirst());
Assert.assertEquals("",result.getQueryParameters().get("e").getFirst());
Assert.assertEquals("",result.getQueryParameters().get("f").getFirst());
}