@Deployment public void testTwoNestedSubProcessesInParallelWithTimer(){
assertEquals("Task in subprocess A",taskA.getName());
assertEquals("Task in subprocess B",taskB.getName());
assertEquals("Task after timer",taskAfterTimer.getName());
}