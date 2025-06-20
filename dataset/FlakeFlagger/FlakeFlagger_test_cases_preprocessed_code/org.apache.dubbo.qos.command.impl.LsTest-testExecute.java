@Test public void testExecute() throws Exception {
assertThat(output,containsString("org.apache.dubbo.FooService|100"));
assertThat(output,containsString("org.apache.dubbo.BarService| Y"));
}