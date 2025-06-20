@Test public void includeScanViaInputStreamSuppliedConfigFile() throws IOException, JoranException, InterruptedException {
assertNull(configurationWatchList.getMainURL());
assertFalse(reconfigureOnChangeFilter.isStarted());
}