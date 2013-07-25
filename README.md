## Java Active Directory Authentication using Kerberos

### Overview
A few months ago I was tasked with a project that required authentication 
against an Active Directory (AD). When first developing this application
I was authenticating using LDAP. This worked fine and all, but the system
this application was running on had all sorts of security settings, so this
required the use of certificates and what not. This got me thinking. I read up
on Kerberos and how this could be used instead. Although it did require a bit
more work, I was able to successfully implement an authentication system using
a Kerberos approach. This eliminated the need to use any sort of certificates, and made more sense since the only thing I needed to do was authenticate.

**NOTE:**

You will need to create a JAAS configuration file and place it in the
classpath. To find out more about this config file please visit
http://www.javaactivedirectory.com/?page_id=72

###Usage
```java
ADAuthenticator auth = new ADAuthenticator(String jaasConf, String realm, String kdc);
auth.validateUser(String userName, String password);
```
