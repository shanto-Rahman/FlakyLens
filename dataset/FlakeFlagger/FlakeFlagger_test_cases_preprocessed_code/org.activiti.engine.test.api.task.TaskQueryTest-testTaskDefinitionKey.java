@Deployment(resources="org/activiti/engine/test/api/task/taskDefinitionProcess.bpmn20.xml") public void testTaskDefinitionKey() throws Exception {
assertNotNull(tasks);
assertEquals(1,tasks.size());
assertEquals("taskKey1",tasks.get(0).getTaskDefinitionKey());
assertEquals(0L,count.longValue());
}