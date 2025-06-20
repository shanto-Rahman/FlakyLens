@Deployment(resources={"org/activiti/engine/test/db/oneJobProcess.bpmn20.xml"}) public void testJobsNotVisibleToAcquisitionIfDefinitionSuspended(){
assertNotNull(job);
assertEquals(1,acquiredJobs.size());
assertEquals(0,acquiredJobs.size());
}