package endpoints

import com.atlassian.jira.component.ComponentAccessor
import com.example.jira.plugin.runner.endpoint.EndpointComponent
import org.apache.log4j.Logger
import javax.servlet.http.HttpServletRequest
import javax.ws.rs.core.MultivaluedMap
import javax.ws.rs.core.Response
import com.atlassian.sal.api.user.UserManager
import com.atlassian.sal.api.user.UserProfile

class ExampleEndpoint extends EndpointComponent {

    private static final Logger log = Logger.getLogger(this)
    private static final UserManager userManager = ComponentAccessor.getOSGiComponentInstanceOfType(UserManager)

    ExampleEndpoint() {

        registerRestEndpoint("method1", { MultivaluedMap queryParams, String body, HttpServletRequest request ->

            String extraPath = getAdditionalPath(request)
            String parameter = queryParams.getFirst("parameter")
            switch (extraPath) {
                case "/submethod11":
                    Response.ok("Success submethod11").build()
                    break
                case "/submethod12":
                    Response.ok("Success submethod12").build()
                    break
                default:
                    Response.ok("Success method1").build()
            }
        },  [httpMethod: "GET", "groups": ["rest", "jira-sysadmins"]])

        registerRestEndpoint("method2", { MultivaluedMap queryParams, String body, HttpServletRequest request ->

            String extraPath = getAdditionalPath(request)
            UserProfile userProfile = userManager.getRemoteUser(request)
            switch (extraPath) {
                case "/submethod21":
                    Response.ok("Success submethod21").build()
                    break
                case "/submethod22":
                    Response.ok("Success submethod22").build()
                    break
                default:
                    Response.ok("Success method2").build()
            }
        },  [httpMethod: "POST", "groups": ["rest", "jira-sysadmins"]])

        registerRestEndpoint("method3", { MultivaluedMap queryParams, String body ->

            String extraPath = getAdditionalPath(request)
            switch (extraPath) {
                case "/submethod31":
                    Response.ok("Success submethod31").build()
                    break
                case "/submethod32":
                    Response.ok("Success submethod32").build()
                    break
                default:
                    Response.status(Response.Status.NOT_FOUND).build()
            }
        },  [httpMethod: "PUT", "groups": ["rest", "jira-sysadmins"]])

        registerRestEndpoint("method4", { MultivaluedMap queryParams, String body, HttpServletRequest request ->

            String extraPath = getAdditionalPath(request)
            get
            switch (extraPath) {
                case "/submethod41":
                    Response.ok("Success submethod41").build()
                    break
                case "/submethod42":
                    Response.ok("Success submethod42").build()
                    break
                default:
                    Response.status(Response.Status.INTERNAL_SERVER_ERROR).build()
            }
        },  [httpMethod: "GET", "groups": ["rest", "jira-sysadmins"]])
    }

    @Override
    run() {

    }
}