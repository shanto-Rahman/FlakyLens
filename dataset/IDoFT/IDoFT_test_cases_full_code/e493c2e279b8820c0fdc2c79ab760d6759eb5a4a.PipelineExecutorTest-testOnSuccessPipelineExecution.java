@Test public void testOnSuccessPipelineExecution(){
  Pipeline pipeline=createPipeline(createExecutionStepWithOnSuccessSteps(createAddFieldProcessor("newField1","value1"),createAddFieldExecutionStep("newField2","value2"),createAddFieldExecutionStep("newField3","value3")));
  Doc doc=createDoc("id","testPipelineExecution","message","hola");
  ExecutionResult executionResult=pipelineExecutor.execute(pipeline,doc);
  assertThat(executionResult.isSucceeded()).isTrue();
  assertThat(doc.getSource().get("newField1")).isEqualTo("value1");
  assertThat(doc.getSource().get("newField2")).isEqualTo("value2");
  assertThat(doc.getSource().get("newField3")).isEqualTo("value3");
  assertThat(overtimeProcessingDocs.contains(doc)).isFalse();
  assertThat(executionResult.isOvertime()).isFalse();
  assertThat(pipelineExecutorMetrics.getTotalDocsSucceededProcessing()).isEqualTo(1);
}
