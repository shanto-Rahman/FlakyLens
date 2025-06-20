@Test public void setExceptionsToIgnore(){
Assert.assertFalse(Tracer.shouldTrace(new IgnoreException()));
Assert.assertFalse(Tracer.shouldTrace(new IgnoreExceptionSub()));
Assert.assertTrue(Tracer.shouldTrace(new Exception()));
}