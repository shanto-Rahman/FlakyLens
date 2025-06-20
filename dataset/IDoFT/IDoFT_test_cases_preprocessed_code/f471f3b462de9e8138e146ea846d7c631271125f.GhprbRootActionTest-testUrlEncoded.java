@Test public void testUrlEncoded() throws Exception {
assertThat(project.getBuilds().toArray().length).isEqualTo(0);
Thread.sleep(50);
assertThat(project.getBuilds().toArray().length).isEqualTo(1);
}