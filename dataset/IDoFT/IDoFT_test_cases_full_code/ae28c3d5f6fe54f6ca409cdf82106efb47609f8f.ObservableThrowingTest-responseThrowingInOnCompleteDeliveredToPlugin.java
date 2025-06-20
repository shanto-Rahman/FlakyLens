@Test public void responseThrowingInOnCompleteDeliveredToPlugin(){
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
  RecordingSubscriber<Response<String>> observer=subscriberRule.create();
  final RuntimeException e=new RuntimeException();
  service.response().unsafeSubscribe(new ForwardingSubscriber<Response<String>>(observer){
    @Override public void onCompleted(){
      throw e;
    }
  }
);
  observer.assertAnyValue();
  assertThat(pluginRef.get()).isSameAs(e);
}
