@Test public void testFailure(){
  Pipeline pipeline=createStopOnFailurePipeline(createAddFieldExecutionStep("newField1","value1"),createFailAlwaysExecutionStep());
  Doc doc=createDoc("id","testFailure","message","hola","type","test");
  ExecutionResult result=pipelineExecutor.execute(pipeline,doc);
  assertThat(result.isSucceeded()).isFalse();
  assertThat(result.isOvertime()).isFalse();
  assertThat(result.getError().get().getException().isPresent()).isFalse();
  assertThat(doc.getSource().get("newField1")).isEqualTo("value1");
  assertThat(overtimeProcessingDocs.contains(doc)).isFalse();
  assertThat(pipelineExecutorMetrics.getTotalDocsFailedProcessing()).isEqualTo(1);
  assertThat(pipelineExecutorMetrics.getTotalDocsSucceededProcessing()).isEqualTo(0);
}
