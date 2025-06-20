@Deployment(resources={"org/activiti/engine/test/bpmn/event/signal/SignalEventTest.testSignalWithGlobalScope.bpmn20.xml"}) public void testSignalProcessInstanceStart() throws Exception {
listener.clearEventsReceived();//IT
listener.clearEventsReceived();//IT
}