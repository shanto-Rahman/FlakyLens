@Test public void testCallSuccessReturnHello() throws InterruptedException, EqCommandTagException {
  SourceCommandExecutor executor=new SourceCommandExecutor(new ICommandRunner(){
    @Override public String runCommand(    SourceCommandTagValue sourceCommandTagValue) throws EqCommandTagException {
      return "hello";
    }
  }
,command);
  executor.start();
  Thread.sleep(20);
  assertTrue(executor.getSourceCommandTagReport().getStatus() == STATUS_OK);
  assertEquals(executor.getSourceCommandTagReport().getReturnValue(),"hello");
}
