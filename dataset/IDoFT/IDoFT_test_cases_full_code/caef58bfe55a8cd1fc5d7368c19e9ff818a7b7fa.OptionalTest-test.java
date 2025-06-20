@Test public void test(){
  final String output=new TypeScriptGenerator(TestUtils.settings()).generateTypeScript(Input.from(Person.class));
  Assert.assertEquals("interface Person {\n" + "    name: string;\n" + "    email?: string;\n"+ "    age?: number;\n"+ "}",output.trim());
}
