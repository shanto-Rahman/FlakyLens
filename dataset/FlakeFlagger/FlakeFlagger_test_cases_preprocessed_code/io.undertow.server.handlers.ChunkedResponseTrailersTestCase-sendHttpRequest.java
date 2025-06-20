@Test public void sendHttpRequest() throws Exception {
if (entity != null) {
if (instream instanceof ChunkedInputStream) {
}
}
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals(message,HttpClientUtils.readResponse(result));//RW
Assert.assertEquals(2,footers.length);
if (header.getName().equals("foo")) {
Assert.assertEquals("fooVal",header.getValue());
if (header.getName().equals("bar")) {
Assert.assertEquals("barVal",header.getValue());
Assert.fail("Unknown header" + header);
}
}
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals(message,HttpClientUtils.readResponse(result));//RW
Assert.assertEquals(2,footers.length);
if (header.getName().equals("foo")) {
Assert.assertEquals("fooVal",header.getValue());
if (header.getName().equals("bar")) {
Assert.assertEquals("barVal",header.getValue());
Assert.fail("Unknown header" + header);
}
}
}