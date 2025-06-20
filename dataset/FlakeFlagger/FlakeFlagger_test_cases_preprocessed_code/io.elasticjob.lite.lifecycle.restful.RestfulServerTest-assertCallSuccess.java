@Test public void assertCallSuccess() throws Exception {
Assert.assertThat(actual.getResponseStatus(),Is.is(200));
Assert.assertThat(actual.getResponseContent(),Is.is("{\"string\":\"test_processed\",\"integer\":\"1_processed\"}"));
}