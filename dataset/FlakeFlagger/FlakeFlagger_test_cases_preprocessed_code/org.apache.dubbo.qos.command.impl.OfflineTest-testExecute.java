@Test public void testExecute() throws Exception {
assertThat(output,containsString("OK"));
assertThat(wrapper.isReg(),is(false));
assertThat(output,containsString("service not found"));
}