@Test public void testTransactionRollback() throws Exception {
assertThat(output,containsString(1,"---->"));
assertThat(output,containsString(1,"----> josh"));
assertThat(output,containsString(2,"Count is 1"));
assertThat(output,containsString(1,"Simulated error"));
}