@Test public void testVolumeAttachmentPrototypeInstanceByVolumeContext() throws Throwable {
assertEquals(encryptionKeyIdentityModel.crn(),"crn:v1:bluemix:public:kms:us-south:a/dffc98a0f1f0f95f6613b3b752286b87:e4a29d1a-2ef0-42a6-8fd2-350deb1c647e:key:5437653b-c4b1-447f-9646-b2a2a4cd6179");
assertEquals(volumeProfileIdentityModel.name(),"general-purpose");
assertEquals(snapshotIdentityModel.id(),"349a61d8-7ab1-420f-a690-5fed76ef9d4f");
assertEquals(volumeAttachmentVolumePrototypeInstanceByVolumeContextModel.capacity(),Long.valueOf("26"));
assertEquals(volumeAttachmentVolumePrototypeInstanceByVolumeContextModel.encryptionKey(),encryptionKeyIdentityModel);
assertEquals(volumeAttachmentVolumePrototypeInstanceByVolumeContextModel.iops(),Long.valueOf("10000"));
assertEquals(volumeAttachmentVolumePrototypeInstanceByVolumeContextModel.name(),"my-volume");
assertEquals(volumeAttachmentVolumePrototypeInstanceByVolumeContextModel.profile(),volumeProfileIdentityModel);
assertEquals(volumeAttachmentVolumePrototypeInstanceByVolumeContextModel.sourceSnapshot(),snapshotIdentityModel);
assertEquals(volumeAttachmentPrototypeInstanceByVolumeContextModel.deleteVolumeOnInstanceDelete(),Boolean.valueOf(false));
assertEquals(volumeAttachmentPrototypeInstanceByVolumeContextModel.name(),"my-volume-attachment");
assertEquals(volumeAttachmentPrototypeInstanceByVolumeContextModel.volume(),volumeAttachmentVolumePrototypeInstanceByVolumeContextModel);
assertTrue(volumeAttachmentPrototypeInstanceByVolumeContextModelNew instanceof VolumeAttachmentPrototypeInstanceByVolumeContext);
assertEquals(volumeAttachmentPrototypeInstanceByVolumeContextModelNew.deleteVolumeOnInstanceDelete(),Boolean.valueOf(false));
assertEquals(volumeAttachmentPrototypeInstanceByVolumeContextModelNew.name(),"my-volume-attachment");
assertEquals(JsonParser.parseString(volumeAttachmentPrototypeInstanceByVolumeContextModelNew.volume().toString()),JsonParser.parseString(volumeAttachmentVolumePrototypeInstanceByVolumeContextModel.toString()));
}