@Test public void assertPersistEphemeralSequential() throws Exception {
zkRegCenter.persistEphemeralSequential("/sequential/test_ephemeral_sequential");//RW
zkRegCenter.persistEphemeralSequential("/sequential/test_ephemeral_sequential");//RW
assertThat(actual.size(),is(2));
assertThat(each,startsWith("test_ephemeral_sequential"));
zkRegCenter.close();//RW
assertTrue(actual.isEmpty());
zkRegCenter.init();//RW
}