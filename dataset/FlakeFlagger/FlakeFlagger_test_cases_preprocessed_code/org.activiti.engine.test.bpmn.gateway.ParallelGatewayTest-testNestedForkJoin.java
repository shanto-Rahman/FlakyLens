@Deployment public void testNestedForkJoin(){
assertEquals(1,tasks.size());
assertEquals("Task 0",tasks.get(0).getName());
assertEquals(2,tasks.size());
assertEquals("Task A",tasks.get(0).getName());
assertEquals("Task B",tasks.get(1).getName());
assertEquals(1,tasks.size());
assertEquals("Task B",tasks.get(0).getName());
assertEquals(2,tasks.size());
assertEquals("Task B1",tasks.get(0).getName());
assertEquals("Task B2",tasks.get(1).getName());
assertEquals(1,tasks.size());
assertEquals("Task C",tasks.get(0).getName());
}