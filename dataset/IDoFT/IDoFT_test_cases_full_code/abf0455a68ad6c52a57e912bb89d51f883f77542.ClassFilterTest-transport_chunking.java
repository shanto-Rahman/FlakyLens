/** 
 * This test case targets command stream created in {@link AbstractSynchronousByteArrayCommandTransport#read()}, which is used by  {@link ChunkedCommandTransport}.
 */
@Test public void transport_chunking() throws Exception {
  setUp();
  commandStreamTestSequence();
}
