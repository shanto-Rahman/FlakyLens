@Test public void testWhenMultiplePartitions(){
  recordReader.addRecord(PARTITION_1_RECORD_1);
  recordReader.addRecord(PARTITION_1_RECORD_2);
  recordReader.addRecord(PARTITION_2_RECORD_1);
  whenTriggerProcessor();
  thenIncomingFlowFileIsRoutedToOriginal();
  thenTheFollowingPartitionsExists(PARTITION_1,PARTITION_2);
  thenPartitionContains(PARTITION_2,0,2,PARTITION_2_RECORD_1);
  thenPartitionContains(PARTITION_1,1,2,PARTITION_1_RECORD_1,PARTITION_1_RECORD_2);
}
