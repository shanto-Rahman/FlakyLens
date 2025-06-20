@Test public void setExceptionsToTrace(){
  Tracer.ignoreClasses=null;
  Tracer.traceClasses=null;
  Tracer.setExceptionsToTrace(TraceException.class,TraceException2.class);
  Assert.assertTrue(Tracer.shouldTrace(new TraceException2()));
  Assert.assertTrue(Tracer.shouldTrace(new TraceExceptionSub()));
  Assert.assertFalse(Tracer.shouldTrace(new Exception()));
}
