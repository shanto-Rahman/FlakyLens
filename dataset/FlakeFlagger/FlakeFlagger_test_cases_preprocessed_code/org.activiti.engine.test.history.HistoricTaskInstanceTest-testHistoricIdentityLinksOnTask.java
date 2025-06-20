@Deployment public void testHistoricIdentityLinksOnTask() throws Exception {
assertNotNull(task);
assertEquals(4,taskService.getIdentityLinksForTask(task.getId()).size());
assertEquals(4,historicIdentityLinks.size());
assertEquals(task.getId(),link.getTaskId());
if (link.getGroupId() != null) {
assertEquals("sales",link.getGroupId());
if (link.getType().equals("candidate")) {
assertEquals("fozzie",link.getUserId());
if (link.getType().equals("assignee")) {
assertEquals("kermit",link.getUserId());
if (link.getType().equals("customUseridentityLink")) {
assertEquals("gonzo",link.getUserId());
}
}
}
}
assertTrue(foundAssignee);
assertTrue(foundCandidateGroup);
assertTrue(foundCandidateUser);
assertTrue(foundCustom);
assertEquals(4,historyService.getHistoricIdentityLinksForTask(task.getId()).size());
fail("Exception expected");
assertEquals(HistoricTaskInstance.class,aonfe.getObjectClass());
}