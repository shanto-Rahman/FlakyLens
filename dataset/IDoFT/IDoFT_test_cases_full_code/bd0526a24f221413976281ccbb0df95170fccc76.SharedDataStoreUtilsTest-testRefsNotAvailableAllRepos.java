@Test public void testRefsNotAvailableAllRepos() throws Exception {
  File rootFolder=folder.newFolder();
  dataStore=getBlobStore(rootFolder);
  Data data=loadData(true);
  String expectedMissingRepoId=data.repoIds.get(data.repoIds.size() - 1);
  dataStore.deleteAllMetadataRecords(SharedStoreRecordType.REFERENCES.getNameFromId(expectedMissingRepoId));
  Set<String> missingRepoIds=SharedDataStoreUtils.refsNotAvailableFromRepos(dataStore.getAllMetadataRecords(SharedStoreRecordType.REPOSITORY.getType()),dataStore.getAllMetadataRecords(SharedStoreRecordType.REFERENCES.getType()));
  assertEquals(Sets.newHashSet(expectedMissingRepoId),missingRepoIds);
}
