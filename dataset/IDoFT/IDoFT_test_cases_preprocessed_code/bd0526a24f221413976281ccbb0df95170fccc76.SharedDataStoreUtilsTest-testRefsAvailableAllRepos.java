@Test public void testRefsAvailableAllRepos() throws Exception {
Assert.assertTrue(SharedDataStoreUtils.refsNotAvailableFromRepos(dataStore.getAllMetadataRecords(SharedStoreRecordType.REPOSITORY.getType()),dataStore.getAllMetadataRecords(SharedStoreRecordType.REFERENCES.getType())).isEmpty());
}