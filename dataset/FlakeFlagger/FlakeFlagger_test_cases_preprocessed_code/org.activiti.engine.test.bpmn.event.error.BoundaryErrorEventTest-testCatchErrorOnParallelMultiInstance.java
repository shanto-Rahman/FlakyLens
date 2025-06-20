@Deployment public void testCatchErrorOnParallelMultiInstance(){
assertEquals(5,tasks.size());
assertEquals(0,taskService.createTaskQuery().count());
}