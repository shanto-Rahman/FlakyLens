@Deployment public void testEchoShellWindows(){
if (osType == OsType.WINDOWS) {
assertNotNull(st);
assertTrue(st.startsWith("EchoTest"));
}
}