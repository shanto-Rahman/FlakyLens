@Test public void testSigTermedFunctionality() throws IOException {
  AppContext mockedContext=Mockito.mock(AppContext.class);
  JHEventHandlerForSigtermTest jheh=new JHEventHandlerForSigtermTest(mockedContext,0);
  JobId jobId=Mockito.mock(JobId.class);
  jheh.addToFileMap(jobId);
  final int numEvents=4;
  JobHistoryEvent events[]=new JobHistoryEvent[numEvents];
  for (int i=0; i < numEvents; ++i) {
    events[i]=getEventToEnqueue(jobId);
    jheh.handle(events[i]);
  }
  jheh.stop();
  assertTrue("handleEvent should've been called only 4 times but was " + jheh.eventsHandled,jheh.eventsHandled == 4);
  jheh=new JHEventHandlerForSigtermTest(mockedContext,0);
  Job job=Mockito.mock(Job.class);
  Mockito.when(mockedContext.getJob(jobId)).thenReturn(job);
  ApplicationId mockAppId=Mockito.mock(ApplicationId.class);
  Mockito.when(mockAppId.getClusterTimestamp()).thenReturn(1000l);
  Mockito.when(jobId.getAppId()).thenReturn(mockAppId);
  jheh.addToFileMap(jobId);
  jheh.setForcejobCompletion(true);
  for (int i=0; i < numEvents; ++i) {
    events[i]=getEventToEnqueue(jobId);
    jheh.handle(events[i]);
  }
  jheh.stop();
  assertTrue("handleEvent should've been called only 5 times but was " + jheh.eventsHandled,jheh.eventsHandled == 5);
  assertTrue("Last event handled wasn't JobUnsuccessfulCompletionEvent",jheh.lastEventHandled.getHistoryEvent() instanceof JobUnsuccessfulCompletionEvent);
}
