@Test public void testChromeDriverVersions(){
  List<String> versions=driverManager.getDriverVersions();
  log.debug("Versions of {} {}",driverManager.getClass().getSimpleName(),versions);
  assertThat(versions,notNullValue());
  assertThat(versions,not(empty()));
}
