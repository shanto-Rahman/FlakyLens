@Deployment public void testDecideBasedOnBeanProperty(){
assertNotNull(task);
assertEquals("Standard service",task.getName());
}