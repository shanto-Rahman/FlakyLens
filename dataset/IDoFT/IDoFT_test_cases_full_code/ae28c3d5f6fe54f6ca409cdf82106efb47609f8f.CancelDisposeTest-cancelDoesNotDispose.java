@Test public void cancelDoesNotDispose(){
  Subscription subscription=service.go().subscribe();
  List<Call> calls=client.dispatcher().runningCalls();
  assertEquals(1,calls.size());
  calls.get(0).cancel();
  assertFalse(subscription.isUnsubscribed());
}
