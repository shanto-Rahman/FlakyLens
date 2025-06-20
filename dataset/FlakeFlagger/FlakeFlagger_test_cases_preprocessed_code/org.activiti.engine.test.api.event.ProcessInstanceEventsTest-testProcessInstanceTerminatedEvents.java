@Deployment(resources="org/activiti/engine/test/bpmn/event/end/TerminateEndEventTest.testProcessTerminate.bpmn") public void testProcessInstanceTerminatedEvents() throws Exception {
assertEquals(3,executionEntities);
assertEquals("There should be exactly one ActivitiEventType.PROCESS_CANCELLED event after the task complete.",1,processTerminatedEvents.size());
assertThat(activitiEvent.getProcessInstanceId(),is(pi.getProcessInstanceId()));
assertThat("There should be exactly two ActivitiEventType.ACTIVITY_CANCELLED event after the task complete.",activityTerminatedEvents.size(),is(2));
if (activityEvent.getActivityId().equals("preNormalTerminateTask")) {
assertThat("The user task must be terminated",activityEvent.getActivityId(),is("preNormalTerminateTask"));
assertThat("The cause must be terminate end event",((FlowNode)activityEvent.getCause()).getId(),is("EndEvent_2"));
if (activityEvent.getActivityId().equals("EndEvent_2")) {
assertThat("The end event must be terminated",activityEvent.getActivityId(),is("EndEvent_2"));
assertThat("The cause must be terminate end event",((FlowNode)activityEvent.getCause()).getId(),is("EndEvent_2"));
}
}
}