@Deployment(resources="org/activiti/examples/runtime/WatchDogAgendaTest-endlessloop.bpmn20.xml") public void testWatchDogWithEndLessLoop(){
fail("ActivitiException with 'WatchDog limit exceeded.' message expected.");
if (!"WatchDog limit exceeded.".equals(e.getMessage())) {
fail("Unexpected exception " + e);
}
}