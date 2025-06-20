@Test public void testEnums(){
  Settings settings=createBaseSettings();
  settings.declarePropertiesAsReadOnly=true;
  String result=generateTypeScript(settings,MultipleEnumContainerClass.class,SingleEnumContainerClass.class);
  String expected=readResource("enums.ts");
  Assert.assertEquals(expected,result);
}
