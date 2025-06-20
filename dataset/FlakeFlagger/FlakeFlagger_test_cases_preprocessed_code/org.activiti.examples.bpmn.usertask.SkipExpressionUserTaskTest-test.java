@Deployment public void test(){
assertEquals(1,tasks.size());
assertEquals(0,taskService.createTaskQuery().list().size());
assertEquals(1,tasks2.size());
assertEquals(0,taskService.createTaskQuery().list().size());
assertEquals(0,tasks3.size());
}