/** 
 * More threads than the pool size.
 */
@Test public void testMultiThread() throws Exception {
ready.countDown();
in.await();
used.incrementAndGet();
ExecutorService service=Executors.newFixedThreadPool(20);
results[i]=service.submit(task);
ready.await(120,TimeUnit.SECONDS);
in.countDown();
result.get(5,TimeUnit.SECONDS);
service.shutdown();
assertEquals(20,used.intValue());
assertEquals(10,MockBean.getPostConstructs());
assertEquals(10,MockBean.getPreDestroys());
}