@Test public void testPartitionDiscoveryTablePattern() throws TException, IOException {
assertEquals(3,partitions.size());
assertEquals(5,fs.listStatus(tablePath).length);
assertEquals(3,partitions.size());
assertEquals(5,partitions.size());
}