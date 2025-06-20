@Test public void testAddMetadata() throws Exception {
  File rootFolder=folder.newFolder();
  dataStore=getBlobStore(rootFolder);
  String repoId=UUID.randomUUID().toString();
  Set<String> refs=Sets.newHashSet("1_1","1_2");
  File f=folder.newFile();
  FileIOUtils.writeStrings(refs.iterator(),f,false);
  dataStore.addMetadataRecord(new FileInputStream(f),SharedStoreRecordType.REFERENCES.getNameFromId(repoId));
  assertTrue(dataStore.metadataRecordExists(SharedStoreRecordType.REFERENCES.getNameFromId(repoId)));
  DataRecord rec=dataStore.getMetadataRecord(SharedStoreRecordType.REFERENCES.getNameFromId(repoId));
  Set<String> refsReturned=FileIOUtils.readStringsAsSet(rec.getStream(),false);
  assertEquals(refs,refsReturned);
  assertEquals(SharedStoreRecordType.REFERENCES.getIdFromName(rec.getIdentifier().toString()),repoId);
  dataStore.deleteAllMetadataRecords(SharedStoreRecordType.REFERENCES.getType());
}
