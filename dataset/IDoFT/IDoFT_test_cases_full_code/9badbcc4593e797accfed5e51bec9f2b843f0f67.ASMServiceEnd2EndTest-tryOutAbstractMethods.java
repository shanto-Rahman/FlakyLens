@Test public void tryOutAbstractMethods(){
  AbstractClassWithVariousAbstractMethods instance=getRandomValue(AbstractClassWithVariousAbstractMethods.class);
  PojoClass pojoClass=PojoClassFactory.getPojoClass(AbstractClassWithVariousAbstractMethods.class);
  for (  PojoMethod method : pojoClass.getPojoMethods())   if (!method.isConstructor()) {
    assertThat("Method" + method,method.isAbstract(),is(true));
    final List<PojoParameter> pojoParameters=method.getPojoParameters();
    Object[] params=new Object[pojoParameters.size()];
    for (int idx=0; idx < params.length; idx++) {
      params[idx]=RandomFactory.getRandomValue(pojoParameters.get(idx));
    }
    final Class<?> returnType=method.getReturnType();
    if (!returnType.equals(Void.class) && !returnType.equals(void.class))     assertThat("Method " + method,method.invoke(instance,params),notNullValue());
 else     assertThat("Method " + method,method.invoke(instance,params),nullValue());
  }
}
