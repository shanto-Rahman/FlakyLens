@Deployment(resources="org/activiti/engine/test/bpmn/event/end/TerminateMultiInstanceEndEventTest.testTerminateNestedMiEmbeddedSubprocess.bpmn20.xml") public void testTerminateNestedMiEmbeddedSubprocess2(){
assertEquals(12,aTasks.size());
assertEquals(12,afterInnerMiTasks.size());
}