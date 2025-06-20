@Test public void nextRecord_manyRecords(){
assertThat(partition.hasNextRecord(),is(true));
assertThat(partition.pendingOffsets.keySet(),contains(1L));
assertThat(partition.offsetPosition,is(2L));
assertThat(partition.hasNextRecord(),is(true));
assertThat(partition.pendingOffsets.keySet(),contains(1L,2L));
assertThat(partition.offsetPosition,is(3L));
assertThat(partition.hasNextRecord(),is(true));
assertThat(partition.pendingOffsets.keySet(),contains(1L,2L,3L));
assertThat(partition.offsetPosition,is(4L));
assertThat(partition.hasNextRecord(),is(false));
assertThat(partition.nextRecord(),is(nullValue()));
assertThat(partition.pendingOffsets.keySet(),contains(1L,2L,3L));
assertThat(partition.offsetPosition,is(4L));
assertThat(partition.committableOffset,is(nullValue()));
assertThat(partition.getCommittableOffsetsSize(),is(0L));
}