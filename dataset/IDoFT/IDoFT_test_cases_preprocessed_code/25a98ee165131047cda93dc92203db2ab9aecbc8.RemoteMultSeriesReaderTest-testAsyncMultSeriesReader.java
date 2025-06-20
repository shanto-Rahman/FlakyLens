@Test public void testAsyncMultSeriesReader() throws IOException, StorageEngineException {
assertTrue(reader.hasNextTimeValuePair(paths.get(0).getFullPath()));
assertEquals(i,pair.getTimestamp());
assertEquals(i * 1.0,pair.getValue().getDouble(),0.00001);
assertFalse(reader.hasNextTimeValuePair(paths.get(0).getFullPath()));
}