@Deployment public void testExecutionListenersOnMultiInstanceUserTask(){
assertEquals(4,TestTaskCompletionListener.count.get());//RW
assertEquals(4,TestStartExecutionListener.countWithLoopCounter.get());//RW
assertEquals(4,TestEndExecutionListener.countWithLoopCounter.get());//RW
assertEquals(1,TestStartExecutionListener.countWithoutLoopCounter.get());//RW
assertEquals(1,TestEndExecutionListener.countWithoutLoopCounter.get());//RW
}