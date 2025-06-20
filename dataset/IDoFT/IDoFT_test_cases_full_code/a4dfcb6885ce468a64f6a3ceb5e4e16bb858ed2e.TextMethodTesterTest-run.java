@SuppressWarnings("rawtypes") @Test public void run() throws IOException {
  TextMethodTester test=new TextMethodTester<>("methods-out.yaml",MockMethodsImpl::new,MockMethods.class,"methods-out.yaml").setup("methods-out.yaml").run();
  assertEquals(test.expected(),test.actual());
}
