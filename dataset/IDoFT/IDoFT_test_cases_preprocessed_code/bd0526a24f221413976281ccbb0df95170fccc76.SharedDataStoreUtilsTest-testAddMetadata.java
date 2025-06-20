@Test public void testAddMetadata() throws Exception {
dataStore.addMetadataRecord(new FileInputStream(f),SharedStoreRecordType.REFERENCES.getNameFromId(repoId));
assertTrue(dataStore.metadataRecordExists(SharedStoreRecordType.REFERENCES.getNameFromId(repoId)));
assertEquals(refs,refsReturned);
assertEquals(SharedStoreRecordType.REFERENCES.getIdFromName(rec.getIdentifier().toString()),repoId);
}