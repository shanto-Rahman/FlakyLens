@Test public void repoMarkerExistOnClose() throws Exception {
assertEquals(repoId,dataStore.getRepositoryId());
assertNotNull(dataStore.getMetadataRecord(SharedStoreRecordType.REPOSITORY.getNameFromId(repoId)));
assertNotNull(FileUtils.getFile(new File(rootFolder,"repository/datastore"),SharedStoreRecordType.REPOSITORY.getNameFromId(repoId)));
assertNotNull(dataStore.getMetadataRecord(SharedStoreRecordType.REPOSITORY.getNameFromId(repoId)));
}