@Test public void testSerialize(){
assertEquals(storageGroupTTLMap,newSnapshot.getStorageGroupTTLMap());
assertEquals(userMap,newSnapshot.getUserMap());
assertEquals(roleMap,newSnapshot.getRoleMap());
assertEquals(templateMap,newSnapshot.getTemplateMap());
assertEquals(partitionTable.serialize(),newSnapshot.getPartitionTableBuffer());
assertEquals(lastLogIndex,newSnapshot.getLastLogIndex());
assertEquals(lastLogTerm,newSnapshot.getLastLogTerm());
assertEquals(metaSimpleSnapshot,newSnapshot);
Assert.fail(e.getMessage());
}