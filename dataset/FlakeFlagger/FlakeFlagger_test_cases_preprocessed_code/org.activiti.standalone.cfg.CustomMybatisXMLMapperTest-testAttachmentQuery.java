public void testAttachmentQuery(){
assertEquals(attachmentId,new AttachmentQuery(managementService).attachmentId(attachmentId).singleResult().getId());
assertEquals("attachment1",new AttachmentQuery(managementService).attachmentName("attachment1").singleResult().getName());
assertEquals(18,new AttachmentQuery(managementService).count());
assertEquals(18,attachments.size());
assertEquals(10,attachments.size());
assertEquals(3,new AttachmentQuery(managementService).taskId(taskId).count());
assertEquals(3,attachments.size());
assertEquals(2,new AttachmentQuery(managementService).userId("kermit").count());
assertEquals(2,attachments.size());
assertEquals(1,new AttachmentQuery(managementService).attachmentType("image/jpeg").count());
assertEquals(1,attachments.size());
assertEquals("zattachment3",new AttachmentQuery(managementService).orderByAttachmentName().desc().list().get(0).getName());
}