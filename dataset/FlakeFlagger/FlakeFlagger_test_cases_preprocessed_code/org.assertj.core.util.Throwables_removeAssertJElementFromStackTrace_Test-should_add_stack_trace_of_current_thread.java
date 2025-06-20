@Test public void should_add_stack_trace_of_current_thread(){
assertTrue(hasStackTraceElementContainingAssertJClass(throwable));
assertFalse(hasStackTraceElementContainingAssertJClass(throwable));
}