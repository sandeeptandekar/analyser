package com



import grails.test.mixin.*
import spock.lang.*

@TestFor(LogCaseController)
@Mock(LogCase)
class LogCaseControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.logCaseInstanceList
            model.logCaseInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.logCaseInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            def logCase = new LogCase()
            logCase.validate()
            controller.save(logCase)

        then:"The create view is rendered again with the correct model"
            model.logCaseInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            logCase = new LogCase(params)

            controller.save(logCase)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/logCase/show/1'
            controller.flash.message != null
            LogCase.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def logCase = new LogCase(params)
            controller.show(logCase)

        then:"A model is populated containing the domain instance"
            model.logCaseInstance == logCase
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def logCase = new LogCase(params)
            controller.edit(logCase)

        then:"A model is populated containing the domain instance"
            model.logCaseInstance == logCase
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/logCase/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def logCase = new LogCase()
            logCase.validate()
            controller.update(logCase)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.logCaseInstance == logCase

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            logCase = new LogCase(params).save(flush: true)
            controller.update(logCase)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/logCase/show/$logCase.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/logCase/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def logCase = new LogCase(params).save(flush: true)

        then:"It exists"
            LogCase.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(logCase)

        then:"The instance is deleted"
            LogCase.count() == 0
            response.redirectedUrl == '/logCase/index'
            flash.message != null
    }
}
