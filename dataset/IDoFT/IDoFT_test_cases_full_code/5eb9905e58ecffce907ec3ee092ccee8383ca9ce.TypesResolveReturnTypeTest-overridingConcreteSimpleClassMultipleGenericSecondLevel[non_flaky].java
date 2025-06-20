@Test public void overridingConcreteSimpleClassMultipleGenericSecondLevel(){
  Method[] methods=getMethods(OverridingConcreteSimpleClassMultipleGenericSecondLevel.class);
  Assertions.assertThat(methods.length).isEqualTo(2);
  Type resolved=Types.resolve(OverridingConcreteSimpleClassMultipleGenericSecondLevel.class,OverridingConcreteSimpleClassMultipleGenericSecondLevel.class,methods[0].getGenericReturnType());
  Assertions.assertThat(resolved).isEqualTo(Long.class);
  Type resolved2=Types.resolve(OverridingConcreteSimpleClassMultipleGenericSecondLevel.class,OverridingConcreteSimpleClassMultipleGenericSecondLevel.class,methods[1].getGenericReturnType());
  Assertions.assertThat(resolved2).isEqualTo(Object.class);
  Type resolvedType=Types.resolveReturnType(resolved,resolved2);
  Assertions.assertThat(resolvedType).isEqualTo(resolved);
}
