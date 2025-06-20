@Test public void rebalanceListener_onPartitionsAssigned(){
assertThat(processingConsumer.partitions.keySet(),contains(newPartition,topicPartition));
assertThat(ProcessingKafkaConsumer.REBALANCE_COUNTER.count(),is(rebalanceCount + 1));
}