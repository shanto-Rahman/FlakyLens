@Test public void canBeUsedInApplicationContext() throws Exception {
assertNotNull(context.getBean(ConditionEvaluationReport.class));
}