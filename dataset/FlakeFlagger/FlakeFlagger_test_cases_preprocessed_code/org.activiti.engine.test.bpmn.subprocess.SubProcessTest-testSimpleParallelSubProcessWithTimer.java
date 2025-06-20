@Deployment public void testSimpleParallelSubProcessWithTimer(){
assertEquals("Task A",taskA.getName());
assertEquals("Task B",taskB.getName());
assertEquals("Task after timer",taskAfterTimer.getName());
}