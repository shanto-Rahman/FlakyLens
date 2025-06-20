@Test public void testDubboMultiThreadInvoke() throws Exception {
Assert.assertEquals(service.getSize(new String[]{"123","456","789"}),3);
Assert.assertEquals(sb.toString(),service.echo(sb.toString()));
ExecutorService exec=Executors.newFixedThreadPool(10);
exec.execute(new Runnable(){
  public void run(){
    for (int i=0; i < 30; i++) {
      System.out.println(fi + ":" + counter.getAndIncrement());
      Assert.assertEquals(service.echo(sb.toString()),sb.toString());
    }
  }
}
);
System.out.println(fi + ":" + counter.getAndIncrement());
Assert.assertEquals(service.echo(sb.toString()),sb.toString());
exec.shutdown();
exec.awaitTermination(10,TimeUnit.SECONDS);
}