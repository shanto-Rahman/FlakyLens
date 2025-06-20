@Test public void asShouldSerializeResponseObjectAsJson() throws Exception {
class TestData {
    public String theString="hi";
    public int theInteger=42;
  }
  serializationFuture.complete(Response.forPayload(new TestData()));
  String json=getResult(Middlewares.autoSerialize(serializationDelegate)).payload().get().utf8();
  assertThat(json,equalToIgnoringWhiteSpace("{\"theString\":\"hi\",\"theInteger\":42}"));
}
