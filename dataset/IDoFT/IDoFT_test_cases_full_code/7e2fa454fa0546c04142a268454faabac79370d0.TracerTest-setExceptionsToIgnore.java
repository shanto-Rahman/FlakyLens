@Test public void setExceptionsToIgnore(){
  Tracer.ignoreClasses=null;
  Tracer.traceClasses=null;
  Tracer.setExceptionsToIgnore(IgnoreException.class,IgnoreException2.class);
  Assert.assertFalse(Tracer.shouldTrace(new IgnoreException()));
  Assert.assertFalse(Tracer.shouldTrace(new IgnoreExceptionSub()));
  Assert.assertTrue(Tracer.shouldTrace(new Exception()));
}
