@Deployment public void testParallelUserTasks(){
assertEquals(3,tasks.size());
assertEquals("My Task 0",tasks.get(0).getName());
assertEquals("My Task 1",tasks.get(1).getName());
assertEquals("My Task 2",tasks.get(2).getName());
}