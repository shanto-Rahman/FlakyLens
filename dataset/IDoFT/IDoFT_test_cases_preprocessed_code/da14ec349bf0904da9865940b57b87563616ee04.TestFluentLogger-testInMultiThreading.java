@Test public void testInMultiThreading() throws Exception {
if (e.tag.equals(tag)) {
}
threadManager.submit(fluentd);//IT
ExecutorService executorService=Executors.newFixedThreadPool(N);
executorService.execute(new Runnable(){
  @Override public void run(){
    Map<String,Object> event=new HashMap<String,Object>();
    for (int j=0; j <= ii; j++) {
      event.put(String.valueOf(j),j);
    }
    for (int j=0; j < LOOP; j++) {
      logger.log(tag,event);
      if (j % 500 == ii)       logger.flush();
    }
    logger.flush();
  }
}
);
if (j % 500 == ii) logger.flush();
Thread.sleep(1000);
executorService.shutdown();
executorService.awaitTermination(300,TimeUnit.SECONDS);
Thread.sleep(2000);
threadManager.join();//IT
assertEquals((i * LOOP * (N - i)),(long)counters.get(i));
}