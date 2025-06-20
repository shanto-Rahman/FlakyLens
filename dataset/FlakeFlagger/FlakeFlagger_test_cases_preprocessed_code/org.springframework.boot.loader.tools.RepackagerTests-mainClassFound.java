@Test public void mainClassFound() throws Exception {
assertThat(actualManifest.getMainAttributes().getValue("Main-Class"),equalTo("org.springframework.boot.loader.JarLauncher"));
assertThat(actualManifest.getMainAttributes().getValue("Start-Class"),equalTo("a.b.C"));
assertThat(hasLauncherClasses(file),equalTo(true));
}