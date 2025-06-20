@Test public void testRefsAvailableAllRepos() throws Exception {
  File rootFolder=folder.newFolder();
  dataStore=getBlobStore(rootFolder);
  loadData(true);
  Assert.assertTrue(SharedDataStoreUtils.refsNotAvailableFromRepos(dataStore.getAllMetadataRecords(SharedStoreRecordType.REPOSITORY.getType()),dataStore.getAllMetadataRecords(SharedStoreRecordType.REFERENCES.getType())).isEmpty());
}
