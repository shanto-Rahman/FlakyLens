@Test public void should_throw_exception_if_Objects_have_not_the_same_properties(){
assertThat(fieldByFieldComparator.compare(new JarJar("Yoda"),2)).isNotZero();
}