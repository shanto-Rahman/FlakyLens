@Test public void parent() throws Exception {
assertThat(this.report,sameInstance(ConditionEvaluationReport.get(this.beanFactory)));
assertThat(this.report,not(nullValue()));
assertThat(this.report.getParent(),not(nullValue()));
assertThat(this.report,sameInstance(ConditionEvaluationReport.get(this.beanFactory)));
assertThat(this.report.getParent(),sameInstance(ConditionEvaluationReport.get((ConfigurableListableBeanFactory)this.beanFactory.getParentBeanFactory())));
}