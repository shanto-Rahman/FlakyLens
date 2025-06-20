@Test public void findValue(){
assertNull(missingMetaDataResult);
assertNull(missingAttributesResult);
assertNotNull(existingSessionResult);
assertSame(metaData,existingSessionResult.getKey());
assertSame(attributes,existingSessionResult.getValue());
}