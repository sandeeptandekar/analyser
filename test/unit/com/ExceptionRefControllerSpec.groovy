package com



import grails.test.mixin.*
import spock.lang.*

@TestFor(ExceptionRefController)
@Mock(ExceptionRef)
class ExceptionRefControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.exceptionRefInstanceList
            model.exceptionRefInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.exceptionRefInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            def exceptionRef = new ExceptionRef()
            exceptionRef.validate()
            controller.save(exceptionRef)

        then:"The create view is rendered again with the correct model"
            model.exceptionRefInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            exceptionRef = new ExceptionRef(params)

            controller.save(exceptionRef)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/exceptionRef/show/1'
            controller.flash.message != null
            ExceptionRef.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def exceptionRef = new ExceptionRef(params)
            controller.show(exceptionRef)

        then:"A model is populated containing the domain instance"
            model.exceptionRefInstance == exceptionRef
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def exceptionRef = new ExceptionRef(params)
            controller.edit(exceptionRef)

        then:"A model is populated containing the domain instance"
            model.exceptionRefInstance == exceptionRef
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/exceptionRef/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def exceptionRef = new ExceptionRef()
            exceptionRef.validate()
            controller.update(exceptionRef)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.exceptionRefInstance == exceptionRef

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            exceptionRef = new ExceptionRef(params).save(flush: true)
            controller.update(exceptionRef)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/exceptionRef/show/$exceptionRef.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/exceptionRef/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def exceptionRef = new ExceptionRef(params).save(flush: true)

        then:"It exists"
            ExceptionRef.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(exceptionRef)

        then:"The instance is deleted"
            ExceptionRef.count() == 0
            response.redirectedUrl == '/exceptionRef/index'
            flash.message != null
    }
}
