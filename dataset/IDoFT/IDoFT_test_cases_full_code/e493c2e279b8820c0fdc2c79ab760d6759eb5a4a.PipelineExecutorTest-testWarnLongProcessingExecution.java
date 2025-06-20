@Test public void testWarnLongProcessingExecution(){
  Pipeline pipeline=createPipeline(createAddFieldExecutionStep("newField1","value1"),createSleepExecutionStep(WARNING_THRESHOLD_TIME_MS + 300));
  Doc doc=createDoc("id","testWarnLongProcessingExecution","message","hola","type","test");
  ExecutionResult executionResult=pipelineExecutor.execute(pipeline,doc);
  assertThat(executionResult.isOvertime()).isTrue();
  assertThat(executionResult.getOvertimeTook().get()).isGreaterThan(WARNING_THRESHOLD_TIME_MS);
  assertThat(doc.getSource().get("newField1")).isEqualTo("value1");
  assertThat(overtimeProcessingDocs.contains(doc)).isTrue();
  assertThat(pipelineExecutorMetrics.getTotalDocsOvertimeProcessing()).isEqualTo(1);
  assertThat(pipelineExecutorMetrics.getTotalDocsProcessingExpired()).isEqualTo(0);
}
