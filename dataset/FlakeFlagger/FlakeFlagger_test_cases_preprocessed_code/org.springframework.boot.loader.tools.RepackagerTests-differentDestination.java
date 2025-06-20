@Test public void differentDestination() throws Exception {
assertThat(new File(source.getParent(),source.getName() + ".original").exists(),equalTo(false));
assertThat(hasLauncherClasses(source),equalTo(false));
assertThat(hasLauncherClasses(dest),equalTo(true));
}