@Test public void testBindingAttachment(){
Assert.assertTrue("set attachment failed!",attachments != null && attachments.size() == 1);
Assert.assertTrue("binding attachment failed!",value != null && value.equals(attachValue));
}