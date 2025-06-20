public void testGetIdentityLinksWithCandidateUser(){
assertEquals(1,identityLinks.size());
assertEquals("kermit",identityLinks.get(0).getUserId());
assertNull(identityLinks.get(0).getGroupId());
assertEquals(IdentityLinkType.CANDIDATE,identityLinks.get(0).getType());
}