@Deployment public void testDecideBasedOnListOrArrayOfBeans(){
assertNotNull(task);
assertEquals("Gold Member service",task.getName());
assertNotNull(task);
assertEquals("Basic service",task.getName());
}