@Test public void ignoreMethodBasedOnFirstArg() throws IOException {
  TextMethodTester test=new TextMethodTester<>("ignore-method/methods-in.yaml",MockMethods2Impl::new,MockMethods2.class,"ignore-method/methods-out.yaml").run();
  assertEquals(test.expected(),test.actual());
}
