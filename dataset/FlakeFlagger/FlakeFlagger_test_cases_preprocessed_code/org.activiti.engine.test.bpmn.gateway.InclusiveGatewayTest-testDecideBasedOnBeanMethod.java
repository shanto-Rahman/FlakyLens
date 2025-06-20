@Deployment public void testDecideBasedOnBeanMethod(){
assertNotNull(task);
assertEquals(BEAN_TASK3_NAME,task.getName());
assertEquals(2,tasks.size());
assertEquals(0,expectedNames.size());
fail();
}