@Test public void testSimpleMimeDecodingWithPreamble() throws IOException {
Assert.assertTrue(parser.isComplete());
Assert.assertEquals(2,handler.parts.size());
Assert.assertEquals("Here is some text.",handler.parts.get(0).data.toString());
Assert.assertEquals("Here is some more text.",handler.parts.get(1).data.toString());
Assert.assertEquals("text/plain",handler.parts.get(0).map.getFirst(Headers.CONTENT_TYPE));
}