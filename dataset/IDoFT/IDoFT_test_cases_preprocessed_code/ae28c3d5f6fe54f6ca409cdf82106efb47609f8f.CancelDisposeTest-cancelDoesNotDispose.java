@Test public void cancelDoesNotDispose(){
assertEquals(1,calls.size());
assertFalse(subscription.isUnsubscribed());
}