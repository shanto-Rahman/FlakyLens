@Test public void try_to_find_first_port() throws Exception {
assertThat(result).isEqualTo(start);
assertThat(secondResult).isEqualTo(start + 1);
assertThat(thirdResult).isEqualTo(start);
}