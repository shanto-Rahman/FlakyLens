@Test public void test() throws Exception {
assertEquals(SharedStoreRecordType.MARKED_START_MARKER.getIdFromName(markerRec1.getIdentifier().toString()),repoId1);
TimeUnit.MILLISECONDS.sleep(100);
TimeUnit.MILLISECONDS.sleep(25);
assertEquals(SharedStoreRecordType.REPOSITORY.getIdFromName(repo1.getIdentifier().toString()),repoId1);
assertEquals(SharedStoreRecordType.REPOSITORY.getIdFromName(repo2.getIdentifier().toString()),repoId2);
assertEquals(SharedStoreRecordType.REFERENCES.getIdFromName(rec1.getIdentifier().toString()),repoId1);
assertEquals(SharedStoreRecordType.REFERENCES.getIdFromName(rec2.getIdentifier().toString()),repoId2);
Assert.assertTrue(SharedDataStoreUtils.refsNotAvailableFromRepos(dataStore.getAllMetadataRecords(SharedStoreRecordType.REPOSITORY.getType()),dataStore.getAllMetadataRecords(SharedStoreRecordType.REFERENCES.getType())).isEmpty());
assertEquals(SharedDataStoreUtils.getEarliestRecord(dataStore.getAllMetadataRecords(SharedStoreRecordType.REFERENCES.getType())).getLastModified(),minRefTime);
Assert.assertTrue(minRefTime >= minMarkerTime);
Assert.assertTrue(dataStore.getAllMetadataRecords(SharedStoreRecordType.REFERENCES.getType()).isEmpty());
Assert.assertTrue(dataStore.getAllMetadataRecords(SharedStoreRecordType.MARKED_START_MARKER.getType()).isEmpty());
assertEquals(2,dataStore.getAllMetadataRecords(SharedStoreRecordType.REPOSITORY.getType()).size());
}