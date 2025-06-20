@Test public void testSyncMultSeriesReader() throws IOException, StorageEngineException {
assertTrue(reader.hasNextTimeValuePair(paths.get(0).getFullPath()));
assertEquals(i,pair.getTimestamp());
assertEquals(i * 1.0,pair.getValue().getDouble(),0.00001);
assertFalse(reader.hasNextTimeValuePair(paths.get(0).getFullPath()));
assertTrue(reader.hasNextTimeValuePair(paths.get(1).getFullPath()));
assertEquals(i,pair.getTimestamp());
assertEquals(i * 1.0,pair.getValue().getInt(),0.00001);
assertFalse(reader.hasNextTimeValuePair(paths.get(1).getFullPath()));
}