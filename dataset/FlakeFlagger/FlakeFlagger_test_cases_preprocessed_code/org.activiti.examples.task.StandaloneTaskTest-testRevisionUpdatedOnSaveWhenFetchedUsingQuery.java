public void testRevisionUpdatedOnSaveWhenFetchedUsingQuery(){
assertEquals(1,((TaskEntity)task).getRevision());
assertEquals(2,((TaskEntity)task).getRevision());
assertEquals(2,((TaskEntity)task).getRevision());
assertEquals(3,((TaskEntity)task).getRevision());
}