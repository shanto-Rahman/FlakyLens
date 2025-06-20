@Test @UsingDataSet(loadStrategy=LoadStrategyEnum.DELETE_ALL) @ShouldMatchDataSet @IgnorePropertyValue(properties={"created_at","_id"}) public void testSaveForDummySuccess() throws Exception {
  final Date createdAt=DateTime.parse("2015-07-20T09:49:02.503Z").toDate();
  final AlarmCallbackConfiguration alarmCallbackConfiguration=mockAlarmCallbackConfiguration(createdAt);
  final Alert alert=mockAlert();
  final AlertCondition alertCondition=mockAlertCondition();
  final AlarmCallbackHistory success=this.alarmCallbackHistoryService.success(alarmCallbackConfiguration,alert,alertCondition);
  this.alarmCallbackHistoryService.save(success);
}
