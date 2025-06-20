@Test public void testRepairSuccessfully() throws InterruptedException {
proxy.notify(notification);//IT
proxy.notify(notification);//IT
proxy.notify(notification);//IT
cdl.await();
assertThat(repairTask.getUnknownRanges()).isNull();
assertThat(repairTask.getCompletedRanges()).containsExactlyElementsOf(ranges);
assertThat(proxy.myOptions.get(RepairOptions.RANGES_KEY)).isNotEmpty();
}