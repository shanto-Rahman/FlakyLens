@Test public void equalsAndHashCode() throws Exception {
assertThat(h1,equalTo(h1));
assertThat(h1,equalTo(h2));
assertThat(h1,not(equalTo(h3)));
assertThat(h1.hashCode(),equalTo(h1.hashCode()));
assertThat(h1.hashCode(),equalTo(h2.hashCode()));
assertThat(h1.hashCode(),not(equalTo(h3.hashCode())));
}