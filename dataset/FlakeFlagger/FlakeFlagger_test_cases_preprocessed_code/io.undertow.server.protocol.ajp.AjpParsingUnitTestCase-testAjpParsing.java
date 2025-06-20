@Test public void testAjpParsing() throws IOException {
Assert.assertEquals(165,state.dataSize);
Assert.assertTrue(state.isComplete());
Assert.assertEquals(0,buffer.remaining());
}