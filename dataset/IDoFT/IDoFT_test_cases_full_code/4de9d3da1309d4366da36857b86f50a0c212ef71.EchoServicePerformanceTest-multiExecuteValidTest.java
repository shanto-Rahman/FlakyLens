@Test public void multiExecuteValidTest() throws Exception {
  setUp(100,"hello","world");
  ExecutorService pool=Executors.newFixedThreadPool(100);
  List<Future<?>> futures=new ArrayList<Future<?>>(10000);
  for (int i=0; i < 10000; i++) {
    final EchoInfo echoInfo=EchoInfo.newBuilder().setMessage(i + "").build();
    final int order=i;
    Runnable runnable=new Runnable(){
      public void run(){
        try {
          EchoInfo echo=echoService.echo(echoInfo);
          Assert.assertEquals("hello:" + order,echo.getMessage());
        }
 catch (        Exception e) {
          e.printStackTrace();
        }
      }
    }
;
    Future<?> submit=pool.submit(runnable);
    futures.add(submit);
  }
  for (  Future<?> future : futures) {
    future.get();
  }
  pool.shutdown();
}
