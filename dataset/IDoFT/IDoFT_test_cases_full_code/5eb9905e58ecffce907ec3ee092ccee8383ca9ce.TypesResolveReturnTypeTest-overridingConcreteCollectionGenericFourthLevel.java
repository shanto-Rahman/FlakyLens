@Test public void overridingConcreteCollectionGenericFourthLevel(){
  Method[] methods=OverridingConcreteCollectionGenericFourthLevel.class.getMethods();
  Assertions.assertThat(methods.length).isEqualTo(2);
  Type resolved=Types.resolve(OverridingConcreteCollectionGenericFourthLevel.class,OverridingConcreteCollectionGenericFourthLevel.class,methods[0].getGenericReturnType());
  Assertions.assertThat(resolved instanceof ParameterizedType).isTrue();
  Type resolved2=Types.resolve(OverridingConcreteCollectionGenericFourthLevel.class,OverridingConcreteCollectionGenericFourthLevel.class,methods[1].getGenericReturnType());
  Assertions.assertThat(resolved2).isEqualTo(Object.class);
  Type resolvedType=Types.resolveReturnType(resolved,resolved2);
  Assertions.assertThat(resolvedType).isEqualTo(resolved);
}
