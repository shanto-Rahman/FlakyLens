@Test public void executions(){
  final JobOperator jobOperator=BatchRuntime.getJobOperator();
  final long id=jobOperator.start("sample",null);
  Batches.waitForEnd(jobOperator,id);
  main(new String[]{"executions","-id",Long.toString(id)});
  assertThat(stdout.getLog(),containsString("Executions of sample for instance " + id));
  assertThat(stdout.getLog(),containsString("COMPLETED"));
}
