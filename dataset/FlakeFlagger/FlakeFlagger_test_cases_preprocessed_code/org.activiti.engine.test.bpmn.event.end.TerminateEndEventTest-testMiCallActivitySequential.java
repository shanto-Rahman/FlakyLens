@Deployment public void testMiCallActivitySequential(){
assertEquals(1,aTasks.size());
assertEquals(1,bTasks.size());
if (i != 8) {
assertEquals("Expected task for i=" + i,1,aTasks.size());
assertEquals("Expected task for i=" + i,1,bTasks.size());
}
assertEquals("After call activity",task.getName());
}