@Test public void bodyThrowingInOnErrorDeliveredToPlugin(){
  server.enqueue(new MockResponse().setResponseCode(404));
  final AtomicReference<Throwable> pluginRef=new AtomicReference<>();
  RxJavaPlugins.getInstance().registerErrorHandler(new RxJavaErrorHandler(){
    @Override public void handleError(    Throwable throwable){
      if (!pluginRef.compareAndSet(null,throwable)) {
        throw Exceptions.propagate(throwable);
      }
    }
  }
);
  RecordingSubscriber<Void> observer=subscriberRule.create();
  final RuntimeException e=new RuntimeException();
  final AtomicReference<Throwable> errorRef=new AtomicReference<>();
  service.completable().unsafeSubscribe(new ForwardingCompletableObserver(observer){
    @Override public void onError(    Throwable throwable){
      errorRef.set(throwable);
      throw e;
    }
  }
);
  CompositeException composite=(CompositeException)pluginRef.get();
  assertThat(composite.getExceptions()).containsExactly(errorRef.get(),e);
}
