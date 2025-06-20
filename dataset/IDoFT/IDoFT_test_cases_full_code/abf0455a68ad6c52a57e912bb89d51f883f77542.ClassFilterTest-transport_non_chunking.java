/** 
 * This test case targets command stream created in {@link ChannelBuilder#makeTransport(InputStream,OutputStream,Mode,Capability)}by not having the chunking capability.
 */
@Test public void transport_non_chunking() throws Exception {
  setUpWithNoCapacity();
  commandStreamTestSequence();
}
