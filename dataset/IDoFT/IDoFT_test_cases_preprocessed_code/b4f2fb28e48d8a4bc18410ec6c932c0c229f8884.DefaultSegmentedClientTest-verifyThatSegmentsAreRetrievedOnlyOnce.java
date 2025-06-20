@Test public void verifyThatSegmentsAreRetrievedOnlyOnce() throws Exception {
assertEquals(5,counter.count);
assertEquals(5,((MeasurableFace)face).sentInterests().size());
assertEquals("01234",stream.assemble().getContent().toString());
}