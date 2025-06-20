@Test public void repackageWithCommonFileDependency() throws Exception {
File buildLibs=new File("target/multi-project-common-file-dependency/build/libs");//RO
JarFile jarFile=new JarFile(new File(buildLibs,"multi-project-common-file-dependency.jar"));
assertThat(jarFile.getEntry("lib/foo.jar"),notNullValue());
}