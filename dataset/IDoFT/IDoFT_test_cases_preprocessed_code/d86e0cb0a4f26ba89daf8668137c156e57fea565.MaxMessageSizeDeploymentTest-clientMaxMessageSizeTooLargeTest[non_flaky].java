@Test public void clientMaxMessageSizeTooLargeTest() throws DeploymentException {
if (expectedWarningMessage.equals(record.getMessage())) {
warningLogged.set(true);
}
assertTrue(warningLogged.get());
fail();
}