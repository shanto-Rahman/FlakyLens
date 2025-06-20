@Test public void testPartialRepair() throws InterruptedException {
proxy.notify(notification);//IT
proxy.notify(notification);//IT
proxy.notify(notification);//IT
cdl.await();
assertThat(repairTask.getUnknownRanges()).isNull();
assertThat(repairTask.getCompletedRanges()).containsExactlyInAnyOrderElementsOf(ranges);
assertThat(proxy.myOptions.get(RepairOptions.RANGES_KEY)).isNotEmpty();
}