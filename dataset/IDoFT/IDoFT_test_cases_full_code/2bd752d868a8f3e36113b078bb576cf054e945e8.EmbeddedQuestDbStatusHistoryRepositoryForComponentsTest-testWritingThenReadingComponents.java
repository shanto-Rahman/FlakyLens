@Test public void testWritingThenReadingComponents() throws Exception {
  testSubject.capture(new NodeStatus(),givenRootProcessGroupStatus(),new ArrayList<>(),INSERTED_AT);
  givenWaitUntilPersisted();
  final StatusHistory rootGroupStatus=testSubject.getProcessGroupStatusHistory(ROOT_GROUP_ID,START,END,PREFERRED_DATA_POINTS);
  assertCorrectStatusHistory(rootGroupStatus,ROOT_GROUP_ID,"Root");
  assertRootProcessGroupStatusSnapshot(rootGroupStatus.getStatusSnapshots().get(0));
  final StatusHistory childGroupStatus=testSubject.getProcessGroupStatusHistory(CHILD_GROUP_ID,START,END,PREFERRED_DATA_POINTS);
  assertCorrectStatusHistory(childGroupStatus,CHILD_GROUP_ID,"Child");
  assertChildProcessGroupStatusSnapshot(childGroupStatus.getStatusSnapshots().get(0));
  final StatusHistory processorStatus=testSubject.getProcessorStatusHistory(PROCESSOR_ID,START,END,PREFERRED_DATA_POINTS,false);
  assertCorrectStatusHistory(processorStatus,PROCESSOR_ID,"Processor");
  assertProcessorStatusSnapshot(processorStatus.getStatusSnapshots().get(0));
  final StatusHistory processorWithCounterStatus1=testSubject.getProcessorStatusHistory(PROCESSOR_WITH_COUNTER_ID,START,END,PREFERRED_DATA_POINTS,false);
  assertCorrectStatusHistory(processorWithCounterStatus1,PROCESSOR_WITH_COUNTER_ID,"ProcessorWithCounter");
  assertProcessorWithCounterStatusSnapshot(processorWithCounterStatus1.getStatusSnapshots().get(0),false);
  final StatusHistory processorWithCounterStatus2=testSubject.getProcessorStatusHistory(PROCESSOR_WITH_COUNTER_ID,START,END,PREFERRED_DATA_POINTS,true);
  assertCorrectStatusHistory(processorWithCounterStatus2,PROCESSOR_WITH_COUNTER_ID,"ProcessorWithCounter");
  assertProcessorWithCounterStatusSnapshot(processorWithCounterStatus2.getStatusSnapshots().get(0),true);
  final StatusHistory connectionStatus=testSubject.getConnectionStatusHistory(CONNECTION_ID,START,END,PREFERRED_DATA_POINTS);
  assertCorrectStatusHistory(connectionStatus,CONNECTION_ID,"Connection");
  assertConnectionStatusSnapshot(connectionStatus.getStatusSnapshots().get(0));
  final StatusHistory remoteProcessGroupStatus=testSubject.getRemoteProcessGroupStatusHistory(REMOTE_PROCESS_GROUP_ID,START,END,PREFERRED_DATA_POINTS);
  assertCorrectStatusHistory(remoteProcessGroupStatus,REMOTE_PROCESS_GROUP_ID,"RemoteProcessGroup");
  assertRemoteProcessGroupSnapshot(remoteProcessGroupStatus.getStatusSnapshots().get(0));
  final StatusHistory rootGroupStatus2=testSubject.getProcessGroupStatusHistory(ROOT_GROUP_ID,START,END_EARLY,PREFERRED_DATA_POINTS);
  assertStatusHistoryIsEmpty(rootGroupStatus2);
}
