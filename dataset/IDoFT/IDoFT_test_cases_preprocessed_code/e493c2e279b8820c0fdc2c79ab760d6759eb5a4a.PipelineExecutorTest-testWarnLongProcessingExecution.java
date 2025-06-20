@Test public void testWarnLongProcessingExecution(){
assertThat(executionResult.isOvertime()).isTrue();
assertThat(executionResult.getOvertimeTook().get()).isGreaterThan(WARNING_THRESHOLD_TIME_MS);
assertThat(doc.getSource().get("newField1")).isEqualTo("value1");
assertThat(overtimeProcessingDocs.contains(doc)).isTrue();
assertThat(pipelineExecutorMetrics.getTotalDocsOvertimeProcessing()).isEqualTo(1);
assertThat(pipelineExecutorMetrics.getTotalDocsProcessingExpired()).isEqualTo(0);
}