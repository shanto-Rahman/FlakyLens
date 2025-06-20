@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testLocalizeTasks() throws Exception {
assertEquals(1,tasks.size());
assertEquals("my task",tasks.get(0).getName());
assertNull(tasks.get(0).getDescription());
assertEquals(1,tasks.size());
assertEquals("my task",tasks.get(0).getName());
assertNull(tasks.get(0).getDescription());
assertEquals(1,tasks.size());
assertEquals("My localized name",tasks.get(0).getName());
assertEquals("My localized description",tasks.get(0).getDescription());
assertEquals(1,tasks.size());
assertEquals("my task",tasks.get(0).getName());
assertNull(tasks.get(0).getDescription());
assertEquals(1,tasks.size());
assertEquals("My localized name",tasks.get(0).getName());
assertEquals("My localized description",tasks.get(0).getDescription());
assertEquals("my task",task.getName());
assertNull(task.getDescription());
assertEquals("My localized name",task.getName());
assertEquals("My localized description",task.getDescription());
assertEquals("my task",task.getName());
assertNull(task.getDescription());
}