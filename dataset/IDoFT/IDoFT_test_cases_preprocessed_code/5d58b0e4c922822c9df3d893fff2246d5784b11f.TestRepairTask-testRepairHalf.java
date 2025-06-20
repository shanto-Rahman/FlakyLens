@Test public void testRepairHalf() throws InterruptedException {
proxy.notify(notification);//IT
proxy.notify(notification);//IT
cdl.await();
assertThat(repairTask.getUnknownRanges()).containsExactly(range2);
assertThat(repairTask.getCompletedRanges()).containsExactly(range1);
assertThat(proxy.myOptions.get(RepairOptions.RANGES_KEY)).isNotEmpty();
}