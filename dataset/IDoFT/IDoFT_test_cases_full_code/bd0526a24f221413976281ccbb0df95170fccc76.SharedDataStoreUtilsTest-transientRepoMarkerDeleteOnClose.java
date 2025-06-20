@Test public void transientRepoMarkerDeleteOnClose() throws Exception {
  System.setProperty("oak.datastore.sharedTransient","true");
  try {
    File rootFolder=folder.newFolder();
    dataStore=getBlobStore(rootFolder);
    String repoId=UUID.randomUUID().toString();
    dataStore.setRepositoryId(repoId);
    assertEquals(repoId,dataStore.getRepositoryId());
    assertNotNull(dataStore.getMetadataRecord(SharedStoreRecordType.REPOSITORY.getNameFromId(repoId)));
    assertNotNull(FileUtils.getFile(new File(rootFolder,"repository/datastore"),SharedStoreRecordType.REPOSITORY.getNameFromId(repoId)));
    dataStore.close();
    dataStore=getBlobStore(rootFolder);
    assertNull(dataStore.getMetadataRecord(SharedStoreRecordType.REPOSITORY.getNameFromId(repoId)));
  }
  finally {
    System.clearProperty("oak.datastore.sharedTransient");
  }
}
