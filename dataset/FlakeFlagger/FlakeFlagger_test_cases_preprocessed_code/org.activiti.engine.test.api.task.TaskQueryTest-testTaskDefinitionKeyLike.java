@Deployment(resources="org/activiti/engine/test/api/task/taskDefinitionProcess.bpmn20.xml") public void testTaskDefinitionKeyLike() throws Exception {
assertNotNull(tasks);
assertEquals(2,tasks.size());
assertEquals("taskKey1",tasks.get(0).getTaskDefinitionKey());
assertEquals("taskKey123",tasks.get(1).getTaskDefinitionKey());
assertNotNull(tasks);
assertEquals(1,tasks.size());
assertEquals("taskKey123",tasks.get(0).getTaskDefinitionKey());
assertNotNull(tasks);
assertEquals(1,tasks.size());
assertEquals("taskKey123",tasks.get(0).getTaskDefinitionKey());
assertEquals(0L,count.longValue());
}