@Test public void schedulerHelperIsSynchronized() throws Exception {
Thread.sleep(40);
final ExecutorService service=Executors.newFixedThreadPool(5);
period.set(period.get() + 30);
service.execute(new Runnable(){
  public void run(){
    helper.scheduleWithPeriod(period.get(),TimeUnit.MILLISECONDS);
  }
}
);
helper.scheduleWithPeriod(period.get(),TimeUnit.MILLISECONDS);
Thread.sleep(400);
service.shutdown();
}