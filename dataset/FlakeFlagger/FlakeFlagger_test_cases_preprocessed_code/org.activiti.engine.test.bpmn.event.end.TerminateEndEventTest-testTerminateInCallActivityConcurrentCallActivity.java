@Deployment(resources={"org/activiti/engine/test/bpmn/event/end/TerminateEndEventTest.testTerminateInCallActivityConcurrentCallActivity.bpmn","org/activiti/engine/test/bpmn/event/end/TerminateEndEventTest.testTerminateAfterUserTask.bpmn","org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testTerminateInCallActivityConcurrentCallActivity() throws Exception {
assertThat(runtimeService.createProcessInstanceQuery().superProcessInstanceId(pi.getId()).list().size(),is(2));
assertEquals(1,runtimeService.createProcessInstanceQuery().processInstanceId(pi.getId()).count());
}