import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

/**
 * ADAuthenticator is used to authenticate the user against the Active
 * Directory using Kerberos.
 *
 * @author Frank Hanner
 * @version 1.0.0.4
 * @since 1.6
 */
public class ADAuthenticator {

    private String jaasConf, realm, kdc, debug;

    /**
     * ADAuthenticator constructor configures the class to connect to
     * either the air or gnd domain depending on computer name
     *
     * @param compName computer that is being used to authenticate. This
     * determines what domain to use.
     */
    public ADAuthenticator(String jaasConf, String realm, String kdc) {
        debug = "false";
        System.setProperty("java.security.auth.login.config", jaasConf);
        System.setProperty("java.security.krb5.realm", realm);
        System.setProperty("java.security.krb5.kdc", kdc);
        System.setProperty("java.security.krb5.debug", debug);
    }

    /**
     * validateUser accepts userName and password and attempts to authenticate against Active Directory
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
