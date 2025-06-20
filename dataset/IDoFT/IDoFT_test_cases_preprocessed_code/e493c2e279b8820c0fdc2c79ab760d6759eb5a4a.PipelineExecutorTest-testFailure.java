@Test public void testFailure(){
assertThat(result.isSucceeded()).isFalse();
assertThat(result.isOvertime()).isFalse();
assertThat(result.getError().get().getException().isPresent()).isFalse();
assertThat(doc.getSource().get("newField1")).isEqualTo("value1");
assertThat(overtimeProcessingDocs.contains(doc)).isFalse();
assertThat(pipelineExecutorMetrics.getTotalDocsFailedProcessing()).isEqualTo(1);
assertThat(pipelineExecutorMetrics.getTotalDocsSucceededProcessing()).isEqualTo(0);
}