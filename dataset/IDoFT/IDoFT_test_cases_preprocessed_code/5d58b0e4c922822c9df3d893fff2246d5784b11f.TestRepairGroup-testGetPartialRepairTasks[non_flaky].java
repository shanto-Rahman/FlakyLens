@Test public void testGetPartialRepairTasks(){
assertThat(tasks.size()).isEqualTo(3);
assertThat(repairTask.getTokenRanges().size()).isEqualTo(1);
assertThat(repairTask.getReplicas()).containsExactlyInAnyOrder(node,node2);
assertThat(repairTask.getTableReference()).isEqualTo(tableReference);
assertThat(repairTask.getRepairConfiguration().getRepairParallelism()).isEqualTo(RepairOptions.RepairParallelism.PARALLEL);
assertThat(repairTaskRanges).containsExactlyInAnyOrderElementsOf(vnodes);
}