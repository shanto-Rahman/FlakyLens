@Deployment public void testFormKeyExpression(){
assertEquals("first-form.json",task.getFormKey());
assertEquals("form-abc.json",task.getFormKey());
assertEquals("form-changed.json",task.getFormKey());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals("form-changed.json",historicTaskInstance.getFormKey());
}
}