@Test public void testCall_withOverrideComponents() throws Exception {
  Set<String> overrides=new HashSet<>(Arrays.asList("mycomponent","myothercomponent"));
  new Installer(fakeSdkRoot,mockInstallScriptProvider,true,overrides,mockProgressListener,mockConsoleListener,mockCommandRunner).install();
  Mockito.verify(mockCommandRunner).run(expectedCommand(true,overrides),sdkParentDirectory,fakeEnv,mockConsoleListener);
  Mockito.verifyNoMoreInteractions(mockCommandRunner);
}
