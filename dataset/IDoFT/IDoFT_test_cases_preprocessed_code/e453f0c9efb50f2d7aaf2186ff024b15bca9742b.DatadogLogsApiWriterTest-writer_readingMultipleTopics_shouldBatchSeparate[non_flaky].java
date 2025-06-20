@Test public void writer_readingMultipleTopics_shouldBatchSeparate() throws IOException {
Assert.assertEquals(2,restHelper.getCapturedRequests().size());
Assert.assertEquals(requestBodySetExpected,requestBodySetActual);
}