@Test public void test(){
final String output=new TypeScriptGenerator(settings).generateTypeScript(Input.from(SomeCode.class));//RW
Assert.assertEquals("declare const enum SomeCode {\n" + "    VALUE0 = 10,\n" + "    VALUE1 = 11,\n"+ "}",output.trim());
}