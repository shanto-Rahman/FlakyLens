@Test public void testRewrite() throws IOException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("URI: /relative/foo?bar=a&woz=b relative: /foo QS:?bar=a&woz=b bar: a woz: b",response);
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("URI: /otherPath/foo/a/b relative: /foo/a/b QS:",response);
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("URI: /otherPath/foo relative: /foo QS:a=b a: b",response);
}