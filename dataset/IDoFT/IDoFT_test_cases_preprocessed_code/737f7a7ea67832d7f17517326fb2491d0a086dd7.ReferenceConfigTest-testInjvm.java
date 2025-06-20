@Test public void testInjvm() throws Exception {
Assert.assertTrue(!Constants.LOCAL_PROTOCOL.equalsIgnoreCase(rc.getInvoker().getUrl().getProtocol()));
}