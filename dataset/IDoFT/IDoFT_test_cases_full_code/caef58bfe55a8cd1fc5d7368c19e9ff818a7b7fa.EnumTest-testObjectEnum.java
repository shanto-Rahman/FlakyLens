@Test public void testObjectEnum(){
  final Settings settings=TestUtils.settings();
  final String output=new TypeScriptGenerator(settings).generateTypeScript(Input.from(StatusType.class));
  final String expected="" + "interface StatusType {\n" + "    code: number;\n"+ "    label: string;\n"+ "}";
  assertEquals(expected.trim(),output.trim());
}
