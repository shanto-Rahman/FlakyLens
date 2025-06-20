@Test public void unsetDefaultValueProperty() throws JoranException {
configure(SIFT_FOLDER_PREFIX + "unsetDefaultValueProperty.xml");//RW
assertFalse(sa.isStarted());
}