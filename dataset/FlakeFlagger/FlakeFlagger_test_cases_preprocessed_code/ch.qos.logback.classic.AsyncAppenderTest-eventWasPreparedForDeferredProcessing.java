@Test public void eventWasPreparedForDeferredProcessing(){
assertFalse(asyncAppender.isStarted());
assertEquals(1,listAppender.list.size());
assertEquals("v",e.getMDCPropertyMap().get(k));
assertFalse(e.hasCallerData());
}