@Test public void repackageWithFileDependency() throws Exception {
FileCopyUtils.copy(new File("src/test/resources/foo.jar"),new File("target/repackage/foo.jar"));//RO
project.newBuild().forTasks("clean","build").withArguments("-PbootVersion=" + BOOT_VERSION,"-Prepackage=true").run();//RW
File buildLibs=new File("target/repackage/build/libs");//RO
JarFile jarFile=new JarFile(new File(buildLibs,"repackage.jar"));
assertThat(jarFile.getEntry("lib/foo.jar"),notNullValue());
}