/** 
 * Test case for https://activiti.atlassian.net/browse/ACT-1978
 */
public void testSignalDeleteOnRedeploy(){
assertEquals(3,runtimeService.createProcessInstanceQuery().count());
}