@Test public void repackageWithTransitiveFileDependency() throws Exception {
File buildLibs=new File("target/multi-project-transitive-file-dependency/main/build/libs");//RO
JarFile jarFile=new JarFile(new File(buildLibs,"main.jar"));
assertThat(jarFile.getEntry("lib/commons-logging-1.1.3.jar"),notNullValue());
assertThat(jarFile.getEntry("lib/foo.jar"),notNullValue());
}