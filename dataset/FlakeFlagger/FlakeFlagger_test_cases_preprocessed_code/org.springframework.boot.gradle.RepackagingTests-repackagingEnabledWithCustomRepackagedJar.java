@Test public void repackagingEnabledWithCustomRepackagedJar(){
project.newBuild().forTasks("clean","build","customRepackagedJar").withArguments("-PbootVersion=" + BOOT_VERSION,"-Prepackage=true").run();//RW
File buildLibs=new File("target/repackage/build/libs");//RO
assertTrue(new File(buildLibs,"repackage.jar").exists());
assertTrue(new File(buildLibs,"repackage.jar.original").exists());
assertFalse(new File(buildLibs,"repackage-sources.jar.original").exists());
assertTrue(new File(buildLibs,"custom.jar").exists());
assertTrue(new File(buildLibs,"custom.jar.original").exists());
}