@Test public void serverMaxMessageSizeTooLargeTest() throws DeploymentException, InterruptedException, IOException {
if (expectedWarningMessage.equals(record.getMessage())) {
warningLogged.set(true);
}
assertTrue(warningLogged.get());
}