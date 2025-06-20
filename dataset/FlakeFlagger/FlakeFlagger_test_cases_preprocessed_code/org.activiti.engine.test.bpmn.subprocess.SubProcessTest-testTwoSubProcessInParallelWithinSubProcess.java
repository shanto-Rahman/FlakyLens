@Deployment public void testTwoSubProcessInParallelWithinSubProcess(){
assertEquals("Task in subprocess A",taskA.getName());
assertEquals("Task in subprocess B",taskB.getName());
assertEquals("Task after subprocess",taskAfterSubProcess.getName());
}