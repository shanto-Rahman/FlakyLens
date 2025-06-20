@Test public void testRowsPutBufferedOneFlush() throws IOException {
assertEquals(0,nbRows);
assertEquals(NB_BATCH_ROWS * 10,nbRows);
}