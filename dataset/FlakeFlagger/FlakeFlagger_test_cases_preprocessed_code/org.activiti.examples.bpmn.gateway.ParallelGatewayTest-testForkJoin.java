@Deployment public void testForkJoin(){
assertEquals(2,tasks.size());
assertEquals("Receive Payment",task1.getName());
assertEquals("Ship Order",task2.getName());
assertEquals(1,tasks.size());
assertEquals("Archive Order",tasks.get(0).getName());
}