@Test public void asShouldSerializeResponseObjectAsJson() throws Exception {
serializationFuture.complete(Response.forPayload(new TestData()));
assertThat(json,equalToIgnoringWhiteSpace("{\"theString\":\"hi\",\"theInteger\":42}"));
}