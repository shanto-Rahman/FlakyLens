@Test public void sameSourceAndDestinationWithBackup() throws Exception {
assertThat(new File(file.getParent(),file.getName() + ".original").exists(),equalTo(true));
assertThat(hasLauncherClasses(file),equalTo(true));
}