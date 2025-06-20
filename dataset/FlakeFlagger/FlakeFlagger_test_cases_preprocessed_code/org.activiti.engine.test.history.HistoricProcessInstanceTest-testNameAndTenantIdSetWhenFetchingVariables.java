/** 
 * Validation for https://jira.codehaus.org/browse/ACT-2182
 */
public void testNameAndTenantIdSetWhenFetchingVariables(){
assertEquals(1,processInstances.size());
assertEquals(processInstanceName,processInstance.getName());
assertEquals(tenantId,processInstance.getTenantId());
assertEquals(2,processInstanceVars.size());
assertEquals("Kermit",processInstanceVars.get("name"));
assertEquals(60,processInstanceVars.get("age"));
assertEquals(1,historicProcessInstances.size());
assertEquals(processInstanceName,historicProcessInstance.getName());
assertEquals(tenantId,historicProcessInstance.getTenantId());
assertEquals(2,historicProcessInstanceVars.size());
assertEquals("Kermit",historicProcessInstanceVars.get("name"));
assertEquals(60,historicProcessInstanceVars.get("age"));
}