@Deployment(resources={"org/activiti/engine/test/api/event/SignalThrowingEventListenerTest.globalSignal.bpmn20.xml","org/activiti/engine/test/api/event/SignalThrowingEventListenerTest.globalSignalExternalProcess.bpmn20.xml"}) public void testGlobalSignal() throws Exception {
assertNotNull(processInstance);
assertNotNull(processInstance);
assertNotNull(externalProcess);
assertNotNull(task);
assertNull(externalProcess);
assertNotNull(task);
assertEquals("kermit",task.getAssignee());
}