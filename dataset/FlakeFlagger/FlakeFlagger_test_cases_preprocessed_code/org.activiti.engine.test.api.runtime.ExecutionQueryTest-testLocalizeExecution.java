@Deployment(resources={"org/activiti/engine/test/api/runtime/executionLocalization.bpmn20.xml"}) public void testLocalizeExecution() throws Exception {
assertEquals(3,executions.size());
if (execution.getParentId() == null) {
assertNull(execution.getName());
assertNull(execution.getDescription());
if (execution.getParentId().equals(execution.getProcessInstanceId())) {
assertNull(execution.getName());
assertNull(execution.getDescription());
}
}
assertEquals(3,executions.size());
if (execution.getParentId() == null) {
assertNull(execution.getName());
assertNull(execution.getDescription());
if (execution.getParentId().equals(execution.getProcessInstanceId())) {
assertNull(execution.getName());
assertNull(execution.getDescription());
}
}
assertEquals(3,executions.size());
if (execution.getParentId() == null) {
assertEquals("Nombre del proceso",execution.getName());
assertEquals("Descripción del proceso",execution.getDescription());
if (execution.getParentId().equals(execution.getProcessInstanceId())) {
assertEquals("Nombre Subproceso",execution.getName());
assertEquals("Subproceso Descripción",execution.getDescription());
}
}
assertEquals(3,executions.size());
if (execution.getParentId() == null) {
assertEquals("Process Name 'en-GB'",execution.getName());
assertEquals("Process Description 'en-GB'",execution.getDescription());
if (execution.getParentId().equals(execution.getProcessInstanceId())) {
assertEquals("SubProcess Name 'en-GB'",execution.getName());
assertEquals("SubProcess Description 'en-GB'",execution.getDescription());
}
}
assertEquals(3,executions.size());
if (execution.getParentId() == null) {
assertNull(execution.getName());
assertNull(execution.getDescription());
if (execution.getParentId().equals(execution.getProcessInstanceId())) {
assertNull(execution.getName());
assertNull(execution.getDescription());
}
}
assertEquals(3,executions.size());
if (execution.getParentId() == null) {
assertEquals("Nombre del proceso",execution.getName());
assertEquals("Descripción del proceso",execution.getDescription());
if (execution.getParentId().equals(execution.getProcessInstanceId())) {
assertEquals("Nombre Subproceso",execution.getName());
assertEquals("Subproceso Descripción",execution.getDescription());
}
}
assertEquals(3,executions.size());
if (execution.getParentId() == null) {
assertEquals("Process Name 'en-GB'",execution.getName());
assertEquals("Process Description 'en-GB'",execution.getDescription());
if (execution.getParentId().equals(execution.getProcessInstanceId())) {
assertEquals("SubProcess Name 'en-GB'",execution.getName());
assertEquals("SubProcess Description 'en-GB'",execution.getDescription());
}
}
assertNull(execution.getName());
assertNull(execution.getDescription());
assertNull(execution.getName());
assertNull(execution.getDescription());
assertEquals("Nombre del proceso",execution.getName());
assertEquals("Descripción del proceso",execution.getDescription());
assertEquals("Nombre Subproceso",execution.getName());
assertEquals("Subproceso Descripción",execution.getDescription());
assertEquals("Process Name 'en-GB'",execution.getName());
assertEquals("Process Description 'en-GB'",execution.getDescription());
assertEquals("SubProcess Name 'en-GB'",execution.getName());
assertEquals("SubProcess Description 'en-GB'",execution.getDescription());
assertEquals("Process Name 'en'",execution.getName());
assertEquals("Process Description 'en'",execution.getDescription());
assertEquals("SubProcess Name 'en'",execution.getName());
assertEquals("SubProcess Description 'en'",execution.getDescription());
assertEquals("Process Name 'en-US'",execution.getName());
assertEquals("Process Description 'en-US'",execution.getDescription());
assertEquals("SubProcess Name 'en-US'",execution.getName());
assertEquals("SubProcess Description 'en-US'",execution.getDescription());
}