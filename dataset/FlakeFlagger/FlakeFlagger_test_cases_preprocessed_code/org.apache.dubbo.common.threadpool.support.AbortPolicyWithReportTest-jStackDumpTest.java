@Test public void jStackDumpTest() throws InterruptedException {
abortPolicyWithReport.rejectedExecution(new Runnable(){
  @Override public void run(){
    System.out.println("hello");
  }
}
,(ThreadPoolExecutor)Executors.newFixedThreadPool(1));
Thread.sleep(1000);
}