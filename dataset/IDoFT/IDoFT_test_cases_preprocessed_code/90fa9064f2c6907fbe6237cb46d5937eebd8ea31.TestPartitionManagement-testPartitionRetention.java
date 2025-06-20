@Test public void testPartitionRetention() throws TException, IOException, InterruptedException {
assertEquals(3,partitions.size());
assertEquals(5,fs.listStatus(tablePath).length);
assertEquals(5,partitions.size());
Thread.sleep(30 * 1000);
assertEquals(0,partitions.size());
}