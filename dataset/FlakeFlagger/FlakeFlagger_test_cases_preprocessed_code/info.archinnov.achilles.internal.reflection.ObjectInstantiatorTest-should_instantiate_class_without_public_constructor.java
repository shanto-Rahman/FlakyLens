@Test public void should_instantiate_class_without_public_constructor() throws Exception {
assertThat(instance).isInstanceOf(BeanWithoutPublicConstructor.class);
}