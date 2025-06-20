@Test public void responseThrowingInOnErrorDeliveredToPlugin(){
  server.enqueue(new MockResponse().setSocketPolicy(DISCONNECT_AFTER_REQUEST));
  final AtomicReference<Throwable> pluginRef=new AtomicReference<>();
  RxJavaPlugins.getInstance().registerErrorHandler(new RxJavaErrorHandler(){
    @Override public void handleError(    Throwable throwable){
      if (!pluginRef.compareAndSet(null,throwable)) {
        throw Exceptions.propagate(throwable);
      }
    }
  }
);
  RecordingSubscriber<Response<String>> observer=subscriberRule.create();
  final AtomicReference<Throwable> errorRef=new AtomicReference<>();
  final RuntimeException e=new RuntimeException();
  service.response().subscribe(new ForwardingObserver<Response<String>>(observer){
    @Override public void onError(    Throwable throwable){
      if (!errorRef.compareAndSet(null,throwable)) {
        throw Exceptions.propagate(throwable);
      }
      throw e;
    }
  }
);
  CompositeException composite=(CompositeException)pluginRef.get();
  assertThat(composite.getExceptions()).containsExactly(errorRef.get(),e);
}
