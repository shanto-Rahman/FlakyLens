@Test public void noCustomDateFormat() throws Exception {
assertEquals(String.valueOf(date.getTime()),mapper.writeValueAsString(date));
}