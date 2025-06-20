@Test public void repoMarkerExistOnClose() throws Exception {
  File rootFolder=folder.newFolder();
  dataStore=getBlobStore(rootFolder);
  String repoId=UUID.randomUUID().toString();
  dataStore.setRepositoryId(repoId);
  assertEquals(repoId,dataStore.getRepositoryId());
  assertNotNull(dataStore.getMetadataRecord(SharedStoreRecordType.REPOSITORY.getNameFromId(repoId)));
  assertNotNull(FileUtils.getFile(new File(rootFolder,"repository/datastore"),SharedStoreRecordType.REPOSITORY.getNameFromId(repoId)));
  dataStore.close();
  dataStore=getBlobStore(rootFolder);
  assertNotNull(dataStore.getMetadataRecord(SharedStoreRecordType.REPOSITORY.getNameFromId(repoId)));
}
