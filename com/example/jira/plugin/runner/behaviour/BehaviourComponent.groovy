package com.example.jira.plugin.runner.behaviour

import javax.validation.constraints.NotNull
import com.onresolve.jira.groovy.user.FormField
import com.onresolve.jira.groovy.user.FieldBehaviours

class BehaviourComponent extends FieldBehaviours {

    /**
    * @param Field of Type Date
    * @return Date without error "Cannot cast object '' with class 'java.lang.String' to class 'java.util.Date'"
    */
    Date getDate(@NotNull FormField field){

        (field.getValue() instanceof Date ? field.getValue() : null) as Date
    }
}