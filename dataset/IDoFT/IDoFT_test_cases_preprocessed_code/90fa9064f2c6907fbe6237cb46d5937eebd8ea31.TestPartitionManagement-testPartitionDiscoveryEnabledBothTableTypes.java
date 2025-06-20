@Test public void testPartitionDiscoveryEnabledBothTableTypes() throws TException, IOException {
assertEquals(3,partitions.size());
assertEquals(5,fs.listStatus(tablePath).length);
assertEquals(3,partitions.size());
assertEquals(5,partitions.size());
assertTrue(deleted);
assertEquals(4,fs.listStatus(tablePath).length);
assertEquals(4,partitions.size());
assertTrue(deleted);
assertEquals(3,fs.listStatus(tablePath).length);
assertEquals(4,partitions.size());
assertEquals(4,partitions.size());
assertEquals(3,partitions.size());
}