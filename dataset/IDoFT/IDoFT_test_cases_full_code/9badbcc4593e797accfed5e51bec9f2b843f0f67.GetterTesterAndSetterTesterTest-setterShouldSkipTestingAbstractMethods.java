@Test public void setterShouldSkipTestingAbstractMethods(){
  PojoClass pojoClass=PojoClassFactory.getPojoClass(Good_AnAbstractClassWithAbstractSetterGetter.class);
  invokeRun(pojoClass,new SetterTester());
}
