@Deployment(resources={"org/activiti/engine/test/bpmn/usertask/DynamicUserTaskTest.assignment.bpmn20.xml"}) public void testChangeOwner(){
assertEquals("ownerTest",task.getOwner());
assertEquals("ownerTest2",task.getOwner());
}