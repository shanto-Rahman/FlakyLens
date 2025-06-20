@Test public void noMainClassAndLayoutIsNone() throws Exception {
assertThat(actualManifest.getMainAttributes().getValue("Main-Class"),equalTo("a.b.C"));
assertThat(hasLauncherClasses(file),equalTo(false));
}