@Test public void shouldNotExceedNumberPeriods() throws Exception {
assertEquals(parse("19700101-00:00:20"),dh.getDateAfter());
assertEquals(parse("19700101-00:00:30"),dh.getDateAfter());
}