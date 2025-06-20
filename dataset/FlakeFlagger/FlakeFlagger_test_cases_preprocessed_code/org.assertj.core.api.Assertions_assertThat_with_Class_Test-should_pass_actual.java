@Test public void should_pass_actual(){
AbstractClassAssert<?> assertions=Assertions.assertThat(clazz);
assertSame(clazz,assertions.actual);
}