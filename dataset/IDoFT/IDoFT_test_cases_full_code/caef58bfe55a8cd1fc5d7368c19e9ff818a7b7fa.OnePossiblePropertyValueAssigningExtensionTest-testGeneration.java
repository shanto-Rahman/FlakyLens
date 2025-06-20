@Test public void testGeneration(){
  Settings settings=createBaseSettings(new OnePossiblePropertyValueAssigningExtension());
  String result=generateTypeScript(settings,SubClass.class,OtherSubClass.class);
  String expected=readResource("all.ts");
  Assert.assertEquals(expected,result);
}
