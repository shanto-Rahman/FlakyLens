@Test public void tryOutAbstractMethods(){
if (!method.isConstructor()) {
assertThat("Method" + method,method.isAbstract(),is(true));
if (!returnType.equals(Void.class) && !returnType.equals(void.class)) assertThat("Method " + method,method.invoke(instance,params),notNullValue());
 else assertThat("Method " + method,method.invoke(instance,params),nullValue());
assertThat("Method " + method,method.invoke(instance,params),notNullValue());
assertThat("Method " + method,method.invoke(instance,params),nullValue());
}
}