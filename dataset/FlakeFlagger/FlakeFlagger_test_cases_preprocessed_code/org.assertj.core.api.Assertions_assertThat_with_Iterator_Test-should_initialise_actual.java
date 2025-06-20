@Test public void should_initialise_actual(){
AbstractIterableAssert<?,? extends Iterable<? extends String>,String> assertions=assertThat(names);
assertThat(assertions.actual).containsOnly("Leia","Luke");
}