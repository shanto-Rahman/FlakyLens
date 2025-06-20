@Deployment public void testAssigneeExtension(){
assertEquals(1,tasks.size());
assertEquals("my task",tasks.get(0).getName());
}