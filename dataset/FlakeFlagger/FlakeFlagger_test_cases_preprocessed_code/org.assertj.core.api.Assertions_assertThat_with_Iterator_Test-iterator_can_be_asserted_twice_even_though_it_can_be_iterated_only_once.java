@Test public void iterator_can_be_asserted_twice_even_though_it_can_be_iterated_only_once() throws Exception {
assertThat(names).containsExactly("Luke","Leia").containsExactly("Luke","Leia");
}