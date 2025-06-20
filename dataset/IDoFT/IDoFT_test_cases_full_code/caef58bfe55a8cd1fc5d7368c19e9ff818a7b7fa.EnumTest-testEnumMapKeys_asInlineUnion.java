@Test public void testEnumMapKeys_asInlineUnion(){
  final Settings settings=TestUtils.settings();
  settings.mapEnum=EnumMapping.asInlineUnion;
  final String output=new TypeScriptGenerator(settings).generateTypeScript(Input.from(ClassWithMapWithEnumKeys.class));
  assertTrue(output.contains("labels: { [P in 'North' | 'East' | 'South' | 'West']?: string }".replace('\'','"')));
  assertTrue(!output.contains("Direction"));
}
