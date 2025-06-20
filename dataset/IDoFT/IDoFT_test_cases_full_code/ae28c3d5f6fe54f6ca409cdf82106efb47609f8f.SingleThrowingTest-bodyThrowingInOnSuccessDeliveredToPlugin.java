@Test public void bodyThrowingInOnSuccessDeliveredToPlugin(){
  server.enqueue(new MockResponse());
  final AtomicReference<Throwable> pluginRef=new AtomicReference<>();
  RxJavaPlugins.getInstance().registerErrorHandler(new RxJavaErrorHandler(){
    @Override public void handleError(    Throwable throwable){
      if (!pluginRef.compareAndSet(null,throwable)) {
        throw Exceptions.propagate(throwable);
      }
    }
  }
);
  RecordingSubscriber<String> observer=subscriberRule.create();
  final RuntimeException e=new RuntimeException();
  service.body().subscribe(new ForwardingObserver<String>(observer){
    @Override public void onSuccess(    String value){
      throw e;
    }
  }
);
  assertThat(pluginRef.get()).isSameAs(e);
}
