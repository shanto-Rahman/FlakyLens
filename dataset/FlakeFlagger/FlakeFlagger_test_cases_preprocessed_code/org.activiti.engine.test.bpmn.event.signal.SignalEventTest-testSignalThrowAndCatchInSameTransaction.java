/** 
 * From https://forums.activiti.org/content/boundary-signal-causes-already-taking-transition
 */
@Deployment public void testSignalThrowAndCatchInSameTransaction(){
assertNotNull(firstProcessInstance);
assertEquals("Add a file",firstTask.getName());
assertEquals(false,vars.get(fileExistsVar));
assertNotNull(secondProcessInstance);
assertEquals(2,tasks.size());
assertEquals("Add a file",secondTask.getName());
assertEquals(false,vars.get(fileExistsVar));
assertEquals(1,usingTask.size());
}