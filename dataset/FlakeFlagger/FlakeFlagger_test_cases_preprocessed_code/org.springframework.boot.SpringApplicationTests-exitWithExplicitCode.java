@Test public void exitWithExplicitCode() throws Exception {
assertNotNull(context);
assertEquals(2,SpringApplication.exit(context,new ExitCodeGenerator(){
  @Override public int getExitCode(){
    return 2;
  }
}
));
}