@Deployment public void testCatchErrorOnEmbeddedSubprocess(){
assertEquals("subprocessTask",task.getName());
assertEquals("task after catching the error",task.getName());
}