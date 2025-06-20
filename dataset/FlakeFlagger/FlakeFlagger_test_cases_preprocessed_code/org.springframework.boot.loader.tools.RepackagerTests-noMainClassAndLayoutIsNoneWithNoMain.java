@Test public void noMainClassAndLayoutIsNoneWithNoMain() throws Exception {
assertThat(actualManifest.getMainAttributes().getValue("Main-Class"),equalTo(null));
assertThat(hasLauncherClasses(file),equalTo(false));
}