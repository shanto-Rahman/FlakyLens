@Test public void testCreateInvalid(){
  ExtensibilitySubscription state=createExtensibilityState();
  state.task=null;
  Operation op=Operation.createPost(host,ExtensibilitySubscriptionService.FACTORY_LINK).setBody(state);
  FailureResponse failure=sender.sendAndWaitFailure(op);
  assertNotNull(failure);
}
