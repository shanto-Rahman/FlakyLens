@Test public void fail_offsetPositionBeforeFailedRecord(){
assertThat(partition.pendingOffsets.keySet(),contains(1L));
assertThat(partition.offsetPosition,is(2L));
assertThat(partition.pendingOffsets.keySet(),contains(1L,2L));
assertThat(partition.offsetPosition,is(3L));
assertThat(partition.fail(1L),is(true));
assertThat(partition.pendingOffsets.keySet(),contains(2L));
assertThat(partition.completedOffsets,empty());
assertThat(partition.offsetPosition,is(0L));
assertThat(partition.fail(2L),is(true));
assertThat(partition.pendingOffsets.keySet(),empty());
assertThat(partition.completedOffsets,empty());
assertThat(partition.offsetPosition,is(0L));
}