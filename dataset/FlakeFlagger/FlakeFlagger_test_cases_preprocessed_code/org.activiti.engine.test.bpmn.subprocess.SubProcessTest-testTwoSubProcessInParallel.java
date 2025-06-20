@Deployment public void testTwoSubProcessInParallel(){
assertEquals("Task in subprocess A",tasks.get(0).getName());
assertEquals("Task in subprocess B",tasks.get(1).getName());
assertEquals("Task after subprocess A",tasks.get(0).getName());
assertEquals("Task in subprocess B",tasks.get(1).getName());
assertEquals("Task after subprocess A",tasks.get(0).getName());
assertEquals("Task after subprocess B",tasks.get(1).getName());
}