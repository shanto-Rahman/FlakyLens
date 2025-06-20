@Test public void testPartitionDiscoverySkipInvalidPath() throws TException, IOException, InterruptedException {
assertEquals(3,partitions.size());
assertEquals(5,fs.listStatus(tablePath).length);
assertEquals(4,partitions.size());
}