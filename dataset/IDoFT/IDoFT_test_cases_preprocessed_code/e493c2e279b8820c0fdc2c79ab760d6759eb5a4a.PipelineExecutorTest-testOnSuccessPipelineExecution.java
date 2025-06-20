@Test public void testOnSuccessPipelineExecution(){
assertThat(executionResult.isSucceeded()).isTrue();
assertThat(doc.getSource().get("newField1")).isEqualTo("value1");
assertThat(doc.getSource().get("newField2")).isEqualTo("value2");
assertThat(doc.getSource().get("newField3")).isEqualTo("value3");
assertThat(overtimeProcessingDocs.contains(doc)).isFalse();
assertThat(executionResult.isOvertime()).isFalse();
assertThat(pipelineExecutorMetrics.getTotalDocsSucceededProcessing()).isEqualTo(1);
}