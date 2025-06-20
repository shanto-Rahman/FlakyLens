@Test public void testSticky() throws Exception {
assertThat(referenceConfig.getSticky(),is(true));
assertThat(parameters,hasKey(Constants.CLUSTER_STICKY_KEY));
}