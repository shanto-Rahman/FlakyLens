@Test @UsingDataSet(loadStrategy=LoadStrategyEnum.DELETE_ALL) @ShouldMatchDataSet @IgnorePropertyValue(properties={"created_at","_id"}) public void testSaveForDummyError() throws Exception {
  final Date createdAt=DateTime.parse("2015-07-20T09:49:02.503Z").toDate();
  final AlarmCallbackConfiguration alarmCallbackConfiguration=mockAlarmCallbackConfiguration(createdAt);
  final Alert alert=mockAlert();
  final AlertCondition alertCondition=mockAlertCondition();
  final String errorMessage="Dummy Error Message";
  final AlarmCallbackHistory error=this.alarmCallbackHistoryService.error(alarmCallbackConfiguration,alert,alertCondition,errorMessage);
  this.alarmCallbackHistoryService.save(error);
}
