@Test public void testWriteIOS() throws Exception {
  Config.Builder builder=new Config.Builder();
  builder.iosSdkVersion("6.1");
  builder.iosInfoPList(new File("Info.plist"));
  builder.iosEntitlementsPList(new File("entitlements.plist"));
  builder.targetType(IOSTarget.TYPE);
  StringWriter out=new StringWriter();
  builder.write(out,wd);
  assertEquals(IOUtils.toString(getClass().getResourceAsStream("ConfigTest.ios.xml")),out.toString());
}
