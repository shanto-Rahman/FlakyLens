@Deployment(resources={"org/activiti/engine/test/api/event/SignalThrowingEventListenerTest.globalSignalDefinedInProcessDefinition.bpmn20.xml","org/activiti/engine/test/api/event/SignalThrowingEventListenerTest.globalSignalExternalProcess.bpmn20.xml"}) public void testGlobalSignalDefinedInProcessDefinition() throws Exception {
assertNotNull(processInstance);
assertNotNull(processInstance);
assertNotNull(externalProcess);
assertNotNull(task);
assertNull(externalProcess);
assertNotNull(task);
assertEquals("kermit",task.getAssignee());
}