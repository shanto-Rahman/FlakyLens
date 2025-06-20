@Deployment(resources="org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml") public void testWatchDogWithOneTaskProcess(){
assertThat(this.runtimeService.createProcessInstanceQuery().count(),is(0L));
}