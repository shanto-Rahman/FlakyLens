@Test public void testBase64MimeDecodingWithSmallBuffers() throws IOException {
Assert.assertTrue(parser.isComplete());
Assert.assertEquals(2,handler.parts.size());
Assert.assertEquals("This is some base64 text.",handler.parts.get(0).data.toString());
Assert.assertEquals("This is some more base64 text.",handler.parts.get(1).data.toString());
Assert.assertEquals("text/plain",handler.parts.get(0).map.getFirst(Headers.CONTENT_TYPE));
}