@Test public void shouldCreateInstanceOnAbstract(){
  final PojoClass pojoClass=getPojoClassImplForClass(AnAbstractClass.class);
  Affirm.affirmNotNull("Should have created instance",InstanceFactory.getInstance(pojoClass));
}
