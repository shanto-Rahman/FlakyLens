@Test public void testWriteIOS() throws Exception {
builder.iosInfoPList(new File("Info.plist"));//RO
builder.iosEntitlementsPList(new File("entitlements.plist"));//RO
assertEquals(IOUtils.toString(getClass().getResourceAsStream("ConfigTest.ios.xml")),out.toString());
}