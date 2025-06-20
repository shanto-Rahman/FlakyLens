@Deployment public void testEchoShellMac(){
if (osType == OsType.MAC) {
assertNotNull(st);
assertTrue(st.startsWith("EchoTest"));
}
}