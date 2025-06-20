@Test public void ensureEncryptedAttributesUnmodified() throws GeneralSecurityException {
  Map<String,AttributeValue> encryptedAttributes=encryptor.encryptAllFieldsExcept(Collections.unmodifiableMap(attribs),context,"hashKey","rangeKey","version");
  String encryptedString=new TreeMap<>(encryptedAttributes).toString();
  encryptor.decryptAllFieldsExcept(Collections.unmodifiableMap(encryptedAttributes),context,"hashKey","rangeKey","version");
  assertEquals(encryptedString,new TreeMap<>(encryptedAttributes).toString());
}
