## Java Active Directory Authentication using Kerberos

### NOTE: LDAP Authentication will be provided in the coming days.

### Overview
A few months ago I was tasked with a project that required authentication 
against an Active Directory (AD). When first developing this application
I was authenticating using LDAP. This worked fine and all, but the system
this application was running on had all sorts of security settings, so this
required the use of certificates and what not. This got me thinking. I read up
on Kerberos and how this could be used instead. Although it did require a bit
more work, I was able to successfully implement an authentication system using
a Kerberos approach

In this repository, you will find two directories with each apporoach I used.
The main goal is to allow others to see what I did and also see if there are 
any ways it could infact be imporved.