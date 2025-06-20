@Test public void should_exclude_by_types() throws Exception {
assertThat(Collections2.filter(Arrays.asList(pm1,pm2),exclude)).containsOnly(pm1);
assertThat(Collections2.filter(Arrays.asList(pm1,pm3),exclude)).containsOnly(pm1,pm3);
}