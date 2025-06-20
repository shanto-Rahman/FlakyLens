@Test public void nextRecord_fairProcessing(){
  TopicPartition topic1Partition1=new TopicPartition("topic1",1);
  TopicPartition topic1Partition2=new TopicPartition("topic1",2);
  TopicPartition topic2Partition1=new TopicPartition("topic2",1);
  TopicPartition topic2Partition2=new TopicPartition("topic2",2);
  when(consumer.committed(topic1Partition1)).thenReturn(new OffsetAndMetadata(0L));
  when(consumer.committed(topic1Partition2)).thenReturn(new OffsetAndMetadata(0L));
  when(consumer.committed(topic2Partition1)).thenReturn(new OffsetAndMetadata(0L));
  when(consumer.committed(topic2Partition2)).thenReturn(new OffsetAndMetadata(0L));
  List<TopicPartition> topicPartitions=Arrays.asList(topic1Partition1,topic1Partition2,topic2Partition1,topic2Partition2);
  Map<TopicPartition,List<ConsumerRecord<String,String>>> recordsMap=new HashMap<>();
  topicPartitions.forEach(tp -> {
    List<ConsumerRecord<String,String>> records=new ArrayList<>();
    for (int message=0; message < 3; message++) {
      records.add(new ConsumerRecord<>(tp.topic(),tp.partition(),message,"key",tp.toString() + " Message: " + message));
    }
    recordsMap.put(tp,records);
  }
);
  ConsumerRecords<String,String> records=new ConsumerRecords<>(recordsMap);
  when(consumer.poll(any(Duration.class))).thenReturn(records);
  rebuildConsumer();
  processingConsumer.rebalanceListener.onPartitionsAssigned(topicPartitions);
  for (int message=0; message < 3; message++) {
    final int messageInt=message;
    Collection<String> values=topicPartitions.stream().map(tp -> tp.toString() + " Message: " + messageInt).collect(Collectors.toList());
    for (int partition=0; partition < topicPartitions.size(); partition++) {
      String value=nextRecordIsPresent().value();
      assertThat("Expected to remove [" + value + "] but it was not part of values ["+ values+ "]",values.remove(value),is(true));
    }
    assertThat(values,empty());
  }
  Optional<ConsumerRecord<String,String>> optional=processingConsumer.nextRecord(POLL_TIME);
  assertThat("expected optional consumer record to not be present",optional.isPresent(),is(false));
}
