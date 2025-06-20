@Test public void testExecute() throws Exception {
assertThat(output,equalTo("OK"));
assertTrue(wrapper.isReg());
}