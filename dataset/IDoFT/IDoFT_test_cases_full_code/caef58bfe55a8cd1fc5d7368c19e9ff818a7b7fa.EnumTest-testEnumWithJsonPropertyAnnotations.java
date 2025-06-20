@Test public void testEnumWithJsonPropertyAnnotations(){
  final Settings settings=TestUtils.settings();
  final String output=new TypeScriptGenerator(settings).generateTypeScript(Input.from(SideWithJsonPropertyAnnotations.class));
  final String expected=("\n" + "type SideWithJsonPropertyAnnotations = 'left-side' | 'right-side';\n").replace("'","\"");
  assertEquals(expected,output);
}
