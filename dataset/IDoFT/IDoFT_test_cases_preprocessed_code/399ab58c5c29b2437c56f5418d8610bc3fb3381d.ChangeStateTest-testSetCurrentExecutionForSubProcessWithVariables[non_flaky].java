@Test @Deployment(resources={"org/flowable/engine/test/api/oneTaskSubProcess.bpmn20.xml"}) public void testSetCurrentExecutionForSubProcessWithVariables(){
assertEquals("subTask",task.getTaskDefinitionKey());
assertEquals("taskBefore",task.getTaskDefinitionKey());
assertEquals(2,executions.size());
assertEquals("test",processVariables.get("processVar1"));
assertEquals(10,processVariables.get("processVar2"));
assertNull(processVariables.get("localVar1"));
assertNull(processVariables.get("localVar2"));
assertEquals("test2",localVariables.get("localVar1"));
assertEquals(20,localVariables.get("localVar2"));
assertThat(changeStateEventListener.getEvents()).extracting(FlowableEvent::getType).containsExactly(FlowableEngineEventType.VARIABLE_CREATED,FlowableEngineEventType.VARIABLE_CREATED,FlowableEngineEventType.ACTIVITY_CANCELLED,FlowableEngineEventType.ACTIVITY_CANCELLED,FlowableEngineEventType.VARIABLE_CREATED,FlowableEngineEventType.VARIABLE_CREATED,FlowableEngineEventType.ACTIVITY_STARTED);
assertThat(changeStateEventListener.getEvents()).filteredOn(stateEvent -> stateEvent instanceof FlowableVariableEvent).extracting(stateEvent -> ((FlowableVariableEvent)stateEvent).getVariableName(),stateEvent -> ((FlowableVariableEvent)stateEvent).getVariableValue()).containsExactlyInAnyOrder(tuple("processVar1","test"),tuple("processVar2",10),tuple("localVar1","test2"),tuple("localVar2",20));
assertThat(changeStateEventListener.getEvents()).filteredOn(stateEvent -> stateEvent instanceof FlowableActivityEvent).extracting(stateEvent -> ((FlowableActivityEvent)stateEvent).getActivityId()).containsExactlyInAnyOrder("subTask","subProcess","taskBefore");
assertEquals("subTask",task.getTaskDefinitionKey());
assertEquals("taskAfter",task.getTaskDefinitionKey());
}