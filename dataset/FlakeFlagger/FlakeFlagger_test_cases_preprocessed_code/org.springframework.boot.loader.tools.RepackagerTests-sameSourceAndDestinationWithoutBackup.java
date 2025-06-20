@Test public void sameSourceAndDestinationWithoutBackup() throws Exception {
assertThat(new File(file.getParent(),file.getName() + ".original").exists(),equalTo(false));
assertThat(hasLauncherClasses(file),equalTo(true));
}