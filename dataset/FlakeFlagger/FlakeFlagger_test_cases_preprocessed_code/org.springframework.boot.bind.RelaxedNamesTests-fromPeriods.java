@Test public void fromPeriods() throws Exception {
assertThat(iterator.next(),equalTo("spring.value"));
assertThat(iterator.next(),equalTo("spring_value"));
assertThat(iterator.next(),equalTo("springValue"));
assertThat(iterator.next(),equalTo("springvalue"));
assertThat(iterator.next(),equalTo("SPRING.VALUE"));
assertThat(iterator.next(),equalTo("SPRING_VALUE"));
assertThat(iterator.next(),equalTo("SPRINGVALUE"));
assertThat(iterator.hasNext(),equalTo(false));
}