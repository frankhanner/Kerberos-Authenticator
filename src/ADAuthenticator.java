import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

/**
 * ADAuthenticator is used to authenticate a user against an Active
 * Directory using Kerberos.
 *
 * @author Frank Hanner
 */
public class ADAuthenticator {

    private String jaasConf, realm, kdc, debug;

    /**
     * Constructs a new ADAuthenticator object by setting the appropriate System
     * properties.
     *
     * @param jaasConf path of jaas configuration file
     * @param realm the realm of the AD
     * @param kdc the kdc of the AD
     */
    public ADAuthenticator(String jaasConf, String realm, String kdc) {
        debug = "false";
        System.setProperty("java.security.auth.login.config", jaasConf);
        System.setProperty("java.security.krb5.realm", realm);
        System.setProperty("java.security.krb5.kdc", kdc);
        System.setProperty("java.security.krb5.debug", debug);
    }

    /**
     * Attempts to authenticate against the Active Directory
     *
     * @return true if user authenticates successfully. false if user
     * doesn't authenticate successfully.
     */
    public boolean validateUser(String userName, String password) {
        try {
            ADCallbackHandler ch = new ADCallbackHandler();
            ch.setUserId(userName);
            ch.setPassword(password);
            LoginContext lc = new LoginContext("JaasConfig", ch);
            lc.login();
            return true;
        } catch (LoginException le) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }
}
