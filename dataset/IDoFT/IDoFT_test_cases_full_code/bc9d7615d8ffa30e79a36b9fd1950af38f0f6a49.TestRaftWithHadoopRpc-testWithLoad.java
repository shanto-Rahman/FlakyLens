@Override @Test public void testWithLoad() throws Exception {
  super.testWithLoad();
  BlockRequestHandlingInjection.getInstance().unblockAll();
}
