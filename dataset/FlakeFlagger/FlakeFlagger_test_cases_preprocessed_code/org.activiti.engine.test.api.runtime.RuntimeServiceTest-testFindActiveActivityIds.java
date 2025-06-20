@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testFindActiveActivityIds(){
assertNotNull(activities);
assertEquals(1,activities.size());
}