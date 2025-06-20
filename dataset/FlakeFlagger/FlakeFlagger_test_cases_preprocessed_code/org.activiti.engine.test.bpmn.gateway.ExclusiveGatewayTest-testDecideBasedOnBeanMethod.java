@Deployment public void testDecideBasedOnBeanMethod(){
assertNotNull(task);
assertEquals("Gold Member service",task.getName());
}