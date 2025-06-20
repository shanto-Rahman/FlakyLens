@Test public void find_fileCreatedBeforeNow(){
  final CommandFileTest tester=new CommandFileTest(this.getClass());
  final File currentDirectory=new File(tester.getInputFile().getParentFile().getPath() + "/default.input");
  final Config config=new Config(tester,currentDirectory);
  tester.runAndAssertIgnoringOrder(Unix4j.use(config).find(Find.Options.typeFile.timeOlder.timeCreate,".",new Date()));
}
