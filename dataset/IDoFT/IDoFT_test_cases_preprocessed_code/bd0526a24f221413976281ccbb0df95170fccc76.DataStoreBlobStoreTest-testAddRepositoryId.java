@Test public void testAddRepositoryId() throws DataStoreException {
assertEquals(repoId,((DataStoreBlobStore)store).getRepositoryId());
assertEquals(repoId,SharedDataStoreUtils.SharedStoreRecordType.REPOSITORY.getIdFromName(metadataRecord.getIdentifier().toString()));
}