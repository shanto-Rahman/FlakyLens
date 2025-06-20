@Test public void testReliableSubscriptionsAfterDocumentOwnerChange() throws Throwable {
  final int runningHosts=cluster.getPeerCount() - 1;
  AtomicInteger counter=new AtomicInteger();
  cluster.getInProcessHostMap().values().forEach((h) -> {
    subscribe(h,this.exampleState,(notification) -> {
      String documentLink=notification.getResult().documentSelfLink;
      if (notification.isDelete()) {
        cluster.log(Level.INFO,String.format("Delete notification received for %s. Ignoring (waiting for updates).",documentLink));
      }
      if (notification.isUpdate()) {
        cluster.log(Level.INFO,String.format("Update notification received for %s. Counting down.",documentLink));
        counter.incrementAndGet();
      }
    }
);
  }
);
  String oldOwner=this.exampleState.documentOwner;
  stopOwnerNode(this.exampleState);
  waitForOwnerChange(oldOwner,this.exampleState.documentSelfLink);
  this.exampleState=getDocument(exampleState.documentSelfLink);
  Assert.assertNotEquals(oldOwner,this.exampleState.documentOwner);
  this.cluster.log(Level.INFO,"New owner is %s",this.exampleState.documentOwner);
  this.exampleState=patchDocument(this.exampleState.documentSelfLink);
  TestContext waiter=new TestContext(1,Duration.ofSeconds(NOTIFICATION_TIMEOUT_SECONDS));
  waitFor(() -> {
    cluster.log("Waiting for notifications, currently got: %d",counter.get());
    if (counter.get() == runningHosts) {
      return true;
    }
    return false;
  }
,waiter);
}
