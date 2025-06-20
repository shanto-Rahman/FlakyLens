@Test public void should_derive_setter() throws Exception {
assertThat(introspector.deriveSetterName(Test.class.getDeclaredField("a"))).isEqualTo("setA");
}