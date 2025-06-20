@Test public void test(){
  final Settings settings=TestUtils.settings();
  final String output=new TypeScriptGenerator(settings).generateTypeScript(Input.from(SomeCode.class));
  Assert.assertEquals("declare const enum SomeCode {\n" + "    VALUE0 = 10,\n" + "    VALUE1 = 11,\n"+ "}",output.trim());
}
