@Test public void loggingThatUsesJulIsCaptured(){
  this.loggingSystem.beforeInitialize();
  this.loggingSystem.initialize(null,null,null);
  java.util.logging.Logger julLogger=java.util.logging.Logger.getLogger(getClass().getName());
  julLogger.severe("Hello world");
  String output=this.output.toString().trim();
  assertThat(output).contains("Hello world");
}
