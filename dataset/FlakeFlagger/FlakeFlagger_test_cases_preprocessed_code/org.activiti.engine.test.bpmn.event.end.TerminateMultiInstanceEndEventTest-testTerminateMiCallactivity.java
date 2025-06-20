@Deployment(resources={"org/activiti/engine/test/bpmn/event/end/TerminateMultiInstanceEndEventTest.testTerminateMiCallactivity-parentProcess.bpmn20.xml","org/activiti/engine/test/bpmn/event/end/TerminateMultiInstanceEndEventTest.testTerminateMiCallactivity-calledProcess.bpmn20.xml"}) public void testTerminateMiCallactivity(){
assertEquals("A",taskA.getName());
assertEquals(4,bTasks.size());
assertEquals(3,cTasks.size());
assertEquals(3,dTasks.size());
assertEquals(2,afterMiTasks.size());
assertEquals("AfterMi",afterMiTasks.get(0).getName());
assertEquals("Parallel task",afterMiTasks.get(1).getName());
}