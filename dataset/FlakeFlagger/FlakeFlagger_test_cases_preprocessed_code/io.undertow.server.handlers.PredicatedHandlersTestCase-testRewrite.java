@Test public void testRewrite() throws IOException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("get",result.getHeaders("type")[0].getValue());
Assert.assertEquals("always",result.getHeaders("someHeader")[0].getValue());
Assert.assertEquals("a",result.getHeaders("template")[0].getValue());
Assert.assertEquals("/foo/a/b",response);
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("get",result.getHeaders("type")[0].getValue());
Assert.assertEquals("always",result.getHeaders("someHeader")[0].getValue());
Assert.assertEquals("a",result.getHeaders("template")[0].getValue());
Assert.assertEquals("/foo/a/b.xcss",response);
}