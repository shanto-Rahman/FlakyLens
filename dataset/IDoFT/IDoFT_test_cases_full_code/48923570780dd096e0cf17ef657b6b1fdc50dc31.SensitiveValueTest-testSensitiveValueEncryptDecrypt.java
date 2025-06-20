@Test public void testSensitiveValueEncryptDecrypt(){
  final String originalValue="OriginalSensitiveValue";
  final String expectedEncryptedString="{Encrypted}rO0ABXQAFk9yaWdpbmFsU2Vuc2l0aXZlVmFsdWU=";
  SensitiveValue value=(SensitiveValue)ValueFactory.create(originalValue,true);
  verifyEncrypted(value,originalValue,expectedEncryptedString);
  value.encrypt();
  verifyEncrypted(value,originalValue,expectedEncryptedString);
  value.decrypt();
  verifyDecrypted(value,originalValue);
  value.decrypt();
  verifyDecrypted(value,originalValue);
  value.encrypt();
  verifyEncrypted(value,originalValue,expectedEncryptedString);
  value.encrypt();
  verifyEncrypted(value,originalValue,expectedEncryptedString);
}
