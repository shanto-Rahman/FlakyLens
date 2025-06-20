@Test public void testEnumWithJsonValueFieldAnnotation(){
  final Settings settings=TestUtils.settings();
  final String output=new TypeScriptGenerator(settings).generateTypeScript(Input.from(SideWithJsonValueFieldAnnotation.class));
  final String expected=("\n" + "type SideWithJsonValueFieldAnnotation = 'left-side' | 'right-side';\n").replace("'","\"");
  assertEquals(expected,output);
}
