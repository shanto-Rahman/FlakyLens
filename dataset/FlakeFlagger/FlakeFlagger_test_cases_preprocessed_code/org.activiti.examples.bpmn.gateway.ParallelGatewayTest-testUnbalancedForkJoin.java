@Deployment public void testUnbalancedForkJoin(){
assertEquals(3,tasks.size());
assertEquals("Task 1",task1.getName());
assertEquals("Task 2",task2.getName());
assertEquals(2,tasks.size());
assertEquals("Task 3",task3.getName());
assertEquals("Task 4",task4.getName());
}