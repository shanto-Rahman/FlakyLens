@Test public void testCancelObservable() throws InterruptedException {
  System.out.println("testCancelObservable");
  for (int i=0; i < 50; i++) {
    long n=5000L;
    File pageFile=new File("target/cancelObs" + i + ".obj");
    pageFile.delete();
    byte[] bytes=new byte[40];
    Observable.just(bytes).repeat(n).to(com.github.davidmoten.rx2.observable.Transformers.onBackpressureBufferToFile().fileFactory(Callables.constant(pageFile)).pageSizeBytes(20000000).serializerBytes()).take(5).count().test().awaitDone(500L,TimeUnit.SECONDS).assertNoErrors().assertComplete().assertValue((long)5);
    long t=TimeUnit.SECONDS.toMillis(5);
    while (t > 0 && pageFile.exists()) {
      long waitMs=10;
      TimeUnit.MILLISECONDS.sleep(waitMs);
      t-=waitMs;
    }
    assertFalse(pageFile.exists());
  }
}
