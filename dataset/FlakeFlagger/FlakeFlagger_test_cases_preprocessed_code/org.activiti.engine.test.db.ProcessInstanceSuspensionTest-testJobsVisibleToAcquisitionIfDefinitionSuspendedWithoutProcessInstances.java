@Deployment(resources={"org/activiti/engine/test/db/oneJobProcess.bpmn20.xml"}) public void testJobsVisibleToAcquisitionIfDefinitionSuspendedWithoutProcessInstances(){
assertNotNull(job);
assertEquals(1,acquiredJobs.size());
assertEquals(1,acquiredJobs.size());
}