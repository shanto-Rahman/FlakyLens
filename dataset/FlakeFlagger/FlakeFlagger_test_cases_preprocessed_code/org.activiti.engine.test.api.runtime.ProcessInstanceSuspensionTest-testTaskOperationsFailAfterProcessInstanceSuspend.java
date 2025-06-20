@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testTaskOperationsFailAfterProcessInstanceSuspend(){
assertNotNull(task);
fail("It is not allowed to complete a task of a suspended process instance");
fail("It is not allowed to claim a task of a suspended process instance");
fail("It is not allowed to set a variable on a task of a suspended process instance");
fail("It is not allowed to set a variable on a task of a suspended process instance");
fail("It is not allowed to set variables on a task of a suspended process instance");
fail("It is not allowed to set variables on a task of a suspended process instance");
fail("It is not allowed to remove a variable on a task of a suspended process instance");
fail("It is not allowed to remove a variable on a task of a suspended process instance");
fail("It is not allowed to remove variables on a task of a suspended process instance");
fail("It is not allowed to remove variables on a task of a suspended process instance");
fail("It is not allowed to add a candidate group on a task of a suspended process instance");
fail("It is not allowed to add a candidate user on a task of a suspended process instance");
fail("It is not allowed to add a candidate user on a task of a suspended process instance");
fail("It is not allowed to add an identityLink on a task of a suspended process instance");
fail("It is not allowed to add a comment on a task of a suspended process instance");
fail("It is not allowed to add an attachment on a task of a suspended process instance");
fail("It is not allowed to set an assignee on a task of a suspended process instance");
fail("It is not allowed to set an owner on a task of a suspended process instance");
fail("It is not allowed to set a priority on a task of a suspended process instance");
}