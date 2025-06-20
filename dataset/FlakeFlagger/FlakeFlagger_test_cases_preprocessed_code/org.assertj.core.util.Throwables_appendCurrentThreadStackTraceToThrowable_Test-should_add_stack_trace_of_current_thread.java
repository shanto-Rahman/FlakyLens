@Test public void should_add_stack_trace_of_current_thread(){
new Thread(){
  @Override public void run(){
    RuntimeException e=new RuntimeException("Thrown on purpose");
    exceptionReference.set(e);
    latch.countDown();
  }
}
.start();
exceptionReference.set(e);
latch.countDown();
latch.await();
RuntimeException thrown=exceptionReference.get();
assertEquals("org.assertj.core.util.Throwables_appendCurrentThreadStackTraceToThrowable_Test$1.run",asString(stackTrace[0]));
assertEquals("org.assertj.core.util.Throwables_appendCurrentThreadStackTraceToThrowable_Test.should_add_stack_trace_of_current_thread",asString(stackTrace[1]));
}