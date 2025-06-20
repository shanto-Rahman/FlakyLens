@Test public void verifySignedJar() throws Exception {
if (entry.contains("bcprov")) {
}
assertNotNull(signedJarFile);
java.util.jar.JarFile jarFile=new JarFile(new File(signedJarFile));//RO
if (!jarEntry.getName().startsWith("META-INF") && !jarEntry.isDirectory() && !jarEntry.getName().endsWith("TigerDigest.class")) {
assertNotNull("Missing cert " + jarEntry.getName(),jarEntry.getCertificates());
}
}