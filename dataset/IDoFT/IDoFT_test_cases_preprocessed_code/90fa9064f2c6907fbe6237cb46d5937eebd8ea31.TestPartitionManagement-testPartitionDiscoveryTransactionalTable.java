@Test public void testPartitionDiscoveryTransactionalTable() throws TException, IOException, InterruptedException, ExecutionException {
assertEquals(3,partitions.size());
assertEquals(5,fs.listStatus(tablePath).length);
assertEquals(5,partitions.size());
assertEquals(0,PartitionManagementTask.getSkippedAttempts());
assertTrue(deleted);
assertEquals(4,fs.listStatus(tablePath).length);
ExecutorService executorService=Executors.newFixedThreadPool(3);
futures.add(executorService.submit(task));
future.get();
assertEquals(1,successAfter - successBefore);
assertEquals(2,skippedAfter - skippedBefore);
assertEquals(4,partitions.size());
}