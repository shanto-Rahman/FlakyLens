@Test public void overrideOverridingConcreteCollectionGenericFourthLevel(){
Assertions.assertThat(methods.length).isEqualTo(2);
Assertions.assertThat(resolved instanceof ParameterizedType).isTrue();
Assertions.assertThat(resolved2).isEqualTo(Object.class);
Assertions.assertThat(resolvedType).isEqualTo(resolved);
}