@Test public void overridingConcreteGenericCollectionGenericFifthLevel(){
  Method[] methods=OverridingConcreteGenericCollectionGenericFifthLevel.class.getMethods();
  Assertions.assertThat(methods.length).isEqualTo(2);
  Type resolved=Types.resolve(OverridingConcreteGenericCollectionGenericFifthLevel.class,OverridingConcreteGenericCollectionGenericFifthLevel.class,methods[0].getGenericReturnType());
  Assertions.assertThat(resolved instanceof ParameterizedType).isTrue();
  Type resolved2=Types.resolve(OverridingConcreteGenericCollectionGenericFifthLevel.class,OverridingConcreteGenericCollectionGenericFifthLevel.class,methods[1].getGenericReturnType());
  Assertions.assertThat(resolved2).isEqualTo(Object.class);
  Type resolvedType=Types.resolveReturnType(methods[0].getGenericReturnType(),methods[1].getGenericReturnType());
  Assertions.assertThat(resolvedType).isEqualTo(resolved);
}
