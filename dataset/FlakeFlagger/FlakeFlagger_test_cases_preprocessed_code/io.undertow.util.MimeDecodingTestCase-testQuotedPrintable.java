@Test public void testQuotedPrintable() throws IOException {
Assert.assertTrue(parser.isComplete());
Assert.assertEquals(1,handler.parts.size());
Assert.assertEquals("time=money.",handler.parts.get(0).data.toString());
Assert.assertEquals("text/plain",handler.parts.get(0).map.getFirst(Headers.CONTENT_TYPE));
}