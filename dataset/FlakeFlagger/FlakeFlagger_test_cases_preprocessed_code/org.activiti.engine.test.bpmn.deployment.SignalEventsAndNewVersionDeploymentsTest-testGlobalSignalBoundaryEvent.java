@Deployment public void testGlobalSignalBoundaryEvent(){
assertEquals(2,getAllEventSubscriptions().size());
assertEquals(0,getAllEventSubscriptions().size());
assertEquals(2,tasks.size());
assertEquals("Task after signal",task.getName());
}