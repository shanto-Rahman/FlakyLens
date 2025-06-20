@Deployment public void testDecideBasedOnListOrArrayOfBeans(){
fail();
assertNotNull(task);
assertEquals(BEAN_TASK3_NAME,task.getName());
assertNotNull(tasks);
assertEquals(2,tasks.size());
assertEquals(0,expectedNames.size());
assertNotNull(tasks);
assertEquals(3,tasks.size());
assertEquals(0,expectedNames.size());
}