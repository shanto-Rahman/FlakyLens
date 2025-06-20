@Test public void testMultManagerMergeRemoteSeriesReader() throws IOException, StorageEngineException {
assertEquals(true,assignPathManagedMergeReader.hasNextTimeValuePair());
assertEquals(i,pair.getTimestamp());
assertEquals(i * 1.0,pair.getValue().getDouble(),0.00001);
assertEquals(false,assignPathManagedMergeReader.hasNextTimeValuePair());
}