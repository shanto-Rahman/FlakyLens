@Test public void realizingOverridingSimpleClassGenericThirdLevel(){
  Method[] methods=RealizingOverridingSimpleClassGenericThirdLevel.class.getMethods();
  Assertions.assertThat(methods.length).isEqualTo(2);
  Type resolved=Types.resolve(RealizingOverridingSimpleClassGenericThirdLevel.class,RealizingOverridingSimpleClassGenericThirdLevel.class,methods[0].getGenericReturnType());
  Assertions.assertThat(resolved).isEqualTo(Long.class);
  Type resolved2=Types.resolve(RealizingOverridingSimpleClassGenericThirdLevel.class,RealizingOverridingSimpleClassGenericThirdLevel.class,methods[1].getGenericReturnType());
  Assertions.assertThat(resolved2).isEqualTo(Object.class);
  Type resolvedType=Types.resolveReturnType(resolved,resolved2);
  Assertions.assertThat(resolvedType).isEqualTo(resolved);
}
