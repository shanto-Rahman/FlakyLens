@Deployment(resources={"org/activiti/engine/test/api/mgmt/timerOnTask.bpmn20.xml"}) public void testDeleteJobDeletion(){
assertNotNull("Task timer should be there",timerJob);
assertNull("There should be no job now. It was deleted",timerJob);
}