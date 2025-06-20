@Deployment public void testSkipMultipleTasks(){
assertEquals(1,tasks.size());
assertEquals("Task3",tasks.get(0).getName());
}