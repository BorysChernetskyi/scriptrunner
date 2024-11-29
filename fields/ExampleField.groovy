package fields

import com.atlassian.jira.issue.Issue
import com.atlassian.jira.issue.fields.CustomField
import com.atlassian.jira.user.ApplicationUser

class ExampleField extends Script {

    @Override
    Object run() {

        //Interface ApplicationUser
        /**
         * Represents the current user in the application.
         * This variable holds the {@link ApplicationUser} object for the currently authenticated user.
         * If there is no authenticated user, this variable will be {@code null}.
         * The current user, or null if there is no user
         */
        ApplicationUser currentUser	= getProperty("ApplicationUser") as ApplicationUser

        //Interface CustomField
        /**
         * Represents a custom field in the application.
         * This variable holds the {@link CustomField} instance for the specific custom field.
         * This custom field instance
         */
        CustomField customField	= getProperty("customField") as CustomField

        //Interface Issue
        /**
         * Represents the current issue that this field or function is associated with.
         * This variable holds the {@link Issue} instance relevant to the context.
         * The current issue that this field/function/etc applies to
         */
        Issue issue = getProperty("issue") as Issue

        //Interface getCustomFieldValue
        /**
         * Shortcut method to retrieve the value of a custom field for the current issue.
         *
         * Usage:
         * {@code getCustomFieldValue(cfNameOrId)}
         *
         * @return a {@link groovy.lang.Closure} that allows fetching the custom field value
         *         by providing the custom field name or ID.
         *         Shortcut method to get the value of a custom field on this issue. Usage:
         getCustomFieldValue(cf name or ID)
         */
        Closure getCustomFieldValue	= getProperty("getCustomFieldValue") as Closure

        //Interface enableCache
        /**
         * A method to enable caching for specific operations.
         *
         * This {@link groovy.lang.Closure} can be used to activate caching
         * mechanisms to optimize performance for repetitive calls or computations.
         * enableCache = { false }
         */
        Closure enableCache	= getProperty("enableCache") as Closure
    }

}
