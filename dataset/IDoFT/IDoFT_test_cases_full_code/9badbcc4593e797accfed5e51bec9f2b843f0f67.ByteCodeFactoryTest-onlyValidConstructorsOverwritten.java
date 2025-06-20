@Test public void onlyValidConstructorsOverwritten(){
  Class<?> clazz=AnAbstractClassWithProtectedMethodBeforeConstructor.class;
  Class<?> subClass1=getSubClass(clazz);
  Assert.assertNotNull(getInstance(PojoClassFactory.getPojoClass(subClass1)));
}
