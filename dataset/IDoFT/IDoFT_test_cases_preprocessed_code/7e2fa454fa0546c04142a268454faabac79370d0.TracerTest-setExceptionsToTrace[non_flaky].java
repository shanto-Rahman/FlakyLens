@Test public void setExceptionsToTrace(){
Assert.assertTrue(Tracer.shouldTrace(new TraceException2()));
Assert.assertTrue(Tracer.shouldTrace(new TraceExceptionSub()));
Assert.assertFalse(Tracer.shouldTrace(new Exception()));
}