@Test public void overridingConcreteSimpleClassGenericSecondLevel(){
Assertions.assertThat(methods.length).isEqualTo(2);
Assertions.assertThat(resolved).isEqualTo(Long.class);
Assertions.assertThat(resolved2).isEqualTo(Object.class);
Assertions.assertThat(resolvedType).isEqualTo(resolved);
}