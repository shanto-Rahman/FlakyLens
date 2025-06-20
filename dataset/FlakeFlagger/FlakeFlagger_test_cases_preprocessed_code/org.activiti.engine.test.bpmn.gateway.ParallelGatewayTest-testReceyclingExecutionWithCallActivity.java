/** 
 * https://activiti.atlassian.net/browse/ACT-1222
 */
@Deployment public void testReceyclingExecutionWithCallActivity(){
assertEquals(2,tasks.size());
assertEquals("Another task",tasks.get(0).getName());
assertEquals("Some Task",tasks.get(1).getName());
assertEquals(1,tasks.size());
assertEquals("Another task",tasks.get(0).getName());
assertEquals(0,taskService.createTaskQuery().count());
}