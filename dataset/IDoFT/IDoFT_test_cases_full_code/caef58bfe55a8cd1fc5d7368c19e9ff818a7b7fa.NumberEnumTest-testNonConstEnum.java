@Test public void testNonConstEnum(){
  final Settings settings=TestUtils.settings();
  settings.outputFileType=TypeScriptFileType.implementationFile;
  settings.nonConstEnums=true;
  final String output=new TypeScriptGenerator(settings).generateTypeScript(Input.from(SomeCode.class));
  Assert.assertEquals("enum SomeCode {\n" + "    VALUE0 = 10,\n" + "    VALUE1 = 11,\n"+ "}",output.trim());
}
