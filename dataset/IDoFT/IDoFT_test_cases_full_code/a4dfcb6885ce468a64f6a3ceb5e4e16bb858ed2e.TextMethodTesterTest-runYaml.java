@SuppressWarnings("rawtypes") @Test public void runYaml() throws IOException {
  TextMethodTester test=new YamlMethodTester<>("methods-out.yaml",MockMethodsImpl::new,MockMethods.class,"methods-out.yaml").setup("methods-out.yaml").run();
  assertEquals(test.expected(),test.actual());
}
