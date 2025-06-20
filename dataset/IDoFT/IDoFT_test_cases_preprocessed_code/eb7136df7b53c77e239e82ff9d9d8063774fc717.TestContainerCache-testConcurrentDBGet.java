@Test public void testConcurrentDBGet() throws Exception {
File root=new File(testRoot);//RO//RW
Assert.assertEquals(0,cache.size());
File containerDir=new File(root,"cont1");
ExecutorService executorService=Executors.newFixedThreadPool(2);
Assert.assertNotNull(db1);
Assert.fail("Should get the DB instance");
futureList.add(executorService.submit(task));
futureList.add(executorService.submit(task));
future.get();
Assert.fail("Should get the DB instance");
Assert.assertEquals(1,cache.size());
}