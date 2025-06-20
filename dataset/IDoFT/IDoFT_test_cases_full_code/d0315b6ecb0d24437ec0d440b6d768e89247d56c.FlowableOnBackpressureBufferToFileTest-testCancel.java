@Test public void testCancel() throws InterruptedException {
  System.out.println("testCancel");
  for (int i=0; i < 50; i++) {
    long n=5000L;
    File pageFile=new File("target/cancel" + i + ".obj");
    pageFile.delete();
    byte[] bytes=new byte[40];
    Flowables.repeat(bytes,n).compose(Transformers.onBackpressureBufferToFile().fileFactory(Callables.constant(pageFile)).pageSizeBytes(20000000).serializerBytes()).take(5).count().test().awaitDone(500L,TimeUnit.SECONDS).assertNoErrors().assertComplete().assertValue((long)5);
    long t=TimeUnit.SECONDS.toMillis(5);
    while (t > 0 && pageFile.exists()) {
      long waitMs=10;
      TimeUnit.MILLISECONDS.sleep(waitMs);
      t-=waitMs;
    }
    assertFalse(pageFile.exists());
  }
}
