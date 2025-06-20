/** 
 * This test case targets command stream created in {@link AbstractByteArrayCommandTransport#setup(Channel,CommandReceiver)}
 */
@Test public void transport_nio() throws Exception {
  setUp(new NioSocketRunner(){
    @Override protected NioChannelBuilder configureNorth(){
      return super.configureNorth().withClassFilter(new TestFilter());
    }
  }
);
  commandStreamTestSequence();
}
