@Test public void should_filter_by_types() throws Exception {
assertThat(Collections2.filter(Arrays.asList(pm1,pm2),filter)).containsOnly(pm2);
assertThat(Collections2.filter(Arrays.asList(pm1,pm3),filter)).isEmpty();
}