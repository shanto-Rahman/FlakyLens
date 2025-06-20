@Test public void testCustomFormatter(){
  this.loggingSystem.beforeInitialize();
  this.loggingSystem.initialize(null,null,null);
  this.logger.info("Hello world");
  String output=this.output.toString().trim();
  assertThat(output).contains("Hello world").contains("???? INFO [");
}
