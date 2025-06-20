@Test public void executions(){
assertThat(stdout.getLog(),containsString("Executions of sample for instance " + id));
assertThat(stdout.getLog(),containsString("COMPLETED"));
}