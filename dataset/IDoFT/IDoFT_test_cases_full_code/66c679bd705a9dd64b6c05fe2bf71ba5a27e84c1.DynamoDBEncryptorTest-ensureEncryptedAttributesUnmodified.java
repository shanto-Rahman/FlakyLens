@Test public void ensureEncryptedAttributesUnmodified() throws GeneralSecurityException {
  Map<String,AttributeValue> encryptedAttributes=encryptor.encryptAllFieldsExcept(Collections.unmodifiableMap(attribs),context,"hashKey","rangeKey","version");
  String encryptedString=encryptedAttributes.toString();
  encryptor.decryptAllFieldsExcept(Collections.unmodifiableMap(encryptedAttributes),context,"hashKey","rangeKey","version");
  assertEquals(encryptedString,encryptedAttributes.toString());
}
