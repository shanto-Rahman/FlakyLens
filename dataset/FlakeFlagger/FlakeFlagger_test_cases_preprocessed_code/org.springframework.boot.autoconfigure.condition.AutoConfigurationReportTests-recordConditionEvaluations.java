@Test public void recordConditionEvaluations() throws Exception {
assertThat(map.size(),equalTo(2));
assertThat(conditionAndOutcome.getCondition(),equalTo(this.condition1));
assertThat(conditionAndOutcome.getOutcome(),equalTo(this.outcome1));
assertThat(conditionAndOutcome.getCondition(),equalTo(this.condition2));
assertThat(conditionAndOutcome.getOutcome(),equalTo(this.outcome2));
assertThat(iterator.hasNext(),equalTo(false));
assertThat(conditionAndOutcome.getCondition(),equalTo(this.condition3));
assertThat(conditionAndOutcome.getOutcome(),equalTo(this.outcome3));
assertThat(iterator.hasNext(),equalTo(false));
}