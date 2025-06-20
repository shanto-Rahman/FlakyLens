@Test public void invalidQueueCapacityShouldResultInNonStartedAppender(){
assertEquals(0,asyncAppenderBase.getQueueSize());
assertFalse(asyncAppenderBase.isStarted());
}