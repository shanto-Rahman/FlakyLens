@Test public void test002(){
  assertThat(getMock("none").greeting()).isEqualTo("none");
  assertThat(getMock("before").greeting()).isNull();
  assertThat(getMock("after").greeting()).isNull();
}
