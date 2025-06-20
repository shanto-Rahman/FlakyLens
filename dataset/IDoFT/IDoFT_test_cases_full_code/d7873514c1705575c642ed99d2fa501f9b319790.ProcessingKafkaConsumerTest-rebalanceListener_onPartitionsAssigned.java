@Test public void rebalanceListener_onPartitionsAssigned(){
  long rebalanceCount=ProcessingKafkaConsumer.REBALANCE_COUNTER.count();
  TopicPartition newPartition=new TopicPartition("new-topic",0);
  when(consumer.committed(newPartition)).thenReturn(new OffsetAndMetadata(0L));
  processingConsumer.rebalanceListener.onPartitionsAssigned(Arrays.asList(topicPartition,newPartition));
  assertThat(processingConsumer.partitions.keySet(),contains(newPartition,topicPartition));
  assertThat(ProcessingKafkaConsumer.REBALANCE_COUNTER.count(),is(rebalanceCount + 1));
}
