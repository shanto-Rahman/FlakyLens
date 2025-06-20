@Test public void testAddRepositoryId() throws DataStoreException {
  String repoId=UUID.randomUUID().toString();
  ((DataStoreBlobStore)store).setRepositoryId(repoId);
  assertEquals(repoId,((DataStoreBlobStore)store).getRepositoryId());
  DataRecord metadataRecord=((DataStoreBlobStore)store).getMetadataRecord(SharedDataStoreUtils.SharedStoreRecordType.REPOSITORY.getNameFromId(repoId));
  assertEquals(repoId,SharedDataStoreUtils.SharedStoreRecordType.REPOSITORY.getIdFromName(metadataRecord.getIdentifier().toString()));
}
