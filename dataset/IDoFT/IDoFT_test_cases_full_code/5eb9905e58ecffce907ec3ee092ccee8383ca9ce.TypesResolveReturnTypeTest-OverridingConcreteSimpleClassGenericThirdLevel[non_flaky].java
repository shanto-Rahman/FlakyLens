@Test public void OverridingConcreteSimpleClassGenericThirdLevel(){
  Method[] methods=getMethods(OverridingConcreteSimpleClassGenericThirdLevel.class);
  Assertions.assertThat(methods.length).isEqualTo(2);
  Type resolved=Types.resolve(OverridingConcreteSimpleClassGenericThirdLevel.class,OverridingConcreteSimpleClassGenericThirdLevel.class,methods[0].getGenericReturnType());
  Assertions.assertThat(resolved).isEqualTo(Long.class);
  Type resolved2=Types.resolve(OverridingConcreteSimpleClassGenericThirdLevel.class,OverridingConcreteSimpleClassGenericThirdLevel.class,methods[1].getGenericReturnType());
  Assertions.assertThat(resolved2).isEqualTo(Object.class);
  Type resolvedType=Types.resolveReturnType(resolved,resolved2);
  Assertions.assertThat(resolvedType).isEqualTo(resolved);
}
