/** 
 * @see  <a href="https://activiti.atlassian.net/browse/ACT-1847">https://activiti.atlassian.net/browse/ACT-1847</a>
 */
@Deployment public void testDataObjectScope(){
assertEquals("Complete Task A",currentTask.getName());
assertEquals(2,variables.size());
if ("StringTest123".equals(varName)) {
assertEquals("Testing123",variables.get(varName));
if ("NoData123".equals(varName)) {
assertNull(variables.get(varName));
fail("Variable not expected " + varName);
}
}
assertEquals("Complete SubTask",currentTask.getName());
assertEquals(3,variables.size());
if ("StringTest123".equals(varName)) {
assertEquals("Testing123",variables.get(varName));
if ("StringTest456".equals(varName)) {
assertEquals("Testing456",variables.get(varName));
if ("NoData123".equals(varName)) {
assertNull(variables.get(varName));
fail("Variable not expected " + varName);
}
}
}
assertEquals(2,variables.size());
if ("StringTest123".equals(varName)) {
assertEquals("Testing123",variables.get(varName));
if ("NoData123".equals(varName)) {
assertNull(variables.get(varName));
fail("Variable not expected " + varName);
}
}
assertEquals(0,variables.size());
assertEquals("Complete Task B",currentTask.getName());
assertNull(runtimeService.createProcessInstanceQuery().processInstanceId(pi.getId()).singleResult());
}