@Deployment public void testSimpleParallelSubProcess(){
assertEquals("Task A",taskA.getName());
assertEquals("Task B",taskB.getName());
assertEquals("Task after sub process",taskAfterSubProcess.getName());
}