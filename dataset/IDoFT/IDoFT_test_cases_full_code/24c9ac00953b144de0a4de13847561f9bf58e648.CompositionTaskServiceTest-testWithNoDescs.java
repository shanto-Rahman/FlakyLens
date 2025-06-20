@Test public void testWithNoDescs() throws Throwable {
  CompositeDescription compositeDesc=createCompositeDesc();
  RequestBrokerState request=startRequest(compositeDesc);
  request=waitForTaskError(request.documentSelfLink,RequestBrokerState.class);
  assertNull(request.resourceLinks);
}
