@Test public void canBeUsedInNonGenericApplicationContext() throws Exception {
assertNotNull(context.getBean(ConditionEvaluationReport.class));
}