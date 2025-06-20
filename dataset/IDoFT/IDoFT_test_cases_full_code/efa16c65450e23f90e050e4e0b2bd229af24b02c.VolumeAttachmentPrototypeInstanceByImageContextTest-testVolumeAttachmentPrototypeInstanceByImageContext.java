@Test public void testVolumeAttachmentPrototypeInstanceByImageContext() throws Throwable {
  EncryptionKeyIdentityByCRN encryptionKeyIdentityModel=new EncryptionKeyIdentityByCRN.Builder().crn("crn:v1:bluemix:public:kms:us-south:a/dffc98a0f1f0f95f6613b3b752286b87:e4a29d1a-2ef0-42a6-8fd2-350deb1c647e:key:5437653b-c4b1-447f-9646-b2a2a4cd6179").build();
  assertEquals(encryptionKeyIdentityModel.crn(),"crn:v1:bluemix:public:kms:us-south:a/dffc98a0f1f0f95f6613b3b752286b87:e4a29d1a-2ef0-42a6-8fd2-350deb1c647e:key:5437653b-c4b1-447f-9646-b2a2a4cd6179");
  VolumeProfileIdentityByName volumeProfileIdentityModel=new VolumeProfileIdentityByName.Builder().name("general-purpose").build();
  assertEquals(volumeProfileIdentityModel.name(),"general-purpose");
  VolumePrototypeInstanceByImageContext volumePrototypeInstanceByImageContextModel=new VolumePrototypeInstanceByImageContext.Builder().capacity(Long.valueOf("26")).encryptionKey(encryptionKeyIdentityModel).iops(Long.valueOf("10000")).name("my-volume").profile(volumeProfileIdentityModel).build();
  assertEquals(volumePrototypeInstanceByImageContextModel.capacity(),Long.valueOf("26"));
  assertEquals(volumePrototypeInstanceByImageContextModel.encryptionKey(),encryptionKeyIdentityModel);
  assertEquals(volumePrototypeInstanceByImageContextModel.iops(),Long.valueOf("10000"));
  assertEquals(volumePrototypeInstanceByImageContextModel.name(),"my-volume");
  assertEquals(volumePrototypeInstanceByImageContextModel.profile(),volumeProfileIdentityModel);
  VolumeAttachmentPrototypeInstanceByImageContext volumeAttachmentPrototypeInstanceByImageContextModel=new VolumeAttachmentPrototypeInstanceByImageContext.Builder().deleteVolumeOnInstanceDelete(true).name("my-volume-attachment").volume(volumePrototypeInstanceByImageContextModel).build();
  assertEquals(volumeAttachmentPrototypeInstanceByImageContextModel.deleteVolumeOnInstanceDelete(),Boolean.valueOf(true));
  assertEquals(volumeAttachmentPrototypeInstanceByImageContextModel.name(),"my-volume-attachment");
  assertEquals(volumeAttachmentPrototypeInstanceByImageContextModel.volume(),volumePrototypeInstanceByImageContextModel);
  String json=TestUtilities.serialize(volumeAttachmentPrototypeInstanceByImageContextModel);
  VolumeAttachmentPrototypeInstanceByImageContext volumeAttachmentPrototypeInstanceByImageContextModelNew=TestUtilities.deserialize(json,VolumeAttachmentPrototypeInstanceByImageContext.class);
  assertTrue(volumeAttachmentPrototypeInstanceByImageContextModelNew instanceof VolumeAttachmentPrototypeInstanceByImageContext);
  assertEquals(volumeAttachmentPrototypeInstanceByImageContextModelNew.deleteVolumeOnInstanceDelete(),Boolean.valueOf(true));
  assertEquals(volumeAttachmentPrototypeInstanceByImageContextModelNew.name(),"my-volume-attachment");
  assertEquals(volumeAttachmentPrototypeInstanceByImageContextModelNew.volume().toString(),volumePrototypeInstanceByImageContextModel.toString());
}
