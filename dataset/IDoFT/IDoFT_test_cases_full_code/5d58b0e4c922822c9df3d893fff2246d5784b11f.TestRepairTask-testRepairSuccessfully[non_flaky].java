@Test public void testRepairSuccessfully() throws InterruptedException {
  Collection<LongTokenRange> ranges=new ArrayList<>();
  LongTokenRange range1=new LongTokenRange(1,2);
  LongTokenRange range2=new LongTokenRange(3,4);
  ranges.add(range1);
  ranges.add(range2);
  final RepairTask repairTask=new RepairTask.Builder().withJMXProxyFactory(jmxProxyFactory).withTableReference(myTableReference).withTokenRanges(ranges).withTableRepairMetrics(myTableRepairMetrics).withRepairHistory(repairHistory).withJobId(jobId).withReplicas(participants).build();
  CountDownLatch cdl=startRepair(repairTask,false);
  Notification notification=new Notification("progress","repair:1",0,getRepairMessage(range1));
  notification.setUserData(getNotificationData(RepairTask.ProgressEventType.PROGRESS.ordinal(),1,2));
  proxy.notify(notification);
  notification=new Notification("progress","repair:1",1,getRepairMessage(range2));
  notification.setUserData(getNotificationData(RepairTask.ProgressEventType.PROGRESS.ordinal(),2,2));
  proxy.notify(notification);
  notification=new Notification("progress","repair:1",2,"Done with repair");
  notification.setUserData(getNotificationData(RepairTask.ProgressEventType.COMPLETE.ordinal(),2,2));
  proxy.notify(notification);
  cdl.await();
  assertThat(repairTask.getUnknownRanges()).isNull();
  assertThat(repairTask.getCompletedRanges()).containsExactlyInAnyOrderElementsOf(ranges);
  assertThat(proxy.myOptions.get(RepairOptions.RANGES_KEY)).isNotEmpty();
  verify(myTableRepairMetrics).repairTiming(eq(TABLE_REFERENCE),anyLong(),any(TimeUnit.class),eq(true));
  verify(repairSessions.get(range1)).start();
  verify(repairSessions.get(range2)).start();
  verify(repairSessions.get(range1)).finish(eq(RepairStatus.SUCCESS));
  verify(repairSessions.get(range2)).finish(eq(RepairStatus.SUCCESS));
}
