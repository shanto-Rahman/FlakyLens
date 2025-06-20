@Test public void loggingLevelIsPropagatedToJul(){
  this.loggingSystem.beforeInitialize();
  this.loggingSystem.initialize(this.initializationContext,null,null);
  this.loggingSystem.setLogLevel(getClass().getName(),LogLevel.DEBUG);
  java.util.logging.Logger julLogger=java.util.logging.Logger.getLogger(getClass().getName());
  julLogger.fine("Hello debug world");
  String output=this.output.toString().trim();
  assertThat(output).contains("Hello debug world");
}
