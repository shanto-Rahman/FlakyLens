@Test public void overridingConcreteGenericCollectionGenericFifthLevel(){
  Method[] methods=getMethods(OverridingConcreteGenericCollectionGenericFifthLevel.class);
  Assertions.assertThat(methods.length).isEqualTo(2);
  Type resolved=Types.resolve(OverridingConcreteGenericCollectionGenericFifthLevel.class,OverridingConcreteGenericCollectionGenericFifthLevel.class,methods[1].getGenericReturnType());
  Assertions.assertThat(resolved instanceof ParameterizedType).isTrue();
  Type resolved2=Types.resolve(OverridingConcreteGenericCollectionGenericFifthLevel.class,OverridingConcreteGenericCollectionGenericFifthLevel.class,methods[0].getGenericReturnType());
  Assertions.assertThat(resolved2).isEqualTo(Object.class);
  Type resolvedType=Types.resolveReturnType(methods[1].getGenericReturnType(),methods[0].getGenericReturnType());
  Assertions.assertThat(resolvedType).isEqualTo(resolved);
}
