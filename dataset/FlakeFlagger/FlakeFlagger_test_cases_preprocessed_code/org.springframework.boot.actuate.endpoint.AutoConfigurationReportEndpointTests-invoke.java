@Test public void invoke() throws Exception {
assertTrue(report.getPositiveMatches().isEmpty());
assertTrue(report.getNegativeMatches().containsKey("a"));
}