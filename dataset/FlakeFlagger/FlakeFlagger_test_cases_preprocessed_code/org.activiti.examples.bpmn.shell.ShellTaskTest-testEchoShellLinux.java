@Deployment public void testEchoShellLinux(){
if (osType == OsType.LINUX) {
assertNotNull(st);
assertTrue(st.startsWith("EchoTest"));
}
}