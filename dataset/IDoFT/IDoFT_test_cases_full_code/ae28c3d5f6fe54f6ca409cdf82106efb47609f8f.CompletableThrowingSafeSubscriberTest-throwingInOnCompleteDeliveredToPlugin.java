@Test public void throwingInOnCompleteDeliveredToPlugin(){
  server.enqueue(new MockResponse());
  final AtomicReference<Throwable> pluginRef=new AtomicReference<>();
  RxJavaPlugins.getInstance().registerErrorHandler(new RxJavaErrorHandler(){
    @Override public void handleError(    Throwable throwable){
      if (throwable instanceof OnCompletedFailedException) {
        if (!pluginRef.compareAndSet(null,throwable)) {
          throw Exceptions.propagate(throwable);
        }
      }
    }
  }
);
  RecordingSubscriber<Void> observer=subscriberRule.create();
  final RuntimeException e=new RuntimeException();
  service.completable().subscribe(new ForwardingCompletableObserver(observer){
    @Override public void onCompleted(){
      throw e;
    }
  }
);
  assertThat(pluginRef.get().getCause()).isSameAs(e);
}
