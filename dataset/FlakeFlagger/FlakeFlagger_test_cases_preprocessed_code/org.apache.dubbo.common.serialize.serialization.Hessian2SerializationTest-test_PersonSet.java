@Test public void test_PersonSet() throws Exception {
fail();
assertThat(expected.getMessage(),containsString("Serialized class org.apache.dubbo.common.model.Person must implement java.io.Serializable"));
}