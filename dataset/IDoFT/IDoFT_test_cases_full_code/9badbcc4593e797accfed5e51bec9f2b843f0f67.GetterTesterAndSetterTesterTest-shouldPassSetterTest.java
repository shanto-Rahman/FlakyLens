@Test public void shouldPassSetterTest(){
  List<PojoClass> goodPojoClasses=getGoodPojoClasses();
  Assert.assertEquals("Classes added/removed?",4,goodPojoClasses.size());
  for (  final PojoClass pojoClass : goodPojoClasses) {
    invokeRun(pojoClass,new SetterTester());
    invokeRun(pojoClass,new GetterTester());
  }
}
